package cn.sibu.codegen.interfaces;

import java.util.List;

import cn.sibu.codegen.vo.TableMeta;

/**
 * 数据库表描述接口
 * @author liuqi
 *
 */
public interface TableMetaService {
	public List<TableMeta> getAllTableName();
}
