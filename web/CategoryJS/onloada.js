/**
 * 
 */
function select_onelevel(){
	var ss = document.getElementById("onelevel");
	var onelevelcode = ss.value;
	if(!onelevelcode)return; // 声明变量就要判断是否为null
	$.ajax({
		type:"post",//请求方式get/post
		url:"LinkageServlet",//请求对应的地址
		data:{"levelcode":onelevelcode},//往服务器传递的参数，
		success:function(data){//服务器交互成功调用的回调函数，data就是服务器端传递出来的数据
			var jdata = data.trim(); // 去前后空格
			if(jdata=="fail"){
				alert("查询失败!");
			}else{
				var json = eval(jdata);//将json字符串对象转化成json
				var sel = document.getElementById('twolevel');
				if(json=='null'){
					sel.options.length = 1;
				}else{
					sel.options.length = 0;
					
					for(var i=0; i<json.length; i++) {
						sel.add(new Option(json[i].name,json[i].code));
					}
					showthree(json[0].code);
				}
			}
		}
	});
};
function selsct_twolevel(){
	var sa = document.getElementById("twolevel");
	var twolevelcode = sa.value;
	if(!twolevelcode)return; // 声明变量就要判断是否为null
	showthree(twolevelcode);
}
function showthree(code) {
	$.ajax({
		type:"post",//请求方式get/post
		url:"LinkageServlet",//请求对应的地址
		data:{"levelcode":code},//往服务器传递的参数，
		success:function(data){//服务器交互成功调用的回调函数，data就是服务器端传递出来的数据
			var jdata = data.trim(); // 去前后空格
			if(jdata=="fail"){
				alert("查询失败!");
			}else{
				var json = eval(jdata);//将json字符串对象转化成json
				var sel = document.getElementById('threelevel');
				if(json=='null'){
					sel.options.length = 1;
				}else{
					sel.options.length = 0;
					for(var i=0; i<json.length; i++) {
						sel.add(new Option(json[i].name,json[i].code));
					}
				}
			}
		}
	});
}
function selsct(lcode,obj){
	$.ajax({
		type:"post",//请求方式get/post
		url:"LinkageServlet",//请求对应的地址
		data:{"levelcode":lcode},//往服务器传递的参数，
		success:function(data){
			var jdata = data.trim(); // 去前后空格
			if(jdata=="fail"){
				alert("查询失败!");
			}else{
				var json = eval(jdata);//将json字符串对象转化成json
				var dd = "";
				for(var i=0; i<json.length; i++) {
					dd+="<dd onclick='showck("+json[i].code+")'>"+json[i].name+"</dd>";
				}
				document.getElementById(obj).innerHTML=dd;
			}
		}
	});
}