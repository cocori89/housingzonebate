package kr.co.housingzone.controller.domain;

// °¶·¯¸® Æï¸íµµ VO
public class GalleryplanVO {
	private int no;
	private int num;
	private String planfilename;

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

	public String getPlanfilename() {
		return planfilename;
	}

	public void setPlanfilename(String planfilename) {
		this.planfilename = planfilename;
	}

	@Override
	public String toString() {
		return "galleryplanVO [num=" + num + ", planfilename=" + planfilename + "]";
	}

}
