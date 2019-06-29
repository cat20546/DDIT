package admin.service;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;
import vo.BoardVO;
import vo.MemberVO;

public interface IAdminMemberService {
	
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
	
	/**
	 * 회원전체조회
	 * @return
	 */
	public List<MemberVO> getAllMemberList();
	
	/**
	 * 회원 등록
	 */
	
	public int adminInsert(MemberVO mv); 
	
	/**
	 * 하나의 MemberVO자료를 이용하여 DB를 update하는 메서드 
	 * @param mv update할 회원정보가 들어있는 MemberVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteMember(String mem_id);
	
	
	public List<MemberVO> getAllAllMember();
	
	
}
