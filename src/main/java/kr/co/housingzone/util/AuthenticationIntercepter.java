package kr.co.housingzone.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 관리자 로그인 을 하지 못하면 관리자 페이지에 접근 하지 못하게 하기 위함
public class AuthenticationIntercepter implements HandlerInterceptor {
	
	//예외 발생 여부에 상관 없이 Cnotroller의 작업이끝나면 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// 예외가 발생하지 않은 경우에만 Controller 작업이 끝나면 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	//Controller가 요청을 처리하기 전에 호출되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		// 홈페이지에 있는 세션을 가져 온다. (로그인이 되있을 경우에는 세션 값이 있기 때문이다. )
		HttpSession session = arg0.getSession();
		if(session.getAttribute("admin")==null){// admin이라는 속성이 없으면 
			//로그인 페이지로 리다이렉트로 보낸다. 
			arg1.sendRedirect(arg0.getContextPath()+"/admin/admin");
			return false;//로그인 되지 않은 경우에는 다음 수행을 하지 않는다
		}
		// 로그인 된경우에는 정상적이 처리 수행
		return true;
	}
	
	

}
