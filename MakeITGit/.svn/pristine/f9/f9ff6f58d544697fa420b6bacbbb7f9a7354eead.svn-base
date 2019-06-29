package searchRoom.service;

import java.util.Map;

import javafx.collections.ObservableList;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public interface ISearchRoomService {
	ObservableList<RoomVO> getRoomList();
	
	RoomImgVO getRoomImg(int room_id);
	
	Map<String, String> getLatLng(String searchStr);
	
	void AddSearchLog(SearchLogVO slvo);
	
	ObservableList<RoomVO> getAdminRoomList(String mem_id);
	/**
	 * 멤버 ID로 멤버 정보를 조회한다.
	 * @param mem_id
	 * @return
	 */
	MemberVO getMemberInfo(String mem_id);

	public int updateRoom(RoomVO rv);
	
	int updateRoomImg(RoomImgVO riv);
}
