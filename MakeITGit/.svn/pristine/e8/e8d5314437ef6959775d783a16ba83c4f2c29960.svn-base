package siteInfo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.view.BuildedSqlMapConfig;
import vo.BoardVO;
import vo.ChatRoomVO;
import vo.ChatVO;
import vo.CommentVO;
import vo.ParticipantVO;

public class ISiteInfoDaoImpl implements ISiteInfoDao{
	
	private static ISiteInfoDaoImpl dao;
	private SqlMapClient client;
	
	private ISiteInfoDaoImpl() {
		client = BuildedSqlMapConfig.getInstance();
	}
	
	public static ISiteInfoDao getInstance() {
		if(dao==null) {
			dao=new ISiteInfoDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int upload(BoardVO bv) throws SQLException {
		Object obj = client.insert("siteInfo.upload",bv);
		if(obj==null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public ObservableList<BoardVO> getNoticeBoardList() throws SQLException {
		List<BoardVO> list = client.queryForList("siteInfo.showNoticeBoard");
		return FXCollections.observableArrayList(list);
	}

	@Override
	public ObservableList<BoardVO> getFrequentQustionBoardList() throws SQLException {
		List<BoardVO> list = client.queryForList("siteInfo.showFQBoard");
		return FXCollections.observableArrayList(list);
	}
	
	@Override
	public int editArticle(BoardVO bv) throws SQLException {
		int cnt= (int)client.update("siteInfo.updateArticle", bv);
		return cnt;
	}

	@Override
	public int deleteArticle(BoardVO bv) throws SQLException {
		int cnt = (int)client.delete("siteInfo.deleteArticle", bv);
		return cnt;
	}

	@Override
	public int checkCommentExist(int board_id) throws SQLException {
		int chk = (int) client.queryForObject("siteInfo.checkCommentExist", board_id);
		return chk;
	}

	@Override
	public int addComment(CommentVO cv) throws SQLException {
		Object obj = client.insert("siteInfo.addComment", cv);
		if(obj==null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public ObservableList<CommentVO> getCommentList(int board_id) throws SQLException {
		List<CommentVO> list = client.queryForList("siteInfo.getCommentList", board_id);
		return FXCollections.observableArrayList(list);
	}

	@Override
	public int updateComment(CommentVO currentCommentVO) throws SQLException {
		int cnt = client.update("siteInfo.updateComment", currentCommentVO);
		return cnt;
	}

	@Override
	public int deleteComment(CommentVO currentCommentVO) throws SQLException {
		int cnt = client.delete("siteInfo.deleteComment", currentCommentVO);
		return cnt;
	}

	@Override
	public int insertChatRoom(ChatRoomVO crv) throws SQLException {
		Object obj = client.insert("siteInfo.insertChatRoom", crv);
		if(obj==null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int insertChat(ChatVO cv) throws SQLException {
		Object obj = client.insert("siteInfo.insertChat", cv);
		if(obj==null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int insertParticipant(ParticipantVO pv) throws SQLException {
		Object obj = client.insert("siteInfo.insertParticipant", pv);
		if(obj==null) {
			return 1;
		}else {
			return 0;
		}
	}

}
