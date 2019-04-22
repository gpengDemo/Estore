<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <title>My JSP 'index.jsp' starting page</title>
 <script type="text/javascript">
 function cancel() {
	window.location="ProductFindAllServlet";
}
function modify() {
	var options=$("#threelevel option:selected").val();
	document.getElementById("c3code").value=options;
	document.getElementById("modif").submit();
}
 </script>
 </head>
  <body>
	<form action="${pageContext.request.contextPath}/ProductUpdateServlet" method="post" encType="multipart/form-data" id="modif">
		<input type="hidden" name="id" value="${pro.id}">
		
		商品名称:<input type="text" name="name" value="${pro.name}"><br>
		商品价格:<input type="text" name="price" value="${pro.price}">
		<input type="hidden" name="c3code" id="c3code">
		<br>
		
		商品类别:
		<%-- 	<my:sex gender="${c.gender}"/> --%>
		一级分类：
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
		</select>
		<br>
			
		商品数量:<input type="text" name="pnum" value="${pro.pnum}"><br>
		商品图片:<input type="file" name="f" value="${pro.imgurl }"><br>
		商品颜色：<input type="text" name="color" value="${pro.color}"><br>
		商品描述:<textarea rows="10" cols="20" name="description">${pro.description }</textarea><br>
		<input type="button" value="修改" onclick="modify()">
		<input type="button" value="取消" onclick="cancel()">
	</form>
<script type="text/javascript" src="CategoryJS/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="CategoryJS/onloada.js"></script>
	
</body>
</html>
