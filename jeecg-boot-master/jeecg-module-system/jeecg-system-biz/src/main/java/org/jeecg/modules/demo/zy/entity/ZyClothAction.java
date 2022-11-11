package org.jeecg.modules.demo.zy.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 基础动作表
 * @Author: jeecg-boot
 * @Date:   2022-11-06
 * @Version: V1.0
 */
@Data
@TableName("zy_cloth_action")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zy_cloth_action对象", description="基础动作表")
public class ZyClothAction implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**频率*/
	@Excel(name = "频率", width = 15)
    @ApiModelProperty(value = "频率")
    private java.lang.Integer freq;
	/**描述*/
	@Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
    private java.lang.String descr;
	/**设备TMU*/
	@Excel(name = "设备TMU", width = 15)
    @ApiModelProperty(value = "设备TMU")
    private java.lang.Integer machineTmu;
	/**手工TMU*/
	@Excel(name = "手工TMU", width = 15)
    @ApiModelProperty(value = "手工TMU")
    private java.lang.Integer manualTmu;
	/**图片*/
	@Excel(name = "图片", width = 15)
    @ApiModelProperty(value = "图片")
    private java.lang.String image;
	/**视频*/
	@Excel(name = "视频", width = 15)
    @ApiModelProperty(value = "视频")
    private java.lang.String vedio;
	/**编号*/
	@Excel(name = "编号", width = 15)
    @ApiModelProperty(value = "编号")
    private java.lang.String nums;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
}
