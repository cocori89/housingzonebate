package kr.co.housingzone.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.housingzone.controller.domain.AdminVO;
import kr.co.housingzone.controller.domain.ContactusVO;
import kr.co.housingzone.controller.domain.NoticeVO;
import kr.co.housingzone.service.AdminService;
import kr.co.housingzone.service.ContactusService;
import kr.co.housingzone.service.NoticeService;

//�����ڿ� ��Ʈ�ѷ� 
@Controller
public class AdminContoller {

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ContactusService contactusService;
	
	// ������ ���� �������� �̵�
	@RequestMapping(value = "/admin/mainAdmin", method = RequestMethod.GET)
	public String mainInsertFrom(Locale locale, Model model) {
		return "/admin/mainAdmin";
	}
	
/*	//���� ���� �� ����
	@RequestMapping(value = "contentAdmin", method = RequestMethod.GET)
	public String contentAdmin(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "/admin/contentAdmin";
	}*/
	// �α���
	@RequestMapping(value = "/admin/login" , method = RequestMethod.POST)
	public String login(RedirectAttributes attr, HttpServletRequest request, HttpSession session){//�α����� ���� HttpSession�� ��� �Ѵ�. 
		AdminVO adminVO = adminService.login(request);
		
		if(adminVO == null){// �α� �� ���н�
			attr.addFlashAttribute("msg","������ ������ �ٽ� �Է��ϼ���");// �ѹ��� �����ش� 
			return "redirect:admin";
		}else{
			session.setAttribute("admin", adminVO.getId()); 
			return "/admin/mainAdmin";
		}
	}
	
	
	// �α� �ƿ� 
	@RequestMapping(value = "/admin/logout")
	public String logout(HttpSession seeion){
		seeion.invalidate();// ������ �����ؼ� �α׾ƿ��� �Ѵ�. 
		return "redirect:/";
	}
	
	//----------------
	// ���� ����
	//----------------
	
	//noticeAdmin �������� list��� �����ִ� ��
	@RequestMapping(value = "/admin/noticeAdmin", method = RequestMethod.GET)
	public String noticeFrom(Locale locale, Model model) {
		List<NoticeVO> list = noticeService.getList();
		model.addAttribute("list",list);
		return "/admin/noticeAdmin";
	}
	

	//�������� �۾��� �������� �̵� 
	@RequestMapping(value = "/admin/noticeInsert", method = RequestMethod.GET)
	public String noticeInsertFrom(Locale locale, Model model) {
		return "/admin/noticeInsert";
	}
	
	//�������� ������ִ� �޼���
	@RequestMapping(value = "/admin/noticeInsert", method = RequestMethod.POST)
	//HttpServletRequest jsp���� �Ѿ���� ���� �޾��ִ� ��ü
	public String noticeInsertService(HttpServletRequest request){
		int r = noticeService.insertNotice(request);// jsp���� �״�� �ٷ� �Ѱ��ش�. 
		if(r>0){ //��Ͽ� ���� ������ 
			//return "notice";
			System.out.println("����");
			return "redirect:/admin/noticeAdmin";//list.jsp�ۼ� ���̱� ������ �ϴ� �Խ÷� test������ 
		}else {// ����� �����߰��
			return "redirect:/admin/noticeAdmin";
		}
	}
	
	//���� ���� �� ����
	@RequestMapping(value = "/admin/contentAdmin", method = RequestMethod.GET)
	public String contentAdmin(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "/admin/contentAdmin";
	}
	
	
	//�������� ���� �ϱ�
	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String deleteNotice(@RequestParam("no")int no, Model model){
		int r = noticeService.deletenotice(no);// jsp���� �״�� �ٷ� �Ѱ��ش�. 
		if(r>0){ //��Ͽ� ���� ������ 
			//return "notice";
			return "redirect:/admin/noticeAdmin";//list.jsp�ۼ� ���̱� ������ �ϴ� �Խ÷� test������ 
		}else {// ����� �����߰��
			return "redirect:/admin/noticeAdmin";
		}
	}

	
	//���� ���� ���� ����
	@RequestMapping(value = "/admin/noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "/admin/noticeUpdate";
	}
	
	//���� ���� ���� �ϱ�
	@RequestMapping(value = "/admin/noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdateService(HttpServletRequest request, Model model){
		int r = noticeService.updateNotice(request);
			
		if(r>0){// �ּ������� 
			System.out.println("����");
			return "redirect:/admin/noticeAdmin";
		}else {
			return "redirect:/admin/noticeAdmin";
		}
	}
	
	
	//----------------
	//�������� 
	//----------------
	//noticeAdmin �������� list��� �����ִ� ��
	@RequestMapping(value = "/admin/contactus.html", method = RequestMethod.GET)
	public String contactAdmin(Locale locale, Model model) {
		List<ContactusVO> list = contactusService.getList();
		model.addAttribute("list",list);
		return "/admin/contactusAdmin";
	}
	
	//���� ���� ����
	@RequestMapping(value = "/admin/contactusDelete", method = RequestMethod.GET)
	public String contactusDelete(@RequestParam("num") int num , RedirectAttributes addr) {
		int r = contactusService.deleteContactus(num);
		
		if(r>0){// ���� ������
			addr.addFlashAttribute("msg", "���� ���Ǹ� ���� �Ͽ����ϴ�. ");
			return "redirect:/admin/contactus.html";
		}else {
			return "redirect:/admin/contactus.html";
		}
	}
	
	//���� ���� ����
	@RequestMapping(value = "/admin/contactusContentAdmin", method = RequestMethod.GET)
	public String contactusContentAdmin(@RequestParam("num")int num, Model model){
		ContactusVO contactusVO = contactusService.selectContactus(num);
		model.addAttribute("contactusVO", contactusVO);
		return "/admin/contactusContentAdmin";
	}
	
	
	
}
