<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equive="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>writer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/writerView.css">
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
					<li><a href="logout">logout</a></li>
				</ul>
			</nav>
		</header>


        <div class="contentsWrapper">
            <div class="view">
                <h1>공지사항</h1>
                <table class="noticeView">
                  
                    <tr>
                        <th class="title">제목</th>
                        <th class="title">${contactusVO.title}</th>
                    </tr>
                    <tr>
                        <td class="writer">작성자</td>
                        <td class="writer">${contactusVO.name}</td>
                    </tr>
                    <tr>
                        <td class="date">작성일</td>
                        <td class="date">${contactusVO.regdate}</td>
                    </tr>
                    <tr>
                        <td class="contents">${contactusVO.content}</td>
                    </tr>
                    
                    <tr>
                        <td class="next" colspan="2"></td>
                    </tr>
                </table>
                
                <button onclick="javascipt:location.href='contactus.html'">목록</button>
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