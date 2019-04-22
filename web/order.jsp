<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 	<link rel="stylesheet" type="text/css" href="home/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/main.css">
</head>
<body>
<header>
    <nav class="navbar navbar-inverse" role="navigation">
     <div class="logo"></div>
        <a href="ProductFindAllServlet">首页</a>
        <a href="javascript:void(0)" onclick="phone('手机')">手机</a>
        <a href="javascript:void(0)" onclick="phone('平板')">平板</a>
        <a href="javascript:void(0)" onclick="phone('笔记本')">笔记本</a>
        <a href="javascript:void(0)" onclick="phone('配件')">配件</a>
        <span class="slider-bar"></span>
        <i class="carts" onclick="tocart()"></i>
        <span><c:if test="${not empty user }">
        			 <h4 class="user">${user.username}</h4>
					 <a class="logout" href="${pageContext.request.contextPath}/LoginOutServlet">注销</a>
			</c:if>
			<c:if test="${ empty user }">
        		<h4 class="signin" data-toggle="modal" data-target="#log-wrapper">登录</h4>
            	<h4 class="signup" data-toggle="modal" data-target="#log-wrapper">注册</h4>
            </c:if>
		</span>
    </nav>
</header>

 <section class="order">
        <div class="head">订单</div>
        <div class="title">
            <ul>
                <li>商品名称</li>
                <li>单价</li>
                <li>数量</li>
                <li>总价</li>
            </ul>
            </ul>
        </div>
        
  	<c:set value="0" var="money"></c:set>
	<ul class="order-content">		
	<c:forEach items="${cart}" var="c">
            <ul>
            <li>
                <img src="/upload/${c.key.imgurl}">
            </li>
            <li><div class="order-details">${c.key.description}</div></li>
            <li><span class="price">${c.key.price }</span></li>
            <li><span class="order-count">${c.value}</span></li>
        </ul>
      	<c:set value="${money+c.key.price*c.value}" var="money"></c:set>
	</c:forEach>
	
            <div class="order-sum">${money}</div>
        </ul>
        <div class="order-foot">
            <ul>
                <li><div class="order-adress">
                    <input aria-label="送货地址" placeholder="送货地址" type="text">
                </div></li>
                <li><a class="sum-btn"	href="${pageContext.request.contextPath}/AddOrderServlet">生成订单</a></li>
            
            </ul>
        </div>
    </section>
    <aside class="aside-tool">
    <ul>
        <li class="customer">
            <a href="http://wpa.qq.com/msgrd?v=3&uin=476759153&site=qq&menu=yes" target=_blank
               clickid=guanwang_navigation_customer>联系客服</a>
        </li>
        <li class="top"></li>
    </ul>
</aside>
    <footer>
   <div>
       <ul>
           <li>开发人员1</li>
           <li>唐宗博</li>
       </ul>
       <ul>
           <li>开发人员2</li>
           <li>辜鹏</li>
       </ul>
    </div>
</footer>

	<script type="text/javascript">
	function phone(obj) {
		location.href="${pageContext.request.contextPath}/FindCategoryServlet?name="+encodeURIComponent(encodeURIComponent(obj));
	}
	</script>
    <script type="text/javascript" src="home/JS/jquery.min.js"></script>
    <script type="text/javascript" src="home/JS/jquery-ui.js"></script>
    <script type="text/javascript" src="home/JS/bootstrap.min.js"></script>
    <script type="text/javascript" src="home/JS/bg-canvas.js"></script>
    <script type="text/javascript" src="home/JS/main.js"></script>
</body>
</html>