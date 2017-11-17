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


//������̼��� ��� �ؼ� Ŭ������ ��Ʈ�ѷ� Ŭ������ ����� �ش�. �ڵ����� �����ǰ� ���ش�. 
// �̷��� ��Ʈ�ѷ��ν� �ۿ� �Ҽ� �ֵ��� �������ִ� ���� xml ���� �鿡�� �̸� �������־���. 
//servlet-context.xml���� Ư�� ������̼��� ��� �Ҽ� �ֵ��� �Ͽ���.
@Controller
public class HousingController {
	
	@Autowired
	private NoticeService noticeService; // ���� Ŭ������ �ִٸ� �ڵ����� �������ش�. 
	
	@Autowired
	private ContactusService contactusService;
	
	@Autowired
	private GalleryService galleryService;
	
	
	// ���� ȭ�� �޼���
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}
	
	//notice.jsp �������� list��� �����ִ� ��
	@RequestMapping(value = "board.html", method = RequestMethod.GET)
	public String noticeFrom(Locale locale, Model model) {
		
		List<NoticeVO> list = noticeService.getList();
		
		model.addAttribute("list",list);
		
		return "notice";
	}
	
	//���� ���� �� ����
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String noticeContent(@RequestParam("no")int no, Model model){
		NoticeVO noticeVO = noticeService.getContent(no);
		model.addAttribute("notice", noticeVO);
		return "content";
	}

	//about ������ �̵�
	@RequestMapping(value = "about.html", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		return "about";
	}
	
	//band ������ �̵�
	@RequestMapping(value = "band.html", method = RequestMethod.GET)
	public String band(Locale locale, Model model) {
		return "band";
	}
	
	// content������ �̵�
	@RequestMapping(value = "content.html", method = RequestMethod.GET)
	public String content(Locale locale, Model model) {
		return "content";
	}
	
	// content������ �̵�
	@RequestMapping(value = "contactus.html", method = RequestMethod.GET)
	public String contactus(Locale locale, Model model) {
		return "contactus";
	}
	
	//gallery ������ �̵�
	@RequestMapping(value = "gallery.html", method = RequestMethod.GET)
	public String gallery(Model model){

		// ������ ����Ʈ ���� ���� 
		List<GallerymainVO> galleryList = galleryService.getGalleryList();
		
		// ����Ʈ�� jsp �� ������
		model.addAttribute("galleryList", galleryList);
		return "gallery";
	}
	
	// Ŭ���̾�Ʈ �� �������� �̵�
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
	
	
	// service ������ �̵�
	@RequestMapping(value = "service.html", method = RequestMethod.GET)
	public String service(Locale locale, Model model) {
		return "service";
	}
	
	// index ������ �̵�
	@RequestMapping(value = "index.html", method = RequestMethod.GET)
	public String indexhtml(Locale locale, Model model) {
		return "index";
	}
	
	// index ������ �̵�
		@RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
		public String admin(Locale locale, Model model) {
			return "/admin/admin";
		}
	
		
		//���� ���� ���� 
		@RequestMapping(value = "contactus", method = RequestMethod.POST)
		public String contactusInsert(HttpServletRequest request, RedirectAttributes attr) {
			int r = contactusService.insertContactus(request);
			
			if(r>0){
				attr.addFlashAttribute("msg","���������� ���� �Ǿ����ϴ�. ");//�Է� ������
				return "redirect:contactus.html";
			}else{
				attr.addFlashAttribute("msg","�ý��� ���ۿ� ������ �ֽ��ϴ�. ����ó�� ��ȭ �ֽñ� �ٶ��ϴ�.");//�Է� ���н�
				return "redirect:contactus.html";
			}
		}
	
	
}
