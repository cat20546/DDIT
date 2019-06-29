package roomInfo.service;

import java.util.List;
import java.util.Map;

import roomInfo.dao.IRoomInfoDao;
import roomInfo.dao.RoomInfoDaoImpl;
import vo.ContractVO;
import vo.LikeVO;
import vo.RoomImgVO;
import vo.RoomVO;

public class RoomInfoServiceImpl implements IRoomInfoService{
	private static IRoomInfoDao dao = RoomInfoDaoImpl.getInstance();
	private static IRoomInfoService service = new RoomInfoServiceImpl();
	public static IRoomInfoService getInstance() {
		return service;
	}

	@Override
	public int memLikeRoom(Map<String, Object> param) {
		return dao.memLikeRoom(param);
	}
	
	@Override
	public void insertLike(LikeVO lv) {
		dao.insertLike(lv);
	}
	@Override
	public void deleteLike(int likeId) {
		dao.deleteLike(likeId);
	}
	@Override
	public int getLikeCount(int roomId) {
		return dao.getLikeCount(roomId);
	}
	@Override
	public int getRoomView(int roomId) {
		return dao.getRoomView(roomId);
	}
	
	@Override
	public int getSearchCount(Map<String, Float> param) {
		return dao.getSearchCount(param);
	}
	@Override
	public List<RoomVO> getRealtorRoom(String mem_id) {
		return dao.getRealtorRoom(mem_id);
	}
	@Override
	public int isContract(int room_id) {
		return dao.isContract(room_id);
	}
	@Override
	public void sendContract(ContractVO cv) {
		dao.sendContract(cv);
	}
	@Override
	public List<RoomImgVO> getRoomImages(int room_id) {
		return dao.getRoomImages(room_id);
	}
}