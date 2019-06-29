package member.Interest.service;

import java.util.List;

import member.Interest.dao.IInterestDao;
import member.Interest.dao.IInterestDaoImpl;
import vo.RoomImgVO;
import vo.RoomVO;

public class IInterestServiceImpl implements IInterestService {
	
	private static IInterestServiceImpl service;
	private IInterestDao dao;
	
	private IInterestServiceImpl() {
		dao=IInterestDaoImpl.getInstance();
	}
	
	public static IInterestService getInstance() {
		if(service==null) {
			service = new IInterestServiceImpl();
		}
		return service;
	}

	@Override
	public RoomImgVO getAllRoomImg(int room_id) {
		return dao.getAllRoomImg(room_id);
	}

	@Override
	public List<RoomVO> getFavoriteLog(String mem_id) {
		return dao.getFavoriteLog(mem_id);
	}


	@Override
	public List<RoomVO> getSearchRoomLog(String mem_id) {
		// TODO Auto-generated method stub
		return dao.getSearchRoomLog(mem_id);
	}

	@Override
	public RoomImgVO getRoomImg(int room_id) {
		return dao.getRoomImg(room_id);
	}

	@Override
	public RoomImgVO getFavoriteRoomImg(int room_id) {
		return dao.getFavoriteRoomImg(room_id);
	}

}
