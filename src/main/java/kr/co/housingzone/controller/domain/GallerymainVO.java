package kr.co.housingzone.controller.domain;


// 갤러리 메인 정보VO 
public class GallerymainVO {

	private int num;
	private String subject;
	private String writer;
	private String mainfilename;
	private String regdate;

	@Override
	public String toString() {
		return "gallerymainVO [num=" + num + ", subject=" + subject + ", writer=" + writer + ", mainfilename="
				+ mainfilename + ", regdate=" + regdate + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMainfilename() {
		return mainfilename;
	}

	public void setMainfilename(String mainfilename) {
		this.mainfilename = mainfilename;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
