package net.ddns.thozz.classproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao{
	Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    private String url = "jdbc:mysql://127.0.0.1:3306/testdb";
    //should i hard wire this part?
    private String user = "root";
    private String password = "qwerty123";

    public UserDaoImpl() throws ClassNotFoundException{
    try {
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        Class.forName("com.mysql.jdbc.Driver");
    }
     catch (SQLException ex) {
        Logger lgr = Logger.getLogger(UserDaoImpl.class.getName());
        lgr.log(Level.SEVERE, ex.getMessage(), ex);
        System.out.println("Error: " + ex);
        }
    } 

    public void DatabaseDisconnect(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserDaoImpl.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);
            System.out.println("Error: " + ex);
            }   
    }

	@Override
	public Boolean authUser(User user) throws ClassNotFoundException {
		String tempUser="temp";
    	String tempPass="temp";
    	
		try{
            String query = "select * from users where username = " + "\'" + user.getUserName() +"\'";
            rs = st.executeQuery(query);
            
            while(rs.next()){
                tempUser = rs.getString("username");
                tempPass = rs.getString("password");    
            }
            
        }
        catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
    	
    	if(tempUser.equals(user.getUserName()) && tempPass.equals(user.getPassword())){
    		System.out.println("Logged in as:\t" + tempUser);
    		DatabaseDisconnect();
    		return true;
        }
        else{
        	return false;
        }
	}
}
