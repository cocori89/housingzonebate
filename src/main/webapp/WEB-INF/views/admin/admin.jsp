<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"
	type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/css/common.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/board.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>
<body>
	<div class="wrapper">
		<header>
			<div class="ci">
				<a href="mainAdmin"><img
					src="${pageContext.request.contextPath}/resources/img/ci/ci.png"
					alt="" class="logoimg"></a>
			</div>
			<nav>
				<ul>
					<li>관리자 모드</li>
					<li class="home"><a href="mainAdmin">HOME</a></li>
					<li class="gallery"><a href="galleryAdmin">GALLERY</a></li>
					<li class="contactus"><a href="contactus.html">CONTACT US</a></li>
					<li class="board"><a href="noticeAdmin">BOARD</a></li>
				</ul>
			</nav>
		</header>
		<form action="login" method="post">
			<div class="contentsWrapper">
				<div class="board2">
					<h2 class="notice">관리자 로그인</h2>
					<h4 class="notice">${msg}</h4>
					<table class="table table-striped">

						<tr>
							<td>id</td>
							<td><input type="text" name="id"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="로그인">
							<input type="reset" value="취소" >
							<input type="button" value="홈으로" onclick="javascipt:location.href='${pageContext.request.contextPath}/index.html'">
							</td>
						</tr>
					</table>
				</div>

			</div>
		</form>


		<footer>
			<div class="footer_wrap">
				<div class="footer1">
					<p>
						상호 : 하우징존 | 대표 : 윤원필 | 사업자번호 : 127-44-96902 | 이메일 : <span>jy7058@naver.com</span>
					</p>
					<p>
						전화 : <span>031-840-2628</span> | 팩스 : 031-624-0131 | 핸드폰 : <span>010-4124-0131</span>
					</p>
					<p>경기도 의정부시 용민로 16 용현동 상가 402호</p>
				</div>
				<div class="footer2">
					<p>
						housingzone.co.kr &copy; 2012 Privacy Policy <a href="#"
							class="admin">관리자</a>
					</p>
				</div>
			</div>
		</footer>
	</div>

</body>
</html>
