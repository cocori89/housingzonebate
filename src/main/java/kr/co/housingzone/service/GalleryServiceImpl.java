package kr.co.housingzone.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;
import kr.co.housingzone.dao.GalleryDao;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	GalleryDao galleryDao;
	//-------------------
	// 갤러리 메인 사진 등록 (단일 서비스)
	@Override
	public int insertMainGallery(MultipartHttpServletRequest request) {
		GallerymainVO gallerymainVO = new GallerymainVO();
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		// 밑에서 오리지날파일 메서드로 받아 들임
		String mainfilename;
		String fileExtension; //파일 확장자 담을 변수 
		
		// 파일 받아줄 객체 
		MultipartFile mf = request.getFile("mainfile");
		
		// 업로트 파일 이름 얻기
		mainfilename = mf.getOriginalFilename();
		
		//파일 업로드전 확장자 유효성 체크 ---------- 시작
		//확장자 뽑기
		fileExtension = mainfilename.substring(mainfilename.indexOf(".")+1, mainfilename.length());
		// 확장자 소문자로 바꾸기
		fileExtension = fileExtension.toLowerCase();
		// 파일 확장자가 이미지 인지 아닌지 판단 
		if(fileExtension.equals("jpg")||fileExtension.equals("tiff")||
				fileExtension.equals("psd")||fileExtension.equals("png")||
				fileExtension.equals("bmp")||fileExtension.equals("gif")){
			System.out.println(mainfilename+ "은(는) 정상적인 이미지 파일입니다. ");
		}else {
			System.out.println(mainfilename+ "은(는) 위험성있는 파일 이미지 입니다.  ");
			return -1;
		}
		//파일 업로드전 확장자 유효성 체크 ---------- 끝
		
		
		
		//저장 경로 정하기 
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/main/");
		// 저장 경로 + 파일 이름 
		String saveFile = path+"/"+ mainfilename;
		
		try {
			mf.transferTo(new File(saveFile));
		} catch (Exception e) {
			System.out.println("메인 사진 오류 등록" +  e);
		}
		
		// Dao 에 보낼 이제 DTO 에 담아 준다. 
		gallerymainVO.setSubject(subject);
		gallerymainVO.setWriter(writer);
		gallerymainVO.setMainfilename(mainfilename);
		
		return galleryDao.insertMainGallery(gallerymainVO);
	}

	// 메인 등록 후 들어올 num 메인 값 가져 오기
	@Override
	public int selectMainNum() {
		return galleryDao.selectMainNum();
	}
	
	
	//--------------------
	// 갤러리 평면도 사진 등록 (다중 서비스)int 값이 넘어와야 하기 때문에 메인이 먼저 완료 후에 작성해야함  
	@Override
	public int insertPlanGallery(MultipartHttpServletRequest request, int num) {
		//파일을 받아주는 객체 생성
		List<MultipartFile> fileList = request.getFiles("planfile");
		//확장자 유효성 체크를 위한 변수 생성
		String fileExtension;
		
		// 저장될 파일 경로 얻기 
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/plan/");
		
			for(MultipartFile mf : fileList){
				GalleryplanVO galleryplanVO= new GalleryplanVO();
				// 파일 이름 얻기
				String planfilename = mf.getOriginalFilename();
				//파일 업로드전 확장자 유효성 체크 ---------- 시작
				//확장자 얻기 
				fileExtension = planfilename.substring(planfilename.indexOf('.')+1,planfilename.length());
				//확장자 소문자로 변환
				fileExtension = fileExtension.toLowerCase();
				// 파일 확장자가 이미지 인지 아닌지 판단 
				if(fileExtension.equals("jpg")||fileExtension.equals("tiff")||
						fileExtension.equals("psd")||fileExtension.equals("png")||
						fileExtension.equals("bmp")||fileExtension.equals("gif")){
					System.out.println(planfilename+ "은(는) 정상적인 이미지 파일입니다. ");
				}else {
					System.out.println(planfilename+ "은(는) 위험성있는 파일 이미지 입니다.  ");
					return -1;
				}
				
				
				
				//파일 업로드전 확장자 유효성 체크 ---------- 끝
				
				// 파일 저장 경로 + 파일 이름 
				String saveFilePath = path+"/"+planfilename;
				
				try {
					mf.transferTo(new File(saveFilePath));
				} catch (Exception e) {
					System.out.println("평면도 파일 오류"+e);
				}
				
				// Dao 에 넘겨줄 DTO 값 세팅
				galleryplanVO.setNum(num);
				galleryplanVO.setPlanfilename(planfilename);
				galleryDao.insertPlanGallery(galleryplanVO);
			}
			return 100; // 성공시 100리턴 
	}

	//--------------
	// 갤러리 상세 정보 사진 등록 
	@Override
	public int insertDetailGallery(MultipartHttpServletRequest request, int num) {
		
		// 파일 받아주는 객체 
		List<MultipartFile> fileList = request.getFiles("detailfile");
		//확장자 유효성 체크를 위한 변수 생성
		String fileExtension;
		
		
		//저장 경로 
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/detail/");
		
		System.out.println("1");
		for(MultipartFile mf : fileList){
			GallerydetailVO gallerydetailVO = new GallerydetailVO();
			//저장 이름 
			String detailfilename = mf.getOriginalFilename();
			//파일 업로드전 확장자 유효성 체크 ---------- 시작
			//확장자 얻기 
			fileExtension = detailfilename.substring(detailfilename.indexOf('.')+1,detailfilename.length());
			//확장자 소문자로 변환
			fileExtension = fileExtension.toLowerCase();
			// 파일 확장자가 이미지 인지 아닌지 판단 
			if(fileExtension.equals("jpg")||fileExtension.equals("tiff")||
					fileExtension.equals("psd")||fileExtension.equals("png")||
					fileExtension.equals("bmp")||fileExtension.equals("gif")){
				System.out.println(detailfilename+ "은(는) 정상적인 이미지 파일입니다. ");
			}else {
				System.out.println(detailfilename+ "은(는) 위험성있는 파일 이미지 입니다.  ");
				return -1;
			}
			
			
			
			// 저장경로 + 저장 이름 
			String saveFilePath = path +"/"+ detailfilename;
			System.out.println("2");
			try {
				mf.transferTo(new File(saveFilePath));
			} catch (Exception e) {
				System.out.println("사세정보 사진 오류 " + e);
			}
			
			// Dao 값을 넘겨 줄 값 세팅 
			gallerydetailVO.setNum(num);
			gallerydetailVO.setDetailfilename(detailfilename);
			galleryDao.insertDetailGallery(gallerydetailVO);
		}
		return 200;
	}

	//--------------------------
	//리스트 불러오기 
	@Override
	public List<GallerymainVO> getGalleryList() {
		return galleryDao.getGalleryList();
	}

	
	@Override
	public GallerymainVO getGalleryInfo(int num) {
		return galleryDao.getGalleryInfo(num);
	}
	//리스트 -> 평면도 불러 오기
	@Override
	public List<GalleryplanVO> selectPlanGallery(int num) {
		return galleryDao.selectPlanGallery(num);
	}
	
	//리스트 -> 상세 보기 불러 오기 
	@Override
	public List<GallerydetailVO> selectDetailGallery(int num) {
		return galleryDao.selectDetailGallery(num);
	}

	
	//메인 갤러리 삭제
	@Override
	public int deleteMainGallery(int num, HttpServletRequest request) {
		

		//메인 갤러리 안쪽의 평면도 파일이름들 구하기 
		List<String> planFileNames = galleryDao.deletePlanGalleryFile(num);
		// 메인 갤러리 안쪽의 평면도를 지운다. 
		for(String planFileName : planFileNames){// 불러 온 값들을 다 가져 온다. 
			//경로+파일이름 을 합친다. 
			String planPath = request.getSession().getServletContext().getRealPath("/resources/gallery/plan/"+planFileName);
			// 파일 객체 생성을 한다. 파일을 컨트롤 하기 위해
			File planFile = new File(planPath);
			try {
				//파일을 삭제한다. 
				planFile.delete();
			} catch (Exception e) {
			}
			
		}

		//메인 갤러리 안쪽의 상세 사진 파일 이름들 구하기 
		List<String> detailFileNames = galleryDao.deleteDetailGalleryFile(num);
		// 구한 상세 사진 만큼 다 지운다. 
		for(String detailFileName : detailFileNames){
			// 경로 + 파일 이름
			String detailPath = request.getSession().getServletContext().getRealPath("/resources/gallery/detail/"+detailFileName);
			// 파일을 삭제하기 위한 파일 객체 생성
			File detailFile = new File(detailPath);
			
			try {
				//파일 삭제
				detailFile.delete();
			} catch (Exception e) {
			}
			
		}
		
		// 메인 파일을 마지막에 지워야 갤러리의 평면도나 상세 사진 경로를 구할수 있ㄷ. 
		//파일 이름 얻기 
		String mainFilaName = galleryDao.deleteMainGalleryFile(num);
		
		//파일 삭제를 위한 파일 경로 얻기
		String mianPath = request.getSession().getServletContext().getRealPath("/resources/gallery/main/"+mainFilaName);
		
		//파일 객체를 인지할 객체를 만든다. 
		File mainFile = new File(mianPath);
		try {
			// 파일 을 삭제한다. 
			mainFile.delete();
		} catch (Exception e) {
		}
		
		
		return galleryDao.deleteMainGallery(num);
	}

	//갤러리 평면도 삭제
	@Override
	public int deletePlanGallery(int no,HttpServletRequest request) {
	
		//파일 이름 얻기 
		String filaName = galleryDao.deletePlanGalleryFileSingle(no);
				System.out.println(no);
		//파일 삭제를 위한 파일 경로 얻기
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/plan/"+filaName);
		System.out.println(filaName);
				
		//파일 객체를 인지할 객체를 만든다. 
		File planFile = new File(path);
				
		try {
			// 파일 을 삭제한다. 
			planFile.delete();
		} catch (Exception e) {
		}
		
		return galleryDao.deletePlanGallery(no);
	}

	//갤러리 상세 정보 삭제
	@Override
	public int deleteDetailGallery(int no,HttpServletRequest request) {
		//파일 이름 얻기 
		String filaName = galleryDao.deleteDetailGalleryFileSIngle(no);
		System.out.println(no);
		System.out.println(filaName);
		
		//파일 삭제를 위한 파일 경로 얻기
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/detail/"+filaName);
		
		//파일 객체를 인지할 객체를 만든다. 
		File detailFile = new File(path);
		
		try {
			// 파일 을 삭제한다. 
			detailFile.delete();
		} catch (Exception e) {
		}
		return galleryDao.deleteDetailGallery(no);
	}

	

}

