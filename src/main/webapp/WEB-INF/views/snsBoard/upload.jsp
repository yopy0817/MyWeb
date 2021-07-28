<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="margin-top: 100px;">

	<h3>
		commons-fileupload 라이브러리 추가. <br/>
		스프링설정파일에 최소 설정
	</h3>
	
	<!-- 단일파일업로드 -->
	<form action="upload_ok" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="file">
		<input type="submit" class="btn btn-default" value="전송">
	</form>
	
	
	<!-- 다중파일업로드 (multiple)-->
	<form action="upload_ok2" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="file" multiple="multiple">
		<input type="submit" class="btn btn-default"  value="전송">
	</form>
	
	<!-- 다중파일업로드2  -->
	<form action="upload_ok3" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="file"><br/>
		파일선택:<input type="file" name="file"><br/>
		파일선택:<input type="file" name="file"><br/>
		<input type="submit" class="btn btn-default"  value="전송">
	</form>
	
	<!-- 가변적인 폼 형식의 업로드 -->
	
	<form action="upload_ok4" method="post" enctype="multipart/form-data">
		이름:<input type="text" name="list[0].name"><br/>
		파일선택:<input type="file" name="list[0].file"><br/>
		
		이름:<input type="text" name="list[1].name"><br/>
		파일선택:<input type="file" name="list[1].file"><br/>
		
		이름:<input type="text" name="list[2].name"><br/>
		파일선택:<input type="file" name="list[2].file"><br/>
		
		
		<input type="submit" class="btn btn-default"  value="전송">
	</form>
	
	
	
	
	
	
</div>    
   
