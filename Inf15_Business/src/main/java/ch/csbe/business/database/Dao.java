package ch.csbe.business.database;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.query.Query;

/**
 * This is a simple Helper Class for work with hibernate objects
 * @author ebuchs
 *
 * @param <T> is a generic entity class 
 */
public class Dao<T> {

	final Class<T> type;


	/**
	 * The Constructor 
	 * example: new Dao(EntityClass.class)
	 * @param type is the class from Entity Class
	 */
	public Dao(Class<T> type){
		this.type = type;
		Database.getInstance().openSession();
	}
	

	/**
	 * Save the given object
	 * @param obj
	 * @return Integer the generated new id from object
	 */
	public Integer save(T obj){
		Integer id = (Integer) Database.getInstance().getSession().save(obj);
		Database.getInstance().getSession().flush();
		return id;
	}
	
	/**
	 * Update the given object
	 * @param obj
	 */
	public void update(T obj){
		Database.getInstance().getSession().update(obj);
		Database.getInstance().getSession().flush();
	}
	
	/**
	 * Delete the given object
	 * @param obj
	 */
	public void delete(T obj){
		Database.getInstance().getSession().delete(obj);
		Database.getInstance().getSession().flush();
	}
	
	/**
	 * A Method which returns a complete List Data from table
	 * @return List<T> the generic List
	 */
	public List<T> list(){
		@SuppressWarnings("unchecked")
		Query<T> query = (Query<T>) Database.getInstance().getSession().createQuery("from " + type.getAnnotationsByType(Entity.class)[0].name());
		return query.getResultList();
	}
	
	/**
	 * Filter method 
	 * example for use filter("name=:name and prename=:prename", new Object[][]{{"name","Johnson"},{"prename","Robin"}});
	 * @param where String with the filter params
	 * @param params Object[][] with the attribute name and values pairs
	 * @return List<T> the generic List
	 */
	public List<T> filter(String where, Object[][] params){
		@SuppressWarnings("unchecked")
		Query<T> query = (Query<T>) Database.getInstance().getSession().createQuery("from " + type.getAnnotationsByType(Entity.class)[0].name() 
				+ " where " + where);
		
		for(Object param[] : params){
			query.setParameter(param[0].toString(), param[1]);
		}
		
		return query.getResultList();
	}
	
	/**
	 * Filter method 
	 * example for use filter("name=? and prename=?", new Object[]{"Johnson","Robin"});
	 * @param where String with the filter params
	 * @param params Object[] with the values
	 * @return List<T> the generic List
	 */
	public List<T> filter(String where, Object[] params){
		@SuppressWarnings("unchecked")
		Query<T> query = (Query<T>) Database.getInstance().getSession().createQuery("from " + type.getAnnotationsByType(Entity.class)[0].name() 
				+ " where " + where);
		
		int i = 0;
		for(Object param : params){
			query.setParameter(i++, param);
		}
		
		return query.getResultList();
	}
	
}
