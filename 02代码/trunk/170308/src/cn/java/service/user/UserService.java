package cn.java.service.user;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
	String userLogin(String user_id, String password, HttpServletRequest request) throws IOException, SQLException;
	Map<String, Object> selectUser(String ID, HttpServletRequest request) throws IOException, SQLException;
	boolean updateUser(String user_id, String password, String username, String tel, String sex, String favorite, HttpServletRequest request) throws IOException, SQLException;


	boolean registerUser(String user_id, String username, String password, String china_name, String user_type, String tel, String sex, String favorite, HttpServletRequest request) throws IOException, SQLException;

	Map<String, Object>  borrowed_record(String book_id, String title, String author, String bb_date, String peality_date, String return_date, HttpServletRequest request) throws IOException, SQLException;
	boolean isempty(String user_id, HttpServletRequest request) throws IOException, SQLException;
	boolean borrowbook(String user_id, String bb_id, String bb_date, String book_id, String title, String author, String peality_date, String return_date,  String state, HttpServletRequest request) throws IOException, SQLException;
	boolean returnbook(String ID, HttpServletRequest request) throws IOException, SQLException;
	List<Map<String, Object>> getHotBooks(HttpServletRequest request) throws IOException, SQLException;
	List<Map<String, Object>> getLikeBooks(HttpServletRequest request) throws IOException, SQLException;
	List<Map<String, Object>> getWholeBooks(HttpServletRequest request) throws IOException, SQLException;
}
