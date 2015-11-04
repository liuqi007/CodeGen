package cn.sibu.codegen.interfaces;

import java.util.List;

import cn.sibu.codegen.vo.ColumnMeta;

/**
 * 数据库表描述接口
 * @author liuqi
 *
 */
public interface ColumnMetaService {
	public List<ColumnMeta> getAllColumnName(String tableName);
}
