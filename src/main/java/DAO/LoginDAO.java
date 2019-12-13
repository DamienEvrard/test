/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.Client;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Quentin
 */
public class LoginDAO {
    private final DataSource ds;
    private String emailAdmin = "admin";
    private String mdpAdmin = "admin";
    
      public LoginDAO(DataSource dataSource) {
    
        this.ds = dataSource;
    }
      
       public boolean getLogin(String email, String pf_id) throws SQLException{//Si les paramètres de login sont vérifies return le customer
       
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID="+pf_id;
		try (Connection connection = ds.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String mail = rs.getString("EMAIL");
                            if(email.equals(mail)){//Si les identifiants sont exact on rempli le customer
                                return true;
                            }
                            
			}
                }
        return false;
    }
       
    public boolean isAdmin(String email, String mdp){
        return email.equals(emailAdmin) && mdp.equals(mdpAdmin);
    }
}
