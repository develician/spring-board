<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form role="form" method="post">
	<input type="hidden" name="bno" value="${vo.bno}">
</form>
<script>
	$(document).ready(function() {
		var frm = $("form[role='form']");
		console.log(frm);

		$(".btn-warning").on("click", function() {
			frm.attr("action","/board/update"); //속성추가
			frm.attr("method","get");
			frm.submit();
		});
		$(".btn-danger").on("click", function() {
			frm.attr("action","/board/delete");
			frm.submit();
		});
		$(".btn-primary").on("click", function() {
			self.location="/board/listAll";
		});
	});
</script>
<div class="col-md-12">
	<div class="box">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> <input type="text"
					name="title" class="form-control" value="${vo.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea rows="5" cols="70" name="content" class="form-control"
					readonly="readonly">${vo.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> <input type="text"
					name="writer" class="form-control" value="${vo.writer }"
					readonly="readonly">
				<!-- vo필드 이름과 동일하게 name -->
			</div>
		</div>
		<div class="box-footer">
			<button type="submit" class="btn btn-warning">글 수정</button>
			<button type="submit" class="btn btn-danger">글 삭제</button>
			<button type="submit" class="btn btn-primary">글 목록</button>
		</div>
	</div>
</div>

<%@include file="../include/footer.jsp"%>