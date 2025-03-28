package com.entity.model;

import com.entity.WuliugongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品物流公司
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuliugongsiModel implements Serializable {
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
     * 物流公司姓名
     */
    private String wuliugongsiName;


    /**
     * 头像
     */
    private String wuliugongsiPhoto;


    /**
     * 联系方式
     */
    private String wuliugongsiPhone;


    /**
     * 邮箱
     */
    private String wuliugongsiEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 物流公司类型
     */
    private Integer wuliugongsiTypes;


    /**
     * 仓库信息简介
     */
    private String wuliugongsiContent;


    /**
     * 假删
     */
    private Integer wuliugongsiDelete;


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
