package ch.csbe.business.database;

import java.util.List;

import org.hibernate.query.Query;

public class Dao<E> {

	
	public Dao(){
		
		
		Database.getInstance().openSession();
	}
	

	public Integer save(E obj){
		Integer id = (Integer) Database.getInstance().getSession().save(obj);
		Database.getInstance().getSession().flush();
		return id;
	}
	
	public void update(E obj){
		Database.getInstance().getSession().update(obj);
		Database.getInstance().getSession().flush();
	}
	
	public void delete(E obj){
		Database.getInstance().getSession().delete(obj);
		Database.getInstance().getSession().flush();
	}
	
	public List<E> list(String from){
		@SuppressWarnings("unchecked")
		Query<E> query = (Query<E>) Database.getInstance().getSession().createQuery(from);
		return query.getResultList();
	}
	
	public List<E> filter(String from, String[][] params){
		@SuppressWarnings("unchecked")
		Query<E> query = (Query<E>) Database.getInstance().getSession().createQuery(from);
		
		for(String param[] : params){
			query.setParameter(param[0], param[1]);
		}
		
		return query.getResultList();
	}
	
}
