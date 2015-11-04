package cn.sibu.codegen.dao;

import java.util.List;

import cn.sibu.codegen.vo.TableMeta;
import cn.sibu.framewark.dao.GenericDao;

public interface TableMetaDao extends GenericDao<TableMeta, Integer> {
	public List<TableMeta> loadAll();
}
