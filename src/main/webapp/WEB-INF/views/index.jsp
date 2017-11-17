<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
	<title>목조건축 시공업체 하우징존</title>
	
<meta name="viewport" content="width=320, initial-scale=1">
  
  <link href="${pageContext.request.contextPath}/resources/css/common.css" type="text/css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet" type="text/css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>

<body>
안녕하세요 
  <div class="wrapper">
    <header>
      <div class="ci">
        <a href="index.html"><img src="${pageContext.request.contextPath}/resources/img/ci/ci.png" alt="" class="logoimg"></a>
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




<div class="container" style="width:100%; padding:0;">
  <h2>Carousel Example</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/resources/img/slide/b4.jpg" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/img/slide/b3.JPG" alt="Chicago" style="width:100%;">
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/img/slide/b5.JPG" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



    <footer>
      <div class="footer_wrap">
        <div class="footer1">
          <p>상호 : 하우징존 | 대표 : 윤원필 | 사업자번호 : 127-44-96902 | 이메일 : <span>jy7058@naver.com</span></p>
          <p>전화 : <span>031-840-2628</span> | 팩스 : 031-624-0131 | 핸드폰 : <span>010-4124-0131</span></p>
          <p>경기도 의정부시 용민로 16 용현동 상가 402호</p>
        </div>
        <div class="footer2">
          <p>housingzone.co.kr &copy; 2012 Privacy Policy <a href="admin/admin" class="admin">관리자</a></p>
        </div>
      </div>
    </footer>

  </div>

</body>

</html>