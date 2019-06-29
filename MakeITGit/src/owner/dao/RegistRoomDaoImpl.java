package owner.dao;

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

import main.view.BuildedSqlMapConfig;
import vo.ContractVO;
import vo.RoomImgVO;
import vo.RoomVO;

/**
 * 방을 관리하는 기능(방등록, 방수정, 방삭제, 방조회)
 * 
 * @author 윤홍식
 *
 */
public class RegistRoomDaoImpl implements IRegistRoomDao {
	private static IRegistRoomDao dao = new RegistRoomDaoImpl();
	private SqlMapClient client;

	// main.view패키지에있는 BuildedSqlMapConfig를 불러와 간편하게 연결
	private RegistRoomDaoImpl() {
		client = BuildedSqlMapConfig.getInstance();
	}

	public static IRegistRoomDao getInstance() {
		return dao;
	}

	/**
	 * 방을 등록하는 메서드
	 */
	@Override
	public int insertRegistRoom(RoomVO rv) {
		int cnt = 0;

		try {
			Object obj = client.insert("room.insertroom", rv);
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return cnt;
		} finally {
			return cnt;
		}
	}
	
	@Override
	public String getAddress(String searchStr) {
		String addr = "";
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
			
			JSONObject tempObj = (JSONObject) jsonArray.get(0);
			addr = (String)tempObj.get("formatted_address");

			System.out.println(addr);
			
			

		} catch(IndexOutOfBoundsException e) {
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return addr;
	}

	@Override
	public void uploadImage(RoomImgVO rv) {
		try {
			client.insert("room.insertRoomImage", rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public int getCurrentRoomId() {
		try {
			return (int) client.queryForObject("room.getCurrentRoomId");
		} catch (SQLException e) {
			return -1;
		}
	}
	
	
	/**
	 * 좌표를 구하는 메서드
	 * @param searchStr
	 * @return
	 */
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
	public List<RoomVO> getAllMyRoom(String mem_id) {
		try {
			return client.queryForList("room.getAllMyRoom", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ContractVO isContract(int room_id) {
		try {
			return (ContractVO) client.queryForObject("room.isContract", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void deleteRoom(int room_id) {
		try {
			client.update("room.deleteRoom", room_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
