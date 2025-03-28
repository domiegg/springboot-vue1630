package com.entity.vo;

import com.entity.NongchanpinweituoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品委托
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongchanpinweituo")
public class NongchanpinweituoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 委托标题
     */

    @TableField(value = "nongchanpinweituo_name")
    private String nongchanpinweituoName;


    /**
     * 委托类型
     */

    @TableField(value = "nongchanpinweituo_types")
    private Integer nongchanpinweituoTypes;


    /**
     * 封面
     */

    @TableField(value = "nongchanpinweituo_photo")
    private String nongchanpinweituoPhoto;


    /**
     * 委托数量
     */

    @TableField(value = "nongchanpinweituo_kucun_number")
    private Integer nongchanpinweituoKucunNumber;


    /**
     * 委托详情
     */

    @TableField(value = "nongchanpinweituo_content")
    private String nongchanpinweituoContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "nongchanpinweituo_delete")
    private Integer nongchanpinweituoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：委托标题
	 */
    public String getNongchanpinweituoName() {
        return nongchanpinweituoName;
    }


    /**
	 * 获取：委托标题
	 */

    public void setNongchanpinweituoName(String nongchanpinweituoName) {
        this.nongchanpinweituoName = nongchanpinweituoName;
    }
    /**
	 * 设置：委托类型
	 */
    public Integer getNongchanpinweituoTypes() {
        return nongchanpinweituoTypes;
    }


    /**
	 * 获取：委托类型
	 */

    public void setNongchanpinweituoTypes(Integer nongchanpinweituoTypes) {
        this.nongchanpinweituoTypes = nongchanpinweituoTypes;
    }
    /**
	 * 设置：封面
	 */
    public String getNongchanpinweituoPhoto() {
        return nongchanpinweituoPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setNongchanpinweituoPhoto(String nongchanpinweituoPhoto) {
        this.nongchanpinweituoPhoto = nongchanpinweituoPhoto;
    }
    /**
	 * 设置：委托数量
	 */
    public Integer getNongchanpinweituoKucunNumber() {
        return nongchanpinweituoKucunNumber;
    }


    /**
	 * 获取：委托数量
	 */

    public void setNongchanpinweituoKucunNumber(Integer nongchanpinweituoKucunNumber) {
        this.nongchanpinweituoKucunNumber = nongchanpinweituoKucunNumber;
    }
    /**
	 * 设置：委托详情
	 */
    public String getNongchanpinweituoContent() {
        return nongchanpinweituoContent;
    }


    /**
	 * 获取：委托详情
	 */

    public void setNongchanpinweituoContent(String nongchanpinweituoContent) {
        this.nongchanpinweituoContent = nongchanpinweituoContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getNongchanpinweituoDelete() {
        return nongchanpinweituoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setNongchanpinweituoDelete(Integer nongchanpinweituoDelete) {
        this.nongchanpinweituoDelete = nongchanpinweituoDelete;
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
