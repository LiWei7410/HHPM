package Dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	/**
	 * 添加新闻对象
	 * @param news
	 * @return
	 */
	public int save(News news);
	/**
	 * 修改新闻对象
	 * @param news
	 * @return
	 */
	public int update(News news);
	/**
	 * 删除新闻对象
	 * @param news
	 * @return
	 */
	public int delete(News news);
	/**
	 * 根据id删除指定的新闻
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据id获取应对的记录
	 * @param id
	 * @return
	 */
	public News findById(int id);
	/**
	 * 返回所有的新闻 
	 * @return
	 */
	public List<News> findAll();
	public List<News> findByIds(String ids);
	/**
	 * 返回最新添加的10条新闻
	 * @return
	 */
	public List<News> findTopTen();

}
