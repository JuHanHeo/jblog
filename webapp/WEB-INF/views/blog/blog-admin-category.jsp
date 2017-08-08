<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<link rel="stylesheet"	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script	src="${pageContext.servletContext.contextPath }/assets/js/ejs/ejs.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">


$(function(){
	
	var dialogDelete = $( "#dialog-deleteForm" ).dialog({
	    autoOpen: false,
	    height: 130,
	    width: 200,
	    modal: true,
	    buttons: {
	      "삭제": function(){
	    	  
	    	  //ajax 통신
	    	  $.ajax({
					url : "${pageContext.request.contextPath}/guestbook/api/delete",
					type : "post",
					dataType : "json",
					data : "no=" + no + "&passwd=" + password,
					//contentType: 'application/json',
					success : function(response) {
						if(response.result ==="fail"){
							return;
						}
						
						//삭제 실패!!
						if(response.data===-1){
							return ;
						}
						
						//삭제 성공
						dialogDelete.dialog( "close" );
					},
					error : function(jqXHR, status, e) {
						console.error(status + " : " + e);
					}
				});
	      },
	      "취소": function() {
	    	  dialogDelete.dialog( "close" );
	      }
	    },
	  });
	
	$(document).on("click","#delete-img",function(event){
		
		event.preventDefault();
		console.log("click")
		dialogDelete.dialog("open");
	})
})

</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/blogheader.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/include/adminmenu.jsp"/>
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items="${list }" var="cl">
					<tr>
						<td>${cl.no }</td>
						<td>${cl.name }</td>
						<td>${cl.cnt }</td>	
						<td>${cl.description }</td>
						<td><img id="delete-img" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>
					</c:forEach>  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<form action="" method="post">
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="description"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	</form>
			</div>
			<div id="dialog-deleteForm" >
				<p>정말 삭제 하시겠습니까?</p>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/blogfooter.jsp"/>
	</div>
</body>
</html>