<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="home/CSS/main.css">
<script type="text/javascript" src="home/JS/jquery.min.js"></script>
<script>
(function($) {
$(window).on('load',function () {
    $('#status').fadeOut();
    $('#preloader').delay(300).fadeOut('slow');
});
})(jQuery);
</script>
</head>
<div id="preloader" >
    <div id="status"></div>
</div>
<body>
<!-- 查询完所有商品转发至商品首页，转发至网站首页 -->
<jsp:forward page="/ProductFindAllServlet"/>
</body>
</html>
