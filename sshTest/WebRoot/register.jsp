<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form with HTML5 and CSS3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript">
		//验证登录名
        var checkUsername = function(){
            var username = $("#usernamesignup").val();
		if($.trim(username)==""){
		    $("#unamehint").html("&nbsp&nbsp&nbsp&nbsp用户名不能为空");
		}else{
		    var url = "${pageContext.request.contextPath}/User_checkUsername.action";
		    var param = {"username":username};
		$.post(url,param,function(data){
		    //判断返回值，即用户名是否已被使用
		    if(data=="Available"){
		       $("#unamehint").html("&nbsp&nbsp&nbsp&nbsp恭喜你！用户名可以使用");
		    }else{
		       $("#unamehint").html("&nbsp&nbsp&nbsp&nbsp用户名已被占用");
		    }
		  });
		}
     }
     
     //验证密码
     var checkPassword = function(){
         var password = $("#passwordsignup").val();
         var password_confirm= $("#passwordsignup_confirm").val();
         if($.trim(password)==""){
            $("#passwordhint").html("&nbsp&nbsp&nbsp&nbsp请输入密码");
         }else{
            $("#passwordhint").html("");
         }
     }
     
    var confirmPassword = function(){
         var password = $("#passwordsignup").val();
         var password_confirm= $("#passwordsignup_confirm").val();
         if(password!=password_confirm){
            $("#passwordhint_confirm").html("&nbsp&nbsp&nbsp&nbsp两次输入的密码不一致！");
         }else{
            $("#passwordhint_confirm").html("");
         }
     }
		</script>
    </head>
    <body>
        <div class="container">
            <div class="codrops-top">
                <div class="clr"></div>
            </div>
            <header>
                <h1>我的博客<span>注册界面</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="register" class="animate form">
                            <form  action="${pageContext.request.contextPath}/User_addUser.action" autocomplete="on"> 
                                <h1> 注册 </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">用户名<span id="unamehint"></span></label>
                                    <input id="usernamesignup" name="username" required="required" type="text" onblur="checkUsername()"/>
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" >邮箱</label>
                                    <input id="emailsignup" name="email" required="required" type="email"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">密码<span id="passwordhint"></span></label>
                                    <input id="passwordsignup" name="userpassword" required="required" type="password" onblur="checkPassword()"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认密码<span id="passwordhint_confirm"></span></label>
                                    <input id="passwordsignup_confirm" required="required" type="password" onblur="confirmPassword()"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="注册"/> 
								</p>
                                <p class="change_link">  
									已有账号？
									<a href="${pageContext.request.contextPath}/login.jsp" class="to_register">马上登录</a>
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>