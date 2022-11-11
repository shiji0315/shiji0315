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
import org.jeecg.modules.demo.zy.entity.ZyStyle_Modular;
import org.jeecg.modules.demo.zy.service.IZyStyle_ModularService;

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
 * @Description: 款式工序表
 * @Author: jeecg-boot
 * @Date:   2022-11-06
 * @Version: V1.0
 */
@Api(tags="款式工序表")
@RestController
@RequestMapping("/zy/zyStyle_Modular")
@Slf4j
public class ZyStyle_ModularController extends JeecgController<ZyStyle_Modular, IZyStyle_ModularService> {
	@Autowired
	private IZyStyle_ModularService zyStyle_ModularService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zyStyle_Modular
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "款式工序表-分页列表查询")
	@ApiOperation(value="款式工序表-分页列表查询", notes="款式工序表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ZyStyle_Modular>> queryPageList(ZyStyle_Modular zyStyle_Modular,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ZyStyle_Modular> queryWrapper = QueryGenerator.initQueryWrapper(zyStyle_Modular, req.getParameterMap());
		Page<ZyStyle_Modular> page = new Page<ZyStyle_Modular>(pageNo, pageSize);
		IPage<ZyStyle_Modular> pageList = zyStyle_ModularService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zyStyle_Modular
	 * @return
	 */
	@AutoLog(value = "款式工序表-添加")
	@ApiOperation(value="款式工序表-添加", notes="款式工序表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style__modular:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ZyStyle_Modular zyStyle_Modular) {
		zyStyle_ModularService.save(zyStyle_Modular);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zyStyle_Modular
	 * @return
	 */
	@AutoLog(value = "款式工序表-编辑")
	@ApiOperation(value="款式工序表-编辑", notes="款式工序表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style__modular:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ZyStyle_Modular zyStyle_Modular) {
		zyStyle_ModularService.updateById(zyStyle_Modular);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "款式工序表-通过id删除")
	@ApiOperation(value="款式工序表-通过id删除", notes="款式工序表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style__modular:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zyStyle_ModularService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "款式工序表-批量删除")
	@ApiOperation(value="款式工序表-批量删除", notes="款式工序表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_style__modular:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zyStyle_ModularService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "款式工序表-通过id查询")
	@ApiOperation(value="款式工序表-通过id查询", notes="款式工序表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ZyStyle_Modular> queryById(@RequestParam(name="id",required=true) String id) {
		ZyStyle_Modular zyStyle_Modular = zyStyle_ModularService.getById(id);
		if(zyStyle_Modular==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zyStyle_Modular);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zyStyle_Modular
    */
    //@RequiresPermissions("org.jeecg.modules.demo:zy_style__modular:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ZyStyle_Modular zyStyle_Modular) {
        return super.exportXls(request, zyStyle_Modular, ZyStyle_Modular.class, "款式工序表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("zy_style__modular:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ZyStyle_Modular.class);
    }

}
