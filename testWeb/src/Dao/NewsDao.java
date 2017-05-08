package Dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	/**
	 * ������Ŷ���
	 * @param news
	 * @return
	 */
	public int save(News news);
	/**
	 * �޸����Ŷ���
	 * @param news
	 * @return
	 */
	public int update(News news);
	/**
	 * ɾ�����Ŷ���
	 * @param news
	 * @return
	 */
	public int delete(News news);
	/**
	 * ����idɾ��ָ��������
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * ����id��ȡӦ�Եļ�¼
	 * @param id
	 * @return
	 */
	public News findById(int id);
	/**
	 * �������е����� 
	 * @return
	 */
	public List<News> findAll();
	public List<News> findByIds(String ids);
	/**
	 * ����������ӵ�10������
	 * @return
	 */
	public List<News> findTopTen();

}
