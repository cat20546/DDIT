package vo;

import java.sql.Date;

public class WarningVO {
	private int warning_id;
	private String warning_comment;
	private Date warning_date;
	private int realtor_id;
	public int getWarning_id() {
		return warning_id;
	}
	public void setWarning_id(int warning_id) {
		this.warning_id = warning_id;
	}
	public String getWarning_comment() {
		return warning_comment;
	}
	public void setWarning_comment(String warning_comment) {
		this.warning_comment = warning_comment;
	}
	public Date getWarning_date() {
		return warning_date;
	}
	public void setWarning_date(Date warning_date) {
		this.warning_date = warning_date;
	}
	public int getRealtor_id() {
		return realtor_id;
	}
	public void setRealtor_id(int realtor_id) {
		this.realtor_id = realtor_id;
	}
	
}
