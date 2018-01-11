<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/blog.css" />
		<link rel="stylesheet" type="text/css" href="css/article_content.css" />
		<script
			src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript">
			
			 //发表评论,用json传递参数至action
             var commentButton = function(){
             var url = "${pageContext.request.contextPath}/CommentOfArticle_addComment.action";
             var param = {articleId:"${article.id}",username:"${user.username}",comment:$("#comment").val()};
             $.post(url,param,function(){
                 window.location.reload();
             });
             }
         /* article属性   
			private Integer id;
			private Integer userId;
			private String title;
			private String author;
			private String date;
			private String content;
	*/
			</script>
	</head>
	<body class="body">
		<jsp:include page="top.jsp"></jsp:include>
		<div id="article">
			<div>
				<div class="blogcenter">
					<div class="title">
						<h1 class="center">
							${article.title}
						</h1>
					</div>
					<div id="list" class="date">
						<div class="center">
							<font size="2">(发表时间：${article.date}</font> 作者：${article.author})
							<hr style="height: 1px">
							<br />
							<div id="content" class="contentShow">
								${article.content}
							</div>
							<br />
							<hr style="height: 1px">
						</div>
					</div>
				</div>
				<div id="comments" class="comments">
					<div
						style="border-bottom: 2px black solid; padding-bottom: 5px; font-size: 20px; padding-left: 10px;">
						<font><b>评论列表</b>
						</font>
					</div>
					<c:forEach items="${article.comments}" var="comment">
						<div
							style="border-bottom: 1px white solid; padding-bottom: 5px; font-size: 16px; height: 40px;">
							<div
								style="text-align: left; padding-left: 10px; text-align: middle; padding-top: 5px;">
								${comment.username}
							</div>
							<div
								style="text-align: right; padding-right: 100px; text-align: middle; margin-top: -25px;">
								${comment.date}
							</div>
						</div>
						<div
							style="border-bottom: 2px black solid; padding-bottom: 5px; font-size: 16px; height: auto; padding-left: 10px;">
							${comment.comment}
						</div>
					</c:forEach>
				</div>
			</div>

			<div id="addComment" class="addComment">
				<div
					style="border-bottom: 2px black solid; padding-bottom: 5px; font-size: 20px; height: 40px; padding-top: 15px; overflow: hidden;">
					发表评论
				</div>
				<textarea id="comment" class="comment" name="comment"
					placeholder="这里写评论"></textarea>
				<input id="commentButton" class="button" type="button" value="发表"
					onclick="commentButton()" />
			</div>

		</div>
	</body>
</html>
