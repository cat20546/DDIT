package roomInfo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import main.view.BuildedSqlMapConfig;
import vo.ContractVO;
import vo.LikeVO;
import vo.RoomImgVO;
import vo.RoomVO;

public class RoomInfoDaoImpl implements IRoomInfoDao {
	private static IRoomInfoDao dao = new RoomInfoDaoImpl();
	private static SqlMapClient smc = BuildedSqlMapConfig.getInstance();
	public static IRoomInfoDao getInstance() {
		return dao;
	}
	
	private RoomInfoDaoImpl() {

	}
	
	@Override
	public int memLikeRoom(Map<String, Object> param) {
		
		try {
			return (int) smc.queryForObject("roomInfo.memLikeRoom", param);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public void insertLike(LikeVO lv) {
		try {
			smc.insert("roomInfo.insertLike", lv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteLike(int likeId) {
		try {
			smc.delete("roomInfo.deleteLike",likeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getLikeCount(int roomId) {
		try {
			return (int) smc.queryForObject("roomInfo.getLikeCount", roomId);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int getRoomView(int roomId) {
		try {
			return (int)smc.queryForObject("roomInfo.getViewCount", roomId);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int getSearchCount(Map<String, Float> param) {
		try {
			return (int)smc.queryForObject("roomInfo.getSearchCount", param);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public List<RoomVO> getRealtorRoom(String mem_id) {
		try {
			return smc.queryForList("roomInfo.getRealtorRoom", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int isContract(int room_id) {
		try {
			return (int)smc.queryForObject("roomInfo.isContract", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public void sendContract(ContractVO cv) {
		try {
			smc.insert("roomInfo.sendContract", cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<RoomImgVO> getRoomImages(int room_id) {
		try {
			return smc.queryForList("roomInfo.getRoomImages", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
