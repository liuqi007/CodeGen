package com.sibu.agency.service;

import java.util.List;
import java.util.Map;

import com.sibu.agency.vo.${className}Vo;
import com.sibu.framework.vo.PageList;
import com.sibu.agency.vo.${className}Prm;

/**
 * ${tableName}表service类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
public interface ${className}Service {

    int update${className}(${className}Vo vo) throws Exception;

    int delete${className}(int id) throws Exception;

    int insert${className}(${className}Vo vo) throws Exception;

    ${className}Vo getOne(int id) throws Exception;

    PageList<${className}Vo> query${className}Page(int id, int pageNum, int pageSize)
        throws Exception;

    /**
     * 查询id对应${className}列表
     * 
     * @param id
     *            
     * @return
     * @throws Exception
     */
    List<${className}Vo> query${className}List(int id) throws Exception;

    /**
     * 返回Map
     * 
     * @param id
     * @return
     * @throws Exception
     */
    Map<Object, Object> queryMap(int id) throws Exception;

    /**
     * 返回List<Map>
     * 
     * @param id
     * @return
     * @throws Exception
     */
    List<Map<Object, Object>> queryListMap(int id) throws Exception;
    
    
     /**
     * 分页查询
     * 
     * @param demoPrm
     * @return
     * @throws Exception
     */
    public PageList<${className}Vo> queryPage(${className}Prm ${className?uncap_first}Prm, int pageNum,
        int pageSize) throws Exception;
}
