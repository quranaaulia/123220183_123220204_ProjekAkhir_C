/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.dataloginDAO;
import DAOImple.LoginImple;
import java.util.List;
import javax.swing.JTextField;
import kereta.Login;
import model.datauser;

/**
 *
 * @author 
 */
public class loginCont {
        Login frame;
    LoginImple impdatalogin;
    List<datauser> dm;
    
    public loginCont(Login frame){
    this.frame = frame;
    impdatalogin = new dataloginDAO();

    }

         public boolean insert(String username, String password) {
        return ((dataloginDAO) impdatalogin).validateLogin(username, password);
    }

    public boolean validateLogin(String Username, String Password) {
        return ((dataloginDAO) impdatalogin).validateLogin(Username, Password);
    }
}
