package vo;

import java.sql.Date;

public class BoardVO {
	
	private int board_id;
	private String board_title;
	private String board_content;
	private Date board_date;
	private String board_category;
	private String board_img;
	private String mem_id;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public String getBoard_img() {
		return board_img;
	}
	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public BoardVO(){}
	
	public BoardVO(String board_title, String board_content, Date board_date, String board_category, String board_img,
			String mem_id) {
		super();
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_category = board_category;
		this.board_img = board_img;
		this.mem_id = mem_id;
	}
	
	
}
