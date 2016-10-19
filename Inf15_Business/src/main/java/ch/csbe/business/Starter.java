package ch.csbe.business;

import org.hibernate.query.Query;

import ch.csbe.business.database.Dao;
import ch.csbe.business.database.Database;
import ch.csbe.business.model.Person;

public class Starter {

	public static void main(String[] args) {
		
		
//		Dao<Person> dao = new Dao<Person>();
//		
//		for(Person p : dao.filter("from Person where name=:name", new String[][]{{"name","Buchs"}})){
//			System.out.println(p.getName());
//		}
		
		
		
		Database.getInstance().openSession();
		
		
		Person pers = new Person("Gartenmann");
//		
//		Query<Person> query1 = Database.getInstance().getSession().createQuery("from Person where id = :id");
//		query1.setParameter("id", 1);
//		Person pe = query1.getSingleResult();
//		pe.setVorname("Enrico");
//		Database.getInstance().getSession().update(pe);
		
		int id = (Integer) Database.getInstance().getSession().save(pers);
		System.out.println(id);
		//Database.getInstance().getSession().flush();
		
		
		Query<Person> query = Database.getInstance().getSession().createQuery("from Person");
		
		
		for(Person p : query.getResultList()){
			System.out.println(p.getName());
		}
		
		Database.getInstance().closeConnection();

	}

}
