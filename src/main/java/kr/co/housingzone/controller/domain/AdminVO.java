package kr.co.housingzone.controller.domain;

//������ �α����� ���� DTO
public class AdminVO {
	private String id; // ���̵� 
	private String password;//��ȣ
	private String addr; // ���� �ּ�
	private String num1; // ����ó1 
	private String num2; // ����ó 2
	private String email; // �̸���
	private String kakao; // īī��

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
