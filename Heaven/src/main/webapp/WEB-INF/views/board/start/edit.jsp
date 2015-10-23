<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<table border="1">
			<tr>
				<th><label for="title">제목</label></th>
				<td><input type="text" name="title"  id="title"/>
					</td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td><input type="text" name="content" id="content" />
					</td>
			</tr>
			<tr>
				<th><label for="writer">작성자</label></th>
				<td><input type="text" name="writer" id="writer"/>
					</td>
			</tr>
			<tr>
				<th><label for="password">비밀번호</label></th>
				<td><input type="password" id="password" name="pwd" /></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록"> <a
				href="#">목록</a>
		</div>
	</form>
</body>
</html>