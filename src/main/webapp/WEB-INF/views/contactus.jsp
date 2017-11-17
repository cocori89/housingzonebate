<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/resources/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/contactus.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>

    
</head>

<body>
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


        <div class="contentsWrapper">
            <section class="section">
                 <article class="title">
                    <h1>CONTACT US</h1>

                    <span>하우징존은</span>
                    <p>풍부한 현장 경험을 가진 목수출신의 담당자가</p>
                    <p> 전문적이고 체계적인 시스템을 바탕으로,</p>
                    <p>내 가족의 집을 짓는 마음으로 시공을 진행합니다.</p>
                    <p>단순히 집을 짓는것에 그치지 않고,</p>
                    <p> 고객님들 각자에게 맞는 1:1 맞춤 설계를 진행해 드립니다.</p>

                </article>


                <article class="info">
					<form method="post" id="contactusFrom" name="contactusFrom" onsubmit="return check()">
					${msg }
                    <table>
                        <tr>
                            <td>
                                <input type="text" name="name" id="name" placeholder=" 이름">
                                <hr>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <input type="email" name="email" id="email" placeholder=" 이메일">
                                <hr>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" name="title" id="title" placeholder=" 제목">
                                <hr>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="tel" name="tel" id="tel" placeholder=" 전화번호">
                                <hr>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <textarea name="content" id="content" cols="30" rows="10" placeholder=" 내용"></textarea>

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <input type="submit" class="submit" value="전송">
                            </td>
                        </tr>

                    </table>
				</form>
                </article>
            </section>
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
    <script type="text/javascript">
    function check(){
		if($("#name").val() == ""){
			alert("이름을 입력해주세요");
			$("#name").focus();
			return false;
		}
		if($("#email").val() == ""){
			alert("이메일을 입력해주세요");
			$("#email").focus();
			return false;
		}
		if($("#title").val() == ""){
			alert("제목을 입력해주세요");
			$("#title").focus();
			return false;
		}
		if($("#tel").val() == ""){
			alert("연락처을 입력해주세요");
			$("#tel").focus();
			return false;
		}
		if($("#content").val() == ""){
			alert("내용을 입력해주세요");
			$("#content").focus();
			return false;
		}
		return true;
		
	}//check end
	</script>

</html>
    