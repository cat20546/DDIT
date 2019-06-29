package siteInfo.service;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import siteInfo.dao.ISiteInfoDao;
import siteInfo.dao.ISiteInfoDaoImpl;
import vo.BoardVO;
import vo.ChatRoomVO;
import vo.ChatVO;
import vo.CommentVO;
import vo.ParticipantVO;

public class ISiteInfoServiceImpl implements ISiteInfoService {
	
	private static ISiteInfoServiceImpl service;
	private ISiteInfoDao dao;
	
	private ISiteInfoServiceImpl() {
		dao=ISiteInfoDaoImpl.getInstance();
	}
	
	public static ISiteInfoService getInstance() {
		if(service==null) {
			service = new ISiteInfoServiceImpl();
		}
		return service;
	}
	
	@Override
	public int upload(BoardVO bv) {
		int cnt = 0;
		try {
			cnt = dao.upload(bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public ObservableList<BoardVO> getNoticeBoardList() {
		ObservableList<BoardVO> ol = null;
		try {
			ol = dao.getNoticeBoardList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ol;
	}

	@Override
	public int editArticle(BoardVO bv) {
		int cnt=0;
		try {
			cnt=dao.editArticle(bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteArticle(BoardVO bv) {
		int cnt=0;
		try {
			cnt = dao.deleteArticle(bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public ObservableList<BoardVO> getFrequentQustionBoardList() {
		ObservableList<BoardVO> ol = null;
		try {
			ol = dao.getFrequentQustionBoardList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ol;
	}

	@Override
	public int checkCommentExist(int board_id) {
		int chk=0;
		try {
			chk = dao.checkCommentExist(board_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int addComment(CommentVO cv) {
		int cnt=0;
		try {
			cnt = dao.addComment(cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public ObservableList<CommentVO> getCommentList(int board_id) {
		ObservableList<CommentVO> list = null;
		try {
			list = dao.getCommentList(board_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateComment(CommentVO currentCommentVO) {
		int cnt=0;
		try {
			cnt = dao.updateComment(currentCommentVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteComment(CommentVO currentCommentVO) {
		int cnt=0;
		try {
			cnt = dao.deleteComment(currentCommentVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertChatRoom(ChatRoomVO crv) {
		int cnt=0;
		try {
			cnt=dao.insertChatRoom(crv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertChat(ChatVO cv) {
		int cnt = 0;
		try {
			cnt=dao.insertChat(cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertParticipant(ParticipantVO pv) {
		int cnt = 0;
		try {
			cnt=dao.insertParticipant(pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
