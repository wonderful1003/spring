package test2;

import java.sql.SQLException;

import org.junit.runner.JUnitCore;

public class User {
	String id;
	String name;
	String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static void main(String[] args) throws SQLException{
		JUnitCore.main("test2.UserDaoTest");
	}
}


