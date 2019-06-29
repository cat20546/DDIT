package owner.service;

import java.util.List;
import java.util.Map;

import owner.dao.IRegistRoomDao;
import owner.dao.RegistRoomDaoImpl;
import vo.ContractVO;
import vo.RoomImgVO;
import vo.RoomVO;

public class RegistRoomServiceImpl implements IRegistRoomService{
	private static RegistRoomServiceImpl service;
	private IRegistRoomDao dao = RegistRoomDaoImpl.getInstance();
	
	/**
	 * 싱글톤
	 * @return
	 */
	public static IRegistRoomService getInstance() {
		if(service==null) {
			service = new RegistRoomServiceImpl();
		}
		return service;
	}
	
	/**
	 * 방 등록
	 */
	@Override
	public int insertRegistRoom(RoomVO rv) {
		return dao.insertRegistRoom(rv);
	}
	
	@Override
	public Map<String, String> getLatLng(String searchStr) {
		return dao.getLatLng(searchStr);
	}


	
	
	@Override
	public String getAddress(String searchStr) {
		return dao.getAddress(searchStr);
	}
	
	
	@Override
	public int getCurrentRoomId() {
		return dao.getCurrentRoomId();
	}
	
	@Override
	public void uploadImage(RoomImgVO rv) {
		dao.uploadImage(rv);
	}
	
	@Override
	public List<RoomVO> getAllMyRoom(String mem_id) {
		return dao.getAllMyRoom(mem_id);
	}
	@Override
	public ContractVO isContract(int room_id) {
		return dao.isContract(room_id);
	}
	@Override
	public void deleteRoom(int room_id) {
		dao.deleteRoom(room_id);
	}
}
