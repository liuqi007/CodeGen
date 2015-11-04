package com.sibu.agency.builder;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.sibu.agency.vo.${className}Vo;
import com.sibu.framework.builder.VoBuildModel;
import com.sibu.framework.exception.VoModelException;
import com.sibu.agency.vo.${className};

/**
 * ${tableName}表vo到bean转换类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
@Component
public class ${className}ModelBuilder implements VoBuildModel<${className}Vo, ${className}> {

    @Override
    public ${className} buildModel(${className}Vo vo) throws VoModelException {
        ${className} model = new ${className}();
        <#list columns as column>
        model.set${column.propertyName?cap_first}(vo.get${column.propertyName?cap_first}());
        </#list>  
        return model;
    }

}
