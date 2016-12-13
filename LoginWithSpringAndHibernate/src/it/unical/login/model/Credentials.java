package it.unical.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Credentials implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6456130890653537598L;
	
	public Credentials() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	int id;

	
	@Column
	private String username;
	@Column
	private String password;

	
	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
