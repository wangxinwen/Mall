package tw.roysu.mall.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import tw.roysu.mall.dao.IBaseDao;

/**
 * Dao基礎建設, 繼承需宣告T為哪個Entity
 */
public class BaseDao<T extends Serializable> implements IBaseDao<T> {
	
	/**
	 * Entity
	 */
	private Class<T> clazz;
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public BaseDao() {
		
	}
	
	public BaseDao(final Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public int save(T entity) {
		return (int) getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void merge(T entity) {
		getSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createCriteria(clazz).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findOrderByIdDesc(int begin, int size) {
		Criteria criteria = getSession().createCriteria(clazz);
		criteria.addOrder(Order.desc("id"));
		criteria.setFirstResult(begin);
		criteria.setMaxResults(size);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public int count() {
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.rowCount());

		Criteria criteria = getSession().createCriteria(clazz);
		criteria.setProjection(projectionList);
		Long count = (Long) criteria.list().get(0);
		return Integer.valueOf(count.toString());
	}
	
	/**
	 * 根據欄位名稱與查詢條件, 回傳Entity
	 */
	@SuppressWarnings("unchecked")
	public T findBy(String columnName, Object value) {
		T entity = null;
        Criteria criteria = getSession().createCriteria(clazz);    
        criteria.add(Restrictions.in(columnName, new Object[]{value}));
        if(criteria.list().size() > 0) {
        	entity = (T) criteria.list().get(0); 
        }
        return entity;
    }
	
	/**
	 * 根據欄位名稱與查詢條件, 回傳Entity List
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListBy(String columnName, Object value) {
        Criteria criteria = getSession().createCriteria(clazz);    
        criteria.add(Restrictions.in(columnName, new Object[]{value}));
        return criteria.list();
    }
	
	/**
	 * 根據欄位名稱與多個查詢條件, 回傳Entity List
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListBy(String columnName, List<Integer> valueList) {
        Criteria criteria = getSession().createCriteria(clazz);    
        criteria.add(Restrictions.in(columnName, valueList));
        return criteria.list();
    }
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
