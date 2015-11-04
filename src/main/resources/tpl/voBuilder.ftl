package com.sibu.agency.builder;

import org.springframework.stereotype.Component;

import com.sibu.agency.vo.${className}Vo;
import com.sibu.framework.builder.ModelBuildVo;
import com.sibu.framework.exception.VoModelException;
import com.sibu.agency.vo.${className};

/**
 * ${tableName}表bean到vo转换类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
@Component
public class ${className}VoBuilder implements
    ModelBuildVo<${className}, ${className}Vo> {

    @Override
    public ${className}Vo buildVo(${className} model)
        throws VoModelException {
        ${className}Vo vo = new ${className}Vo();
        <#list columns as column>
        vo.set${column.propertyName?cap_first}(model.get${column.propertyName?cap_first}());
        </#list>  
        return vo;
    }

}
