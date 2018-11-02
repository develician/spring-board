<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form action="update" method="post">
<input type="hidden" name="bno" value="${vo.bno}"> <input
		type="hidden" name="page" value="${cri.page}" /> <input type="hidden"
		name="perPageNum" value="${cri.perPageNum}" /> <input type="hidden"
		name="searchType" value="${cri.searchType}" /> <input type="hidden"
		name="keyword" value="${cri.keyword}" />
	<div class="col-md-12">
		<div class="box">
			<div class="box-body">
			<div class="form-group">
					<label for="exampleInputEmail1">Bno</label> 
					<input type="text" name="writer" class="form-control" readonly="readonly" value="${vo.bno}">
					<!-- vo필드 이름과 동일하게 name -->
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					 <input type="text" name="title" class="form-control"value="${vo.title}">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Content</label>
					<textarea rows="5" cols="70" name="content" class="form-control">${vo.content }</textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label> 
					<input type="text" name="writer" class="form-control" readonly="readonly" value="${vo.writer }">
					<!-- vo필드 이름과 동일하게 name -->
				</div>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-warning">저장</button>
				<button type="button" class="btn btn-primary">취소</button>
			</div>
		</div>
	</div>
</form>
<script>
	$(document).ready(function(){
		var frm=$("form[role='form']");
		$(".btn-warning").on("click",function(){
			frm.submit();
		});
		$(".btn-primary").on("click",function(){
			self.location="/board/list?page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}";
		});
	});
</script>
<%@include file="../include/footer.jsp"%>