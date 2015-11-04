<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>【思埠代码生成器】</title>
<style type="text/css">
.table_border {
	border: solid 1px #B4B4B4;
	border-collapse: collapse;
}

.table_border tr th {
	/* 		background:url("../../images/gray/bg_table_th.gif") repeat; */
	background-color: #7bb3ff; padding-left : 4px;
	height: 27px;
	border: solid 1px #B4B4B4;
	padding-left: 4px;
}

.table_border tr td {
	height: 25px;
	padding: 4px;
	border: solid 1px #B4B4B4;
}
</style>
</head>
<body>
	<table class="table_border" width="100%" border="0" id="high_light"
		lang="tabRowData" cellpadding="0" cellspacing="0">
		<tr>
			<th>表名</th>
			<th>生成代码</th>
		</tr>
		<c:forEach items="${allTable}" var="tableItem">
			<tr>
				<td style="width: 400px;">${tableItem.tableName}</td>
				<td><input type="button" value="生成代码" onclick="codeGen('${tableItem.tableName}','0')"/><input type="button" value="生成使用缓存代码" onclick="codeGen('${tableItem.tableName}','0')"/></td>
			</tr>
		</c:forEach>
	</table>
</body>

<script type="text/javascript">
function codeGen(tableName,type){
	$.ajax({
		type     : "post",
		dataType : "json",
		url      : ctx + "/codeGen/makeCode", 
		data     : {"tableName" : tableName,"type":type},
		success :function(data){
			if ( data.code == 0 ){
				$("#order" + id).remove();
				location.reload(true);
			} else {
				jAlert(data.msg,"温馨提醒XXX");
				return;
			}
		},
        error :function(data) {
        }
	});
}
</script>
</html>