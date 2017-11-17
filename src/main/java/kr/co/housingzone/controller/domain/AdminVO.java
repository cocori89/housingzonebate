package kr.co.housingzone.controller.domain;

//관리자 로그인을 위한 DTO
public class AdminVO {
	private String id; // 아이디 
	private String password;//암호
	private String addr; // 업장 주소
	private String num1; // 연락처1 
	private String num2; // 연락처 2
	private String email; // 이메일
	private String kakao; // 카카오

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKakao() {
		return kakao;
	}

	public void setKakao(String kakao) {
		this.kakao = kakao;
	}

	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", password=" + password + ", addr=" + addr + ", num1=" + num1 + ", num2=" + num2
				+ ", email=" + email + ", kakao=" + kakao + "]";
	}

}
