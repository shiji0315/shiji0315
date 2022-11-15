package org.jeecg.modules.demo.zy.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.zy.entity.ZyClothsStyle;
import org.jeecg.modules.demo.zy.service.IZyClothsStyleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 服装款式表
 * @Author: jeecg-boot
 * @Date:   2022-11-15
 * @Version: V1.0
 */
@Api(tags="服装款式表")
@RestController
@RequestMapping("/zy/zyClothsStyle")
@Slf4j
public class ZyClothsStyleController extends JeecgController<ZyClothsStyle, IZyClothsStyleService> {
	@Autowired
	private IZyClothsStyleService zyClothsStyleService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zyClothsStyle
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "服装款式表-分页列表查询")
	@ApiOperation(value="服装款式表-分页列表查询", notes="服装款式表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ZyClothsStyle>> queryPageList(ZyClothsStyle zyClothsStyle,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ZyClothsStyle> queryWrapper = QueryGenerator.initQueryWrapper(zyClothsStyle, req.getParameterMap());
		Page<ZyClothsStyle> page = new Page<ZyClothsStyle>(pageNo, pageSize);
		IPage<ZyClothsStyle> pageList = zyClothsStyleService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zyClothsStyle
	 * @return
	 */
	@AutoLog(value = "服装款式表-添加")
	@ApiOperation(value="服装款式表-添加", notes="服装款式表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_style:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ZyClothsStyle zyClothsStyle) {
		zyClothsStyleService.save(zyClothsStyle);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zyClothsStyle
	 * @return
	 */
	@AutoLog(value = "服装款式表-编辑")
	@ApiOperation(value="服装款式表-编辑", notes="服装款式表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_style:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ZyClothsStyle zyClothsStyle) {
		zyClothsStyleService.updateById(zyClothsStyle);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "服装款式表-通过id删除")
	@ApiOperation(value="服装款式表-通过id删除", notes="服装款式表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_style:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zyClothsStyleService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "服装款式表-批量删除")
	@ApiOperation(value="服装款式表-批量删除", notes="服装款式表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_style:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zyClothsStyleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "服装款式表-通过id查询")
	@ApiOperation(value="服装款式表-通过id查询", notes="服装款式表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ZyClothsStyle> queryById(@RequestParam(name="id",required=true) String id) {
		ZyClothsStyle zyClothsStyle = zyClothsStyleService.getById(id);
		if(zyClothsStyle==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zyClothsStyle);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zyClothsStyle
    */
    //@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_style:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ZyClothsStyle zyClothsStyle) {
        return super.exportXls(request, zyClothsStyle, ZyClothsStyle.class, "服装款式表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("zy_cloths_style:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ZyClothsStyle.class);
    }

}
