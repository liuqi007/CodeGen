/**
 * 
 */
package cn.sibu.codegen.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sibu.codegen.dao.ColumnMetaDao;
import cn.sibu.codegen.interfaces.ColumnMetaService;
import cn.sibu.codegen.vo.ColumnMeta;

/**
 * 数据库表描述接口实现类
 * @author liuqi
 *
 */
@Service
public class ColumnMetaServiceImpl implements ColumnMetaService {

	@Autowired
	private ColumnMetaDao columnMetaDao;
	public List<ColumnMeta> getAllColumnName(String tableName) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tableName", tableName);
		return columnMetaDao.select(map);
	}
}
