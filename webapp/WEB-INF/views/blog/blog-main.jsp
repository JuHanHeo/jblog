<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/blogheader.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
				<c:if test="${post==-1 }">
					<h4>${postList[0].title }</h4>
					<p>${postList[0].content }<p>
				</c:if>
				
				<c:if test="${post!=-1 }">
					<h4>${postvo.title }</h4>
					<p>${postvo.content }<p>
				</c:if>
					
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList }" var="list" varStatus="cnt">
						<li><a href="${pageContext.request.contextPath }/${userId}/${list.no}">${list.title }</a> <span>${list.regDate }</span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath }${blogvo.logo }	">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${cateList }" var="clist" varStatus="status">
					<li><a href="${pageContext.request.contextPath}/${userId}?cate=${clist.name}">${clist.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		<c:import url="/WEB-INF/views/include/blogfooter.jsp" />
	</div>
</body>
</html>