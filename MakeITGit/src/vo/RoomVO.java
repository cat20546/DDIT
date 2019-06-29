package vo;

public class RoomVO {
	private int room_id;
	private String room_name;
	private String room_type;
	private String room_addr1;
	private String room_addr2;
	private String room_transaction;
	private String room_comment;
	private int room_size;
	private int room_floor;
	private String room_heating_system;
	private int room_available;
	private int room_price;
	private int room_deposit;
	private int opt_airconditioner;
	private int opt_washer;
	private int opt_bed;
	private int opt_desk;
	private int opt_closet;
	private int opt_tv;
	private int opt_refregerator;
	private int opt_stove;
	private int opt_pet_availabillity;
	private int opt_parking_lot;
	private int opt_veranda;
	private int opt_lease_fund;
	//추가
	private int room_my_floor;
	//
	private String mem_id;
	
	
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getRoom_addr1() {
		return room_addr1;
	}
	public void setRoom_addr1(String room_addr1) {
		this.room_addr1 = room_addr1;
	}
	public String getRoom_addr2() {
		return room_addr2;
	}
	public void setRoom_addr2(String room_addr2) {
		this.room_addr2 = room_addr2;
	}
	public String getRoom_transaction() {
		return room_transaction;
	}
	public void setRoom_transaction(String room_transaction) {
		this.room_transaction = room_transaction;
	}
	public String getRoom_comment() {
		return room_comment;
	}
	public void setRoom_comment(String room_comment) {
		this.room_comment = room_comment;
	}
	public int getRoom_size() {
		return room_size;
	}
	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}
	public int getRoom_floor() {
		return room_floor;
	}
	public void setRoom_floor(int room_floor) {
		this.room_floor = room_floor;
	}
	public String getRoom_heating_system() {
		return room_heating_system;
	}
	public void setRoom_heating_system(String room_heating_system) {
		this.room_heating_system = room_heating_system;
	}
	public int getRoom_available() {
		return room_available;
	}
	public void setRoom_available(int room_available) {
		this.room_available = room_available;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public int getRoom_deposit() {
		return room_deposit;
	}
	public void setRoom_deposit(int room_deposit) {
		this.room_deposit = room_deposit;
	}
	public int getOpt_airconditioner() {
		return opt_airconditioner;
	}
	public void setOpt_airconditioner(int opt_airconditioner) {
		this.opt_airconditioner = opt_airconditioner;
	}
	public int getOpt_washer() {
		return opt_washer;
	}
	public void setOpt_washer(int opt_washer) {
		this.opt_washer = opt_washer;
	}
	public int getOpt_bed() {
		return opt_bed;
	}
	public void setOpt_bed(int opt_bed) {
		this.opt_bed = opt_bed;
	}
	public int getOpt_desk() {
		return opt_desk;
	}
	public void setOpt_desk(int opt_desk) {
		this.opt_desk = opt_desk;
	}
	public int getOpt_closet() {
		return opt_closet;
	}
	public void setOpt_closet(int opt_closet) {
		this.opt_closet = opt_closet;
	}
	public int getOpt_tv() {
		return opt_tv;
	}
	public void setOpt_tv(int opt_tv) {
		this.opt_tv = opt_tv;
	}
	public int getOpt_refregerator() {
		return opt_refregerator;
	}
	public void setOpt_refregerator(int opt_refregerator) {
		this.opt_refregerator = opt_refregerator;
	}
	public int getOpt_stove() {
		return opt_stove;
	}
	public void setOpt_stove(int opt_stove) {
		this.opt_stove = opt_stove;
	}
	public int getOpt_pet_availabillity() {
		return opt_pet_availabillity;
	}
	public void setOpt_pet_availabillity(int opt_pet_availabillity) {
		this.opt_pet_availabillity = opt_pet_availabillity;
	}
	public int getOpt_parking_lot() {
		return opt_parking_lot;
	}
	public void setOpt_parking_lot(int opt_parking_lot) {
		this.opt_parking_lot = opt_parking_lot;
	}
	public int getOpt_veranda() {
		return opt_veranda;
	}
	public void setOpt_veranda(int opt_veranda) {
		this.opt_veranda = opt_veranda;
	}
	public int getOpt_lease_fund() {
		return opt_lease_fund;
	}
	public void setOpt_lease_fund(int opt_lease_fund) {
		this.opt_lease_fund = opt_lease_fund;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getRoom_my_floor() {
		return room_my_floor;
	}
	public void setRoom_my_floor(int room_my_floor) {
		this.room_my_floor = room_my_floor;
	}
	
	
	@Override
	public String toString() {
		return "RoomVO [room_id=" + room_id + ", room_name=" + room_name + ", room_type=" + room_type + ", room_addr1="
				+ room_addr1 + ", room_addr2=" + room_addr2 + ", room_transaction=" + room_transaction
				+ ", room_comment=" + room_comment + ", room_size=" + room_size + ", room_floor=" + room_floor
				+ ", room_heating_system=" + room_heating_system + ", room_available=" + room_available
				+ ", room_price=" + room_price + ", room_deposit=" + room_deposit + ", opt_airconditioner="
				+ opt_airconditioner + ", opt_washer=" + opt_washer + ", opt_bed=" + opt_bed + ", opt_desk=" + opt_desk
				+ ", opt_closet=" + opt_closet + ", opt_tv=" + opt_tv + ", opt_refregerator=" + opt_refregerator
				+ ", opt_stove=" + opt_stove + ", opt_pet_availabillity=" + opt_pet_availabillity + ", opt_parking_lot="
				+ opt_parking_lot + ", opt_veranda=" + opt_veranda + ", opt_lease_fund=" + opt_lease_fund
				+ ", room_my_floor=" + room_my_floor + ", mem_id=" + mem_id + "]";
	}


	
	
	
	
	
	
	
}
