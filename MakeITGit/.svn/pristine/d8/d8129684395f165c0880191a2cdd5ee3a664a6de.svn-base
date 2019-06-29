package board.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import main.view.BuildedSqlMapConfig;
import vo.BoardVO;

public class IBoardDaoImpl implements IBoardDao{
	
	private static IBoardDaoImpl dao;
	private SqlMapClient client;
	
	private IBoardDaoImpl() {
		client = BuildedSqlMapConfig.getInstance();
	}
	
	public static IBoardDao getInstance() {
		if(dao==null) {
			dao=new IBoardDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int postArticle(BoardVO bv) throws SQLException {
		Object obj = client.insert("board.postArticle",bv);
		if(obj==null) {
			return 1;
		}else {
			return 0;
		}
	}
}
