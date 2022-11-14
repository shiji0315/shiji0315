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
 * @Description: 款式模块表
 * @Author: jeecg-boot
 * @Date:   2022-11-12
 * @Version: V1.0
 */
@Data
@TableName("zy_style_module")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="zy_style_module对象", description="款式模块表")
public class ZyStyleModule implements Serializable {
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
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**服装类型id*/
	@Excel(name = "服装类型id", width = 15, dictTable = "zy_cloths_type", dicText = "nums", dicCode = "id")
	@Dict(dictTable = "zy_cloths_type", dicText = "nums", dicCode = "id")
    @ApiModelProperty(value = "服装类型id")
    private java.lang.String clothsTypeId;
	/**款式id*/
	@Excel(name = "款式id", width = 15, dictTable = "zy_cloths_style", dicText = "style_names", dicCode = "id")
	@Dict(dictTable = "zy_cloths_style", dicText = "style_names", dicCode = "id")
    @ApiModelProperty(value = "款式id")
    private java.lang.String styleId;
	/**模块id*/
	@Excel(name = "模块id", width = 15, dictTable = "zy_cloths_modular", dicText = "modular_name", dicCode = "id")
	@Dict(dictTable = "zy_cloths_modular", dicText = "modular_name", dicCode = "id")
    @ApiModelProperty(value = "模块id")
    private java.lang.String modularId;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
}
