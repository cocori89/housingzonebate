package kr.co.housingzone.controller.domain;

// 게시판에 필요한 DTO 를 만든다. 
public class NoticeVO {

	private String no;// 글번호
	private String subject; // 글제목
	private String content;// 글내용
	private String writer; // 글쓴이
	private String regdate;// 글쓴 날짜
	private String ip;// 글쓴 사람 아이피

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
