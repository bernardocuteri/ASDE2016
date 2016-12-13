package it.unical.login.persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.unical.login.model.Credentials;
import it.unical.login.persistence.DBHandler.Operation;

@Component("UsersDAO")
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private DBHandler dBHandler;
	
	@Override
	public boolean saveCredentials(Credentials c) {
		dBHandler.performOperation(c, Operation.SAVE);
		return true;
	}

	@Override
	public boolean checkCredentials(Credentials c) {
	
		Session session = dBHandler.openSession();
		Query q = session.createQuery("from Credentials where username =:u and password= :p");
		q.setParameter("u", c.getUsername());
		q.setParameter("p", c.getPassword());
		boolean returningValue =  !q.list().isEmpty();
		session.close();
		return returningValue;
		
		
		
	}

}
