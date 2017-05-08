package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DataAccessException;

public class DBUtils {
	private static final String CONNECTION_STRING = "jdbc:oracle:thin:@//localhost:1521/orcl";
	private static final String USER_NAME = "scott";
	private static final String PASSWORD = "accp";
	private static String url;
	private static String username;
	private static String password;
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void initDBInfo(String url, String username, String password){
		DBUtils.url = url;
		DBUtils.username = username;
		DBUtils.password = password;
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
	}
	public static int executeUpdate(String sql, Object... params){
		if(Utils.isEmpty(sql)) return 0;
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params.length > 0){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}
	
	//查
	public static <T> List<T> executeQuery(RowConverter<T> converter,String sql, Object... params){
		List<T> list= new ArrayList<>();
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params.length > 0){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					T entity=converter.convert(rs);
					list.add(entity);
				}
				
			}
		}catch(Exception e){
			throw new DataAccessException(e);
		}
		
		return list;
	}

}
