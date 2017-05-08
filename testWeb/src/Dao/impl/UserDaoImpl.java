package Dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import Dao.UserDao;
import common.DBUtils;
import entity.User;
import exception.DataAccessException;

public class UserDaoImpl implements UserDao {

	private static final String CONNECTION_STRING = "jdbc:oracle:thin:@//localhost:1521/orcl";
	private static final String USER_NAME = "scott";
	private static final String PASSWORD = "accp";
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int save(User user) {
		/*try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("insert into u_user values(seq_u_user_id.nextval, ?, ?, ?, ?)")){
				//设置参数
				ps.setString(1, user.getU_name());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getU_password());
				ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
				//执行sql
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException("保存失败：", e);
		}*/
		return	DBUtils.executeUpdate("insert into t_news values(seq_t_news_id.nextval, ?, ?, ?, ?)",user.getU_name(),user.getUsername(),user.getU_password(),new java.sql.Date(user.getBirthday().getTime()));
	}
	@Override
	public int update(User user) {
/*		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("update u_user set  u_name=?, username=?, u_password=?, u_birthday=? where u_id=?")){
				//设置参数
				ps.setString(1, user.getU_name());
				ps.setString(2, user.getUsername());
				ps.setString(3, user.getU_password());
				ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
				ps.setInt(5, user.getU_id());
				//执行sql
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException("保存失败：", e);
		}*/
		return	DBUtils.executeUpdate("update u_user set  u_name=?, username=?, u_password=?, u_birthday=? where u_id=?",user.getU_name(),user.getUsername(),user.getU_password(),new java.sql.Date(user.getBirthday().getTime()),user.getU_id());
	}

	@Override
	public int delete(User user) {
		return 0;
	}

	@Override
	public int delete(int id) {
		/*try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("delete from u_user where u_id=?")){
				//设置参数
				ps.setInt(1, id);
				
				//执行sql
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException("删除失败：", e);
		}*/
		return	DBUtils.executeUpdate("delete from u_user where u_id=?",id);
	}

	@Override
	public User findById(int id) {
		 
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("select u_id, u_name, username, u_password, u_birthday from u_user where u_id=?")){
				ps.setInt(1, id);
				//执行sql
				try(ResultSet rs = ps.executeQuery()){
					
				if(rs.next()){//是否还存在数据
						//行与对象的转换
						User user = new User();
						user.setU_id(rs.getInt("u_id"));
						user.setU_name(rs.getString("u_name"));
						user.setUsername(rs.getString("username"));
						user.setBirthday(rs.getDate("u_dirthday"));
						return user;
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException("失败：", e);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("select u_id, u_name, username, password, birthday from u_user")){
				//执行sql
				try(ResultSet rs = ps.executeQuery()){
					User user = null;
					while(rs.next()){//是否还存在数据
						//行与对象的转换
						user = new User();
						user.setU_id(rs.getInt("u_id"));
						user.setU_name(rs.getString("u_name"));
						user.setUsername(rs.getString("username"));
						user.setBirthday(rs.getDate("u_dirthday"));
						list.add(user);
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException("保存新闻失败：", e);
		}
		return list;
	}

	@Override
	public List<User> findTopTen() {
		return null;
	}
	@Override
	public User findByName(String username) {
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("select u_id, u_name, username, u_password, u_birthday from u_user where username=?")){
				ps.setString(1, username);
				//执行sql
				try(ResultSet rs = ps.executeQuery()){
					
				if(rs.next()){//是否还存在数据
						//行与对象的转换
						User user = new User();
						user.setU_id(rs.getInt("u_id"));
						user.setU_name(rs.getString("u_name"));
						user.setUsername(rs.getString("username"));
						user.setU_password(rs.getString("u_password"));
						user.setBirthday(rs.getDate("u_birthday"));
						return user;
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException("失败：", e);
		}
		return null;
	}

}
