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
import org.jeecg.modules.demo.zy.entity.ZyModularComx;
import org.jeecg.modules.demo.zy.service.IZyModularComxService;

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
 * @Description: 模块部件表
 * @Author: jeecg-boot
 * @Date:   2022-11-06
 * @Version: V1.0
 */
@Api(tags="模块部件表")
@RestController
@RequestMapping("/zy/zyModularComx")
@Slf4j
public class ZyModularComxController extends JeecgController<ZyModularComx, IZyModularComxService> {
	@Autowired
	private IZyModularComxService zyModularComxService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zyModularComx
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "模块部件表-分页列表查询")
	@ApiOperation(value="模块部件表-分页列表查询", notes="模块部件表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ZyModularComx>> queryPageList(ZyModularComx zyModularComx,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ZyModularComx> queryWrapper = QueryGenerator.initQueryWrapper(zyModularComx, req.getParameterMap());
		Page<ZyModularComx> page = new Page<ZyModularComx>(pageNo, pageSize);
		IPage<ZyModularComx> pageList = zyModularComxService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zyModularComx
	 * @return
	 */
	@AutoLog(value = "模块部件表-添加")
	@ApiOperation(value="模块部件表-添加", notes="模块部件表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_modular_comx:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ZyModularComx zyModularComx) {
		zyModularComxService.save(zyModularComx);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zyModularComx
	 * @return
	 */
	@AutoLog(value = "模块部件表-编辑")
	@ApiOperation(value="模块部件表-编辑", notes="模块部件表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_modular_comx:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ZyModularComx zyModularComx) {
		zyModularComxService.updateById(zyModularComx);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "模块部件表-通过id删除")
	@ApiOperation(value="模块部件表-通过id删除", notes="模块部件表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_modular_comx:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zyModularComxService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "模块部件表-批量删除")
	@ApiOperation(value="模块部件表-批量删除", notes="模块部件表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_modular_comx:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zyModularComxService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "模块部件表-通过id查询")
	@ApiOperation(value="模块部件表-通过id查询", notes="模块部件表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ZyModularComx> queryById(@RequestParam(name="id",required=true) String id) {
		ZyModularComx zyModularComx = zyModularComxService.getById(id);
		if(zyModularComx==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zyModularComx);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zyModularComx
    */
    //@RequiresPermissions("org.jeecg.modules.demo:zy_modular_comx:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ZyModularComx zyModularComx) {
        return super.exportXls(request, zyModularComx, ZyModularComx.class, "模块部件表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("zy_modular_comx:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ZyModularComx.class);
    }

}
