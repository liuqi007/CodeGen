package cn.sibu.codegen.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class ColumnMeta implements Serializable {
	private static final long serialVersionUID = 1L;

	public ColumnMeta() {
	}

	private String tableName;
	private String columnName;
	private String isNullable;
	private String dataType;
	private String columnKey;
	private String extra;
	private int characterMaximumLength;
	private String propertyName;
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = getPropertyType(dataType);
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public int getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	public void setCharacterMaximumLength(int characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * 获取属性名称
	 * 
	 * @return
	 */
	public String getPropertyName() {
		StringBuffer pn = new StringBuffer();
		String[] names = StringUtils.split(columnName.toLowerCase(), "_");
		pn.append(names[0]); // 第一个单词全小写
		for (int i = 1, len = names.length; i < len; i++) {
			pn.append(names[i].substring(0, 1).toUpperCase()
					+ names[i].substring(1));
		}
		propertyName = pn.toString();
		return propertyName;
	}

	/**
	 * 获取属性类型
	 * 
	 * @return
	 */
	public String getPropertyType(String dataType) {
		String type = dataType.toLowerCase();
		String propertyType = null;
		if (StringUtils.startsWith(type, "tinyint")) { // tinyint
			propertyType = "Integer";
		}else if (StringUtils.startsWith(type, "int")) { // int/long
			if (characterMaximumLength <= 4)
				propertyType = "Integer";
			else
				propertyType = "Long";
		} else if (StringUtils.startsWith(type, "bigint")) { // long
			propertyType = "Long";
		} else if (StringUtils.startsWith(type, "double")) { // double
			propertyType = "Double";
		} else if (StringUtils.startsWith(type, "float")) { // float
			propertyType = "Float";
		} else if (StringUtils.startsWith(type, "decimal")) { // float
			propertyType = "java.math.BigDecimal";
		}else if (StringUtils.startsWith(type, "varchar")) { // String
			propertyType = "String";
		} else if (StringUtils.startsWith(type, "char")) { // String
			propertyType = "String";
		} else if (StringUtils.startsWith(type, "text")) { // String
			propertyType = "String";
		} else if (StringUtils.startsWith(type, "date")) { // date
			propertyType = "java.util.Date";
		} else if (StringUtils.startsWith(type, "datetime")) { // date
			propertyType = "java.util.Date";
		} else if (StringUtils.startsWith(type, "timestamp")) { // date
			propertyType = "java.util.Date";
		} else {
			System.out.println("==类型[" + type + "]解析尚不支持==");
		}
		return propertyType;
	}
}
