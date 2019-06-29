package owner.service;

import java.util.List;
import java.util.Map;

import vo.ContractVO;
import vo.RoomImgVO;
import vo.RoomVO;

public interface IRegistRoomService {
	
	public int insertRegistRoom(RoomVO rv);

	
	public String getAddress(String searchStr);
	
	public int getCurrentRoomId();
	
	public void uploadImage(RoomImgVO rv);
	public Map<String, String> getLatLng(String searchStr);
	public List<RoomVO> getAllMyRoom(String mem_id);
	public ContractVO isContract(int room_id);


	public void deleteRoom(int room_id);
}
