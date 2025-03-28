package com.entity.model;

import com.entity.GongyingshangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品供应商
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongyingshangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 供应商姓名
     */
    private String gongyingshangName;


    /**
     * 头像
     */
    private String gongyingshangPhoto;


    /**
     * 联系方式
     */
    private String gongyingshangPhone;


    /**
     * 邮箱
     */
    private String gongyingshangEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 供应商类型
     */
    private Integer gongyingshangTypes;


    /**
     * 简介
     */
    private String gongyingshangContent;


    /**
     * 假删
     */
    private Integer gongyingshangDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
