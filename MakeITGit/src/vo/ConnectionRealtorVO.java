package vo;

import java.sql.Date;

public class ConnectionRealtorVO {
	private int conn_id;
	private Date conn_date;
	private int realtor_id;
	private int reg_id;
	public int getConn_id() {
		return conn_id;
	}
	public void setConn_id(int conn_id) {
		this.conn_id = conn_id;
	}
	public Date getConn_date() {
		return conn_date;
	}
	public void setConn_date(Date conn_date) {
		this.conn_date = conn_date;
	}
	public int getRealtor_id() {
		return realtor_id;
	}
	public void setRealtor_id(int realtor_id) {
		this.realtor_id = realtor_id;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	
}
