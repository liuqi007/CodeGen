package com.sibu.agency.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sibu.agency.builder.${className}ModelBuilder;
import com.sibu.agency.builder.${className}VoBuilder;
import com.sibu.agency.dao.${className}Dao;
import com.sibu.agency.service.${className}Service;
import com.sibu.agency.vo.${className}Vo;
import com.sibu.agency.vo.${className}Prm;
import com.sibu.framework.vo.PageList;

/**
 * ${tableName}表service实现类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Dao ${className?uncap_first}Dao;

    @Autowired
    private ${className}VoBuilder ${className?uncap_first}VoBuilder;

    @Autowired
    private ${className}ModelBuilder ${className?uncap_first}ModelBuilder;

    public ${className}ServiceImpl() {
    }

    @Override
    @Transactional
    public int update${className}(${className}Vo vo) throws Exception {
        return this.${className?uncap_first}Dao.update(this.${className?uncap_first}ModelBuilder.buildModel(vo));
    }

    @Override
    @Transactional
    public int delete${className}(int id) throws Exception {
        return this.${className?uncap_first}Dao.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert${className}(${className}Vo vo) throws Exception {
        return this.${className?uncap_first}Dao.insert(this.${className?uncap_first}ModelBuilder.buildModel(vo));
    }

    @Override
    public ${className}Vo getOne(int id) throws Exception {
        return this.${className?uncap_first}VoBuilder.buildVo(this.${className?uncap_first}Dao.selectOne(id));
    }

    @Override
    public List<${className}Vo> query${className}List(int id) throws Exception {
        return this.${className?uncap_first}Dao.query${className}List(id);
    }

    @Override
    public Map<Object, Object> queryMap(int uId) throws Exception {
        return this.${className?uncap_first}Dao.queryMap(uId);
    }

    @Override
    public List<Map<Object, Object>> queryListMap(int uId) throws Exception {
        return this.${className?uncap_first}Dao.queryListMap(uId);
    }

    @Override
    public PageList<${className}Vo> query${className}Page(int uId, int pageNum, int pageSize)
        throws Exception {
        return this.${className?uncap_first}Dao.query${className}Page(uId, pageNum, pageSize);
    }

  	@Override
    public PageList<${className}Vo> queryPage(${className}Prm ${className?uncap_first}Prm, int pageNum,
        int pageSize) throws Exception {
        return this.${className?uncap_first}Dao.queryPage(${className?uncap_first}Prm, pageNum, pageSize);
    }
}
