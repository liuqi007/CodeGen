package cn.sibu.codegen.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class TableMeta implements Serializable {
	private static final long serialVersionUID = 1L;

	public TableMeta() {
	}

	private String tableName;
	private String tableComment;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getClassName() {
		if (tableName == null)
			return "";
		StringBuffer className = new StringBuffer();
		String[] names = StringUtils.split(tableName.toLowerCase(), "_");
		for (int i = 0, len = names.length; i < len; i++) {
			className.append(names[i].substring(0, 1).toUpperCase()
					+ names[i].substring(1));
		}
		return className.toString();
	}
}
