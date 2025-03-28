package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

	//级联表 农产品供应商
		/**
		* 供应商姓名
		*/

		@ColumnInfo(comment="供应商姓名",type="varchar(200)")
		private String gongyingshangName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String gongyingshangPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String gongyingshangPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String gongyingshangEmail;
		/**
		* 供应商类型
		*/
		@ColumnInfo(comment="供应商类型",type="int(11)")
		private Integer gongyingshangTypes;
			/**
			* 供应商类型的值
			*/
			@ColumnInfo(comment="供应商类型的字典表值",type="varchar(200)")
			private String gongyingshangValue;
		/**
		* 简介
		*/

		@ColumnInfo(comment="简介",type="text")
		private String gongyingshangContent;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer gongyingshangDelete;
	//级联表 农产品物流公司
		/**
		* 物流公司姓名
		*/

		@ColumnInfo(comment="物流公司姓名",type="varchar(200)")
		private String wuliugongsiName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String wuliugongsiPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String wuliugongsiPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String wuliugongsiEmail;
		/**
		* 物流公司类型
		*/
		@ColumnInfo(comment="物流公司类型",type="int(11)")
		private Integer wuliugongsiTypes;
			/**
			* 物流公司类型的值
			*/
			@ColumnInfo(comment="物流公司类型的字典表值",type="varchar(200)")
			private String wuliugongsiValue;
		/**
		* 仓库信息简介
		*/

		@ColumnInfo(comment="仓库信息简介",type="text")
		private String wuliugongsiContent;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer wuliugongsiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;
	//级联表 管理员
		/**
		* 用户名
		*/
		@ColumnInfo(comment="用户名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
	}


	//级联表的get和set 农产品供应商

		/**
		* 获取： 供应商姓名
		*/
		public String getGongyingshangName() {
			return gongyingshangName;
		}
		/**
		* 设置： 供应商姓名
		*/
		public void setGongyingshangName(String gongyingshangName) {
			this.gongyingshangName = gongyingshangName;
		}

		/**
		* 获取： 头像
		*/
		public String getGongyingshangPhoto() {
			return gongyingshangPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setGongyingshangPhoto(String gongyingshangPhoto) {
			this.gongyingshangPhoto = gongyingshangPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getGongyingshangPhone() {
			return gongyingshangPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setGongyingshangPhone(String gongyingshangPhone) {
			this.gongyingshangPhone = gongyingshangPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getGongyingshangEmail() {
			return gongyingshangEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setGongyingshangEmail(String gongyingshangEmail) {
			this.gongyingshangEmail = gongyingshangEmail;
		}
		/**
		* 获取： 供应商类型
		*/
		public Integer getGongyingshangTypes() {
			return gongyingshangTypes;
		}
		/**
		* 设置： 供应商类型
		*/
		public void setGongyingshangTypes(Integer gongyingshangTypes) {
			this.gongyingshangTypes = gongyingshangTypes;
		}


			/**
			* 获取： 供应商类型的值
			*/
			public String getGongyingshangValue() {
				return gongyingshangValue;
			}
			/**
			* 设置： 供应商类型的值
			*/
			public void setGongyingshangValue(String gongyingshangValue) {
				this.gongyingshangValue = gongyingshangValue;
			}

		/**
		* 获取： 简介
		*/
		public String getGongyingshangContent() {
			return gongyingshangContent;
		}
		/**
		* 设置： 简介
		*/
		public void setGongyingshangContent(String gongyingshangContent) {
			this.gongyingshangContent = gongyingshangContent;
		}

		/**
		* 获取： 假删
		*/
		public Integer getGongyingshangDelete() {
			return gongyingshangDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setGongyingshangDelete(Integer gongyingshangDelete) {
			this.gongyingshangDelete = gongyingshangDelete;
		}
	//级联表的get和set 农产品物流公司

		/**
		* 获取： 物流公司姓名
		*/
		public String getWuliugongsiName() {
			return wuliugongsiName;
		}
		/**
		* 设置： 物流公司姓名
		*/
		public void setWuliugongsiName(String wuliugongsiName) {
			this.wuliugongsiName = wuliugongsiName;
		}

		/**
		* 获取： 头像
		*/
		public String getWuliugongsiPhoto() {
			return wuliugongsiPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setWuliugongsiPhoto(String wuliugongsiPhoto) {
			this.wuliugongsiPhoto = wuliugongsiPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getWuliugongsiPhone() {
			return wuliugongsiPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setWuliugongsiPhone(String wuliugongsiPhone) {
			this.wuliugongsiPhone = wuliugongsiPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getWuliugongsiEmail() {
			return wuliugongsiEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setWuliugongsiEmail(String wuliugongsiEmail) {
			this.wuliugongsiEmail = wuliugongsiEmail;
		}
		/**
		* 获取： 物流公司类型
		*/
		public Integer getWuliugongsiTypes() {
			return wuliugongsiTypes;
		}
		/**
		* 设置： 物流公司类型
		*/
		public void setWuliugongsiTypes(Integer wuliugongsiTypes) {
			this.wuliugongsiTypes = wuliugongsiTypes;
		}


			/**
			* 获取： 物流公司类型的值
			*/
			public String getWuliugongsiValue() {
				return wuliugongsiValue;
			}
			/**
			* 设置： 物流公司类型的值
			*/
			public void setWuliugongsiValue(String wuliugongsiValue) {
				this.wuliugongsiValue = wuliugongsiValue;
			}

		/**
		* 获取： 仓库信息简介
		*/
		public String getWuliugongsiContent() {
			return wuliugongsiContent;
		}
		/**
		* 设置： 仓库信息简介
		*/
		public void setWuliugongsiContent(String wuliugongsiContent) {
			this.wuliugongsiContent = wuliugongsiContent;
		}

		/**
		* 获取： 假删
		*/
		public Integer getWuliugongsiDelete() {
			return wuliugongsiDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setWuliugongsiDelete(Integer wuliugongsiDelete) {
			this.wuliugongsiDelete = wuliugongsiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}
	//级联表的get和set 管理员
		/**
		* 获取： 用户名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 用户名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ForumView{" +
			", forumStateValue=" + forumStateValue +
			", gongyingshangName=" + gongyingshangName +
			", gongyingshangPhoto=" + gongyingshangPhoto +
			", gongyingshangPhone=" + gongyingshangPhone +
			", gongyingshangEmail=" + gongyingshangEmail +
			", gongyingshangContent=" + gongyingshangContent +
			", gongyingshangDelete=" + gongyingshangDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", wuliugongsiName=" + wuliugongsiName +
			", wuliugongsiPhoto=" + wuliugongsiPhoto +
			", wuliugongsiPhone=" + wuliugongsiPhone +
			", wuliugongsiEmail=" + wuliugongsiEmail +
			", wuliugongsiContent=" + wuliugongsiContent +
			", wuliugongsiDelete=" + wuliugongsiDelete +
			"} " + super.toString();
	}
}
