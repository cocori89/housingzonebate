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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/gallery_detail1.css">
     <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>



<div class="wrapper">
        <header>
            <div class="ci">
				<a href="mainAdmin"><imgasdas
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
            <div class="view">
                <h1>시공사진</h1>
                <table class="noticeView">
                    <tr>
                        <th class="title">제목</th>
                        <th class="title">${subject }</th>
                    </tr>
                    <tr>
                        <td class="writer">작성자</td>
                        <td class="writer">관리자</td>
                    </tr>
                    <tr>
                        <td class="date">작성일</td>
                        <td class="date">${regdate }</td>
                    </tr>
                    <tr>
                       	<c:forEach var="pList" items="${planList}">
                        <td class="contents">
                            <img src="${pageContext.request.contextPath}/resources/gallery/plan/${pList.planfilename}" width="500px" alt="도면" height="400px" class="contents_img"/>
                        </td>
						</c:forEach>
                    </tr>
                </table>
                <table class="next_btn">
                    <tr>
                        <td>
                            <button class="btn1">시공사진 보기 클릭</button>
                            <div class="btn_img"><img src="${pageContext.request.contextPath}/resources/img/5.JPG" alt="" class="btn1_img">
							<c:forEach var="dList" items="${detailList}">
                                <img src="${pageContext.request.contextPath}/resources/gallery/detail/${dList.detailfilename}" alt="" class="btn1_img">
							</c:forEach>
                            </div>
                        </td>
                    </tr>

                </table>
                <div class="btn2_position">
                    <button class="btn2" onclick="javecript:location.href='gallery.html'">목록</button>
                </div>
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

<script>
    $(function() {
        $('.btn1_img').hide();
        $('.btn1').click(function() {
            $('.btn1_img').toggle();
        } );
    })

</script>

</html>
