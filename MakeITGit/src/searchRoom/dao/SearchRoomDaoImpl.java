package searchRoom.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ibatis.sqlmap.client.SqlMapClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.view.BuildedSqlMapConfig;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public class SearchRoomDaoImpl implements ISearchRoomDao {
	private static ISearchRoomDao dao = new SearchRoomDaoImpl();
	private static SqlMapClient smc = BuildedSqlMapConfig.getInstance();

	public static ISearchRoomDao getInstance() {
		return dao;
	}

	private SearchRoomDaoImpl() {

	}

	@Override
	public ObservableList<RoomVO> getRoomList() {
		ObservableList<RoomVO> roomList;
		try {
			roomList = FXCollections.observableArrayList(smc.queryForList("Test.getAllRoom"));
			return roomList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RoomImgVO getRoomImg(int room_id) {
		List<RoomImgVO> imgList;
		try {
			imgList = smc.queryForList("Test.getAllRoomImg", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return imgList.get(0);
	}

	@Override
	public Map<String, String> getLatLng(String searchStr) {
		Map<String, String> resultMap = null;
		searchStr = searchStr.replaceAll(" ", "%20");
		String urlLink = "https://maps.googleapis.com/maps/api/geocode/json?address=" + searchStr
				+ "&key=AIzaSyCiNE-lKV0z0cU8WCjFDw72ojQ0POpY-Po";
		try {
			URL url = new URL(urlLink);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader bin = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;

			while ((line = bin.readLine()) != null) {
				sb.append(line);
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj;
			jsonObj = (JSONObject) jsonParser.parse(sb.toString());

			JSONArray jsonArray = (JSONArray) jsonObj.get("results");
//			JSONObject jsonStatus = (JSONObject) jsonArray.get(1);
//			if (jsonStatus.get("status") != "OK") {
//				System.out.println("잘못된 주소를 입력하셨습니다.");
//				return null;
//			}
			
			JSONObject tempObj = (JSONObject) jsonArray.get(0);
			tempObj = (JSONObject) tempObj.get("geometry");
			tempObj = (JSONObject) tempObj.get("location");
			
			
			System.out.println("lat ===" + tempObj.get("lat"));
			System.out.println("lng ===" + tempObj.get("lng"));
			
			resultMap = new HashMap<>();
			resultMap.put("lat", tempObj.get("lat")+"");
			resultMap.put("lng", tempObj.get("lng")+"");

		} catch(IndexOutOfBoundsException e) {
			// 이 예외는 검색한 결과가 없을 때 나타납니다
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return resultMap;
	}
	
	
	
	@Override
	public void AddSearchLog(SearchLogVO slvo) {
		try {
			smc.insert("Test.addSearchLog",slvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 관리자 메인화면 방 띄우기
	 */
	@Override
	public ObservableList<RoomVO> getAdminRoomList(String mem_id) {
		ObservableList<RoomVO> roomList;
		try {
			roomList = FXCollections.observableArrayList(smc.queryForList("Test.getAdminRoom",mem_id));
			return roomList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public MemberVO getMemberInfo(String mem_id) {
		try {
			return (MemberVO)smc.queryForObject("Test.getAdminRoom", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateRoom(RoomVO rv) {
		int cnt = 0;
		
		try {
			cnt = smc.update("Test.updateRoom", rv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public int updateRoomImg(RoomImgVO riv) {
		int cnt = 0;
		
		try {
			cnt = smc.update("Test.updateImg", riv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	
}
