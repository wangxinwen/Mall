package tw.roysu.mall.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Dao基礎建設, 繼承需宣告T為哪個Entity
 */
public interface IBaseDao<T extends Serializable> {

	/**
	 * 新增Entity, 回傳ID
	 */
	public int save(T entity);

	/**
	 * 修改Entity
	 */
	public void update(T entity);

	/**
	 * 新增或修改Entity, 用ID區別功能
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 合併Entity
	 */
	public void merge(T entity);

	/**
	 * 刪除Entity
	 */
	public void delete(T entity);

	/**
	 * 查詢整個Table, 取得Entity List
	 */
	public List<T> findAll();

	/**
	 * 查詢Entity List, 傳入開始筆數與List筆數, 根據ID由新至舊排序
	 */
	public List<T> findOrderByIdDesc(int begin, int size);

	/**
	 * 根據ID, 查詢Entity
	 */
	public T findById(int id);

	/**
	 * 查詢Entity總數量
	 */
	public int count();

}
