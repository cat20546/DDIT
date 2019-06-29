package member.service;

import java.util.List;
import java.util.Map;

import javafx.collections.ObservableList;
import vo.BlacklistVO;
import vo.BoardVO;
import vo.MemberVO;
import vo.ReviewVO;

public interface IMemberService {
	
	/**
	 * 입력받은 id가 db에 존재하는지 검사하는 메서드
	 * @author PC-08
	 * @param id
	 */
	int checkDuplication(String id);
	
	/**
	 * 입력받은 회원정보로 회원가입을 하는 메서드
	 * @author PC-08
	 * @param mv
	 */
	int signUp(MemberVO mv);
	
	/**
	 * 방 주소를 검색해 상세주소를 반환하는 메서드
	 * @param searchStr
	 * @return
	 */
	public String getAddress(String searchStr);
	
	/**
	 * 자신이 작성한 게시글만 리턴하는 메서드
	 * @param mem_id
	 * @return
	 */
	ObservableList<BoardVO> getMyBoardList(String mem_id);
	
	List<Map<String, Object>> getReceiveContrace(String mem_id); 
	
	void newContract(Map<String, Object> param);
	
	List<Map<String, Object>> getContract(String mem_id);
	
	void insertReview(ReviewVO rv);
	
	List<ReviewVO> getMyReview(String mem_id);
	
	void deleteReview(int review_id);
	
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
	 */
	int deleteAccount(MemberVO currentMember);
	
	/**
	 * 비밀번호를 찾기위해 아이디와 이메일을 대조시켜주는 메서드
	 * @author Jonghoon Park
	 * @param id
	 * @param email
	 * @return
	 */
	int checkCorrectEmail(Map<String, String> param1);
	
	/**
	 * 임시비밀번호로 바꿔주는 메서드
	 * @author Jonghoon Park
	 * @param emailIdNum
	 * @param emailIdNum2 
	 * @return
	 */
	int updateTempPw(Map<String, String> param2);
	
	/**
	 * 탈퇴한 회원을 체크하는 메서드
	 * @author PC-08
	 * @param id
	 * @return
	 */
	int checkDeletedMember(String id);
}
