/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.*;
import DAO.datakeretaDAO;
import DAOImple.Datakeretaimplement;
import javax.swing.JOptionPane;
import model.*;
import kereta.MainView;
/**
 *
 * @author 
 */
public class datakeretacontroller {
    MainView frame;
    Datakeretaimplement impdatakereta;
    List<datakereta> dm;
    
    public datakeretacontroller(MainView frame){
    this.frame = frame;
    impdatakereta = new datakeretaDAO();
    dm = impdatakereta.getALL();
    }
    public void isitabel (){
        dm = impdatakereta.getALL();
        modeltabelkereta mm = new modeltabelkereta(dm);
        frame.getTabeldatakereta().setModel(mm);
    }
    
 public void insert(){
     datakereta dm = new datakereta();
     dm.setNama(frame.getNama().getText());
     String selectedJurusan = (String) frame.getJurusan().getSelectedItem();
     dm.setJurusan(selectedJurusan);
     String tarif = frame.getTharga().getText();
     dm.setTarif(Integer.parseInt(tarif));
     String jumlah = frame.getJumlah().getText();
     dm.setJumlah_beli(Integer.parseInt(jumlah));
     String total = frame.getTotal().getText();
     dm.setJumlah_bayar(Integer.parseInt(total));
     impdatakereta.insert(dm);
     
    }
 
 public void update() {
    try {
        datakereta dm = new datakereta();
        dm.setNama(frame.getNama().getText());
        
        String selectedJurusan = (String) frame.getJurusan().getSelectedItem();
        dm.setJurusan(selectedJurusan);

        String tarif = frame.getTharga().getText();
        if (tarif.isEmpty()) {
            throw new IllegalArgumentException("Tarif tidak boleh kosong");
        }
        dm.setTarif(Integer.parseInt(tarif));

        String jumlah = frame.getJumlah().getText();
        if (jumlah.isEmpty()) {
            throw new IllegalArgumentException("Jumlah tidak boleh kosong");
        }
        dm.setJumlah_beli(Integer.parseInt(jumlah));

        String total = frame.getTotal().getText();
        if (total.isEmpty()) {
            throw new IllegalArgumentException("Total tidak boleh kosong");
        }
        dm.setJumlah_bayar(Integer.parseInt(total));

        String idDataStr = frame.getId_data().getText();
        if (idDataStr.isEmpty()) {
            throw new IllegalArgumentException("ID data tidak boleh kosong");
        }
        dm.setId_data(Integer.parseInt(idDataStr));

        impdatakereta.update(dm);
        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Menambahkan pencatatan pengecualian ke dalam log
    }
}

  public void delete(){
int id_data = Integer.parseInt(frame.getId_data().getText());
impdatakereta.delete(id_data);

    }

}
