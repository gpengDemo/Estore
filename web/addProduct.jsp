<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
 <script type="text/javascript">
 function cancel() {
	window.location="${pageContext.request.contextPath}/ProductFindAllServlet";
}
function add() {
	var options=$("#threelevel option:selected").val();
	document.getElementById("c3code").value=options;
	document.getElementById("add").submit();
}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ProductAddServlet"
		method="post" encType="multipart/form-data" id="add">
		<table border="1" align="center">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>商品数量</td>
				<td><input type="text" name="pnum">
				<input type="hidden" name="c3code" id="c3code"></td>
			</tr>
			<tr>
				<td>商品类别</td>
				<td>一级分类：
					<select id="onelevel" onchange="select_onelevel()">
						<option value="">-请选择-</option>
						<c:forEach var="l" items="${onelevel}">
							<option value="${l.code}">${l.name}</option>
						</c:forEach>
					</select>
					二级分类：
					<select id="twolevel" onchange="selsct_twolevel()">
						<option value="">-请选择-</option>
					</select>
					三级分类：
				<select id="threelevel">
					<option value="">-请选择-</option>
				</select></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><input type="file" name="f"></td>
			</tr>
			<tr>
				<td>商品颜色</td>
				<td><input type="text" name="color"></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><textarea rows="10" cols="20" name="description"></textarea>
				</td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="添加" onclick="add()">&nbsp;&nbsp;
					<input type="reset" value="取消" onclick="cancel()">
				</td>

			</tr>
			
		</table>
</form>
<script type="text/javascript" src="CategoryJS/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="CategoryJS/onloada.js"></script>

</body>
</html>