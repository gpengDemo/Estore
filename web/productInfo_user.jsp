<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单个商品详细信息</title>
<link rel="stylesheet" type="text/css" href="home/CSS/main.css">
</head>
<body>

<section class="w">
<div class="product-img">
    <div class="handle">
        <div class="thumb">
            <ul>
                <li class="n-hover">
                    <img src="/upload/${pro.imgurl }">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/e086ecc18effe218e6f9cefeb1745b83.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/eb09f6835eb770e9106dff6b300fe2f8.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/47bacd1fbf16cba1554d0723dddfe4fe.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/2e94f6482d570ce355030bea44fd42fa.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/e2c7f88b1bd6809ade50c5be45455da0.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/4cae1678a7b505eea715486651c0f4c7.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/fee60363efe598aa21d633a3671a4861.jpg">
                </li>
                <li class="">
                    <img src="http://img001.fview.cn/Public/upload/product/76f87b698fe34f6447dd4e53dc052d44.jpg">
                </li>
            </ul>
        </div>
        <a class="arrow up i-icon"></a>
        <a class="arrow down i-icon"></a>
    </div>
    <div class="view">
        <img src="/upload/${pro.imgurl }">
    </div>
</div>
<div class="product-details">
    <h1>${pro.description}</h1>
    <p class="re"><span>产品编号：</span><span>RE201612101843132</span></p>
    <p class="price" data-price="3649">
        <span>价格</span>
        <span class="price">${pro.price }</span>
    </p>
    <ul class="details">
        <li><span>颜色</span><a class="u-check n-check">${pro.color }</a></li>
        <li><span>内存</span><a class="u-check n-check">64G</a></li>
        <li><span>版本</span><a class="u-check n-check">联通4G/移动4G/电信4G</a></li>
        <li><span>销售地区</span><a class="u-check n-check">加拿大</a></li>
        <li><span>购买数量：</span>
            <div class="count-box">
                    <input class="min" name="" type="button" value="-"/>
                    <input class="text-box" name="" type="text" value="1"/>
                    <input class="add" name="" type="button" value="+"/>
                </div>
        </li>
    </ul>
    <div class="action">
        <a class="buy"	href="fastbuy.jsp">立即购买</a>
        
       <a class="addCar" onclick="addProductToCart('${pro.id}')"><i></i>加入购物车</a>
    </div>
</div>
</section>

<script type="text/javascript">
	function addProductToCart(id){
		
		location.href="${pageContext.request.contextPath}/AddProductToCartServlet?id="+id;
	}
</script>
<script type="text/javascript" src="home/JS/jquery.min.js"></script>
<script type="text/javascript" src="home/JS/jquery-ui.js"></script>
<script type="text/javascript" src="home/JS/bootstrap.min.js"></script>
<script type="text/javascript" src="home/JS/bg-canvas.js"></script>
<script type="text/javascript" src="home/JS/main.js"></script>

</body>
</html>
