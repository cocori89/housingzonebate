package kr.co.housingzone.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// ������ �α��� �� ���� ���ϸ� ������ �������� ���� ���� ���ϰ� �ϱ� ����
public class AuthenticationIntercepter implements HandlerInterceptor {
	
	//���� �߻� ���ο� ��� ���� Cnotroller�� �۾��̳����� ȣ��Ǵ� �޼ҵ�
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// ���ܰ� �߻����� ���� ��쿡�� Controller �۾��� ������ ȣ��Ǵ� �޼ҵ�
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	//Controller�� ��û�� ó���ϱ� ���� ȣ��Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		// Ȩ�������� �ִ� ������ ���� �´�. (�α����� ������ ��쿡�� ���� ���� �ֱ� �����̴�. )
		HttpSession session = arg0.getSession();
		if(session.getAttribute("admin")==null){// admin�̶�� �Ӽ��� ������ 
			//�α��� �������� �����̷�Ʈ�� ������. 
			arg1.sendRedirect(arg0.getContextPath()+"/admin/admin");
			return false;//�α��� ���� ���� ��쿡�� ���� ������ ���� �ʴ´�
		}
		// �α��� �Ȱ�쿡�� �������� ó�� ����
		return true;
	}
	
	

}
