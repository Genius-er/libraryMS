package cn.java.dao.manager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.http.HttpServletRequest;

public class ManagerDaoImpl implements ManagerDao {
	//manager
	@Override
	public boolean managerLogin(String user_id, String password) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("password", password);
		Map<String, Object> managerMap = session.selectOne("cn.java.dao.manager.ManagerDaoImpl.managerLogin", paramMap);
		System.out.println(managerMap); //测试查询结果

		if (Integer.parseInt(managerMap.get("num").toString()) == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean addUser(String user_id, String password, String china_name, String tel, String sex, String user_type) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("username", user_id);
		paramMap.put("password", password);
		paramMap.put("china_name", china_name);
		paramMap.put("tel", tel);
		paramMap.put("sex", sex);
		paramMap.put("user_type", user_type);

		boolean flag = true;
		try {
			session.insert("cn.java.dao.manager.ManagerDaoImpl.AddUser", paramMap);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean updateUser(String user_id, String username, String password, String china_name, String tel, String sex, String user_type) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("username", username);
		paramMap.put("password", password);
		paramMap.put("china_name", china_name);
		paramMap.put("tel", tel);
		paramMap.put("sex", sex);
		paramMap.put("user_type", user_type);

		System.out.println(paramMap);

		boolean flag = true;
		try {
			session.update("cn.java.dao.manager.ManagerDaoImpl.UpdateUser", paramMap);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean checkManager(String user_id) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> managerMap = session.selectOne("cn.java.dao.manager.ManagerDaoImpl.checkManager", user_id);
		System.out.println(managerMap); //测试查询结果

		if (managerMap.get("user_type").toString().equals("管理员")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteUser(String user_id) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);

		boolean flag = true;
		try {
			session.delete("cn.java.dao.manager.ManagerDaoImpl.deleteUser", paramMap);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Map<String, Object>> getAllBooks(String page, String booktype_name) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		System.out.println("这是书的类型 "+ booktype_name);
		int pageInt = Integer.parseInt(page);
		int current_index = pageInt * 10 - 10;

		Map<String, Object> total = session.selectOne("cn.java.dao.manager.ManagerDaoImpl.getBooksTotal");

        List<Map<String, Object>> books;
        if (booktype_name.equals("")) {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("current_index", current_index);
            books = session.selectList("cn.java.dao.manager.ManagerDaoImpl.getAllBooks", paramMap);
        }
        else {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("booktype_name", booktype_name);
            books = session.selectList("cn.java.dao.manager.ManagerDaoImpl.getAllBooksByType", paramMap);
        }

		books.add(0, total);

		System.out.println(books); //测试查询结果
		return books;
	}

	@Override
	public Map<String, List<String>> getBookType() throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		List<String> bookTypeList = new ArrayList<String>();;

		List<Map<String, Object>> bookType = session.selectList("cn.java.dao.manager.ManagerDaoImpl.ManagerGetBookType");

		for (int i = 0; i < bookType.size(); i++) {
			//System.out.println(bookType.get(i).get("booktype_name"));
			bookTypeList.add(bookType.get(i).get("booktype_name").toString());
		}

		//System.out.println(bookTypeList); //测试查询结果

		Map<String, List<String>> bookTypeMap = new HashMap<>();
		bookTypeMap.put("booktype_name", bookTypeList);
		//System.out.println(bookTypeMap); //测试查询结果

		return bookTypeMap;
	}

	@Override
	public boolean deleteBook(String book_id) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("book_id", book_id);

		boolean flag = true;
		try {
			session.delete("cn.java.dao.manager.ManagerDaoImpl.deleteBook", paramMap);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Map<String, Object>> searchBook(String name) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		List<Map<String, Object>> books = session.selectList("cn.java.dao.manager.ManagerDaoImpl.searchBook", name); //TODO:分页还没做
		System.out.println(books); //测试查询结果

		return books;
	}

	@Override
	public List<Map<String, Object>> getAllUsers() throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		List<Map<String, Object>> users = session.selectList("cn.java.dao.manager.ManagerDaoImpl.getAllUsers");
		System.out.println(users); //测试查询结果

		return users;
	}

	@Override
	public boolean managerAddBook(String title, String author, String isbn, String publish, String booktype_name, String cover) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("author", author);
		paramMap.put("isbn", isbn);
		paramMap.put("publish", publish);
		paramMap.put("booktype_name", booktype_name);
		paramMap.put("cover", cover);

		boolean flag = true;
		try {
			session.insert("cn.java.dao.manager.ManagerDaoImpl.managerAddBook", paramMap);
			session.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			flag = false;
		}
		return flag;

	}

	@Override
	public boolean managerModifyBook(String title, String author, String isbn, String publish, String booktype_name, String cover,String book_id) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("book_id", Integer.parseInt(book_id));
		paramMap.put("title", title);
		paramMap.put("author", author);
		paramMap.put("isbn", isbn);
		paramMap.put("publish", publish);
		paramMap.put("booktype_name", booktype_name);
		paramMap.put("cover", cover);

		boolean flag = true;
		try {
			session.update("cn.java.dao.manager.ManagerDaoImpl.managerModifyBook", paramMap);
			session.commit();
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	@Override
	public Map<String, Object> getBookInfoById(String book_id) throws IOException, SQLException {
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("book_id", Integer.parseInt(book_id));

		boolean flag = true;
		try {
			Map<String, Object> managerMap = session.selectOne("cn.java.dao.manager.ManagerDaoImpl.mangerModifyBookSearchById", paramMap);
			System.out.println(managerMap); //测试查询结果
			return managerMap;
		} catch (Exception e) {
			flag = false;
		}
		return null;
	}

	public Map<String, Object> ManagerSelectUser(String user_id) throws IOException, SQLException{
		ManagerConn managerConn = new ManagerConn();
		SqlSession session = managerConn.open();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", Integer.parseInt(user_id));
		Map<String, Object> userInfo = session.selectOne("cn.java.dao.manager.ManagerDaoImpl.ManagerSelectUser", paramMap);
		System.out.println(userInfo); //测试查询结果

		return userInfo;
	}
}
