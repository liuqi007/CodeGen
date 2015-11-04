package cn.sibu.codegen.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.sibu.codegen.dao.ColumnMetaDao;
import cn.sibu.codegen.vo.ColumnMeta;
import cn.sibu.framewark.dao.GenericDaoMybatis;

@Repository
public class ColumnMetaDaoImpl extends GenericDaoMybatis<ColumnMeta, Integer> implements ColumnMetaDao {

	 private static final String MAPPER_NAMESAPCE = "cn.sibu.codegen.dao.ColumnMetaDao.";
	public int insert(ColumnMeta t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ColumnMeta selectOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(ColumnMeta t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected String getInsertSqlId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateSqlId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteSqlIdPK() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectOneSqlIdPk() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ColumnMeta> select(Map<String, Object> map) {
		return this.readSqlSessionTemplate.selectList(MAPPER_NAMESAPCE +
	            "select", map);
	}
}
