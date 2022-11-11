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
import org.jeecg.modules.demo.zy.entity.ZyStyleModule;
import org.jeecg.modules.demo.zy.service.IZyStyleModuleService;

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
 * @Description: 款式模块表
 * @Author: jeecg-boot
 * @Date:   2022-11-06
 * @Version: V1.0
 */
@Api(tags="款式模块表")
@RestController
@RequestMapping("/zy/zyStyleModule")
@Slf4j
public class ZyStyleModuleController extends JeecgController<ZyStyleModule, IZyStyleModuleService> {
	@Autowired
	private IZyStyleModuleService zyStyleModuleService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zyStyleModule
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "款式模块表-分页列表查询")
	@ApiOperation(value="款式模块表-分页列表查询", notes="款式模块表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ZyStyleModule>> queryPageList(ZyStyleModule zyStyleModule,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ZyStyleModule> queryWrapper = QueryGenerator.initQueryWrapper(zyStyleModule, req.getParameterMap());
		Page<ZyStyleModule> page = new Page<ZyStyleModule>(pageNo, pageSize);
		IPage<ZyStyleModule> pageList = zyStyleModuleService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zyStyleModule
	 * @return
	 */
	@AutoLog(value = "款式模块表-添加")
	@ApiOperation(value="款式模块表-添加", notes="款式模块表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style_module:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ZyStyleModule zyStyleModule) {
		zyStyleModuleService.save(zyStyleModule);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zyStyleModule
	 * @return
	 */
	@AutoLog(value = "款式模块表-编辑")
	@ApiOperation(value="款式模块表-编辑", notes="款式模块表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style_module:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ZyStyleModule zyStyleModule) {
		zyStyleModuleService.updateById(zyStyleModule);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "款式模块表-通过id删除")
	@ApiOperation(value="款式模块表-通过id删除", notes="款式模块表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style_module:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zyStyleModuleService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "款式模块表-批量删除")
	@ApiOperation(value="款式模块表-批量删除", notes="款式模块表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style_module:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zyStyleModuleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "款式模块表-通过id查询")
	@ApiOperation(value="款式模块表-通过id查询", notes="款式模块表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ZyStyleModule> queryById(@RequestParam(name="id",required=true) String id) {
		ZyStyleModule zyStyleModule = zyStyleModuleService.getById(id);
		if(zyStyleModule==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zyStyleModule);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zyStyleModule
    */
    //@RequiresPermissions("org.jeecg.modules.demo:zy_style_module:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ZyStyleModule zyStyleModule) {
        return super.exportXls(request, zyStyleModule, ZyStyleModule.class, "款式模块表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("zy_style_module:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ZyStyleModule.class);
    }

}
