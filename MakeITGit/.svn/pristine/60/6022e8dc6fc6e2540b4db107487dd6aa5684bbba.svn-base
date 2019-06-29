package owner.dao;

import java.util.List;
import java.util.Map;

import vo.ContractVO;
import vo.RoomImgVO;
import vo.RoomVO;

public interface IRegistRoomDao {
	// 공실 등록
	public int insertRegistRoom(RoomVO rv);

	
	public String getAddress(String searchStr);
	
	//이미지사진을 받아와 등록한다
	public void uploadImage(RoomImgVO rv);
	
	public int getCurrentRoomId();
	
	public Map<String, String> getLatLng(String searchStr);
	
	public List<RoomVO> getAllMyRoom(String mem_id);
	
	public ContractVO isContract(int room_id);


	public void deleteRoom(int room_id);
	
}

