package admin.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ibatis.sqlmap.client.SqlMapClient;

import encryption.Encryption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.view.BuildedSqlMapConfig;
import vo.BoardVO;
import vo.MemberVO;

public class AdminMemberDaoImpl implements IAdminMemberDao {

	private static AdminMemberDaoImpl dao;
	private SqlMapClient client;

	private AdminMemberDaoImpl() {
		client = BuildedSqlMapConfig.getInstance();
	}

	public static IAdminMemberDao getInstance() {
		if (dao == null) {
			dao = new AdminMemberDaoImpl();
		}
		return dao;
	}

	@Override
	public int checkDuplication(String id) throws SQLException {
		int chk = (int) client.queryForObject("member.checkDuplication", id);
		return chk;
	}

	@Override
	public int signUp(MemberVO mv) throws SQLException {
		Object obj = client.insert("member.signUp", mv);
		if (obj == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String getAddress(String searchStr) {
		String address = "";
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
			address = (String) tempObj.get("formatted_address");

			System.out.println(address);

		} catch (IndexOutOfBoundsException e) {
			// 이 예외는 검색한 결과가 없을 때 나타납니다
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return address;
	}

	@Override
	public ObservableList<BoardVO> getMyBoardList(String mem_id) {
		try {
			List<BoardVO> list = client.queryForList("member.getMyBoardList", mem_id);
			return FXCollections.observableArrayList(list);
		} catch (SQLException e) {
			System.out.println("아 내 리뷰 못가져옴 ㅡㅡ");
			return null;
		}
	}

	/**
	 * 멤버전체조회
	 */
	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memberList = null;

		try {
			memberList = client.queryForList("member.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberList;
	}

	/**
	 * 멤버등록
	 */
	@Override
	public int adminInsert(MemberVO mv) {
		String shaPass = Encryption.encryptSHA256(mv.getMem_pw());
		mv.setMem_pw(shaPass);
		int cnt = 0;
		try {
			Object obj = client.insert("member.adminInsert", mv); // namespace + xml insert에있는 id
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}
	
	/**
	 * 회원수정
	 */
	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;

		try {
			cnt = client.update("member.updateMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getAllAllMember() {
		List<MemberVO> memberList = null;

		try {
			memberList = client.queryForList("member.getAllAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberList;
	}
	/**
	 * 회원 삭제
	 */
	@Override
	public int deleteMember(String mem_id) {
		int cnt = 0;

		try {
			cnt = client.delete("member.deleteMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}


}
