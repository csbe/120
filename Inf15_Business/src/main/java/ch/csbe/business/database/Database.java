package ch.csbe.business.database;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ch.csbe.business.helper.AnnotatedClassLoader;

public class Database {
	
	private static Database instance;
	private Configuration config;
	private SessionFactory sessions;
	private Session session;
	
	public static Database getInstance(){
		if(instance == null){
			try {
				instance = new Database();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	private Database() throws IOException{
		this.config = new Configuration()
//	    .addAnnotatedClass(Ort.class)
//	    .addAnnotatedClass(Mitglied.class)
//	    .addAnnotatedClass(Amt.class)
//	    .addAnnotatedClass(Politik.class)
//	    .addAnnotatedClass(Kommission.class)
				;
		AnnotatedClassLoader.appendAnnotatedClasses(this.config, "ch.csbe.business.model");
		this.sessions = this.config.buildSessionFactory();
	}
	
	public void openSession(){
		if(this.sessions == null || this.sessions.isClosed()){
			this.sessions = this.config.buildSessionFactory();
		}
		if(this.session == null || !this.session.isOpen())
			this.session = this.sessions.openSession();
	}
	
	public Session getSession(){
		return this.session;
	}
	
	public void closeSession(){
		this.session.close();
	}
	
	public void closeConnection(){
		if(this.session.isOpen()){
			this.session.close();
		}
		this.sessions.close();
	}
	
	
}