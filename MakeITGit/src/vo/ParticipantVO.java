package vo;

import java.sql.Date;

public class ParticipantVO {
	private int participant_id;
	private Date participant_date;
	private String mem_id;
	private int chat_room_id;
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public Date getParticipant_date() {
		return participant_date;
	}
	public void setParticipant_date(Date participant_date) {
		this.participant_date = participant_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getChat_room_id() {
		return chat_room_id;
	}
	public void setChat_room_id(int chat_room_id) {
		this.chat_room_id = chat_room_id;
	}
	
}
