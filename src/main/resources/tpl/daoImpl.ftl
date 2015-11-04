package com.sibu.agency.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sibu.agency.dao.${className}Dao;
import com.sibu.agency.vo.${className}Vo;
import com.sibu.framework.dao.impl.GenericDaoMybatis;
import com.sibu.framework.vo.PageList;
import com.sibu.agency.vo.${className};
import com.sibu.agency.vo.${className}Prm;

/**
 * ${tableName}表Dao实现类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
@Repository
public class ${className}DaoImpl extends GenericDaoMybatis<${className}, Integer> implements
    ${className}Dao {

    private static final String MAPPER_NAMESAPCE_${className?upper_case} = "com.sibu.agency.dao.${className}Dao.";
    private static final String INSERT = "insert";
    private static final String UPDATE = "update";
    private static final String SELECT_ID = "selectId";
    private static final String DELETE_ID = "deleteId";

    @Override
    protected String getInsertSqlId(){
        return MAPPER_NAMESAPCE_${className?upper_case} + INSERT;
    }

    @Override
    protected String getUpdateSqlId(){
        return MAPPER_NAMESAPCE_${className?upper_case} + UPDATE;
    }

    @Override
    protected String getDeleteSqlIdPK(){
        return MAPPER_NAMESAPCE_${className?upper_case} + DELETE_ID;
    }

    @Override
    protected String getSelectOneSqlIdPk(){
        return MAPPER_NAMESAPCE_${className?upper_case} + SELECT_ID;
    }

    @Override
    public List<${className}Vo> query${className}List(int id) throws Exception{
        return this.getSqlSessionTemplate().selectList(
            MAPPER_NAMESAPCE_${className?upper_case} + SELECT_ID, id);
    }

    @Override
    public Map<Object, Object> queryMap(int id) throws Exception {
        return this.readSqlSessionTemplate.selectMap(MAPPER_NAMESAPCE_${className?upper_case} +
            "selectIdMap", id, "id");
    }

    @Override
    public List<Map<Object, Object>> queryListMap(int id) throws Exception {
        return this.readSqlSessionTemplate.selectList(MAPPER_NAMESAPCE_${className?upper_case} +
            "selectIdListMap", id);
    }

    @Override
    public List<Map<Object, Object>> queryUnionListMap(int id) throws Exception {
        return this.readSqlSessionTemplate.selectList(MAPPER_NAMESAPCE_${className?upper_case} +
            "selectUnitIdListMap", id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageList<${className}Vo> query${className}Page(int id, int pageNum, int pageSize) throws Exception {
        return (PageList<${className}Vo>) this.findPage(MAPPER_NAMESAPCE_${className?upper_case} +
            SELECT_ID, pageNum, pageSize, id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
   	public PageList<${className}Vo> queryPage(${className}Prm ${className?uncap_first}Prm, int pageNum,
        int pageSize) throws Exception {
        return (PageList<${className}Vo>) this.findPage(MAPPER_NAMESAPCE_${className?upper_case} +
            "queryPage", pageNum, pageSize, ${className?uncap_first}Prm);
    }
}
