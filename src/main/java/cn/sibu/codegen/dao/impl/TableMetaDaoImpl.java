package cn.sibu.codegen.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sibu.codegen.dao.TableMetaDao;
import cn.sibu.codegen.vo.TableMeta;
import cn.sibu.framewark.dao.GenericDaoMybatis;

@Repository
public class TableMetaDaoImpl extends GenericDaoMybatis<TableMeta, Integer> implements TableMetaDao {

	 private static final String MAPPER_NAMESAPCE = "cn.sibu.codegen.dao.TableMetaDao.";
	public int insert(TableMeta t) {
		return 0;
	}

	public TableMeta selectOne(Integer id) {
		return this.readSqlSessionTemplate.selectOne(MAPPER_NAMESAPCE +
	            "selectOne");
	}

	public int update(TableMeta t) {
		return 0;
	}

	public int delete(Integer id) {
		return 0;
	}

	public List<TableMeta> loadAll() {
		return this.readSqlSessionTemplate.selectList(MAPPER_NAMESAPCE +
	            "loadAll");
	}

	@Override
	protected String getInsertSqlId() {
		return null;
	}

	@Override
	protected String getUpdateSqlId() {
		return null;
	}

	@Override
	protected String getDeleteSqlIdPK() {
		return null;
	}

	@Override
	protected String getSelectOneSqlIdPk() {
		return null;
	}
}
