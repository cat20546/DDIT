package roomInfo.dao;

import java.util.List;
import java.util.Map;

import vo.ContractVO;
import vo.LikeVO;
import vo.RoomImgVO;
import vo.RoomVO;

public interface IRoomInfoDao {

	public int memLikeRoom(Map<String, Object> param);
	public void insertLike(LikeVO lv);
	public void deleteLike(int likeId);
	public int getLikeCount(int roomId);
	public int getRoomView(int roomId);
	int getSearchCount(Map<String, Float> param);
	public List<RoomVO> getRealtorRoom(String mem_id);	
	public int isContract(int room_id);
	public void sendContract(ContractVO cv);
	public List<RoomImgVO> getRoomImages(int room_id);
	
}
