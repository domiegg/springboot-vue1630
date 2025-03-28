package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 农产品委托
 *
 * @author 
 * @email
 */
@TableName("nongchanpinweituo")
public class NongchanpinweituoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongchanpinweituoEntity() {

	}

	public NongchanpinweituoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 委托标题
     */
    @ColumnInfo(comment="委托标题",type="varchar(200)")
    @TableField(value = "nongchanpinweituo_name")

    private String nongchanpinweituoName;


    /**
     * 委托类型
     */
    @ColumnInfo(comment="委托类型",type="int(11)")
    @TableField(value = "nongchanpinweituo_types")

    private Integer nongchanpinweituoTypes;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "nongchanpinweituo_photo")

    private String nongchanpinweituoPhoto;


    /**
     * 委托数量
     */
    @ColumnInfo(comment="委托数量",type="int(11)")
    @TableField(value = "nongchanpinweituo_kucun_number")

    private Integer nongchanpinweituoKucunNumber;


    /**
     * 委托详情
     */
    @ColumnInfo(comment="委托详情",type="text")
    @TableField(value = "nongchanpinweituo_content")

    private String nongchanpinweituoContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "nongchanpinweituo_delete")

    private Integer nongchanpinweituoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：委托标题
	 */
    public String getNongchanpinweituoName() {
        return nongchanpinweituoName;
    }
    /**
	 * 设置：委托标题
	 */

    public void setNongchanpinweituoName(String nongchanpinweituoName) {
        this.nongchanpinweituoName = nongchanpinweituoName;
    }
    /**
	 * 获取：委托类型
	 */
    public Integer getNongchanpinweituoTypes() {
        return nongchanpinweituoTypes;
    }
    /**
	 * 设置：委托类型
	 */

    public void setNongchanpinweituoTypes(Integer nongchanpinweituoTypes) {
        this.nongchanpinweituoTypes = nongchanpinweituoTypes;
    }
    /**
	 * 获取：封面
	 */
    public String getNongchanpinweituoPhoto() {
        return nongchanpinweituoPhoto;
    }
    /**
	 * 设置：封面
	 */

    public void setNongchanpinweituoPhoto(String nongchanpinweituoPhoto) {
        this.nongchanpinweituoPhoto = nongchanpinweituoPhoto;
    }
    /**
	 * 获取：委托数量
	 */
    public Integer getNongchanpinweituoKucunNumber() {
        return nongchanpinweituoKucunNumber;
    }
    /**
	 * 设置：委托数量
	 */

    public void setNongchanpinweituoKucunNumber(Integer nongchanpinweituoKucunNumber) {
        this.nongchanpinweituoKucunNumber = nongchanpinweituoKucunNumber;
    }
    /**
	 * 获取：委托详情
	 */
    public String getNongchanpinweituoContent() {
        return nongchanpinweituoContent;
    }
    /**
	 * 设置：委托详情
	 */

    public void setNongchanpinweituoContent(String nongchanpinweituoContent) {
        this.nongchanpinweituoContent = nongchanpinweituoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getNongchanpinweituoDelete() {
        return nongchanpinweituoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setNongchanpinweituoDelete(Integer nongchanpinweituoDelete) {
        this.nongchanpinweituoDelete = nongchanpinweituoDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Nongchanpinweituo{" +
            ", id=" + id +
            ", nongchanpinweituoName=" + nongchanpinweituoName +
            ", nongchanpinweituoTypes=" + nongchanpinweituoTypes +
            ", nongchanpinweituoPhoto=" + nongchanpinweituoPhoto +
            ", nongchanpinweituoKucunNumber=" + nongchanpinweituoKucunNumber +
            ", nongchanpinweituoContent=" + nongchanpinweituoContent +
            ", nongchanpinweituoDelete=" + nongchanpinweituoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
