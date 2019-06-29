package vo;

import java.sql.Date;

public class ApartmentVO {
	private int apt_id;
	private String apt_name;
	private String apt_build_type;
	private String apt_supply_type;
	private String apt_addr1;
	private String apt_addr2;
	private int apt_price;
	private Date apt_start_date;
	private Date apt_end_date;
	private int apt_size;
	private int household_number;
	private String apt_construction_company;
	private String apt_developer;
	private int apt_floor;
	public int getApt_id() {
		return apt_id;
	}
	public void setApt_id(int apt_id) {
		this.apt_id = apt_id;
	}
	public String getApt_name() {
		return apt_name;
	}
	public void setApt_name(String apt_name) {
		this.apt_name = apt_name;
	}
	public String getApt_build_type() {
		return apt_build_type;
	}
	public void setApt_build_type(String apt_build_type) {
		this.apt_build_type = apt_build_type;
	}
	public String getApt_supply_type() {
		return apt_supply_type;
	}
	public void setApt_supply_type(String apt_supply_type) {
		this.apt_supply_type = apt_supply_type;
	}
	public String getApt_addr1() {
		return apt_addr1;
	}
	public void setApt_addr1(String apt_addr1) {
		this.apt_addr1 = apt_addr1;
	}
	public String getApt_addr2() {
		return apt_addr2;
	}
	public void setApt_addr2(String apt_addr2) {
		this.apt_addr2 = apt_addr2;
	}
	public int getApt_price() {
		return apt_price;
	}
	public void setApt_price(int apt_price) {
		this.apt_price = apt_price;
	}
	public Date getApt_start_date() {
		return apt_start_date;
	}
	public void setApt_start_date(Date apt_start_date) {
		this.apt_start_date = apt_start_date;
	}
	public Date getApt_end_date() {
		return apt_end_date;
	}
	public void setApt_end_date(Date apt_end_date) {
		this.apt_end_date = apt_end_date;
	}
	public int getApt_size() {
		return apt_size;
	}
	public void setApt_size(int apt_size) {
		this.apt_size = apt_size;
	}
	public int getHousehold_number() {
		return household_number;
	}
	public void setHousehold_number(int household_number) {
		this.household_number = household_number;
	}
	public String getApt_construction_company() {
		return apt_construction_company;
	}
	public void setApt_construction_company(String apt_construction_company) {
		this.apt_construction_company = apt_construction_company;
	}
	public String getApt_developer() {
		return apt_developer;
	}
	public void setApt_developer(String apt_developer) {
		this.apt_developer = apt_developer;
	}
	public int getApt_floor() {
		return apt_floor;
	}
	public void setApt_floor(int apt_floor) {
		this.apt_floor = apt_floor;
	}
	
}
