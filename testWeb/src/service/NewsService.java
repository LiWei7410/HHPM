package service;

import java.util.List;

import entity.News;


public interface NewsService {
	public int save(News news);
	public int update(News news);
	public int delete(int id);
	public News get(int id);
	public List<News> get();
	public List<News> getTopTen();	
}
