package it.unical.login.persistence;

import it.unical.login.model.Credentials;

public interface UsersDAO {

	public boolean saveCredentials(Credentials c);
	
	public boolean checkCredentials(Credentials c);
	
}
