package siteInfo.dao;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import vo.BoardVO;
import vo.ChatRoomVO;
import vo.ChatVO;
import vo.CommentVO;
import vo.ParticipantVO;

public interface ISiteInfoDao {
	
	/**
	 * 게시글을 등록하는 메서드
	 * @author PC-08
	 * @param bv
	 * @return
	 * @throws SQLException 
	 */
	int upload(BoardVO bv) throws SQLException;
	
	/**
	 * 공지사항을 조회하는 메서드
	 * @author PC-08 
	 * @return
	 */
	ObservableList<BoardVO> getNoticeBoardList() throws SQLException;
	
	/**
	 * 자주 묻는 질문을 조회하는 메서드
	 * @author PC-08 
	 * @return
	 * @throws SQLException 
	 */
	ObservableList<BoardVO> getFrequentQustionBoardList() throws SQLException;
	
	/**
	 * 게시글을 수정하는 메서드
	 * @param bv
	 * @return
	 * @throws SQLException 
	 */
	int editArticle(BoardVO bv) throws SQLException;
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @author PC-08
	 * @param currentBoardVO
	 * @return
	 * @throws SQLException 
	 */
	int deleteArticle(BoardVO bv) throws SQLException;
	
	/**
	 * 댓글의 존재여부를 확인하는 메서드
	 * @author Jonghoon Park
	 * @param mem_id
	 * @throws SQLException 
	 */
	int checkCommentExist(int board_id) throws SQLException;
	
	/**
	 * 댓글을 추가하는 메서드
	 * @author Jonghoon Park
	 * @param cv
	 * @return
	 * @throws SQLException 
	 */
	int addComment(CommentVO cv) throws SQLException;
	
	/**
	 * 댓글을 조회하는 메서드
	 * @author Jonghoon Park
	 * @return
	 * @throws SQLException 
	 */
	ObservableList<CommentVO> getCommentList(int board_id) throws SQLException;
	
	/**
	 * 댓글을 수정하는 메서드
	 * @author PC-08
	 * @param currentCommentVO
	 * @return
	 * @throws SQLException 
	 */
	int updateComment(CommentVO currentCommentVO) throws SQLException;
	
	/**
	 * 댓글을 삭제하는 메서드
	 * @author PC-08
	 * @param currentCommentVO
	 * @return
	 * @throws SQLException 
	 */
	int deleteComment(CommentVO currentCommentVO) throws SQLException;
	
	/**
	 * 채팅방을 추가하는 메서드
	 * @author PC-08
	 * @param crv
	 * @return
	 * @throws SQLException 
	 */
	int insertChatRoom(ChatRoomVO crv) throws SQLException;
	
	/**
	 * 챗을 추가하는 메서드
	 * @author PC-08
	 * @param cv
	 * @return
	 * @throws SQLException 
	 */
	int insertChat(ChatVO cv) throws SQLException;
	
	/**참가자를 추가하는 메서드
	 * @author PC-08
	 * @param pv
	 * @return
	 * @throws SQLException 
	 */
	int insertParticipant(ParticipantVO pv) throws SQLException;


}
