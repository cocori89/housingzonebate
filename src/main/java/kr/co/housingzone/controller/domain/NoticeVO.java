package kr.co.housingzone.controller.domain;

// �Խ��ǿ� �ʿ��� DTO �� �����. 
public class NoticeVO {

	private String no;// �۹�ȣ
	private String subject; // ������
	private String content;// �۳���
	private String writer; // �۾���
	private String regdate;// �۾� ��¥
	private String ip;// �۾� ��� ������

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", ip=" + ip + "]";
	}

}
