package cn.java.dao.user;

import cn.java.dao.user.UserConn;
import cn.java.dao.user.UserDao;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao{
	//user
	@Override
	public String userLogin(String user_id, String password) throws IOException, SQLException {
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("password", password);
		Map<String, Object> userMap = session.selectOne("cn.java.dao.user.UserDaoImpl.userLogin", paramMap);
		System.out.println(userMap); //测试查询结果
		String diff;

		if (Integer.parseInt(userMap.get("num").toString()) != 0&&userMap.get("user_type").toString().equals("用户")) {
			diff = "11";
			String userName = userMap.get("username").toString();
			diff = diff + ":" + userName;
			System.out.println(diff);
		} else if (Integer.parseInt(userMap.get("num").toString()) != 0&&userMap.get("user_type").toString().equals("管理员")) {
			diff = "12";
			String userName = userMap.get("username").toString();
			diff = diff + ":" + userName;
		}
		else{
			diff = " ";
		}
		return diff;
	}
	@Override
	public Map<String, Object> selectUser(String user_id) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		Map<String, Object> userMap = session.selectOne("cn.java.dao.user.UserDaoImpl.selectUser", paramMap);
		System.out.println(userMap);
		return userMap;
	}

//	@Override
//	public boolean updateUser(String ID) throws IOException, SQLException {
//		return false;
//	}


	public boolean updateUser(String user_id, String password, String username, String tel, String sex, String favorite) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("password", password);
		paramMap.put("username", username);
		paramMap.put("tel", tel);
		paramMap.put("sex", sex);
		paramMap.put("favorite", favorite);

		boolean flag = true;
		try {
			session.update("cn.java.dao.user.UserDaoImpl.updateUser", paramMap);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			flag = false;
		}
		return flag;
	}


	@Override
	public boolean registerUser(String user_id, String username, String password,  String china_name, String user_type, String tel, String sex, String favorite) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("username", username);
		paramMap.put("password", password);
		paramMap.put("china_name", china_name);
		paramMap.put("user_type", user_type);
		paramMap.put("tel", tel);
		paramMap.put("sex", sex);
		paramMap.put("favorite", favorite);

		boolean flag = true;
		try {
			session.update("cn.java.dao.user.UserDaoImpl.registerUser", paramMap);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
			System.out.println(e.toString());
		}
		return flag;
	}

	@Override
	public boolean isempty(String ID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("isbn", ID);
		System.out.println(ID);
		Map<String, Object> userMap = session.selectOne("cn.java.dao.user.UserDaoImpl.borrow1", paramMap);
		System.out.println(userMap); //测试查询结果

		if (Integer.parseInt(userMap.get("lef").toString()) == 0) {
			return false;
		}
		else {
			return true;
		}
	}


	@Override
	public boolean borrowbook(String user_id, String bb_id,  String bb_date, String book_id, String title, String author, String peality_date, String return_date, String state) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap2 = new HashMap<String, Object>();
		paramMap2.put("isbn", book_id);
		System.out.println(book_id);
		Map<String, Object> userMap = session.selectOne("cn.java.dao.user.UserDaoImpl.borrow1", paramMap2);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("bb_id", bb_id);
		paramMap.put("book_id", book_id);
		paramMap.put("isbn", book_id);
		paramMap.put("bb_date", bb_date);
		paramMap.put("peality_date", peality_date);
		paramMap.put("return_date", return_date);
		paramMap.put("state", state);

		boolean flag = true;
		try {
			session.update("cn.java.dao.user.UserDaoImpl.borrow2", paramMap);
			session.update("cn.java.dao.user.UserDaoImpl.borrow3", paramMap);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean returnbook(String ID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ID", ID);

		boolean flag = true;
		try {
			session.update("cn.java.dao.user.UserDaoHomeImpl.return", paramMap);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		return flag;
	}

	@Override
	public Map<String, Object> borrowed_record(String book_id, String title, String author, String bb_date, String peality_date, String return_date) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("book_id", book_id);
		paramMap.put("title", title);
		paramMap.put("author", author);
		paramMap.put("bb_date", bb_date);
		paramMap.put("peality_date", peality_date);
		paramMap.put("return_date", return_date);

		Map<String, Object> userMap = session.selectOne("cn.java.dao.user.UserDaoImpl.borrowed_record", paramMap);
		System.out.println(userMap);
		return userMap;
	}

	@Override
	public List<Map<String, Object>> getHotBooks() throws IOException, SQLException {
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		List<Map<String, Object>> books = session.selectList("cn.java.dao.user.UserDaoImpl.getHotBooks"); //TODO:分页还没做
		System.out.println(books); //测试查询结果

		return books;
	}

	@Override
	public List<Map<String, Object>> getLikeBooks() throws IOException, SQLException {
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		List<Map<String, Object>> books = session.selectList("cn.java.dao.user.UserDaoImpl.getLikeBooks"); //TODO:分页还没做
		System.out.println(books); //测试查询结果

		return books;
	}

	@Override
	public List<Map<String, Object>> getWholeBooks() throws IOException, SQLException {
		UserConn userConn = new UserConn();
		SqlSession session = userConn.open();

		List<Map<String, Object>> books = session.selectList("cn.java.dao.user.UserDaoImpl.getWholeBooks"); //TODO:分页还没做
		System.out.println(books); //测试查询结果

		return books;
	}
}
