package com.entity.vo;

import com.entity.PeisongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品配送
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("peisong")
public class PeisongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 配送标题
     */

    @TableField(value = "peisong_name")
    private String peisongName;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 配送状态
     */

    @TableField(value = "peisong_types")
    private Integer peisongTypes;


    /**
     * 配送数量
     */

    @TableField(value = "peisong_kucun_number")
    private Integer peisongKucunNumber;


    /**
     * 配送详情
     */

    @TableField(value = "peisong_content")
    private String peisongContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "peisong_delete")
    private Integer peisongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：配送标题
	 */
    public String getPeisongName() {
        return peisongName;
    }


    /**
	 * 获取：配送标题
	 */

    public void setPeisongName(String peisongName) {
        this.peisongName = peisongName;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：配送状态
	 */
    public Integer getPeisongTypes() {
        return peisongTypes;
    }


    /**
	 * 获取：配送状态
	 */

    public void setPeisongTypes(Integer peisongTypes) {
        this.peisongTypes = peisongTypes;
    }
    /**
	 * 设置：配送数量
	 */
    public Integer getPeisongKucunNumber() {
        return peisongKucunNumber;
    }


    /**
	 * 获取：配送数量
	 */

    public void setPeisongKucunNumber(Integer peisongKucunNumber) {
        this.peisongKucunNumber = peisongKucunNumber;
    }
    /**
	 * 设置：配送详情
	 */
    public String getPeisongContent() {
        return peisongContent;
    }


    /**
	 * 获取：配送详情
	 */

    public void setPeisongContent(String peisongContent) {
        this.peisongContent = peisongContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getPeisongDelete() {
        return peisongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setPeisongDelete(Integer peisongDelete) {
        this.peisongDelete = peisongDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
