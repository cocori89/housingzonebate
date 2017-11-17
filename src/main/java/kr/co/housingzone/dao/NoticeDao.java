package kr.co.housingzone.dao;

import java.util.List;

import kr.co.housingzone.controller.domain.NoticeVO;

//DAO 객체를 구현하기전에 미리 인터페이스를 만들어준다. 
public interface NoticeDao {
	
	//여기서 int 값을 리턴을 받는 이유는 insert가 정상정으로 sql문이 성공 여부를 알기 위해서 이다. 
	//그렇지 않으면 나중에 실제로 값이 안들어 갔을 때에 알수가 없다. 
	//때문에 int 값으로 리턴해서 판단을 한다. 양수이면 성공!!
	public int insertNotice(NoticeVO noticeVO);//공지사항 등록 DAO 선언
	
	public List<NoticeVO> getList();//공지사항의 리스트를 받아오는것
	
	public NoticeVO getContent(int no);//공지사항 상세정보 얻어오기 
	
	public int deletenotice(int no);//반환값으로 int 가 와야지 성공여부를 알수 있다. 

	public int updateNotice(NoticeVO noticeVO);//공지사항 수정 DAO 선언
}
