package board.service;

import java.sql.SQLException;

import board.dao.IBoardDao;
import board.dao.IBoardDaoImpl;
import vo.BoardVO;

public class IBoardServiceImpl implements IBoardService {
	
	private static IBoardServiceImpl service;
	private IBoardDao dao;
	
	private IBoardServiceImpl() {
		dao=IBoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service==null) {
			service = new IBoardServiceImpl();
		}
		return service;
	}

	@Override
	public int postArticle(BoardVO bv) {
		int cnt = 0;
		try {
			cnt = dao.postArticle(bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
