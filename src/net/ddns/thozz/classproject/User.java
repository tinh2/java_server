package net.ddns.thozz.classproject;

public class User{
	private String userName;
	private String userPass;
	
	User(String userName, String password){
		this.userName = userName;
		this.userPass = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return userPass;
	}
	public void setPassword(String password) {
		this.userPass = password;
	}
}