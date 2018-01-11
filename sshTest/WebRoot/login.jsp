<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<html>
	<head>
		<script
			src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/particles.js"></script>
		<script src="${pageContext.request.contextPath}/js/app.js"></script>
		<script src="${pageContext.request.contextPath}/js/login.js"></script>
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<script type="text/javascript">
			//检查用户名是否 可用
			var checkUsername = function(){
			var username = $("#Rusername").val();
			if(username==""){
			    $("#Rusernamehint").html("用户名不能为空!");
			}else{
			$.post("${pageContext.request.contextPath}/User_checkUsername.action?username="+username,function(data){
			       if(data=="Unavailable"){
			       $("#Rusernamehint").html("用户名已被占用!");
			       }else{
			       $("#Rusernamehint").html("恭喜你，该用户名可以使用!");
			       }
			});
			}
			};
			//检查登录表单是否有项目为空
			var checkForm = function(){
			var username = $("#username").val();
			var password = $("#userpassword").val();
			if(username==""||password==""){
			      $("#usernamehint").html("请输入用户名和密码");
			      }else{
			      $("#usernamehint").html("");
			      }
			};
			
			//表单为空时禁用submit按钮
			var checkLogin = function(){
			var username = $("#username").val();
			var password = $("#userpassword").val();
			if(username==""||password==""){
			      $("#submit").attr("disabled",true);
			   }
			};
			var initButton = function(){
			 $("#submit").attr("disabled",false);
			};
		</script>
	</head>
	<body id="particles-js">
		<div id="form" class="form">
		</div>
			<div id="loginTitle" class="loginTitle">
				登录
			</div>
			<div id="registerTitle" class="registerTitle">
				注册
			</div>
			<div id="login" class="login">
				<form action="User_login.action" method="post" autocomplete="off">
					<input id="username" class="username" name="username" type="text" placeholder="用户名" onfocus="initButton()"/>
					<input id="userpassword" class="userpassword" name="userpassword" type="password"
						placeholder="密码" onblur="checkForm()" onfocus="initButton()"/>
					<div id="usernamehint" class="usernamehint"></div>
					<input id="submit" class="submit" type="submit" value="登录" onmouseover="checkLogin()"/>
				</form>
			</div>
			<div id="register" class="register">
				<form action="User_addUser.action" method="post" autocomplete="off">
					<input id="Rusername" class="username" name="username" type="text" placeholder="用户名" onkeyup="checkUsername()"/>
					<div id="Rusernamehint" class="Rusernamehint"></div>
					<input id="userpassword" class="userpassword" name="userpassword" type="password"
						placeholder="密码" />
					<input id="email" class="email" name="email" type="text" placeholder="邮箱" />
					<input id="submit1" class="submit" type="submit" value="注册"/>
					</form>
					</div>
	</body>
</html>