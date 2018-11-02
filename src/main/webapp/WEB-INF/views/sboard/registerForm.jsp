<%@include file="../include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form action="/sboard/regist" method="post">
	<div class="col-md-12">
		<div class="box">
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					 <input type="text" name="title" class="form-control" placeholder="제목 입력">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Content</label>
					<textarea rows="5" cols="70" name="content" class="form-control"></textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label>
					 <input type="text" name="writer" class="form-control" placeholder="작성자를 입력하세요.">
					<!-- vo필드 이름과 동일하게 name -->
				</div>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">글 등록</button>
			</div>
		</div>
	</div>
</form>
<%@include file="../include/footer.jsp"%>