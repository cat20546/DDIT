package siteInfo.service;

import javafx.collections.ObservableList;
import vo.BoardVO;
import vo.ChatRoomVO;
import vo.ChatVO;
import vo.CommentVO;
import vo.ParticipantVO;

public interface ISiteInfoService {
	
	/**
	 * 게시글을 등록하는 메서드
	 * @author PC-08
	 * @param bv
	 * @return
	 */
	int upload(BoardVO bv);
	
	/**
	 * 공지사항을 조회하는 메서드
	 * @author PC-08 
	 * @return
	 */
	ObservableList<BoardVO> getNoticeBoardList();
	
	/**
	 * 자주 묻는 질문을 조회하는 메서드
	 * @author PC-08 
	 * @return
	 */
	ObservableList<BoardVO> getFrequentQustionBoardList();
	
	/**
	 * 게시글을 수정하는 메서드
	 * @author PC-08
	 * @param bv
	 * @return
	 */
	int editArticle(BoardVO bv);
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @author PC-08
	 * @param currentBoardVO
	 * @return
	 */
	int deleteArticle(BoardVO bv);

	/**
	 * 댓글의 존재여부를 확인하는 메서드
	 * @author Jonghoon Park
	 * @param mem_id
	 */
	int checkCommentExist(int board_id);
	
	/**
	 * 댓글을 추가하는 메서드
	 * @author Jonghoon Park
	 * @param cv
	 * @return
	 */
	int addComment(CommentVO cv);
	
	/**
	 * 댓글을 조회하는 메서드
	 * @author Jonghoon Park
	 * @param board_id 
	 * @return
	 */
	ObservableList<CommentVO> getCommentList(int board_id);
	
	/**
	 * 댓글을 수정하는 메서드
	 * @author PC-08
	 * @param currentCommentVO
	 * @return
	 */
	int updateComment(CommentVO currentCommentVO);
	
	/**
	 * 댓글을 삭제하는 메서드
	 * @author PC-08
	 * @param currentCommentVO
	 * @return
	 */
	int deleteComment(CommentVO currentCommentVO);
	
	/**
	 * 채팅방을 추가하는 메서드
	 * @author PC-08
	 * @param crv
	 * @return
	 */
	int insertChatRoom(ChatRoomVO crv);
	
	/**
	 * 챗을 추가하는 메서드
	 * @author PC-08
	 * @param cv
	 * @return
	 */
	int insertChat(ChatVO cv);
	
	/**참가자를 추가하는 메서드
	 * @author PC-08
	 * @param pv
	 * @return
	 */
	int insertParticipant(ParticipantVO pv);
	

}
