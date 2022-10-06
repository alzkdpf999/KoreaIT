<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Spring 파일업로드 결과</title>
</head>
<body>
	<h2>파일 업로드 결과</h2>

	<c:forEach var="file" items="${list}">
${file.filenName }<br>
${file.originalFileName }<br>
${file.contentType }<br>
==============================<br>
	</c:forEach>
</body>
</html>
