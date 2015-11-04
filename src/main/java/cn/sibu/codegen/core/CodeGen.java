package cn.sibu.codegen.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sibu.codegen.interfaces.ColumnMetaService;
import cn.sibu.codegen.interfaces.TableMetaService;
import cn.sibu.codegen.vo.ColumnMeta;
import cn.sibu.codegen.vo.TableMeta;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class CodeGen {
	@Autowired
	private TableMetaService tableMetaService;
	@Autowired
	private ColumnMetaService columnMetaService;

	private static Map<String, String> map = new HashMap<String, String>();

	static {
		map.put("bean.ftl", ".java");
		map.put("vo.ftl", "Vo.java");
		map.put("service.ftl", "Service.java");
		map.put("serviceImpl.ftl", "ServiceImpl.java");
		map.put("dao.ftl", "Dao.java");
		map.put("daoImpl.ftl", "DaoImpl.java");
		map.put("voBuilder.ftl", "VoBuilder.java");
		map.put("modelBuilder.ftl", "ModelBuilder.java");
		map.put("mapper.ftl", "-mapper.xml");
		map.put("prm.ftl", "Prm.java");
	}

	public void create(String tableName) throws IOException, TemplateException {
		// 获得表信息
		TableMeta tableMeta = getTableMeta(tableName);

		// 获得表的列信息
		List<ColumnMeta> allColumnMeta = columnMetaService
				.getAllColumnName(tableName);

		// 创建存放目录
		String targetDir = System.getProperty("user.dir");
		File dir = new File(targetDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// 读取模板配置
		Configuration cfg = new Configuration();
//		String ABS = System.getProperty("user.dir");
		System.out.println("=========path"+this.getClass().getResource("/tpl").getPath());
		cfg.setDirectoryForTemplateLoading(new File(this.getClass().getResource("/tpl").getPath()));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		// 封装模板所需参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comment", tableMeta.getTableComment());
		map.put("tableName", tableName);
		map.put("className", tableMeta.getClassName());
		map.put("columns", allColumnMeta);

		for (Iterator<String> iterator = CodeGen.map.keySet().iterator(); iterator
				.hasNext();) {
			String key = (String) iterator.next();
			String value = CodeGen.map.get(key);
			String ftlFileName = key;
			String targetFileName = tableMeta.getClassName() + value;
			process(cfg, ftlFileName, targetFileName, map);
		}
	}

	private TableMeta getTableMeta(String tableName) {
		List<TableMeta> allTableName = tableMetaService.getAllTableName();
		for (TableMeta tableMeta : allTableName) {
			if (tableName.equals(tableMeta.getTableName())) {
				return tableMeta;
			}
		}
		return null;
	}

	/**
	 * 根据模板产生文件
	 * 
	 * @param cfg
	 * @param ftlFileName
	 * @param targetFileName
	 * @param map
	 * @throws IOException
	 * @throws TemplateException
	 */
	private void process(Configuration cfg, String ftlFileName,
			String targetFileName, Map<String, Object> map) throws IOException,
			TemplateException {
		Template beanFtl = cfg.getTemplate(ftlFileName);
		Writer out = new FileWriter(new File(targetFileName));
		beanFtl.process(map, out);
		out.flush();
		out.close();
	}
}
