package searchRoom.dao;

import java.util.Map;

import javafx.collections.ObservableList;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public interface ISearchRoomDao {
	/**
	 * 메인 화면에 보여줄 방을 가져온다
	 * @return
	 */
	ObservableList<RoomVO> getRoomList();
	
	/**
	 * 방 이미지 1개를 가져온다
	 * @return
	 */
	RoomImgVO getRoomImg(int room_id);

	/**
	 * 검색어를 받아와 좌표값을 넘겨준다.
	 * key : lat, lng
	 * @param searchStr
	 * @return
	 */
	Map<String, String> getLatLng(String searchStr);
	
	/**
	 * 방 조회기록을 남깁니다.
	 * @param slvo
	 */
	void AddSearchLog(SearchLogVO slvo);
	
	/**
	 * 관리자 메인 화면에 보여줄 방을 가져온다
	 * @return
	 */
	ObservableList<RoomVO> getAdminRoomList(String mem_id);
	
	/**
	 * 멤버 ID로 멤버 정보를 조회한다.
	 * @param mem_id
	 * @return
	 */
	MemberVO getMemberInfo(String mem_id);
	
	/**
	 * 방 업데이트
	 * @param rv
	 * @return
	 */
	int updateRoom(RoomVO rv);
	
	int updateRoomImg(RoomImgVO riv); 
	
}
