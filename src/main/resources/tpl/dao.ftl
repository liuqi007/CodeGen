package com.sibu.agency.dao;

import java.util.List;
import java.util.Map;

import com.sibu.agency.vo.${className}Vo;
import com.sibu.framework.dao.GenericDao;
import com.sibu.framework.vo.PageList;
import com.sibu.agency.vo.${className};
import com.sibu.agency.vo.${className}Prm;

/**
 * ${tableName}表Dao类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
public interface ${className}Dao extends GenericDao<${className}, Integer> {

    List<${className}Vo> query${className}List(int id) throws Exception;

    PageList<${className}Vo> query${className}Page(int id, int pageNo, int pageSize) throws Exception;

    Map<Object, Object> queryMap(int id) throws Exception;

    List<Map<Object, Object>> queryListMap(int id) throws Exception;

    List<Map<Object, Object>> queryUnionListMap(int id) throws Exception;

	public PageList<${className}Vo> queryPage(${className}Prm ${className?uncap_first}Prm, int pageNum,
        int pageSize) throws Exception;
}
