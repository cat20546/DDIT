package member.Interest.dao;

import java.util.List;

import vo.RoomImgVO;
import vo.RoomVO;

public interface IInterestDao {

	/**
	 * 최근목록 방 정보를 가져온다		
	 * @return
	 */
	List<RoomVO> getSearchRoomLog(String mem_id);
	
	/**
	 * 즐겨찾기 방 정보를 가져온다.
	 */
	List<RoomVO> getFavoriteLog(String mem_id);
	
	/**
	 * 방 이미지 전부를 가져온다
	 * @return
	 */
	RoomImgVO getAllRoomImg(int room_id);
	
	/**
	 * 최근 조회 방 이미지 하나를 가져온다.
	 * @return
	 */
	RoomImgVO getRoomImg(int room_id);
	
	/**
	 * 찜목록 방 이미지 하나를 가져온다.
	 * @param room_id
	 * @return
	 */
	RoomImgVO getFavoriteRoomImg(int room_id);
	
	
}
