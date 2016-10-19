package ch.csbe.business;

import java.util.List;

import org.hibernate.query.Query;

import ch.csbe.business.database.Dao;
import ch.csbe.business.database.Database;
import ch.csbe.business.model.Person;

public class Starter {

	public static void main(String[] args) {
		
		
		Database.getInstance().openSession();
		Database.getInstance().getSession().beginTransaction();
		Dao<Person> dao = new Dao<Person>(Person.class);
		
		
		
//		Person p = (Person) Database.getInstance().getSession().getNamedQuery("findPerson").setParameter("name", "Buchs").setParameter("vorname", "Enrico").uniqueResult();
//		
//		p.setVorname("Enrico");
//		
//		dao.save(p);
//		System.out.println(p.getVorname());
//		Database.getInstance().getSession().getTransaction().commit();
		
//		Person p = dao.filter("id=:id", new Object[][]{{"id",1}}).get(0);
		Person p = dao.filter("id=?", new Object[]{1}).get(0);
		p.setVorname("Muster");
		dao.save(p);
		
		for(Person pa : dao.filter("name=:name or vorname=:vorname", new Object[][]{{"name","Buchs"},{"vorname","Enrico"}})){
			System.out.println(pa.getName() + " " + pa.getVorname());
		}
//		
//		
//		Database.getInstance().openSession();
//		
//		
//		Person pers = new Person("Gartenmann");
//		
//		Query<Person> query1 = Database.getInstance().getSession().createQuery("from Person where id = :id");
//		query1.setParameter("id", 1);
//		Person pe = query1.getSingleResult();
//		pe.setVorname("Enrico");
//		Database.getInstance().getSession().update(pe);
		
//		int id = (Integer) Database.getInstance().getSession().save(pers);
//		System.out.println(id);
//		//Database.getInstance().getSession().flush();
//		
//		
//		Query<Person> query = Database.getInstance().getSession().createQuery("from Person");
//		
//		
//		for(Person p : query.getResultList()){
//			System.out.println(p.getName());
//		}
//		
		Database.getInstance().closeConnection();

	}

}
