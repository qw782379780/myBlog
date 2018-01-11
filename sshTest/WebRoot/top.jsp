<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'top.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/blog.css" />
		<script
			src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript">
    window.onload = function(){
    
   /* var userInfo = function(){
       $.ajax();
    };
    */
    //使用xmlhttp获取用户信息
    
    var userInfo = function(){ 
    var xmlhttp;
	    if (window.XMLHttpRequest)
	      {// code for IE7+, Firefox, Chrome, Opera, Safari
	           xmlhttp=new XMLHttpRequest();
	      }else{// code for IE6, IE5
	           xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }
	           xmlhttp.onreadystatechange=function(){
	           if (xmlhttp.readyState==4 && xmlhttp.status==200){
	           var userInfoJson = xmlhttp.responseText;
	           userInfoJson = eval('('+userInfoJson+')');
	           $("#userInfo").html(userInfoJson.username+"</br>"+userInfoJson.email+"</br>");
	           }
	    }
	    xmlhttp.open("post","${pageContext.request.contextPath}/User_userInfo.action?username=${user.username}","true");
	    xmlhttp.send();
    };
    userInfo();
    
    //控制用户登录登出菜单的显示
     var loginOut = function(){
        $.post("${pageContext.request.contextPath}/User_loginOut.action",function(){
             $("#login").attr('href','${pageContext.request.contextPath}/login.jsp');
		$("#login").html("<font color='white'>登录</font>");
        });
    };
    var username = "${user.username}";
    var show = function(){ 
    $("#userInfo").show();
    $("#loginOut").show();
    };
    var hide = function(){ 
    $("#userInfo").hide();
    $("#loginOut").hide();
    };
    var isloginOut = false;
	if(username!==""){
		$("#login").attr('href','javascript:{return 0};');
		$("#login").html("<font color='white'>"+username+"</font>");
		$("#login").hover(function(){
		if(!isloginOut){
		show();
		}
		});
		$("#login").mouseleave(function(){
		setTimeout(hide,1000);
		});
		$("#loginOut").click(function(){
		loginOut();
		isloginOut = true;
		hide();
		});
	}
}
    </script>
	</head>

	<body>
		<div class="top">
			<div id="top" class="topFont">
			<div class="login">
				<a id="login" href="${pageContext.request.contextPath}/login.jsp"><font
					color="white">登录</font>
				</a>
				</div> &nbsp&nbsp&nbsp
				<div id="addArticle" class="addArticle">
				<a href="${pageContext.request.contextPath}/addBlog.jsp"><font
					color="white">添加随笔</font>
				</a>
				</div>
			</div>
			<div id="userInfo" class="userInfo">
			</div>
			  <div id="loginOut" class="loginOut">
			      <font>退出</font>
			  </div>
		</div>
	</body>
</html>
