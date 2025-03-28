package com.dao;

import com.entity.PeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeisongView;

/**
 * 农产品配送 Dao 接口
 *
 * @author 
 */
public interface PeisongDao extends BaseMapper<PeisongEntity> {

   List<PeisongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
