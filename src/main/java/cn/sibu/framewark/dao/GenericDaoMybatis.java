package cn.sibu.framewark.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * 抽象的基类，默认使用sqlSessionTemplate实现GenericDao。<br>
 * 读写分离，<strong>写使用：writeSqlSessionTemplate,读使用：readSqlSessionTemplate。</strong>
 * </br>
 * 在同一事务中不能同时使用writeSqlSessionTemplate和readSqlSessionTemplate,因为数据源不同。</br>
 * 实现方法getInsertSqlId(),getUpdateSqlId(),getDeleteSqlIdPK(),
 * getSelectOneSqlIdPk()返回单个model的增、删、查、改sqlId。
 * 
 * @author li.yuanyang
 *
 * @param <T>
 * @param <PK>
 */
public abstract class GenericDaoMybatis<T, PK extends Serializable> implements
    GenericDao<T, PK> {

    /**
     * <strong>写使用</strong></br>
     * 在同一个事务中不能同时使用writeSqlSessionTemplate和readSqlSessionTemplate，因为数据源不同。
     * 
     */
    @Resource(name = "writeSqlSessionTemplate")
    protected SqlSessionTemplate writeSqlSessionTemplate;

    /**
     * <strong>读使用</strong></br>
     * 在同一个事务中不能同时使用writeSqlSessionTemplate和readSqlSessionTemplate，因为数据源不同。
     * 
     */
    @Resource(name = "writeSqlSessionTemplate")
    protected SqlSessionTemplate readSqlSessionTemplate;

    /**
     * 增加实体 T 对应sqlId
     */
    protected abstract String getInsertSqlId();

    /**
     * 更新实体 T 对应sqlId
     */
    protected abstract String getUpdateSqlId();

    /**
     * 主键删除对应sqlId
     */
    protected abstract String getDeleteSqlIdPK();

    /**
     * 主键查询对应sqlId
     */
    protected abstract String getSelectOneSqlIdPk();

//    @Override
//    public int update(T t) {
//        return this.writeSqlSessionTemplate.update(getUpdateSqlId(), t);
//    }
//
//    @Override
//    public int delete(PK id) {
//        return this.writeSqlSessionTemplate.delete(getDeleteSqlIdPK(), id);
//    }
//
//    @Override
//    public int insert(T t) {
//        return this.writeSqlSessionTemplate.insert(getInsertSqlId(), t);
//    }

    public T selectOne(PK id) {
        return this.writeSqlSessionTemplate
            .selectOne(getSelectOneSqlIdPk(), id);
    }

    public int insert(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(PK id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<T> loadAll() {
		return null;//writeSqlSessionTemplate.selectList(statement);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
        return writeSqlSessionTemplate;
    }
}
