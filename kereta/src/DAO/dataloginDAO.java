/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOImple.LoginImple;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kereta.Login;
/**
 *
 * @author 
 */
public class dataloginDAO implements LoginImple {
    Connection connection;
    
    final String select = "SELECT * FROM user WHERE username = ? AND password = ?;";
    final String ter ="SELECT * FROM user ;";
    
    public dataloginDAO(){
        connection = connector.connection();
        
    }

   
 
    

    @Override
    public List<datauser> getALL() {
        List<datauser> dm = null;
        try{
            dm = new ArrayList<datauser>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(ter);
            while (rs.next()){
                datauser Login = new datauser ();
          
            Login.setUser_id(rs.getInt("id_data"));
            Login.setUsername(rs.getString("nama"));
            Login.setPassword(rs.getString("password"));

                dm.add(Login);
            }
        }catch(SQLException ex){
            Logger.getLogger(datakeretaDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dm; }

   
    public void insert(String username, String password, boolean isValid) {
                PreparedStatement statement = null;
    try {
   statement = connection.prepareStatement(select, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
}

    public boolean validateLogin(String username, String password) {
        boolean isValid = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(select);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isValid;  }

    @Override
    public void insert(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
