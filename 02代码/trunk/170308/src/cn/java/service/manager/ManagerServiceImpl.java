package cn.java.service.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.java.dao.manager.ManagerDao;
import cn.java.dao.manager.ManagerDaoImpl;

public class ManagerServiceImpl implements ManagerService{
	private ManagerDao manager = new ManagerDaoImpl();

	@Override
	public boolean managerLogin(String user_id, String password, HttpServletRequest request) throws IOException, SQLException {
		boolean flag = manager.managerLogin(user_id, password);
        return flag;
	}

	@Override
	public boolean checkManager(String user_id, HttpServletRequest request) throws IOException, SQLException {
		boolean flag = manager.checkManager(user_id);
		return flag;
	}

	@Override
	public boolean addUser(String user_id, String password, String china_name, String tel, String sex, String user_type, HttpServletRequest request) throws IOException, SQLException{
		// TODO Auto-generated method stub
		boolean flag = manager.addUser(user_id, password, china_name, tel, sex, user_type);
		return flag;
	}

	@Override
	public boolean updateUser(String user_id, String username, String password, String china_name, String tel, String sex, String user_type, HttpServletRequest request) throws IOException, SQLException{
		// TODO Auto-generated method stub
		boolean flag = manager.updateUser(user_id, username, password, china_name, tel, sex, user_type);
		return flag;
	}

	@Override
	public boolean deleteUser(String user_id,HttpServletRequest request) throws IOException, SQLException{
		boolean flag = manager.deleteUser(user_id);
		return flag;
	}

	@Override
	public List<Map<String, Object>> getAllBooks(String page, String booktype_name, HttpServletRequest request) throws IOException, SQLException {
		List<Map<String, Object>> books = manager.getAllBooks(page, booktype_name);
		return books;
	}

	@Override
	public Map<String, List<String>> getBookType(HttpServletRequest request) throws IOException, SQLException {
		Map<String, List<String>> bookTypeMap = manager.getBookType();
		return bookTypeMap;
	}

		@Override
	public boolean deleteBook(String book_id, HttpServletRequest request) throws IOException, SQLException {
		boolean flag = manager.deleteBook(book_id);
		return flag;
	}

	@Override
	public List<Map<String, Object>> searchBook(String name, HttpServletRequest request) throws IOException, SQLException {
		List<Map<String, Object>> books = manager.searchBook(name);
		return books;
	}

	@Override
	public List<Map<String, Object>> getAllUsers(HttpServletRequest request) throws IOException, SQLException {
		List<Map<String, Object>> users = manager.getAllUsers();
		return users;
	}

	@Override
	public boolean managerAddBook(String title, String author, String isbn, String publish, String booktype_name, String cover, HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		boolean flag = manager.managerAddBook(title, author, isbn, publish, booktype_name, cover);
		return flag;
	}

	@Override
	public boolean managerModifyBook(String title, String author, String isbn, String publish, String booktype_name, String cover,String book_id ,HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		boolean flag = manager.managerModifyBook(title, author, isbn, publish, booktype_name, cover,book_id);
		return flag;
	}

	@Override
	public Map<String, Object> getBookInfoById(String book_id ,HttpServletRequest request) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> flag = manager.getBookInfoById(book_id);
		return flag;
	}

	@Override
	public 	Map<String, Object> ManagerSelectUser(String user_id, HttpServletRequest request) throws IOException, SQLException{
		Map<String, Object> userInfo = manager.ManagerSelectUser(user_id);
		return userInfo;
	}

}
