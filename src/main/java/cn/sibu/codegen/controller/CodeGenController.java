package cn.sibu.codegen.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.sibu.codegen.core.CodeGen;
import cn.sibu.codegen.interfaces.TableMetaService;
import cn.sibu.codegen.vo.TableMeta;
import freemarker.template.TemplateException;

/**
 * 代码生成控制页
 * @author liuqi
 *
 */
@Controller
public class CodeGenController{

	@Autowired 
	private TableMetaService tableMetaService;
	@Autowired 
	private CodeGen codeGen;
	
	
	/**
	 * 首页
	 * 
	 * @param session
	 * @return ModelAndView
	 */
	@RequestMapping("/")
	public ModelAndView index(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		List<TableMeta> allTableName = tableMetaService.getAllTableName();
		for (TableMeta tableMeta : allTableName) {
			System.out.println(tableMeta.getTableName());
		}
		map.put("allTable", allTableName);
		return new ModelAndView("/core/index",map);
	}


	/**
	 * 代码生成
	 * @param tableName 表名
	 * @param type      生成类型：0 不使用缓存  1使用缓存
	 * @return
	 */
	@RequestMapping("/codeGen/makeCode")
	public ModelAndView makeCode(@RequestParam(required=true)String tableName,@RequestParam(required=true,defaultValue="0")String type){
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			codeGen.create(tableName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("/core/index",map);
	}
}
