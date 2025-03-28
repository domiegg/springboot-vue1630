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
 * 农产品配送
 *
 * @author 
 * @email
 */
@TableName("peisong")
public class PeisongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeisongEntity() {

	}

	public PeisongEntity(T t) {
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
     * 配送标题
     */
    @ColumnInfo(comment="配送标题",type="varchar(200)")
    @TableField(value = "peisong_name")

    private String peisongName;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 配送状态
     */
    @ColumnInfo(comment="配送状态",type="int(11)")
    @TableField(value = "peisong_types")

    private Integer peisongTypes;


    /**
     * 配送数量
     */
    @ColumnInfo(comment="配送数量",type="int(11)")
    @TableField(value = "peisong_kucun_number")

    private Integer peisongKucunNumber;


    /**
     * 配送详情
     */
    @ColumnInfo(comment="配送详情",type="text")
    @TableField(value = "peisong_content")

    private String peisongContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "peisong_delete")

    private Integer peisongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：配送标题
	 */
    public String getPeisongName() {
        return peisongName;
    }
    /**
	 * 设置：配送标题
	 */

    public void setPeisongName(String peisongName) {
        this.peisongName = peisongName;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：配送状态
	 */
    public Integer getPeisongTypes() {
        return peisongTypes;
    }
    /**
	 * 设置：配送状态
	 */

    public void setPeisongTypes(Integer peisongTypes) {
        this.peisongTypes = peisongTypes;
    }
    /**
	 * 获取：配送数量
	 */
    public Integer getPeisongKucunNumber() {
        return peisongKucunNumber;
    }
    /**
	 * 设置：配送数量
	 */

    public void setPeisongKucunNumber(Integer peisongKucunNumber) {
        this.peisongKucunNumber = peisongKucunNumber;
    }
    /**
	 * 获取：配送详情
	 */
    public String getPeisongContent() {
        return peisongContent;
    }
    /**
	 * 设置：配送详情
	 */

    public void setPeisongContent(String peisongContent) {
        this.peisongContent = peisongContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getPeisongDelete() {
        return peisongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setPeisongDelete(Integer peisongDelete) {
        this.peisongDelete = peisongDelete;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Peisong{" +
            ", id=" + id +
            ", peisongName=" + peisongName +
            ", yonghuId=" + yonghuId +
            ", peisongTypes=" + peisongTypes +
            ", peisongKucunNumber=" + peisongKucunNumber +
            ", peisongContent=" + peisongContent +
            ", peisongDelete=" + peisongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
