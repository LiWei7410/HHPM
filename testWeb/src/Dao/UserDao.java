package Dao;

import java.util.List;

import entity.News;
import entity.User;

public interface UserDao {
		
	public int save(User user);

	public int update(User user);
	
	public int delete(User user);
	
	public int delete(int id);
	
	public User findById(int id);
	
	public User findByName(String username);
	
	public List<User> findAll();

	public List<User> findTopTen();
	
}
