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

//관리자용 컨트롤러 
@Controller
public class AdminContoller {

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ContactusService contactusService;
	
	// 관리자 메인 페이지로 이동
	@RequestMapping(value = "/admin/mainAdmin", method = RequestMethod.GET)
	public String mainInsertFrom(Locale locale, Model model) {
		return "/admin/mainAdmin";
	}
	
/*	//공지 사항 상세 보기
	@RequestMapping(value = "contentAdmin", method = RequestMethod.GET)
	public String contentAdmin(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "/admin/contentAdmin";
	}*/
	// 로그인
	@RequestMapping(value = "/admin/login" , method = RequestMethod.POST)
	public String login(RedirectAttributes attr, HttpServletRequest request, HttpSession session){//로그인을 윙해 HttpSession을 사용 한다. 
		AdminVO adminVO = adminService.login(request);
		
		if(adminVO == null){// 로그 인 실패시
			attr.addFlashAttribute("msg","관리자 정보를 다시 입력하세요");// 한번만 보여준다 
			return "redirect:admin";
		}else{
			session.setAttribute("admin", adminVO.getId()); 
			return "/admin/mainAdmin";
		}
	}
	
	
	// 로그 아웃 
	@RequestMapping(value = "/admin/logout")
	public String logout(HttpSession seeion){
		seeion.invalidate();// 세션을 삭제해서 로그아웃을 한다. 
		return "redirect:/";
	}
	
	//----------------
	// 공지 사항
	//----------------
	
	//noticeAdmin 페이지겸 list목록 보여주는 것
	@RequestMapping(value = "/admin/noticeAdmin", method = RequestMethod.GET)
	public String noticeFrom(Locale locale, Model model) {
		List<NoticeVO> list = noticeService.getList();
		model.addAttribute("list",list);
		return "/admin/noticeAdmin";
	}
	

	//공지사항 글쓰기 페이지로 이동 
	@RequestMapping(value = "/admin/noticeInsert", method = RequestMethod.GET)
	public String noticeInsertFrom(Locale locale, Model model) {
		return "/admin/noticeInsert";
	}
	
	//공지사항 등록해주는 메서드
	@RequestMapping(value = "/admin/noticeInsert", method = RequestMethod.POST)
	//HttpServletRequest jsp에서 넘어오는 값을 받아주는 객체
	public String noticeInsertService(HttpServletRequest request){
		int r = noticeService.insertNotice(request);// jsp값을 그대로 바로 넘겨준다. 
		if(r>0){ //등록에 성공 했을때 
			//return "notice";
			System.out.println("성공");
			return "redirect:/admin/noticeAdmin";//list.jsp작성 전이기 떄문에 일단 입시로 test용으로 
		}else {// 등록이 실패했경우
			return "redirect:/admin/noticeAdmin";
		}
	}
	
	//공지 사항 상세 보기
	@RequestMapping(value = "/admin/contentAdmin", method = RequestMethod.GET)
	public String contentAdmin(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "/admin/contentAdmin";
	}
	
	
	//공지사항 삭제 하기
	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String deleteNotice(@RequestParam("no")int no, Model model){
		int r = noticeService.deletenotice(no);// jsp값을 그대로 바로 넘겨준다. 
		if(r>0){ //등록에 성공 했을때 
			//return "notice";
			return "redirect:/admin/noticeAdmin";//list.jsp작성 전이기 떄문에 일단 입시로 test용으로 
		}else {// 등록이 실패했경우
			return "redirect:/admin/noticeAdmin";
		}
	}

	
	//공지 사항 수정 보기
	@RequestMapping(value = "/admin/noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "/admin/noticeUpdate";
	}
	
	//공지 사항 수정 하기
	@RequestMapping(value = "/admin/noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdateService(HttpServletRequest request, Model model){
		int r = noticeService.updateNotice(request);
			
		if(r>0){// 주성성공시 
			System.out.println("성공");
			return "redirect:/admin/noticeAdmin";
		}else {
			return "redirect:/admin/noticeAdmin";
		}
	}
	
	
	//----------------
	//견전문의 
	//----------------
	//noticeAdmin 페이지겸 list목록 보여주는 것
	@RequestMapping(value = "/admin/contactus.html", method = RequestMethod.GET)
	public String contactAdmin(Locale locale, Model model) {
		List<ContactusVO> list = contactusService.getList();
		model.addAttribute("list",list);
		return "/admin/contactusAdmin";
	}
	
	//견적 문의 삭제
	@RequestMapping(value = "/admin/contactusDelete", method = RequestMethod.GET)
	public String contactusDelete(@RequestParam("num") int num , RedirectAttributes addr) {
		int r = contactusService.deleteContactus(num);
		
		if(r>0){// 삭제 성공시
			addr.addFlashAttribute("msg", "견적 문의를 삭제 하였습니다. ");
			return "redirect:/admin/contactus.html";
		}else {
			return "redirect:/admin/contactus.html";
		}
	}
	
	//견적 문의 보기
	@RequestMapping(value = "/admin/contactusContentAdmin", method = RequestMethod.GET)
	public String contactusContentAdmin(@RequestParam("num")int num, Model model){
		ContactusVO contactusVO = contactusService.selectContactus(num);
		model.addAttribute("contactusVO", contactusVO);
		return "/admin/contactusContentAdmin";
	}
	
	
	
}
