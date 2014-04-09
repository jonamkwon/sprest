<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="js/jquery.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	var message = $('#message').val();
	
	if(message == "updatecomplete") {
		alert('수정이 완료 되었습니다.');
	}else if(message == "insertcomplete") {
		alert('가입이 완료 되었습니다.');
	}else if(message == "deletecomplete") {
		alert('탈퇴가 완료 되었습니다.');
	}
	
	$('#insert').click(function(){
		//var name = $('#getName').val();
		//var age = $('#getAge').val();
		$('#indexForm').attr('action', 'goInsert').submit();
		//location.href="/sprest/goInsert?name="+name+"&age="+age;
	});
	
	
	$('#update').click(function(){
	//	var name = $('#getName').val();
	//	var age = $('#getAge').val();
	//	var s_no = $('#getS_no').val();
		$('#indexForm').attr('action', 'goUpdate').submit();
	//	location.href="/sprest/goUpdate?name="+name+"&age="+age+"&s_no="+s_no;
	});
	
	$('#delete').click(function(){
	//	var s_no = $('#getS_no').val();
		$('#indexForm').attr('action', 'goDelete').submit();
	//	location.href="/sprest/goDelete?s_no="+s_no;
	});
});
</script>
<body>
<form action="goView" id="indexForm" name="indexForm" method="post">
	<table border="1">
		<tr>
			<td><h3>GET</h3></td>
			<td>s_no : <input type="text" name="s_no" id="s_no" value="${s_no }"/>
			<input type="submit" id="check" name="check" value="확인" /></td>
		</tr>
	</table>
	<c:set var="name" value="${result.name }"/>
	<c:set var="age" value="${result.age }"/>
	<c:set var="s_no" value="${result.s_no }"/>
	<c:set var="rs" value="${rs }"/>
	<table border="1">
		<tr>
			<td><h3>POST</h3></td>
			<td>
				<textarea id="result" name="result" readonly="readonly">
					${rs }
				</textarea>
				<h4>이름</h4><input type="text" id="getName" name="getName" value="${name }" />
				<h4>나이</h4><input type="text" id="getAge" name="getAge" value="${age }" />
				<input type="hidden" id="getS_no" name="getS_no" value="${s_no }" />
				<input type="hidden" id="message" name="message" value="${message }" />
			</td>		
		</tr>
		<tr>
			<td>
				<c:if test="${rs != null }">
					<input type="button" id="update" name="update" value="수정" /><input type="button" id="delete" name="delete" value="삭제" />
				</c:if>
				<c:if test="${rs == null }">
					<input type="button" id="insert" name="insert" value="가입" />
				</c:if>
			</td>
		</tr>
	</table>
	
	<table border="1">
		<tr>
			<td colspan="3"><h3>회원 리스트</h3></td>
		</tr>
		<tr>
			<td>회원번호</td>
			<td>이름</td>
			<td>나이</td>
		</tr>
		<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.s_no }</td>
			<td>${list.name }</td>
			<td>${list.age }</td>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>