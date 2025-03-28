
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
 * 农产品供应商
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongyingshang")
public class GongyingshangController {
    private static final Logger logger = LoggerFactory.getLogger(GongyingshangController.class);

    private static final String TABLE_NAME = "gongyingshang";

    @Autowired
    private GongyingshangService gongyingshangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private NongchanpinweituoService nongchanpinweituoService;//农产品委托
    @Autowired
    private PeisongService peisongService;//农产品配送
    @Autowired
    private WuliugongsiService wuliugongsiService;//农产品物流公司
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
        params.put("gongyingshangDeleteStart",1);params.put("gongyingshangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = gongyingshangService.queryPage(params);

        //字典表数据转换
        List<GongyingshangView> list =(List<GongyingshangView>)page.getList();
        for(GongyingshangView c:list){
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
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
        if(gongyingshang !=null){
            //entity转view
            GongyingshangView view = new GongyingshangView();
            BeanUtils.copyProperties( gongyingshang , view );//把实体数据重构到view中
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
    public R save(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .eq("username", gongyingshang.getUsername())
            .or()
            .eq("gongyingshang_phone", gongyingshang.getGongyingshangPhone())
            .andNew()
            .eq("gongyingshang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity==null){
            gongyingshang.setGongyingshangDelete(1);
            gongyingshang.setCreateTime(new Date());
            gongyingshang.setPassword("123456");
            gongyingshangService.insert(gongyingshang);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());
        GongyingshangEntity oldGongyingshangEntity = gongyingshangService.selectById(gongyingshang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(gongyingshang.getGongyingshangPhoto()) || "null".equals(gongyingshang.getGongyingshangPhoto())){
                gongyingshang.setGongyingshangPhoto(null);
        }

            gongyingshangService.updateById(gongyingshang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GongyingshangEntity> oldGongyingshangList =gongyingshangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<GongyingshangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GongyingshangEntity gongyingshangEntity = new GongyingshangEntity();
            gongyingshangEntity.setId(id);
            gongyingshangEntity.setGongyingshangDelete(2);
            list.add(gongyingshangEntity);
        }
        if(list != null && list.size() >0){
            gongyingshangService.updateBatchById(list);
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
            List<GongyingshangEntity> gongyingshangList = new ArrayList<>();//上传的东西
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
                            GongyingshangEntity gongyingshangEntity = new GongyingshangEntity();
//                            gongyingshangEntity.setUsername(data.get(0));                    //账户 要改的
//                            //gongyingshangEntity.setPassword("123456");//密码
//                            gongyingshangEntity.setGongyingshangName(data.get(0));                    //供应商姓名 要改的
//                            gongyingshangEntity.setGongyingshangPhoto("");//详情和图片
//                            gongyingshangEntity.setGongyingshangPhone(data.get(0));                    //联系方式 要改的
//                            gongyingshangEntity.setGongyingshangEmail(data.get(0));                    //邮箱 要改的
//                            gongyingshangEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            gongyingshangEntity.setGongyingshangTypes(Integer.valueOf(data.get(0)));   //供应商类型 要改的
//                            gongyingshangEntity.setGongyingshangContent("");//详情和图片
//                            gongyingshangEntity.setGongyingshangDelete(1);//逻辑删除字段
//                            gongyingshangEntity.setCreateTime(date);//时间
                            gongyingshangList.add(gongyingshangEntity);


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
                                if(seachFields.containsKey("gongyingshangPhone")){
                                    List<String> gongyingshangPhone = seachFields.get("gongyingshangPhone");
                                    gongyingshangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> gongyingshangPhone = new ArrayList<>();
                                    gongyingshangPhone.add(data.get(0));//要改的
                                    seachFields.put("gongyingshangPhone",gongyingshangPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<GongyingshangEntity> gongyingshangEntities_username = gongyingshangService.selectList(new EntityWrapper<GongyingshangEntity>().in("username", seachFields.get("username")).eq("gongyingshang_delete", 1));
                        if(gongyingshangEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongyingshangEntity s:gongyingshangEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<GongyingshangEntity> gongyingshangEntities_gongyingshangPhone = gongyingshangService.selectList(new EntityWrapper<GongyingshangEntity>().in("gongyingshang_phone", seachFields.get("gongyingshangPhone")).eq("gongyingshang_delete", 1));
                        if(gongyingshangEntities_gongyingshangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongyingshangEntity s:gongyingshangEntities_gongyingshangPhone){
                                repeatFields.add(s.getGongyingshangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongyingshangService.insertBatch(gongyingshangList);
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
        GongyingshangEntity gongyingshang = gongyingshangService.selectOne(new EntityWrapper<GongyingshangEntity>().eq("username", username));
        if(gongyingshang==null || !gongyingshang.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(gongyingshang.getGongyingshangDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(gongyingshang.getId(),username, "gongyingshang", "农产品供应商");
        R r = R.ok();
        r.put("token", token);
        r.put("role","农产品供应商");
        r.put("username",gongyingshang.getGongyingshangName());
        r.put("tableName","gongyingshang");
        r.put("userId",gongyingshang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .eq("username", gongyingshang.getUsername())
            .or()
            .eq("gongyingshang_phone", gongyingshang.getGongyingshangPhone())
            .andNew()
            .eq("gongyingshang_delete", 1)
            ;
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity != null)
            return R.error("账户或者联系方式已经被使用");
        gongyingshang.setGongyingshangDelete(1);
        gongyingshang.setCreateTime(new Date());
        gongyingshangService.insert(gongyingshang);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
        gongyingshang.setPassword("123456");
        gongyingshangService.updateById(gongyingshang);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        GongyingshangEntity gongyingshang = gongyingshangService.selectOne(new EntityWrapper<GongyingshangEntity>().eq("username", username));
        if(gongyingshang!=null){
            gongyingshang.setPassword("123456");
            gongyingshangService.updateById(gongyingshang);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrGongyingshang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
        if(gongyingshang !=null){
            //entity转view
            GongyingshangView view = new GongyingshangView();
            BeanUtils.copyProperties( gongyingshang , view );//把实体数据重构到view中

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
        PageUtils page = gongyingshangService.queryPage(params);

        //字典表数据转换
        List<GongyingshangView> list =(List<GongyingshangView>)page.getList();
        for(GongyingshangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongyingshangEntity gongyingshang = gongyingshangService.selectById(id);
            if(gongyingshang !=null){


                //entity转view
                GongyingshangView view = new GongyingshangView();
                BeanUtils.copyProperties( gongyingshang , view );//把实体数据重构到view中

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
    public R add(@RequestBody GongyingshangEntity gongyingshang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gongyingshang:{}",this.getClass().getName(),gongyingshang.toString());
        Wrapper<GongyingshangEntity> queryWrapper = new EntityWrapper<GongyingshangEntity>()
            .eq("username", gongyingshang.getUsername())
            .or()
            .eq("gongyingshang_phone", gongyingshang.getGongyingshangPhone())
            .andNew()
            .eq("gongyingshang_delete", 1)
//            .notIn("gongyingshang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongyingshangEntity gongyingshangEntity = gongyingshangService.selectOne(queryWrapper);
        if(gongyingshangEntity==null){
            gongyingshang.setGongyingshangDelete(1);
            gongyingshang.setCreateTime(new Date());
        gongyingshang.setPassword("123456");
        gongyingshangService.insert(gongyingshang);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

}

