package kr.co.housingzone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.housingzone.controller.domain.NoticeVO;

//이러면 DAO객체 역할을 하는 어노테이션이다. 그리고 서버 구동시 자동으로 만들어 질수 있도록 한다 .
@Repository//단어뜻은 저장소!
public class NoticeDaoImpl implements NoticeDao {

	//@Autowired은 SqlSession 클래스와 같은 종류의 객체가 있으면 이어준다. 
	@Autowired//단어뜻은 자동연결되어진 정도의 뜻이다.
	private SqlSession sqlSession; //notice.xml에서 만든 sql문을 사용 하기 위함이다. 
	// notice.xml파일의 경우 root-context.xml 에서 빈등록 되어 있다.
	
	// 공지사항 등록 하는 Dao 메서드 
	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return sqlSession.insert("notice.insertNotice",noticeVO);
	}

	@Override
	public List<NoticeVO> getList() {
		return sqlSession.selectList("notice.selectList");
	}

	@Override
	public NoticeVO getContent(int no) {
		return sqlSession.selectOne("notice.selectContent",no);
	}

	@Override
	public int deletenotice(int no) {
		return sqlSession.delete("notice.deleteNotice", no);
	}

	@Override
	public int updateNotice(NoticeVO noticeVO) {
		return sqlSession.update("notice.updateNotice",noticeVO);
	}
}
