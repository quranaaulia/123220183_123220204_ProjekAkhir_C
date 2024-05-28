/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author 
 */
public class modeltabelkereta extends AbstractTableModel{
    List<datakereta> dm;
    public modeltabelkereta(List<datakereta>dm){
        this.dm = dm;
    }
    
    @Override
    public int getRowCount() {
     return dm.size();
    }

    @Override
    public int getColumnCount() {
     return 6;
    }

    @Override
    public String getColumnName(int  column){
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nama";
            case 2:
                return "Jurusan";
            case 3:
                return "Tarif";
            case 4:
                return "Jumlah_beli";
            case 5:
                return "Jumlah_bayar";
            default:
                return null; 
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dm.get(row).getId_data();
            case 1:
                return dm.get(row).getNama();
            case 2:
                return dm.get(row).getJurusan();
            case 3:
                return dm.get(row).getTarif();
            case 4:
                return dm.get(row).getJumlah_beli();
            case 5:
                return dm.get(row).getJumlah_bayar();
            default:
                return null; 
        }
    }
    
}
