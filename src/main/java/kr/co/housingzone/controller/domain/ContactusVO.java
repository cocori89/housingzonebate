package kr.co.housingzone.controller.domain;

public class ContactusVO {
	private String num;
	private String name;
	private String email;
	private String title;
	private String content;
	private String regdate;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ContactusVO [num=" + num + ", name=" + name + ", email=" + email + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + "]";
	}

}
