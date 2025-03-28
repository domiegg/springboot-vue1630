
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 农产品物流公司
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuliugongsi")
public class WuliugongsiController {
    private static final Logger logger = LoggerFactory.getLogger(WuliugongsiController.class);

    private static final String TABLE_NAME = "wuliugongsi";

    @Autowired
    private WuliugongsiService wuliugongsiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GongyingshangService gongyingshangService;//农产品供应商
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private NongchanpinweituoService nongchanpinweituoService;//农产品委托
    @Autowired
    private PeisongService peisongService;//农产品配送
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("农产品供应商".equals(role))
            params.put("gongyingshangId",request.getSession().getAttribute("userId"));
        else if("农产品物流公司".equals(role))
            params.put("wuliugongsiId",request.getSession().getAttribute("userId"));
        params.put("wuliugongsiDeleteStart",1);params.put("wuliugongsiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wuliugongsiService.queryPage(params);

        //字典表数据转换
        List<WuliugongsiView> list =(List<WuliugongsiView>)page.getList();
        for(WuliugongsiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuliugongsiEntity wuliugongsi = wuliugongsiService.selectById(id);
        if(wuliugongsi !=null){
            //entity转view
            WuliugongsiView view = new WuliugongsiView();
            BeanUtils.copyProperties( wuliugongsi , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuliugongsiEntity wuliugongsi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuliugongsi:{}",this.getClass().getName(),wuliugongsi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WuliugongsiEntity> queryWrapper = new EntityWrapper<WuliugongsiEntity>()
            .eq("username", wuliugongsi.getUsername())
            .or()
            .eq("wuliugongsi_phone", wuliugongsi.getWuliugongsiPhone())
            .andNew()
            .eq("wuliugongsi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliugongsiEntity wuliugongsiEntity = wuliugongsiService.selectOne(queryWrapper);
        if(wuliugongsiEntity==null){
            wuliugongsi.setWuliugongsiDelete(1);
            wuliugongsi.setCreateTime(new Date());
            wuliugongsi.setPassword("123456");
            wuliugongsiService.insert(wuliugongsi);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuliugongsiEntity wuliugongsi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuliugongsi:{}",this.getClass().getName(),wuliugongsi.toString());
        WuliugongsiEntity oldWuliugongsiEntity = wuliugongsiService.selectById(wuliugongsi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wuliugongsi.getWuliugongsiPhoto()) || "null".equals(wuliugongsi.getWuliugongsiPhoto())){
                wuliugongsi.setWuliugongsiPhoto(null);
        }

            wuliugongsiService.updateById(wuliugongsi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuliugongsiEntity> oldWuliugongsiList =wuliugongsiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WuliugongsiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WuliugongsiEntity wuliugongsiEntity = new WuliugongsiEntity();
            wuliugongsiEntity.setId(id);
            wuliugongsiEntity.setWuliugongsiDelete(2);
            list.add(wuliugongsiEntity);
        }
        if(list != null && list.size() >0){
            wuliugongsiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WuliugongsiEntity> wuliugongsiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WuliugongsiEntity wuliugongsiEntity = new WuliugongsiEntity();
//                            wuliugongsiEntity.setUsername(data.get(0));                    //账户 要改的
//                            //wuliugongsiEntity.setPassword("123456");//密码
//                            wuliugongsiEntity.setWuliugongsiName(data.get(0));                    //物流公司姓名 要改的
//                            wuliugongsiEntity.setWuliugongsiPhoto("");//详情和图片
//                            wuliugongsiEntity.setWuliugongsiPhone(data.get(0));                    //联系方式 要改的
//                            wuliugongsiEntity.setWuliugongsiEmail(data.get(0));                    //邮箱 要改的
//                            wuliugongsiEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            wuliugongsiEntity.setWuliugongsiTypes(Integer.valueOf(data.get(0)));   //物流公司类型 要改的
//                            wuliugongsiEntity.setWuliugongsiContent("");//详情和图片
//                            wuliugongsiEntity.setWuliugongsiDelete(1);//逻辑删除字段
//                            wuliugongsiEntity.setCreateTime(date);//时间
                            wuliugongsiList.add(wuliugongsiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("wuliugongsiPhone")){
                                    List<String> wuliugongsiPhone = seachFields.get("wuliugongsiPhone");
                                    wuliugongsiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> wuliugongsiPhone = new ArrayList<>();
                                    wuliugongsiPhone.add(data.get(0));//要改的
                                    seachFields.put("wuliugongsiPhone",wuliugongsiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<WuliugongsiEntity> wuliugongsiEntities_username = wuliugongsiService.selectList(new EntityWrapper<WuliugongsiEntity>().in("username", seachFields.get("username")).eq("wuliugongsi_delete", 1));
                        if(wuliugongsiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuliugongsiEntity s:wuliugongsiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<WuliugongsiEntity> wuliugongsiEntities_wuliugongsiPhone = wuliugongsiService.selectList(new EntityWrapper<WuliugongsiEntity>().in("wuliugongsi_phone", seachFields.get("wuliugongsiPhone")).eq("wuliugongsi_delete", 1));
                        if(wuliugongsiEntities_wuliugongsiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuliugongsiEntity s:wuliugongsiEntities_wuliugongsiPhone){
                                repeatFields.add(s.getWuliugongsiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuliugongsiService.insertBatch(wuliugongsiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        WuliugongsiEntity wuliugongsi = wuliugongsiService.selectOne(new EntityWrapper<WuliugongsiEntity>().eq("username", username));
        if(wuliugongsi==null || !wuliugongsi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(wuliugongsi.getWuliugongsiDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(wuliugongsi.getId(),username, "wuliugongsi", "农产品物流公司");
        R r = R.ok();
        r.put("token", token);
        r.put("role","农产品物流公司");
        r.put("username",wuliugongsi.getWuliugongsiName());
        r.put("tableName","wuliugongsi");
        r.put("userId",wuliugongsi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WuliugongsiEntity wuliugongsi, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<WuliugongsiEntity> queryWrapper = new EntityWrapper<WuliugongsiEntity>()
            .eq("username", wuliugongsi.getUsername())
            .or()
            .eq("wuliugongsi_phone", wuliugongsi.getWuliugongsiPhone())
            .andNew()
            .eq("wuliugongsi_delete", 1)
            ;
        WuliugongsiEntity wuliugongsiEntity = wuliugongsiService.selectOne(queryWrapper);
        if(wuliugongsiEntity != null)
            return R.error("账户或者联系方式已经被使用");
        wuliugongsi.setWuliugongsiDelete(1);
        wuliugongsi.setCreateTime(new Date());
        wuliugongsiService.insert(wuliugongsi);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        WuliugongsiEntity wuliugongsi = wuliugongsiService.selectById(id);
        wuliugongsi.setPassword("123456");
        wuliugongsiService.updateById(wuliugongsi);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        WuliugongsiEntity wuliugongsi = wuliugongsiService.selectOne(new EntityWrapper<WuliugongsiEntity>().eq("username", username));
        if(wuliugongsi!=null){
            wuliugongsi.setPassword("123456");
            wuliugongsiService.updateById(wuliugongsi);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWuliugongsi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WuliugongsiEntity wuliugongsi = wuliugongsiService.selectById(id);
        if(wuliugongsi !=null){
            //entity转view
            WuliugongsiView view = new WuliugongsiView();
            BeanUtils.copyProperties( wuliugongsi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wuliugongsiService.queryPage(params);

        //字典表数据转换
        List<WuliugongsiView> list =(List<WuliugongsiView>)page.getList();
        for(WuliugongsiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuliugongsiEntity wuliugongsi = wuliugongsiService.selectById(id);
            if(wuliugongsi !=null){


                //entity转view
                WuliugongsiView view = new WuliugongsiView();
                BeanUtils.copyProperties( wuliugongsi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WuliugongsiEntity wuliugongsi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wuliugongsi:{}",this.getClass().getName(),wuliugongsi.toString());
        Wrapper<WuliugongsiEntity> queryWrapper = new EntityWrapper<WuliugongsiEntity>()
            .eq("username", wuliugongsi.getUsername())
            .or()
            .eq("wuliugongsi_phone", wuliugongsi.getWuliugongsiPhone())
            .andNew()
            .eq("wuliugongsi_delete", 1)
//            .notIn("wuliugongsi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliugongsiEntity wuliugongsiEntity = wuliugongsiService.selectOne(queryWrapper);
        if(wuliugongsiEntity==null){
            wuliugongsi.setWuliugongsiDelete(1);
            wuliugongsi.setCreateTime(new Date());
        wuliugongsi.setPassword("123456");
        wuliugongsiService.insert(wuliugongsi);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

}

