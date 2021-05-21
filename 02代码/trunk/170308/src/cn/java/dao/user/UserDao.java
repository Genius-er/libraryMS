package cn.java.dao.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
	String userLogin(String user_id, String password) throws IOException, SQLException;
	Map<String, Object> selectUser(String user_id) throws IOException, SQLException;
	boolean updateUser(String user_id, String password, String username, String tel, String sex, String favorite) throws IOException, SQLException;

	boolean registerUser(String user_id, String username, String password, String china_name, String user_type, String tel, String sex, String favorite) throws IOException, SQLException;
	Map<String, Object> borrowed_record(String book_id, String title, String author, String bb_date, String peality_date, String return_date) throws IOException, SQLException;

	boolean isempty(String ID) throws IOException, SQLException;
	boolean borrowbook(String user_id, String bb_id, String bb_date, String book_id, String title, String author, String peality_date, String return_date, String ID) throws IOException, SQLException;
	boolean returnbook(String ID) throws IOException, SQLException;
	List<Map<String, Object>> getHotBooks() throws IOException, SQLException;
	List<Map<String, Object>> getLikeBooks() throws IOException, SQLException;
	List<Map<String, Object>> getWholeBooks() throws IOException, SQLException;
}

