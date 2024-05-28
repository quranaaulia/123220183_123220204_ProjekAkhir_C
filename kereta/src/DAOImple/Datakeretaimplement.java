/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImple;
import java.util.List;
import model.*;
/**
 *
 * @author 
 */
public interface Datakeretaimplement {
    public void insert(datakereta m);
    public void update(datakereta m);
    public void delete(int id_data);
    public List<datakereta> getALL();
}
