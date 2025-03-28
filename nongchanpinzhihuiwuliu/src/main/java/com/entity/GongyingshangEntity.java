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
 * 农产品供应商
 *
 * @author 
 * @email
 */
@TableName("gongyingshang")
public class GongyingshangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongyingshangEntity() {

	}

	public GongyingshangEntity(T t) {
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
     * 供应商姓名
     */
    @ColumnInfo(comment="供应商姓名",type="varchar(200)")
    @TableField(value = "gongyingshang_name")

    private String gongyingshangName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "gongyingshang_photo")

    private String gongyingshangPhoto;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "gongyingshang_phone")

    private String gongyingshangPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "gongyingshang_email")

    private String gongyingshangEmail;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 供应商类型
     */
    @ColumnInfo(comment="供应商类型",type="int(11)")
    @TableField(value = "gongyingshang_types")

    private Integer gongyingshangTypes;


    /**
     * 简介
     */
    @ColumnInfo(comment="简介",type="text")
    @TableField(value = "gongyingshang_content")

    private String gongyingshangContent;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "gongyingshang_delete")

    private Integer gongyingshangDelete;


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
	 * 获取：供应商姓名
	 */
    public String getGongyingshangName() {
        return gongyingshangName;
    }
    /**
	 * 设置：供应商姓名
	 */

    public void setGongyingshangName(String gongyingshangName) {
        this.gongyingshangName = gongyingshangName;
    }
    /**
	 * 获取：头像
	 */
    public String getGongyingshangPhoto() {
        return gongyingshangPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setGongyingshangPhoto(String gongyingshangPhoto) {
        this.gongyingshangPhoto = gongyingshangPhoto;
    }
    /**
	 * 获取：联系方式
	 */
    public String getGongyingshangPhone() {
        return gongyingshangPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setGongyingshangPhone(String gongyingshangPhone) {
        this.gongyingshangPhone = gongyingshangPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getGongyingshangEmail() {
        return gongyingshangEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setGongyingshangEmail(String gongyingshangEmail) {
        this.gongyingshangEmail = gongyingshangEmail;
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
	 * 获取：供应商类型
	 */
    public Integer getGongyingshangTypes() {
        return gongyingshangTypes;
    }
    /**
	 * 设置：供应商类型
	 */

    public void setGongyingshangTypes(Integer gongyingshangTypes) {
        this.gongyingshangTypes = gongyingshangTypes;
    }
    /**
	 * 获取：简介
	 */
    public String getGongyingshangContent() {
        return gongyingshangContent;
    }
    /**
	 * 设置：简介
	 */

    public void setGongyingshangContent(String gongyingshangContent) {
        this.gongyingshangContent = gongyingshangContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getGongyingshangDelete() {
        return gongyingshangDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setGongyingshangDelete(Integer gongyingshangDelete) {
        this.gongyingshangDelete = gongyingshangDelete;
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
        return "Gongyingshang{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongyingshangName=" + gongyingshangName +
            ", gongyingshangPhoto=" + gongyingshangPhoto +
            ", gongyingshangPhone=" + gongyingshangPhone +
            ", gongyingshangEmail=" + gongyingshangEmail +
            ", sexTypes=" + sexTypes +
            ", gongyingshangTypes=" + gongyingshangTypes +
            ", gongyingshangContent=" + gongyingshangContent +
            ", gongyingshangDelete=" + gongyingshangDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
