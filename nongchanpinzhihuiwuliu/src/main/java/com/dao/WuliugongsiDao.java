package com.dao;

import com.entity.WuliugongsiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuliugongsiView;

/**
 * 农产品物流公司 Dao 接口
 *
 * @author 
 */
public interface WuliugongsiDao extends BaseMapper<WuliugongsiEntity> {

   List<WuliugongsiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
