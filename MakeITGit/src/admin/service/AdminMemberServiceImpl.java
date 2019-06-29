package admin.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.IAdminMemberDao;
import admin.dao.AdminMemberDaoImpl;
import encryption.Encryption;
import javafx.collections.ObservableList;
import vo.BoardVO;
import vo.MemberVO;

public class AdminMemberServiceImpl implements IAdminMemberService{

	private static AdminMemberServiceImpl service;
	private IAdminMemberDao dao;
	
	private AdminMemberServiceImpl() {
		dao=AdminMemberDaoImpl.getInstance();
	}
	
	public static IAdminMemberService getInstance() {
		if(service==null) {
			service = new AdminMemberServiceImpl();
		}
		return service;
	}

	@Override
	public int checkDuplication(String id) {
		int chk = 0;
		try {
			chk = dao.checkDuplication(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int signUp(MemberVO mv) {
		int cnt = 0;
		try {
			String shaPass = Encryption.encryptSHA256(mv.getMem_pw());
			mv.setMem_pw(shaPass);
			
			cnt = dao.signUp(mv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public String getAddress(String searchStr) {
		return dao.getAddress(searchStr);
	}
	
	
	@Override
	public ObservableList<BoardVO> getMyBoardList(String mem_id) {
		return dao.getMyBoardList(mem_id);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return dao.getAllMemberList();
	}

	@Override
	public int adminInsert(MemberVO mv) {
		return dao.adminInsert(mv);
	}

	@Override
	public int updateMember(MemberVO mv) {
		return dao.updateMember(mv);
	}

	@Override
	public List<MemberVO> getAllAllMember() {
		return dao.getAllAllMember();
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}


	






	
}
