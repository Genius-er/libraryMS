package cn.java.service.user;

import cn.java.dao.user.UserDao;
import cn.java.dao.user.UserDaoImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
	private UserDao user = new UserDaoImpl();

	@Override
	public String userLogin(String user_id, String password, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String flag = user.userLogin(user_id, password);
        return flag;
	}

	public Map<String, Object> selectUser(String user_id, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = user.selectUser(user_id);
		return map;
	}

	public boolean updateUser(String user_id, String password, String username, String tel, String sex, String favorite, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		boolean flag = user.updateUser(user_id, password, username, tel, sex, favorite);
		return flag;
	}


	public boolean registerUser(String user_id, String username, String password, String china_name, String user_type, String tel, String sex, String favorite, HttpServletRequest request) throws IOException, SQLException{
		boolean flag = user.registerUser(user_id, username, password, china_name, user_type, tel, sex, favorite);
		return flag;
	}

	@Override
	public boolean isempty(String ID, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		boolean flag = user.isempty(ID);


		return flag;
	}

	public boolean borrowbook(String user_id, String bb_id,  String bb_date, String book_id, String title, String author, String peality_date, String return_date, String state, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		boolean flag = user.borrowbook(user_id, bb_id,  bb_date, book_id, title, author, peality_date, return_date,state);


		return flag;
	}

	public boolean returnbook(String ID, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		boolean flag = user.returnbook(ID);


		return flag;
	}
	public Map<String, Object> borrowed_record(String book_id, String title, String author, String bb_date, String peality_date, String return_date, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map= user.borrowed_record(book_id,title,author,bb_date,peality_date,return_date);


		return map;
	}

	@Override
	public List<Map<String, Object>> getHotBooks(HttpServletRequest request) throws IOException, SQLException {
		List<Map<String, Object>> books = user.getHotBooks();
		return books;
	}

	@Override
	public List<Map<String, Object>> getLikeBooks(HttpServletRequest request) throws IOException, SQLException {
		List<Map<String, Object>> books = user.getLikeBooks();
		return books;
	}
	@Override
	public List<Map<String, Object>> getWholeBooks(HttpServletRequest request) throws IOException, SQLException {
		List<Map<String, Object>> books = user.getWholeBooks();
		return books;
	}

}
