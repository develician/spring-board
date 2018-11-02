<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script>
	var result = '${result}';
	if (result == "success") {
		alert("정상적으로 글이 등록되었습니다.");
	} else if (result == "delete") {
		alert("정상적으로 글이 삭제되었습니다.");
	} else if (result == "update") {
		alert("정상적으로 글이 수정되었습니다.");
	}

	$(document).ready(
			function() {
				$('#searchBtn').on(
						'click',
						function(e) {
							window.location = 'list'
									+ '${maker.makeQuery(1)}'
									+ '&searchType='
									+ $("select option:selected").val()
									+ "&keyword="
									+ encodeURIComponent($('#keywordInput')
											.val());
						});

				$('#newBtn').on('click', function(e) {
					window.location = 'regist';
				});
			});
</script>


<div class="col-md-12">
	<div class="box-body">
		<select name="searchType">
			<option value="n"
				<c:out value="${ cri.searchType == null ? 'selected' : ''}" />>
				====</option>
			<option value="t"
				<c:out value="${ cri.searchType eq 't' ? 'selected' : ''}" />>
				Title</option>
			<option value="c"
				<c:out value="${ cri.searchType eq 'c' ? 'selected' : ''}" />>
				Content</option>
			<option value="w"
				<c:out value="${ cri.searchType eq 'w' ? 'selected' : ''}" />>
				Write</option>
			<option value="tc"
				<c:out value="${ cri.searchType eq 'tc' ? 'selected' : ''}" />>
				Title or Content</option>
			<option value="cw"
				<c:out value="${ cri.searchType eq 'cw' ? 'selected' : ''}" />>
				Content or Writer</option>
			<option value="tcw"
				<c:out value="${ cri.searchType eq 'tcw' ? 'selected' : ''}" />>
				Title or Content or Writer</option>
		</select> <input type="text" name="keyword" id="keywordInput"
			value="${ cri.keyword }" />
		<button id="searchBtn">Search</button>
		<button id="newBtn">New Board</button>
	</div>
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
					<td><a
						href="/sboard/read${ maker.makeSearch(maker.cri.page) }&bno=${vo.bno }">${vo.title }</td>
					<td>${vo.writer}</td>
					<td><fmt:formatDate value="${vo.regdate }"
							pattern="yyyy-MM-dd HH:mm" /></td>
					<td><span class="badbe bg-red">${vo.viewcnt }</span></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</div>

<div class="text-center">
	<ul class="pagination">
		<c:if test="${maker.prev }">
			<li><a href="list${ maker.makeSearch(maker.startPage - 1) }">&laquo;</a></li>
		</c:if>
		<c:forEach begin="${maker.startPage }" end="${maker.endPage }" var="i">
			<li <c:out value="${maker.cri.page==i ? 'class=active':'' }"/>><a
				href="list${ maker.makeSearch(i) }">${i}</a></li>
		</c:forEach>
		<c:if test="${maker.next && maker.endPage>0}">
			<li><a href="list${ maker.makeSearch(maker.endPage + 1) }">&raquo;</a></li>
		</c:if>
	</ul>
</div>


<%@include file="../include/footer.jsp"%>
















