<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="header">
			<h1>${blogvo.title }</h1>
			<ul>
				<c:if test="${empty authUser }">
					<li><a href="${pageContext.servletContext.contextPath }/user/login">로그인</a></li>
				</c:if>
				
				<c:if test="${!empty authUser }">
					<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.servletContext.contextPath }/${authUser.id}/admin/basic">블로그 관리</a></li>
				</c:if>
				
			</ul>
		</div>