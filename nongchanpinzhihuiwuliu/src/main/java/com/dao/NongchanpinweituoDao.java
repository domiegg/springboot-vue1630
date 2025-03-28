package com.dao;

import com.entity.NongchanpinweituoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanpinweituoView;

/**
 * 农产品委托 Dao 接口
 *
 * @author 
 */
public interface NongchanpinweituoDao extends BaseMapper<NongchanpinweituoEntity> {

   List<NongchanpinweituoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
