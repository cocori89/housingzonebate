package kr.co.housingzone.controller.domain;

//갤러리  진행 정보 사진 VO
public class GallerydetailVO {

	private int no;
	private int num;
	private String detailfilename;

	@Override
	public String toString() {
		return "GallerydetailVO [no=" + no + ", num=" + num + ", detailfilename=" + detailfilename + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDetailfilename() {
		return detailfilename;
	}

	public void setDetailfilename(String detailfilename) {
		this.detailfilename = detailfilename;
	}

}
