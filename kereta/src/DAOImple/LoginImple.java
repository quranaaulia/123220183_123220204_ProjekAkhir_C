/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImple;

import java.util.List;
import model.datauser;

/**
 *
 * @author 
 */
public interface LoginImple {
   public void insert(String username ,String password);
   public List<datauser> getALL();
}
