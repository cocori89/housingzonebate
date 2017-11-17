<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/css/about.css"	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/common.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/reset.css"	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>

<body>
	<div class="wrapper">
		<header>
			<div class="ci">
				<a href="index.html"><img
					src="${pageContext.request.contextPath}/resources/img/ci/ci.png"
					alt="" class="logoimg"></a>
			</div>
			<nav>
				<ul>
					<li class="home"><a href="index.html">HOME</a></li>
					<li class="about"><a href="about.html">ABOUT US</a></li>
					<li class="service"><a href="service.html">SERVICE</a></li>
					<li class="gallery"><a href="gallery.html">GALLERY</a></li>
					<li class="contactus"><a href="contactus.html">CONTACT US</a></li>
					<li class="board"><a href="board.html">BOARD</a></li>
					<li class="band"><a href="band.html">BAND</a></li>
				</ul>
			</nav>
		</header>


		<div class="contentsWrapper">

			<div class="about2">
				<img
					src="${pageContext.request.contextPath}/resources/img/about.png">
			</div>
			<hr>
			<div class="contents">
				<h1 class="h1">WE ARE HERE!</h1>
				<div id="map">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3155.374478811356!2d127.07938521561466!3d37.73435802225635!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357cc70712c62fcf%3A0x5e4482559c950da!2z6rK96riw64-EIOydmOygleu2gOyLnCDsmqnrr7zroZwgMTY!5e0!3m2!1sko!2skr!4v1507354576184"
						allowfullscreen></iframe>
				</div>
			</div>

		</div>


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
						housingzone.co.kr &copy; 2012 Privacy Policy <a href="admin/admin"
							class="admin">관리자</a>
					</p>
				</div>
			</div>
		</footer>

	</div>

</body>

</html>
