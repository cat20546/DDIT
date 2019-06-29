package admin.dao;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;
import vo.BoardVO;
import vo.MemberVO;

public interface IAdminMemberDao {
	
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
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO객체를 담고있는 List객체
	 */
	public List<MemberVO> getAllMemberList();
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 자료가 저장된 MemberVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 반환된다.
	 */
	int adminInsert(MemberVO mv); 
	
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
	
	/**
	 * 회원정보를 조회하는 조회하는 메서드
	 * ObservableList로 사용
	 * @return
	 */

	List<MemberVO> getAllAllMember();
}
