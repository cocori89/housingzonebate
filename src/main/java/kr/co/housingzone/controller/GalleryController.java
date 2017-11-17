package kr.co.housingzone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;
import kr.co.housingzone.service.GalleryService;

@Controller
public class GalleryController {

	
	@Autowired
	private GalleryService galleryService;

	
	//--------------------------------- test
		//-------- �װ� ������ �׽�Ʈ 
		
		//������ ������ ù ���� �������� �̵� (������ ȭ�� ���� ��)
		@RequestMapping(value = "/admin/galleryAdmin", method = RequestMethod.GET)
		public String galleryAdmin(Model model){
			
			// ������ ����Ʈ ���� ���� 
			List<GallerymainVO> galleryList = galleryService.getGalleryList();
			
			// ����Ʈ�� jsp �� ������
			model.addAttribute("galleryList", galleryList);
			return "/admin/galleryAdmin";
		}
		
		//������ ������ �߰� �������� �̵�
		@RequestMapping(value = "/admin/galleryInsertAdmin", method = RequestMethod.GET)
		public String galleryInsertAdmin(){
			return "/admin/galleryInsertAdmin";
		}
		
		// �����Ⱑ �߰� ���Ǹ� MultipartHttpServletRequest request �̰ɷ� �״�� �Ѱ� �ֱ� 
		@RequestMapping(value = "/admin/galleryInsertAdmin", method = RequestMethod.POST)
		public String insertMainGallery(MultipartHttpServletRequest request,RedirectAttributes attr){
			//MultipartHttpServletRequest request2 = request;
			int rMain = galleryService.insertMainGallery(request);
			if(rMain>0){// ���� ����
			 int num = galleryService.selectMainNum();
				System.out.println(num);
				int rPlan = galleryService.insertPlanGallery(request, num);
				System.out.println(rPlan);
				int rDetail = galleryService.insertDetailGallery(request, num); 
				System.out.println(rDetail);
				
				attr.addFlashAttribute("msg", "���ο� ���� ��� �Ǿ����ϴ�. ");
				return "redirect:galleryAdmin";
			}else{//���� ����
				System.out.println("����");
				attr.addFlashAttribute("msg","�̹���������jpg,tiff,psd,png,bmp,gif�� �����մϴ�.");
				return "redirect:/admin/galleryInsertAdmin";
			}
		}
		//������ ������ �� ���� �������� �̵�
		@RequestMapping(value = "/admin/galleryContentAdmin", method = RequestMethod.GET)
		public String galleryContentAdmin(@RequestParam("num")int num, Model model ){
			
			GallerymainVO gallerymainVO = galleryService.getGalleryInfo(num);
			List<GalleryplanVO> planList = galleryService.selectPlanGallery(num);
			List<GallerydetailVO> detailList = galleryService.selectDetailGallery(num);
			
			model.addAttribute("planList", planList);
			model.addAttribute("detailList", detailList);
			model.addAttribute("num", num);
			model.addAttribute("subject", gallerymainVO.getSubject());
			model.addAttribute("regdate", gallerymainVO.getRegdate());
			
			return "/admin/galleryContentAdmin";
		}
		
		//���� ���� �ϱ� 
		@RequestMapping(value ="/admin/galleryMainDelete" , method = RequestMethod.GET)
		public String galleryMainDelete(@RequestParam("num")int num, RedirectAttributes attr,HttpServletRequest request){
			System.out.println(num);
			int r = galleryService.deleteMainGallery(num,request);
			if(r>0){// ����
				attr.addFlashAttribute("msg", "�Խù� ������ ���� �Ͽ����ϴ�.");
				return "redirect:galleryAdmin";//���� ������ 
			}else{
				attr.addFlashAttribute("msg", "������ ���� �߽��ϴ�.");
				return "redirect:galleryAdmin";//���� ������ 
			}
		}
		//������ ��鵵 ���� �ϱ� 
		@RequestMapping(value ="/admin/galleryPlanDelete" , method = RequestMethod.GET)
		public String galleryPlanDelete(@RequestParam("no")int no, RedirectAttributes attr,HttpServletRequest request){
			String num = request.getParameter("num");
			System.out.println(no);
			int r = galleryService.deletePlanGallery(no,request);
			if(r>0){// ����
				attr.addFlashAttribute("msg", "��鵵 ������ ���� �Ͽ����ϴ�.");
				return "redirect:galleryContentAdmin?num="+num;//���� ������ 
			}else{
				attr.addFlashAttribute("msg", "������ ���� �߽��ϴ�.");
				return "redirect:galleryContentAdmin?num="+num;//���� ������ 
			}
		}
		
		//������ ������ ���� �ϱ� 
		@RequestMapping(value ="/admin/galleryDetailDelete" , method = RequestMethod.GET)
		public String galleryDetailDelete(@RequestParam("no")int no, RedirectAttributes attr,HttpServletRequest request){
			String num = request.getParameter("num");
			System.out.println(no);
			
			int r = galleryService.deleteDetailGallery(no,request);
			
			if(r>0){// ����
				attr.addFlashAttribute("msg", "�Խù� ������ ���� �Ͽ����ϴ�.");
				return "redirect:galleryContentAdmin?num="+num;//���� ������ 
			}else{
				attr.addFlashAttribute("msg", "��Ը� ���� �߽��ϴ�.");
				return "redirect:galleryContentAdmin?num="+num;//���� ������ 
			}
		}
		

		

	
	
	
}
