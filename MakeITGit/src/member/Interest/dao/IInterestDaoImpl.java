package member.Interest.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import admin.dao.AdminMemberDaoImpl;
import admin.dao.IAdminMemberDao;
import main.view.BuildedSqlMapConfig;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public class IInterestDaoImpl implements IInterestDao {
	private static IInterestDaoImpl dao;
	private SqlMapClient client;

	private IInterestDaoImpl() {
		client = BuildedSqlMapConfig.getInstance();
	}

	public static IInterestDao getInstance() {
		if (dao == null) {
			dao = new IInterestDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 최근본 방 로그 전체조회
	 */
	@Override
	public List<RoomVO> getSearchRoomLog(String mem_id) {
			List<RoomVO> logList = null;

			try {
				logList = client.queryForList("interest.getAllSearchLog",mem_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return logList;
		}
	
	/**
	 * 이미지 전체 가져오기
	 */
	@Override
	public RoomImgVO getAllRoomImg(int room_id) {
		List<RoomImgVO> imgList;
		try {
			imgList = client.queryForList("interest.getAllRoomImg", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return imgList.get(0);
	}
	
	/**
	 * 즐겨찾기 방 전체 조회
	 */
	@Override
	public List<RoomVO> getFavoriteLog(String mem_id) {
		List<RoomVO> favoriteList = null;

		try {
			favoriteList = client.queryForList("interest.getAllFavorite",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return favoriteList;
	}

	/**
	 * 최근 조회 회원별 방 하나 가져오기
	 */
	@Override
	public RoomImgVO getRoomImg(int room_id) {
		List<RoomImgVO> imgList;
		try {
			imgList = client.queryForList("interest.getRoomImg", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return imgList.get(0);
	}

	@Override
	public RoomImgVO getFavoriteRoomImg(int room_id) {
		List<RoomImgVO> imgList;
		try {
			imgList = client.queryForList("interest.getFavoriteRoomImg", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return imgList.get(0);
	}
	
	
	
	
	}

