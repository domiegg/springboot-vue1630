
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
 * 农产品委托
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongchanpinweituo")
public class NongchanpinweituoController {
    private static final Logger logger = LoggerFactory.getLogger(NongchanpinweituoController.class);

    private static final String TABLE_NAME = "nongchanpinweituo";

    @Autowired
    private NongchanpinweituoService nongchanpinweituoService;


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
        params.put("nongchanpinweituoDeleteStart",1);params.put("nongchanpinweituoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinweituoService.queryPage(params);

        //字典表数据转换
        List<NongchanpinweituoView> list =(List<NongchanpinweituoView>)page.getList();
        for(NongchanpinweituoView c:list){
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
        NongchanpinweituoEntity nongchanpinweituo = nongchanpinweituoService.selectById(id);
        if(nongchanpinweituo !=null){
            //entity转view
            NongchanpinweituoView view = new NongchanpinweituoView();
            BeanUtils.copyProperties( nongchanpinweituo , view );//把实体数据重构到view中
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
    public R save(@RequestBody NongchanpinweituoEntity nongchanpinweituo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongchanpinweituo:{}",this.getClass().getName(),nongchanpinweituo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<NongchanpinweituoEntity> queryWrapper = new EntityWrapper<NongchanpinweituoEntity>()
            .eq("nongchanpinweituo_name", nongchanpinweituo.getNongchanpinweituoName())
            .eq("nongchanpinweituo_types", nongchanpinweituo.getNongchanpinweituoTypes())
            .eq("nongchanpinweituo_kucun_number", nongchanpinweituo.getNongchanpinweituoKucunNumber())
            .eq("nongchanpinweituo_delete", nongchanpinweituo.getNongchanpinweituoDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchanpinweituoEntity nongchanpinweituoEntity = nongchanpinweituoService.selectOne(queryWrapper);
        if(nongchanpinweituoEntity==null){
            nongchanpinweituo.setNongchanpinweituoDelete(1);
            nongchanpinweituo.setInsertTime(new Date());
            nongchanpinweituo.setCreateTime(new Date());
            nongchanpinweituoService.insert(nongchanpinweituo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongchanpinweituoEntity nongchanpinweituo, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongchanpinweituo:{}",this.getClass().getName(),nongchanpinweituo.toString());
        NongchanpinweituoEntity oldNongchanpinweituoEntity = nongchanpinweituoService.selectById(nongchanpinweituo.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(nongchanpinweituo.getNongchanpinweituoPhoto()) || "null".equals(nongchanpinweituo.getNongchanpinweituoPhoto())){
                nongchanpinweituo.setNongchanpinweituoPhoto(null);
        }

            nongchanpinweituoService.updateById(nongchanpinweituo);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongchanpinweituoEntity> oldNongchanpinweituoList =nongchanpinweituoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<NongchanpinweituoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            NongchanpinweituoEntity nongchanpinweituoEntity = new NongchanpinweituoEntity();
            nongchanpinweituoEntity.setId(id);
            nongchanpinweituoEntity.setNongchanpinweituoDelete(2);
            list.add(nongchanpinweituoEntity);
        }
        if(list != null && list.size() >0){
            nongchanpinweituoService.updateBatchById(list);
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
            List<NongchanpinweituoEntity> nongchanpinweituoList = new ArrayList<>();//上传的东西
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
                            NongchanpinweituoEntity nongchanpinweituoEntity = new NongchanpinweituoEntity();
//                            nongchanpinweituoEntity.setNongchanpinweituoName(data.get(0));                    //委托标题 要改的
//                            nongchanpinweituoEntity.setNongchanpinweituoTypes(Integer.valueOf(data.get(0)));   //委托类型 要改的
//                            nongchanpinweituoEntity.setNongchanpinweituoPhoto("");//详情和图片
//                            nongchanpinweituoEntity.setNongchanpinweituoKucunNumber(Integer.valueOf(data.get(0)));   //委托数量 要改的
//                            nongchanpinweituoEntity.setNongchanpinweituoContent("");//详情和图片
//                            nongchanpinweituoEntity.setNongchanpinweituoDelete(1);//逻辑删除字段
//                            nongchanpinweituoEntity.setInsertTime(date);//时间
//                            nongchanpinweituoEntity.setCreateTime(date);//时间
                            nongchanpinweituoList.add(nongchanpinweituoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        nongchanpinweituoService.insertBatch(nongchanpinweituoList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinweituoService.queryPage(params);

        //字典表数据转换
        List<NongchanpinweituoView> list =(List<NongchanpinweituoView>)page.getList();
        for(NongchanpinweituoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchanpinweituoEntity nongchanpinweituo = nongchanpinweituoService.selectById(id);
            if(nongchanpinweituo !=null){


                //entity转view
                NongchanpinweituoView view = new NongchanpinweituoView();
                BeanUtils.copyProperties( nongchanpinweituo , view );//把实体数据重构到view中

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
    public R add(@RequestBody NongchanpinweituoEntity nongchanpinweituo, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongchanpinweituo:{}",this.getClass().getName(),nongchanpinweituo.toString());
        Wrapper<NongchanpinweituoEntity> queryWrapper = new EntityWrapper<NongchanpinweituoEntity>()
            .eq("nongchanpinweituo_name", nongchanpinweituo.getNongchanpinweituoName())
            .eq("nongchanpinweituo_types", nongchanpinweituo.getNongchanpinweituoTypes())
            .eq("nongchanpinweituo_kucun_number", nongchanpinweituo.getNongchanpinweituoKucunNumber())
            .eq("nongchanpinweituo_delete", nongchanpinweituo.getNongchanpinweituoDelete())
//            .notIn("nongchanpinweituo_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchanpinweituoEntity nongchanpinweituoEntity = nongchanpinweituoService.selectOne(queryWrapper);
        if(nongchanpinweituoEntity==null){
            nongchanpinweituo.setNongchanpinweituoDelete(1);
            nongchanpinweituo.setInsertTime(new Date());
            nongchanpinweituo.setCreateTime(new Date());
        nongchanpinweituoService.insert(nongchanpinweituo);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

