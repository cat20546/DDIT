package member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javafx.collections.ObservableList;
import vo.BlacklistVO;
import vo.BoardVO;
import vo.MemberVO;
import vo.ReviewVO;

public interface IMemberDao {
	
	/**
	 * 입력받은 id가 db에 존재하는지 검사하는 메서드
	 * @author PC-08
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	int checkDuplication(String id) throws SQLException;
	
	/**
	 * 입력받은 회원정보로 회원가입을 하는 메서드
	 * @author PC-08
	 * @param mv
	 * @throws SQLException 
	 */
	int signUp(MemberVO mv) throws SQLException;

	/**
	 * 주소를 검색하면 상세주소를 리턴하는 메서드
	 * @param searchStr
	 * @return
	 */
	String getAddress(String searchStr);
	
	
	/**
	 * 자신이 작성한 게시글만 리턴하는 메서드
	 * @param mem_id
	 * @return
	 */
	ObservableList<BoardVO> getMyBoardList(String mem_id);
	
	/**
	 * 자신이 계약을 요청한 방중 중개사가 응답한 방을 보여줌
	 * @param mem_id
	 * @return
	 */
	List<Map<String, Object>> getReceiveContrace(String mem_id); 
	
	/**
	 * 계약 대기중인 공실을 가져옴
	 * @param param
	 */
	void newContract(Map<String, Object> param);
	
	/**
	 * 계약을 완료한 공실을 가져옴
	 */
	List<Map<String, Object>> getContract(String mem_id);
	
	/**
	 * 리뷰를 DB에 올림
	 * @param rv
	 */
	void insertReview(ReviewVO rv);
	
	/**
	 * 내가 쓴 리뷰를 가져옴
	 * @param mem_id
	 * @return
	 */
	List<ReviewVO> getMyReview(String mem_id);
	/**
	 * 리뷰를 지움
	 * @param review_id
	 */
	void deleteReview(int review_id);
	
	/**
	 * 리뷰 수정
	 * @param rv
	 */
	void updateReview(ReviewVO rv);

	
	/**
	 * 블랙리스트인지 확인
	 * @param mem_id
	 * @return
	 */
	List<BlacklistVO> checkBlacklist(String mem_id);	
	
	void deleteContract(int room_id);
	
	/**
	 * 회원탈퇴를 하는 메서드
	 * @author Jonghoon Park
	 * @param currentMember
	 * @return
	 * @throws SQLException 
	 */
	int deleteAccount(MemberVO currentMember) throws SQLException;
	
	/**
	 * 비밀번호를 찾기위해 아이디와 이메일을 대조시켜주는 메서드
	 * @author Jonghoon Park
	 * @param id
	 * @param email
	 * @return
	 * @throws SQLException 
	 */
	int checkCorrectEmail(Map<String, String> param1) throws SQLException;
	
	/**
	 * 임시비밀번호로 바꿔주는 메서드
	 * @author Jonghoon Park
	 * @param emailIdNum
	 * @return
	 * @throws SQLException 
	 */
	int updateTempPw(Map<String, String> param2) throws SQLException;
	
	/**
	 * 탈퇴한 회원을 체크하는 메서드
	 * @author PC-08
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	int checkDeletedMember(String id) throws SQLException;
}
