package com.entity.vo;

import com.entity.WuliugongsiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品物流公司
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuliugongsi")
public class WuliugongsiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 物流公司姓名
     */

    @TableField(value = "wuliugongsi_name")
    private String wuliugongsiName;


    /**
     * 头像
     */

    @TableField(value = "wuliugongsi_photo")
    private String wuliugongsiPhoto;


    /**
     * 联系方式
     */

    @TableField(value = "wuliugongsi_phone")
    private String wuliugongsiPhone;


    /**
     * 邮箱
     */

    @TableField(value = "wuliugongsi_email")
    private String wuliugongsiEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 物流公司类型
     */

    @TableField(value = "wuliugongsi_types")
    private Integer wuliugongsiTypes;


    /**
     * 仓库信息简介
     */

    @TableField(value = "wuliugongsi_content")
    private String wuliugongsiContent;


    /**
     * 假删
     */

    @TableField(value = "wuliugongsi_delete")
    private Integer wuliugongsiDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：物流公司姓名
	 */
    public String getWuliugongsiName() {
        return wuliugongsiName;
    }


    /**
	 * 获取：物流公司姓名
	 */

    public void setWuliugongsiName(String wuliugongsiName) {
        this.wuliugongsiName = wuliugongsiName;
    }
    /**
	 * 设置：头像
	 */
    public String getWuliugongsiPhoto() {
        return wuliugongsiPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setWuliugongsiPhoto(String wuliugongsiPhoto) {
        this.wuliugongsiPhoto = wuliugongsiPhoto;
    }
    /**
	 * 设置：联系方式
	 */
    public String getWuliugongsiPhone() {
        return wuliugongsiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setWuliugongsiPhone(String wuliugongsiPhone) {
        this.wuliugongsiPhone = wuliugongsiPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getWuliugongsiEmail() {
        return wuliugongsiEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setWuliugongsiEmail(String wuliugongsiEmail) {
        this.wuliugongsiEmail = wuliugongsiEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：物流公司类型
	 */
    public Integer getWuliugongsiTypes() {
        return wuliugongsiTypes;
    }


    /**
	 * 获取：物流公司类型
	 */

    public void setWuliugongsiTypes(Integer wuliugongsiTypes) {
        this.wuliugongsiTypes = wuliugongsiTypes;
    }
    /**
	 * 设置：仓库信息简介
	 */
    public String getWuliugongsiContent() {
        return wuliugongsiContent;
    }


    /**
	 * 获取：仓库信息简介
	 */

    public void setWuliugongsiContent(String wuliugongsiContent) {
        this.wuliugongsiContent = wuliugongsiContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getWuliugongsiDelete() {
        return wuliugongsiDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setWuliugongsiDelete(Integer wuliugongsiDelete) {
        this.wuliugongsiDelete = wuliugongsiDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
