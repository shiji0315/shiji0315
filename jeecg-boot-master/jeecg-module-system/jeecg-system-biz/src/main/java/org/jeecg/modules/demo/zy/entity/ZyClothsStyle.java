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
 * @Description: 服装款式表
 * @Author: jeecg-boot
 * @Date:   2022-11-12
 * @Version: V1.0
 */
@Data
@TableName("zy_cloths_style")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zy_cloths_style对象", description="服装款式表")
public class ZyClothsStyle implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**服装类型id*/
	@Excel(name = "服装类型id", width = 15)
    @ApiModelProperty(value = "服装类型id")
    private java.lang.String clothsTypeId;
	/**形式*/
	@Excel(name = "形式", width = 15, dicCode = "style_shape")
	@Dict(dicCode = "style_shape")
    @ApiModelProperty(value = "形式")
    private java.lang.Integer shape;
	/**编号*/
	@Excel(name = "编号", width = 15)
    @ApiModelProperty(value = "编号")
    private java.lang.String nums;
	/**名称*/
	@Excel(name = "名称", width = 15)
    @ApiModelProperty(value = "名称")
    private java.lang.String styleNames;
	/**规格*/
	@Excel(name = "规格", width = 15)
    @ApiModelProperty(value = "规格")
    private java.lang.String specification;
	/**销售地区*/
	@Excel(name = "销售地区", width = 15)
    @ApiModelProperty(value = "销售地区")
    private java.lang.String salesTerritory;
	/**产品概述*/
	@Excel(name = "产品概述", width = 15)
    @ApiModelProperty(value = "产品概述")
    private java.lang.String productOverview;
	/**结构*/
	@Excel(name = "结构", width = 15)
    @ApiModelProperty(value = "结构")
    private java.lang.String structure;
	/**特征*/
	@Excel(name = "特征", width = 15)
    @ApiModelProperty(value = "特征")
    private java.lang.String characteristic;
	/**效果图*/
	@Excel(name = "效果图", width = 15)
    @ApiModelProperty(value = "效果图")
    private java.lang.String designSketch;
	/**主图*/
	@Excel(name = "主图", width = 15)
    @ApiModelProperty(value = "主图")
    private java.lang.String mainMap;
	/**测量方法*/
	@Excel(name = "测量方法", width = 15)
    @ApiModelProperty(value = "测量方法")
    private java.lang.String measuringMethod;
	/**误差*/
	@Excel(name = "误差", width = 15)
    @ApiModelProperty(value = "误差")
    private java.lang.String error;
	/**定额用料*/
	@Excel(name = "定额用料", width = 15)
    @ApiModelProperty(value = "定额用料")
    private java.lang.String quotaMaterials;
	/**折叠搭配及包装*/
	@Excel(name = "折叠搭配及包装", width = 15)
    @ApiModelProperty(value = "折叠搭配及包装")
    private java.lang.String foldingPackaging;
	/**配件及标志*/
	@Excel(name = "配件及标志", width = 15)
    @ApiModelProperty(value = "配件及标志")
    private java.lang.String accLogos;
	/**缝纫形式*/
	@Excel(name = "缝纫形式", width = 15)
    @ApiModelProperty(value = "缝纫形式")
    private java.lang.String sewingForm;
	/**企业id*/
	@Excel(name = "企业id", width = 15)
    @ApiModelProperty(value = "企业id")
    private java.lang.String enterpriseId;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
}
