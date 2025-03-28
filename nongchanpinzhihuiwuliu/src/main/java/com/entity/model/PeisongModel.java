package com.entity.model;

import com.entity.PeisongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品配送
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeisongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 配送标题
     */
    private String peisongName;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 配送状态
     */
    private Integer peisongTypes;


    /**
     * 配送数量
     */
    private Integer peisongKucunNumber;


    /**
     * 配送详情
     */
    private String peisongContent;


    /**
     * 逻辑删除
     */
    private Integer peisongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
