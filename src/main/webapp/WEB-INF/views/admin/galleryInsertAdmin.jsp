<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/gallery.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_gallery.css">
     <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>



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
					<li><a href="logout">logout</a></li>
                </ul>
            </nav>
        </header>


    <form method="post" action="galleryInsertAdmin" enctype="multipart/form-data">
      <div class="contentsWrapper">
    <div class="admin_gly">
    <div class="imgs">
   <p style="color:red"> ${ msg }</p>
   메인사진 &gt;&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="mainfile"><br>
   도면사진 &gt;&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="planfile" multiple="multiple"><br>
  시공사진 &gt;&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="detailfile" multiple="multiple"><br>
</div>
  
  <div class="btns">
   사진제목 : <input type="text" name="subject"><br>
   작 성 자 : &nbsp;<input type="text" name="writer"  value="관리자" readonly class="wr"><br>
   <input type="submit" value="등록" class="sb">
   <input type="button" value="등록취소" class="sb" onclick="javascipt:location.href='galleryAdmin'">
   </div>
    </div>
    </div>
   </form>
        <footer>
            <div class="footer_wrap">
                <div class="footer1">
                    <p>상호 : 하우징존 | 대표 : 윤원필 | 사업자번호 : 127-44-96902 | 이메일 : <span>jy7058@naver.com</span></p>
                    <p>전화 : <span>031-840-2628</span> | 팩스 : 031-624-0131 | 핸드폰 : <span>010-4124-0131</span></p>
                    <p>경기도 의정부시 용민로 16 용현동 상가 402호</p>
                </div>
                <div class="footer2">
                    <p>housingzone.co.kr &copy; 2012 Privacy Policy <a href="#" class="admin">관리자</a></p>
                </div>
            </div>
        </footer>

    </div>
</body>

<script>
    $(function() {
        $('.btn1_img').hide();
        $('.btn1').click(function() {
            $('.btn1_img').toggle();
        } );
    })

</script>

</html>
