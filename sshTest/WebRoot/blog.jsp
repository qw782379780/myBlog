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
	    <link rel="stylesheet" href="css3-animation-bg-menu/css/style.css" media="screen" type="text/css" />
		<link rel="stylesheet" type="text/css" href="css/blog.css" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans'
			rel='stylesheet' type='text/css'>
		<link
			href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
			rel="stylesheet">
		<script
			src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
		<%  
		    //每次有来自不同session的访问时，count++
		    Integer count = (Integer) application.getAttribute("count");
		    if (session.getAttribute("isChanged") == null) {
		        session.setAttribute("isChanged",new Integer(0));
		    	if((Integer)session.getAttribute("isChanged") < 1){
		    	    Integer isChanged = (Integer) session.getAttribute("isChanged");
		    	    session.setAttribute("isChanged", new Integer(isChanged.intValue() + 1));
					if (application.getAttribute("count") == null) {
						application.setAttribute("count", new Integer(0));
					}
						count = (Integer) application.getAttribute("count");
						application
								.setAttribute("count", new Integer(count.intValue() + 1));
						count = (Integer) application.getAttribute("count");
				}
			}
		%>
	</head>
	<body class="body">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="blogcenter">
			<div id="article">
				<c:forEach items="${page.beanlist}" var="article">
					<div class="title">
						<a
							href="${pageContext.request.contextPath}/Article_findArticleById.action?id=${article.id}"
							target="_blank"> <font
							style="color: #000000; font-size: 20px;"><b>${article.title}</b>
						</font> </a>
						<br />
						<font size="2">(发表时间：${article.date}</font> 作者：${article.author})
					</div>
					<br />
					<div id="content" class="contentHide">
						<a
							href="${pageContext.request.contextPath}/Article_findArticleById.action?id=${article.id}"
							target="_blank"> <font style="color: #000000">${article.content}</font>
						</a>
					</div>
					<br />
					<hr style="height: 1px">
				</c:forEach>
			</div>
			<div class="bottom">
				<c:if test="${page.currentPage==1}">
					<a href="javascript:{return 0}">首页&nbsp&nbsp</a>
				</c:if>
				<c:if test="${page.currentPage!=1}">
					<a
						href="${pageContext.request.contextPath}/Article_findByPage.action?currentPage=1">首页&nbsp&nbsp</a>
				</c:if>
				<c:if test="${page.currentPage==1}">
					<a href="javascript:{return 0}">上一页&nbsp&nbsp</a>
				</c:if>
				<c:if test="${page.currentPage!=1}">
					<a
						href="${pageContext.request.contextPath}/Article_findByPage.action?currentPage=${page.currentPage-1}">上一页&nbsp&nbsp</a>
				</c:if>
				<c:forEach begin="1" end="${page.totalPage}" var="n">
					<c:if test="${page.currentPage==n}">
						<a href="javascript:{return 0}">${n}</a>
					</c:if>
					<c:if test="${page.currentPage!=n}">
						<a
							href="${pageContext.request.contextPath}/Article_findByPage.action?currentPage=${n}">${n}</a>
					</c:if>
				</c:forEach>
				<c:if test="${page.currentPage==page.totalPage}">
					<a href="javascript:{return 0}">下一页&nbsp&nbsp</a>
				</c:if>
				<c:if test="${page.currentPage!=page.totalPage}">
					<a
						href="${pageContext.request.contextPath}/Article_findByPage.action?currentPage=${page.currentPage+1}">下一页&nbsp&nbsp</a>
				</c:if>
				<c:if test="${page.currentPage==page.totalPage}">
					<a href="javascript:{return 0}">尾页&nbsp&nbsp</a>
				</c:if>
				<c:if test="${page.currentPage!=page.totalPage}">
					<a
						href="${pageContext.request.contextPath}/Article_findByPage.action?currentPage=${page.totalPage}">尾页</a>
				</c:if>
			</div>
		</div>
		<div id="count" class="count">
			这是第<%=count.intValue()%>个访问者!
		</div>
		
		
<div class="sidebar">
  <h1><i class="fa fa-bars push"></i>Animated <span class="color">Menu</span></h1>
    <ul>
    <li><a href="#"><i class="fa fa-dashboard push"></i>Dashboard<i class="fa fa-angle-right"></i></a><span class="hover"></span>
    </li>
    <li><a href="#"><i class="fa fa-user push"></i>Users<i class="fa fa-angle-right"></i></a><span class="hover"></span>
      <ul class="sub-menu">
         <li><a href="#">Add User<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
         <li><a href="#">Manage Users<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
      </ul>
    </li>
    <li><a href="#"><i class="fa fa-cog push"></i>Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span>
     <ul class="sub-menu">
         <li><a href="#">Dashboard Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
         <li><a href="#">Profile Settings<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
        <li><a href="#">Manage Menu<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
       <li><a href="#">User Profiles<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
      </ul></li>
    <li><a href="#"><i class="fa fa-picture-o push"></i>appearance<i class="fa fa-angle-right"></i></a><span class="hover"></span>
        <ul class="sub-menu">
         <li><a href="#">Change Theme<i class="fa fa-angle-right"></i></a><span class="hover"></span>
          </li>
         <li><a href="#">Theme Options<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
      </ul>
    </li>
    <li><a href="#"><i class="fa fa-file push"></i>Information<i class="fa fa-angle-right"></i></a><span class="hover"></span>
        <ul class="sub-menu">
         <li><a href="#">Latest News<i class="fa fa-angle-right"></i></a><span class="hover"></span>
          </li>
         <li><a href="#">Recent Articles<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
      </ul>
    </li>
    <li><a href="#"><i class="fa fa-plane push"></i>Contact<i class="fa fa-angle-right"></i></a><span class="hover"></span></li>
  </ul>
</div>
<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>

  <script src="css3-animation-bg-menu/js/index.js"></script>
	</body>
</html>
