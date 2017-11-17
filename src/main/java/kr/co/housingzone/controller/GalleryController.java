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
		//-------- 그거 갤러리 테스트 
		
		//관리자 갤러리 첫 메인 페이지로 이동 (갤러리 화면 들이 뜸)
		@RequestMapping(value = "/admin/galleryAdmin", method = RequestMethod.GET)
		public String galleryAdmin(Model model){
			
			// 갤러리 리스트 가져 오기 
			List<GallerymainVO> galleryList = galleryService.getGalleryList();
			
			// 리스트를 jsp 에 보내줌
			model.addAttribute("galleryList", galleryList);
			return "/admin/galleryAdmin";
		}
		
		//관리자 갤러리 추가 페이지도 이동
		@RequestMapping(value = "/admin/galleryInsertAdmin", method = RequestMethod.GET)
		public String galleryInsertAdmin(){
			return "/admin/galleryInsertAdmin";
		}
		
		// 갤러기가 추가 가되면 MultipartHttpServletRequest request 이걸러 그대로 넘겨 주기 
		@RequestMapping(value = "/admin/galleryInsertAdmin", method = RequestMethod.POST)
		public String insertMainGallery(MultipartHttpServletRequest request,RedirectAttributes attr){
			//MultipartHttpServletRequest request2 = request;
			int rMain = galleryService.insertMainGallery(request);
			if(rMain>0){// 메인 성공
			 int num = galleryService.selectMainNum();
				System.out.println(num);
				int rPlan = galleryService.insertPlanGallery(request, num);
				System.out.println(rPlan);
				int rDetail = galleryService.insertDetailGallery(request, num); 
				System.out.println(rDetail);
				
				attr.addFlashAttribute("msg", "새로운 글이 등록 되었습니다. ");
				return "redirect:galleryAdmin";
			}else{//메인 실패
				System.out.println("실패");
				attr.addFlashAttribute("msg","이미지형식은jpg,tiff,psd,png,bmp,gif만 가능합니다.");
				return "redirect:/admin/galleryInsertAdmin";
			}
		}
		//관지라 갤러리 상세 보기 페이지로 이동
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
		
		//메인 삭제 하기 
		@RequestMapping(value ="/admin/galleryMainDelete" , method = RequestMethod.GET)
		public String galleryMainDelete(@RequestParam("num")int num, RedirectAttributes attr,HttpServletRequest request){
			System.out.println(num);
			int r = galleryService.deleteMainGallery(num,request);
			if(r>0){// 성공
				attr.addFlashAttribute("msg", "게시물 삭제를 성공 하였습니다.");
				return "redirect:galleryAdmin";//삭제 성공시 
			}else{
				attr.addFlashAttribute("msg", "삭제를 실패 했습니다.");
				return "redirect:galleryAdmin";//삭제 성공시 
			}
		}
		//갤러리 평면도 삭제 하기 
		@RequestMapping(value ="/admin/galleryPlanDelete" , method = RequestMethod.GET)
		public String galleryPlanDelete(@RequestParam("no")int no, RedirectAttributes attr,HttpServletRequest request){
			String num = request.getParameter("num");
			System.out.println(no);
			int r = galleryService.deletePlanGallery(no,request);
			if(r>0){// 성공
				attr.addFlashAttribute("msg", "평면도 삭제를 성공 하였습니다.");
				return "redirect:galleryContentAdmin?num="+num;//삭제 성공시 
			}else{
				attr.addFlashAttribute("msg", "삭제를 실패 했습니다.");
				return "redirect:galleryContentAdmin?num="+num;//삭제 성공시 
			}
		}
		
		//갤러리 상세정보 삭제 하기 
		@RequestMapping(value ="/admin/galleryDetailDelete" , method = RequestMethod.GET)
		public String galleryDetailDelete(@RequestParam("no")int no, RedirectAttributes attr,HttpServletRequest request){
			String num = request.getParameter("num");
			System.out.println(no);
			
			int r = galleryService.deleteDetailGallery(no,request);
			
			if(r>0){// 성공
				attr.addFlashAttribute("msg", "게시물 삭제를 성공 하였습니다.");
				return "redirect:galleryContentAdmin?num="+num;//삭제 성공시 
			}else{
				attr.addFlashAttribute("msg", "삭게를 실패 했습니다.");
				return "redirect:galleryContentAdmin?num="+num;//삭제 성공시 
			}
		}
		

		

	
	
	
}
