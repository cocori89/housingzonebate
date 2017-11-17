package kr.co.housingzone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.housingzone.controller.domain.NoticeVO;

//�̷��� DAO��ü ������ �ϴ� ������̼��̴�. �׸��� ���� ������ �ڵ����� ����� ���� �ֵ��� �Ѵ� .
@Repository//�ܾ���� �����!
public class NoticeDaoImpl implements NoticeDao {

	//@Autowired�� SqlSession Ŭ������ ���� ������ ��ü�� ������ �̾��ش�. 
	@Autowired//�ܾ���� �ڵ�����Ǿ��� ������ ���̴�.
	private SqlSession sqlSession; //notice.xml���� ���� sql���� ��� �ϱ� �����̴�. 
	// notice.xml������ ��� root-context.xml ���� ���� �Ǿ� �ִ�.
	
	// �������� ��� �ϴ� Dao �޼��� 
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
