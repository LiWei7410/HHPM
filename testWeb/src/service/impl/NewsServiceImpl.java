package service.impl;

import java.util.Date;
import java.util.List;

import Dao.DaoFactory;
import Dao.NewsDao;
import entity.News;
import service.NewsService;



public class NewsServiceImpl implements NewsService{
	private NewsDao dao = DaoFactory.createNewsDao();

	@Override
	public int delete(int id) {
		return dao.delete(id);
	}
	public int save(News news) {
		news.setTimes(new Date());
		// TODO Auto-generated method stub
		return dao.save(news);
	}

	public int update(News news) {
		return dao.update(news);
	}

	@Override
	public News get(int id) {
		return dao.findById(id);
	}

	@Override
	public List<News> get() {
		return dao.findAll();
	}

	@Override
	public List<News> getTopTen() {
		return dao.findTopTen();
	}

}
