package vo;

import java.sql.Date;

public class MemberVO {
	
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private Date mem_birth;
	private String mem_mail;
	private String mem_phone;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_auth;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setmem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_auth() {
		return mem_auth;
	}
	public void setMem_auth(String mem_auth) {
		this.mem_auth = mem_auth;
	}
	
	public MemberVO() {}
	
	public MemberVO(String mem_id, String mem_pw, String mem_name, Date mem_birth, String mail, String mem_phone,
			String mem_addr1, String mem_addr2, String mem_auth) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_birth = mem_birth;
		this.mem_mail = mail;
		this.mem_phone = mem_phone;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_auth = mem_auth;
	}
	
	public MemberVO(String mem_pw, String mem_name, Date mem_birth, String mail, String mem_phone,
			String mem_addr1, String mem_addr2, String mem_auth) {
		super();
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_birth = mem_birth;
		this.mem_mail = mail;
		this.mem_phone = mem_phone;
		this.mem_addr1 = mem_addr1;
		this.mem_addr2 = mem_addr2;
		this.mem_auth = mem_auth;
	}
	
}
