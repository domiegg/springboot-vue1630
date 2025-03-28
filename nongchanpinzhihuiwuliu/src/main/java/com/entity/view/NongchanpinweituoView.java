package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongchanpinweituoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品委托
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongchanpinweituo")
public class NongchanpinweituoView extends NongchanpinweituoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 委托类型的值
	*/
	@ColumnInfo(comment="委托类型的字典表值",type="varchar(200)")
	private String nongchanpinweituoValue;




	public NongchanpinweituoView() {

	}

	public NongchanpinweituoView(NongchanpinweituoEntity nongchanpinweituoEntity) {
		try {
			BeanUtils.copyProperties(this, nongchanpinweituoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 委托类型的值
	*/
	public String getNongchanpinweituoValue() {
		return nongchanpinweituoValue;
	}
	/**
	* 设置： 委托类型的值
	*/
	public void setNongchanpinweituoValue(String nongchanpinweituoValue) {
		this.nongchanpinweituoValue = nongchanpinweituoValue;
	}




	@Override
	public String toString() {
		return "NongchanpinweituoView{" +
			", nongchanpinweituoValue=" + nongchanpinweituoValue +
			"} " + super.toString();
	}
}
