/**
 * 
 */
package cn.sibu.codegen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sibu.codegen.dao.TableMetaDao;
import cn.sibu.codegen.interfaces.TableMetaService;
import cn.sibu.codegen.vo.TableMeta;

/**
 * 数据库表描述接口实现类
 * @author liuqi
 *
 */
@Service
public class TableMetaServiceImpl implements TableMetaService {

	@Autowired
	private TableMetaDao tableMetaDao;
	public List<TableMeta> getAllTableName() {
		return tableMetaDao.loadAll();
	}

}
