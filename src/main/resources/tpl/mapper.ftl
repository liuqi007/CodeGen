<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.sibu.agency.dao.${className}Dao">
	<resultMap type="com.sibu.mybatis.model.${className?uncap_first}.${className}" id="${className}Result">
		<#list columns as column>
		<#if column.columnKey = "PRI">
		<id property="${column.propertyName}" column="${column.columnName}" />
		<#else>
		<result property="${column.propertyName}" column="${column.columnName}" />
		</#if>
		</#list>
	</resultMap>
	
	<!-- 保存 -->
	<insert id="insert" parameterType="com.sibu.mybatis.model.${className}">
		INSERT INTO
		${tableName}(
		<#list columns as column>
		<#if column.extra != "auto_increment" &&  column_index < (columns?size)-1>
			${column.columnName},
		</#if>
		<#if column.columnKey != "auto_increment" && column_index = (columns?size)-1  >
			${column.columnName}
		</#if>
		</#list>
		)
		VALUES(
		<#list columns as column>
		<#if column.extra != "auto_increment" &&  column_index < (columns?size)-1>
			${"#{"?html}${column.propertyName}${"}"?html},
		</#if>
		<#if column.columnKey != "auto_increment" && column_index = (columns?size)-1  >
			${"#{"?html}${column.propertyName}${"}"?html}
		</#if>
		</#list>
		)
	</insert>
	
	<!-- 更新 -->
	<update id="update" parameterType="com.sibu.mybatis.model.${className}">
		UPDATE ${tableName}
		SET
		<#list columns as column>
		<#if column.extra != "auto_increment" &&  column_index < (columns?size)-1>
			${column.columnName} = ${"#{"?html}${column.propertyName}${"}"?html},
		</#if>
		<#if column.columnKey != "auto_increment" && column_index = (columns?size)-1  >
			${column.columnName} = ${"#{"?html}${column.propertyName}${"}"?html}
		</#if>
		</#list>
		WHERE 
		<#list columns as column>
		<#if column.columnKey = "PRI">
		${column.columnName} = ${"#{"?html}${column.propertyName}${"}"?html}
		</#if>
		</#list>
	</update>
	
	<!-- 查找 -->
	<select id="selectId" parameterType="int" resultMap="${className}Result">
		SELECT *
		from ${tableName} WHERE 
		<#list columns as column>
		<#if column.columnKey = "PRI">
		${column.columnName} = ${"#{"?html}${column.propertyName}${"}"?html}
		</#if>
		</#list>
	</select>
	
	<!-- 删除 -->
	<delete id="deleteId" parameterType="int">
		DELETE FROM ${tableName} WHERE
		<#list columns as column>
		<#if column.columnKey = "PRI">
		${column.columnName} = ${"#{"?html}${column.propertyName}${"}"?html}
		</#if>
		</#list>
	</delete>
	
	<!-- 单表查 返回Map查找id -->
	<select id="selectIdMap" parameterType="int" resultType="hashmap">
		SELECT
		* from ${tableName} WHERE 
		<#list columns as column>
		<#if column.columnKey = "PRI">
		${column.columnName} = ${"#{"?html}${column.propertyName}${"}"?html}
		</#if>
		</#list>
	</select>
	
	<!-- 分页查询 -->
	<select id="findPage"
		parameterType="com.sibu.agency.vo.${className}Prm"
		resultType="com.sibu.agency.vo.${className}Vo">
		SELECT * from ${tableName} where 1=1
		<if test="param1 != ''"></if>
		<if test="param2 != ''"></if>
		limit ${"#{"?html}start${"}"?html},${"#{"?html}end${"}"?html}
	</select>
</mapper>
