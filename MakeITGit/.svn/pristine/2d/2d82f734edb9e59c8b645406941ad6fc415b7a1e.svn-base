package searchRoom.service;

import java.util.Map;

import javafx.collections.ObservableList;
import searchRoom.dao.ISearchRoomDao;
import searchRoom.dao.SearchRoomDaoImpl;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public class SearchRoomServiceImpl implements ISearchRoomService{
	private static ISearchRoomDao dao = SearchRoomDaoImpl.getInstance();
	private static ISearchRoomService service = new SearchRoomServiceImpl();
	public static ISearchRoomService getInstance() {
		return service;
	}
	@Override
	public ObservableList<RoomVO> getRoomList() {
		return dao.getRoomList();
	}
	
	@Override
	public RoomImgVO getRoomImg(int room_id) {
		return dao.getRoomImg(room_id);
	}
	
	@Override
	public Map<String, String> getLatLng(String searchStr){
		return dao.getLatLng(searchStr);
	}
	@Override
	public void AddSearchLog(SearchLogVO slvo) {
		dao.AddSearchLog(slvo);
	}
	@Override
	public ObservableList<RoomVO> getAdminRoomList(String mem_id) {
		return dao.getAdminRoomList(mem_id);
	}
	
	@Override
	public MemberVO getMemberInfo(String mem_id) {
		return dao.getMemberInfo(mem_id);
	}
	@Override
	public int updateRoom(RoomVO rv) {
		return dao.updateRoom(rv);
	}
	@Override
	public int updateRoomImg(RoomImgVO riv) {
		return dao.updateRoomImg(riv);
	}
}