package kr.co.housingzone.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;
import kr.co.housingzone.controller.domain.NoticeVO;
import kr.co.housingzone.service.ContactusService;
import kr.co.housingzone.service.GalleryService;
import kr.co.housingzone.service.NoticeService;


//어노테이션을 사용 해서 클래스를 컨트롤러 클래스로 만들어 준다. 자동으로 생성되게 해준다. 
// 이러한 컨트롤러로써 작용 할수 있도록 설정해주는 곳은 xml 파일 들에서 미리 설정해주었다. 
//servlet-context.xml에서 특히 어노테이션을 사용 할수 있도록 하였다.
@Controller
public class HousingController {
	
	@Autowired
	private NoticeService noticeService; // 같은 클래스가 있다면 자동으로 연결해준다. 
	
	@Autowired
	private ContactusService contactusService;
	
	@Autowired
	private GalleryService galleryService;
	
	
	// 메인 화면 메서드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}
	
	//notice.jsp 페이지겸 list목록 보여주는 것
	@RequestMapping(value = "board.html", method = RequestMethod.GET)
	public String noticeFrom(Locale locale, Model model) {
		
		List<NoticeVO> list = noticeService.getList();
		
		model.addAttribute("list",list);
		
		return "notice";
	}
	
	//공지 사항 상세 보기
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String noticeContent(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "content";
	}

	//about 페이지 이동
	@RequestMapping(value = "about.html", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		return "about";
	}
	
	//band 페이지 이동
	@RequestMapping(value = "band.html", method = RequestMethod.GET)
	public String band(Locale locale, Model model) {
		return "band";
	}
	
	// content페이지 이동
	@RequestMapping(value = "content.html", method = RequestMethod.GET)
	public String content(Locale locale, Model model) {
		return "content";
	}
	
	// content페이지 이동
	@RequestMapping(value = "contactus.html", method = RequestMethod.GET)
	public String contactus(Locale locale, Model model) {
		return "contactus";
	}
	
	//gallery 페이지 이동
	@RequestMapping(value = "gallery.html", method = RequestMethod.GET)
	public String gallery(Model model){

		// 갤러리 리스트 가져 오기 
		List<GallerymainVO> galleryList = galleryService.getGalleryList();
		
		// 리스트를 jsp 에 보내줌
		model.addAttribute("galleryList", galleryList);
		return "gallery";
	}
	
	// 클라이언트 상세 페이지로 이동
	@RequestMapping(value = "galleryContent", method = RequestMethod.GET)
	public String galleryContent(@RequestParam("num")int num, Model model ){
		
		GallerymainVO gallerymainVO = galleryService.getGalleryInfo(num);
		List<GalleryplanVO> planList = galleryService.selectPlanGallery(num);
		List<GallerydetailVO> detailList = galleryService.selectDetailGallery(num);
		
		model.addAttribute("planList", planList);
		model.addAttribute("detailList", detailList);
		model.addAttribute("num", num);
		model.addAttribute("subject", gallerymainVO.getSubject());
		model.addAttribute("regdate", gallerymainVO.getRegdate());
		return "galleryContent";
	}
	
	
	// service 페이지 이동
	@RequestMapping(value = "service.html", method = RequestMethod.GET)
	public String service(Locale locale, Model model) {
		return "service";
	}
	
	// index 페이지 이동
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public String indexhtml(Locale locale, Model model) {
		return "index";
	}
	
	// index 페이지 이동
		@RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
		public String admin(Locale locale, Model model) {
			return "/admin/admin";
		}
	
		
		//고객의 견적 문의 
		@RequestMapping(value = "contactus", method = RequestMethod.POST)
		public String contactusInsert(HttpServletRequest request, RedirectAttributes attr) {
			int r = contactusService.insertContactus(request);
			
			if(r>0){
				attr.addFlashAttribute("msg","성공적으로 전송 되었습니다. ");//입력 성공시
				return "redirect:contactus.html";
			}else{
				attr.addFlashAttribute("msg","시스템 전송에 오류가 있습니다. 연락처로 전화 주시기 바랍니다.");//입력 실패시
				return "redirect:contactus.html";
			}
		}
	
	
}
