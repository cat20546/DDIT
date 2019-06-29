package vo;

import java.sql.Date;

public class ChatRoomVO {
	
	private int chat_room_id;
	private String chat_name;
	private String chat_type;
	private Date chat_room_date;
	
	public int getChat_room_id() {
		return chat_room_id;
	}
	public void setChat_room_id(int chat_room_id) {
		this.chat_room_id = chat_room_id;
	}
	public String getChat_name() {
		return chat_name;
	}
	public void setChat_name(String chat_name) {
		this.chat_name = chat_name;
	}
	public String getChat_type() {
		return chat_type;
	}
	public void setChat_type(String chat_type) {
		this.chat_type = chat_type;
	}
	public Date getChat_room_date() {
		return chat_room_date;
	}
	public void setChat_room_date(Date chat_room_date) {
		this.chat_room_date = chat_room_date;
	}
}
