package cn.sibu.codegen.dao;

import java.util.List;
import java.util.Map;

import cn.sibu.codegen.vo.ColumnMeta;
import cn.sibu.framewark.dao.GenericDao;

public interface ColumnMetaDao extends GenericDao<ColumnMeta, Integer> {
	public List<ColumnMeta> select(Map<String, Object> map);
}
