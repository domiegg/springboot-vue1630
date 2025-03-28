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
 * 农产品物流公司
 *
 * @author 
 * @email
 */
@TableName("wuliugongsi")
public class WuliugongsiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuliugongsiEntity() {

	}

	public WuliugongsiEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 物流公司姓名
     */
    @ColumnInfo(comment="物流公司姓名",type="varchar(200)")
    @TableField(value = "wuliugongsi_name")

    private String wuliugongsiName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "wuliugongsi_photo")

    private String wuliugongsiPhoto;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "wuliugongsi_phone")

    private String wuliugongsiPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "wuliugongsi_email")

    private String wuliugongsiEmail;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 物流公司类型
     */
    @ColumnInfo(comment="物流公司类型",type="int(11)")
    @TableField(value = "wuliugongsi_types")

    private Integer wuliugongsiTypes;


    /**
     * 仓库信息简介
     */
    @ColumnInfo(comment="仓库信息简介",type="text")
    @TableField(value = "wuliugongsi_content")

    private String wuliugongsiContent;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "wuliugongsi_delete")

    private Integer wuliugongsiDelete;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：物流公司姓名
	 */
    public String getWuliugongsiName() {
        return wuliugongsiName;
    }
    /**
	 * 设置：物流公司姓名
	 */

    public void setWuliugongsiName(String wuliugongsiName) {
        this.wuliugongsiName = wuliugongsiName;
    }
    /**
	 * 获取：头像
	 */
    public String getWuliugongsiPhoto() {
        return wuliugongsiPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setWuliugongsiPhoto(String wuliugongsiPhoto) {
        this.wuliugongsiPhoto = wuliugongsiPhoto;
    }
    /**
	 * 获取：联系方式
	 */
    public String getWuliugongsiPhone() {
        return wuliugongsiPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setWuliugongsiPhone(String wuliugongsiPhone) {
        this.wuliugongsiPhone = wuliugongsiPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getWuliugongsiEmail() {
        return wuliugongsiEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setWuliugongsiEmail(String wuliugongsiEmail) {
        this.wuliugongsiEmail = wuliugongsiEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：物流公司类型
	 */
    public Integer getWuliugongsiTypes() {
        return wuliugongsiTypes;
    }
    /**
	 * 设置：物流公司类型
	 */

    public void setWuliugongsiTypes(Integer wuliugongsiTypes) {
        this.wuliugongsiTypes = wuliugongsiTypes;
    }
    /**
	 * 获取：仓库信息简介
	 */
    public String getWuliugongsiContent() {
        return wuliugongsiContent;
    }
    /**
	 * 设置：仓库信息简介
	 */

    public void setWuliugongsiContent(String wuliugongsiContent) {
        this.wuliugongsiContent = wuliugongsiContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getWuliugongsiDelete() {
        return wuliugongsiDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setWuliugongsiDelete(Integer wuliugongsiDelete) {
        this.wuliugongsiDelete = wuliugongsiDelete;
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
        return "Wuliugongsi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", wuliugongsiName=" + wuliugongsiName +
            ", wuliugongsiPhoto=" + wuliugongsiPhoto +
            ", wuliugongsiPhone=" + wuliugongsiPhone +
            ", wuliugongsiEmail=" + wuliugongsiEmail +
            ", sexTypes=" + sexTypes +
            ", wuliugongsiTypes=" + wuliugongsiTypes +
            ", wuliugongsiContent=" + wuliugongsiContent +
            ", wuliugongsiDelete=" + wuliugongsiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
