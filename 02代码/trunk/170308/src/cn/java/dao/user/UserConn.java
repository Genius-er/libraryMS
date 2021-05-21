package cn.java.dao.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class UserConn {
	public SqlSession open() throws IOException, SQLException{
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		InputStream ins = Resources.getResourceAsStream("user.xml");
		SqlSessionFactory ssf = sfb.build(ins);
		SqlSession session = ssf.openSession();
		
		return session;
	}
}
