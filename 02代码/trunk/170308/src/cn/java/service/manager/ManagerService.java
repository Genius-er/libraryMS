package cn.java.service.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ManagerService {
	boolean managerLogin(String user_id, String password, HttpServletRequest request) throws IOException, SQLException;
	boolean checkManager(String user_id, HttpServletRequest request) throws IOException, SQLException;
	boolean addUser(String user_id, String password, String china_name, String tel, String sex, String user_type, HttpServletRequest request) throws IOException, SQLException;
	boolean updateUser(String user_id, String username, String password, String china_name, String tel, String sex, String user_type, HttpServletRequest request) throws IOException, SQLException;
	boolean deleteUser(String user_id, HttpServletRequest request) throws IOException, SQLException;
	List<Map<String, Object>> getAllBooks(String page, String booktype_name, HttpServletRequest request) throws IOException, SQLException;
	boolean deleteBook(String book_id, HttpServletRequest request) throws IOException, SQLException;
	List<Map<String, Object>> searchBook(String name, HttpServletRequest request) throws IOException, SQLException;
	List<Map<String, Object>> getAllUsers(HttpServletRequest request) throws IOException, SQLException;
	boolean managerAddBook(String title, String author, String isbn, String publish, String booktype_name, String cover, HttpServletRequest request) throws IOException, SQLException;
	boolean managerModifyBook(String title, String author, String isbn, String publish, String booktype_name, String cover,String book_id ,HttpServletRequest request) throws IOException, SQLException;
	Map<String, Object> getBookInfoById(String book_id ,HttpServletRequest request) throws IOException, SQLException;
	Map<String, Object> ManagerSelectUser(String user_id, HttpServletRequest request) throws IOException, SQLException;
	Map<String, List<String>> getBookType(HttpServletRequest request) throws IOException, SQLException;
}
