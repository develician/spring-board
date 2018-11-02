<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="col-md-12">
	<div class="box">
		<div class="box-header with-border">
			<h2 class="box-title">Dummy 게시글</h2>
		</div>
		<table class="table table-bordered" width="500px">

			<tr>
				<th width="10px">no</th>
				<th>title</th>
				<th>writer</th>
				<th>regdate</th>
				<th width="40px">viewcnt</th>
			</tr>
			<c:forEach items="${list }" var="vo">
				<tr>
					<td>${vo.bno }</td>
					<td><a href="/board/read?bno=${vo.bno }">${vo.title }</td>
					<td>${vo.writer}</td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH:mm"/></td>
					<td><span class="badbe bg-red">${vo.viewcnt }</span></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<%@include file="../include/footer.jsp"%>
<script>
	var result = '${result}';
	if (result == "success") {
		alert("정상적으로 글이 등록되었습니다.");
	}else if(result=="delete"){
		alert("정상적으로 글이 삭제되었습니다.");
	}else if(result=="update"){
		alert("정상적으로 글이 수정되었습니다.");
	}
</script>
















