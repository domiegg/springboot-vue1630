package com.entity.model;

import com.entity.NongchanpinweituoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品委托
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongchanpinweituoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 委托标题
     */
    private String nongchanpinweituoName;


    /**
     * 委托类型
     */
    private Integer nongchanpinweituoTypes;


    /**
     * 封面
     */
    private String nongchanpinweituoPhoto;


    /**
     * 委托数量
     */
    private Integer nongchanpinweituoKucunNumber;


    /**
     * 委托详情
     */
    private String nongchanpinweituoContent;


    /**
     * 逻辑删除
     */
    private Integer nongchanpinweituoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
