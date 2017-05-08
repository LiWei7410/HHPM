package Dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.NewsDao;
import common.DBUtils;
import common.RowConverter;
import entity.News;
import exception.DataAccessException;

public class NewsDaoImpl implements NewsDao,RowConverter<News>{
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
	public int save(News news) {
		/*try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("insert into t_news values(seq_t_news_id.nextval, ?, ?, ?, ?)")){
				//设置参数
				ps.setString(1, news.getBt());
				ps.setString(2, news.getNr());
				ps.setString(3, news.getZz());
				ps.setDate(4, new java.sql.Date(news.getTimes().getTime()));
				//执行sql
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException("保存新闻失败：", e);
		}*/
	    return	DBUtils.executeUpdate("insert into t_news values(seq_t_news_id.nextval, ?, ?, ?, ?)", news.getBt(),news.getNr(),news.getZz(),new java.sql.Date(news.getTimes().getTime()));
	}
	@Override
	public int update(News news) {
/*		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("update t_news set  bt=?, nr=?, zz=?, times=? where id=?")){
				//设置参数
				ps.setString(1, news.getBt());
				ps.setString(2, news.getNr());
				ps.setString(3, news.getZz());
				ps.setDate(4, new java.sql.Date(news.getTimes().getTime()));
				ps.setInt(5, news.getId());
				//执行sql
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException("保存新闻失败：", e);
		}*/
		  return	DBUtils.executeUpdate("update t_news set  bt=?, nr=?, zz=?, times=? where id=?", news.getBt(),news.getNr(),news.getZz(),new java.sql.Date(news.getTimes().getTime()));
	}

	@Override
	public int delete(News news) {
		return 0;
	}

	@Override
	public int delete(int id) {
		/*try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("delete from t_news where id=?")){
				//设置参数
				ps.setInt(1, id);
				
				//执行sql
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException("删除失败：", e);
		}*/
		 return	DBUtils.executeUpdate("delete from t_news where id=?", id);
	}

	@Override
	public News findById(int id) {
		 
		/*try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("select id, bt, nr, zz, times from t_news where id=?")){
				ps.setInt(1, id);
				//执行sql
				try(ResultSet rs = ps.executeQuery()){
					
				if(rs.next()){//是否还存在数据
						//行与对象的转换
						News news = new News();
						news.setId(rs.getInt("id"));
						news.setBt(rs.getString("bt"));
						news.setNr(rs.getString("nr"));
						news.setZz(rs.getString("zz"));
						news.setTimes(rs.getDate("times"));
						return news;
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException("失败：", e);
		}
		return null;*/
		List<News> list= DBUtils.executeQuery(this, "select id, bt, nr, zz, times from t_news where id=?",id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<News> findAll() {
		/*List<News> list = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD)){
			try(PreparedStatement ps = conn.prepareStatement("select id, bt, nr, zz, times from t_news")){
				//执行sql
				try(ResultSet rs = ps.executeQuery()){
					News news = null;
					while(rs.next()){//是否还存在数据
						//行与对象的转换
						news = new News();
						news.setId(rs.getInt("id"));
						news.setBt(rs.getString("bt"));
						news.setNr(rs.getString("nr"));
						news.setZz(rs.getString("zz"));
						news.setTimes(rs.getDate("times"));
						list.add(news);
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException("保存新闻失败：", e);
		}
		return list;*/
		return DBUtils.executeQuery(this, "select id, bt, nr, zz, times from t_news");
	}
	@Override
	public List<News> findByIds(String ids) {
		/*
		List<News> list = new ArrayList<>();
		try(Connection conn = DBUtils.getConnection()){
			try(PreparedStatement ps = conn.prepareStatement("select id, title, create_at, author, content, source from t_news where id in(" + ids + ")")){
				//执行sql
				try(ResultSet rs = ps.executeQuery()){
					News news = null;
					while(rs.next()){//是否还存在数据
						//行与对象的转换
						news = new News();
						news.setId(rs.getInt("id"));
						news.setTitle(rs.getString("title"));
						news.setCreateAt(rs.getTimestamp("create_at"));
						news.setAuthor(rs.getString("author"));
						news.setContent(rs.getString("content"));
						news.setSource(rs.getString("source"));
						list.add(news);
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException("查询新闻失败：", e);
		}
		return list;*/
		return DBUtils.executeQuery(this, "select id, title, create_at, author, content, source from t_news where id in(" + ids + ")");
	}

	@Override
	public List<News> findTopTen() {
		return null;
	}
	@Override
	public News convert(ResultSet rs) {
		News news=new News();
		try {
			news.setId(rs.getInt("id"));
			news.setBt(rs.getString("bt"));
			news.setNr(rs.getString("nr"));
			news.setZz(rs.getString("zz"));
			news.setTimes(rs.getDate("times"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

}
