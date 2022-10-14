<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Spring 파일업로드</title>
</head>
<body>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="text" name="writer" /> 
		<!-- name과 컨틀로러의 파라미터 이름이 같아야 함 -->
		<input type="file" name="uploadFiles" multiple/> 
		<input type="submit" value="업로드">
	</form>
</body>
</html>
