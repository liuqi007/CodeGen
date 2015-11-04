<#-- TODO 改为实际使用的包名 -->
package com.sibu.agency.vo;

/**
 * ${tableName}表Bean类
 * @author  
 * @desc   
 * @date    ${.now?string("yyyy/MM/dd")}
 */
public class ${className}{
    <#list columns as column>
	    <#assign autograph = "private " + column.dataType + " " + column.propertyName + ";">
	    ${autograph}<#if (column.columnComment?? && column.columnComment?length > 0)><#if (autograph?length < 4)>${"\t\t\t\t\t\t\t\t\t\t"}<#elseif (autograph?length < 8)>${"\t\t\t\t\t\t\t\t\t"}<#elseif (autograph?length < 12)>${"\t\t\t\t\t\t\t\t"}<#elseif (autograph?length < 16)>${"\t\t\t\t\t\t\t"}<#elseif (autograph?length < 20)>${"\t\t\t\t\t\t"}<#elseif (autograph?length < 24)>${"\t\t\t\t\t"}<#elseif (autograph?length < 28)>${"\t\t\t\t"}<#elseif (autograph?length < 32)>${"\t\t\t"}<#elseif (autograph?length < 36)>${"\t\t"}<#else>${"\t"}</#if>// ${column.columnComment}</#if> 
    </#list>  
    

    <#list columns as column>
	    public void set${column.propertyName?cap_first}(${column.dataType} ${column.propertyName}){
	        this.${column.propertyName} = ${column.propertyName};
	    }
	    public ${column.dataType} get${column.propertyName?cap_first}(){
	        return this.${column.propertyName};
	    }
    </#list>  
}