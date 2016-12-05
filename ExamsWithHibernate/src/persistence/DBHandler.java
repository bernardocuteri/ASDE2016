package persistence;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBHandler {
	
	public enum Operation {SAVE, UPDATE, DELETE};
	
	private static DBHandler instance;
	public static DBHandler getInstance() {
		if(instance==null) {
			instance = new DBHandler();
		}
		return instance;
	}
	
	private SessionFactory sessionFactory;
	
	public DBHandler() {
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		sessionFactory = config.buildSessionFactory(builder.build());
	}
	
	public void performOperation(Object object, Operation op) {
		
		Session session = sessionFactory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			switch (op) {
			case SAVE:
				session.save(object);
				break;
			case UPDATE:
				session.update(object);
				break;
			case DELETE:
				session.delete(object);
				break;
			default:
				break;
			}
			
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	
		
	

}
