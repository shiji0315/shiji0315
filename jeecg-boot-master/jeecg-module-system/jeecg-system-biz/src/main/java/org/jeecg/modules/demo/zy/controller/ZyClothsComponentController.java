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
import org.jeecg.modules.demo.zy.entity.ZyClothsComponent;
import org.jeecg.modules.demo.zy.service.IZyClothsComponentService;

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
 * @Description: 制衣部件表
 * @Author: jeecg-boot
 * @Date:   2022-11-06
 * @Version: V1.0
 */
@Api(tags="制衣部件表")
@RestController
@RequestMapping("/zy/zyClothsComponent")
@Slf4j
public class ZyClothsComponentController extends JeecgController<ZyClothsComponent, IZyClothsComponentService> {
	@Autowired
	private IZyClothsComponentService zyClothsComponentService;
	
	/**
	 * 分页列表查询
	 *
	 * @param zyClothsComponent
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "制衣部件表-分页列表查询")
	@ApiOperation(value="制衣部件表-分页列表查询", notes="制衣部件表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<ZyClothsComponent>> queryPageList(ZyClothsComponent zyClothsComponent,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<ZyClothsComponent> queryWrapper = QueryGenerator.initQueryWrapper(zyClothsComponent, req.getParameterMap());
		Page<ZyClothsComponent> page = new Page<ZyClothsComponent>(pageNo, pageSize);
		IPage<ZyClothsComponent> pageList = zyClothsComponentService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param zyClothsComponent
	 * @return
	 */
	@AutoLog(value = "制衣部件表-添加")
	@ApiOperation(value="制衣部件表-添加", notes="制衣部件表-添加")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_component:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody ZyClothsComponent zyClothsComponent) {
		zyClothsComponentService.save(zyClothsComponent);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param zyClothsComponent
	 * @return
	 */
	@AutoLog(value = "制衣部件表-编辑")
	@ApiOperation(value="制衣部件表-编辑", notes="制衣部件表-编辑")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_component:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody ZyClothsComponent zyClothsComponent) {
		zyClothsComponentService.updateById(zyClothsComponent);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "制衣部件表-通过id删除")
	@ApiOperation(value="制衣部件表-通过id删除", notes="制衣部件表-通过id删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_component:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		zyClothsComponentService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "制衣部件表-批量删除")
	@ApiOperation(value="制衣部件表-批量删除", notes="制衣部件表-批量删除")
	//@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_component:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.zyClothsComponentService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "制衣部件表-通过id查询")
	@ApiOperation(value="制衣部件表-通过id查询", notes="制衣部件表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<ZyClothsComponent> queryById(@RequestParam(name="id",required=true) String id) {
		ZyClothsComponent zyClothsComponent = zyClothsComponentService.getById(id);
		if(zyClothsComponent==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(zyClothsComponent);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param zyClothsComponent
    */
    //@RequiresPermissions("org.jeecg.modules.demo:zy_cloths_component:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, ZyClothsComponent zyClothsComponent) {
        return super.exportXls(request, zyClothsComponent, ZyClothsComponent.class, "制衣部件表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("zy_cloths_component:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, ZyClothsComponent.class);
    }

}
