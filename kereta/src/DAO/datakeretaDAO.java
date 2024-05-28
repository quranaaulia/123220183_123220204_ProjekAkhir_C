/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOImple.Datakeretaimplement;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 
 */
public class datakeretaDAO implements Datakeretaimplement{
    Connection connection;
    
    final String select = "SELECT * FROM data";
    final String insert = "INSERT INTO data (id_data,nama,jurusan,tarif,jumlah_beli,jumlah_bayar) VALUES (?, ?, ?, ?,?,?)";
    final String update = "UPDATE data set  nama=?,jurusan=?,tarif=?,jumlah_beli=?,jumlah_bayar=? where id_data=?";
    final String delete = "DELETE from data where id_data=?";
    public datakeretaDAO(){
        connection = connector.connection();
        
    }

    @Override
    public void insert(datakereta m) {
     PreparedStatement statement = null;
        try {
         
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, m.getId_data());
            statement.setString(2, m.getNama());
            statement.setString(3, m.getJurusan());
            statement.setInt(4, m.getTarif());
            statement.setInt(5, m.getJumlah_beli());
            statement.setInt(6, m.getJumlah_bayar());
          
            statement.executeUpdate();
            ResultSet re = statement.getGeneratedKeys();
            while(re.next()){
                m.setId_data(re.getInt(1));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datakereta m) {
         PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update, statement.RETURN_GENERATED_KEYS);
statement.setString(1, m.getNama());
statement.setString(2, m.getJurusan());
statement.setInt(3, m.getTarif());
statement.setInt(4, m.getJumlah_beli());
statement.setInt(5, m.getJumlah_bayar());
statement.setInt(6, m.getId_data());

            statement.executeUpdate();
            ResultSet re = statement.getGeneratedKeys();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
    }
    
    

    @Override
    public List<datakereta> getALL() {
        List<datakereta> dm = null;
        try{
            dm = new ArrayList<datakereta>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                datakereta kereta = new datakereta ();
          
            kereta.setId_data(rs.getInt("id_data"));
            kereta.setNama(rs.getString("nama"));
            kereta.setJurusan(rs.getString("jurusan"));
            kereta.setTarif(rs.getInt("tarif"));
            kereta.setJumlah_beli(rs.getInt("jumlah_beli"));
            kereta.setJumlah_bayar(rs.getInt("jumlah_bayar"));
                dm.add(kereta);
            }
        }catch(SQLException ex){
            Logger.getLogger(datakeretaDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dm;
    }
    @Override
     public void delete(int id_data) {
        PreparedStatement statement = null;
        try { 
            statement = connection.prepareStatement(delete, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_data);
            statement.executeUpdate();
            ResultSet re = statement.getGeneratedKeys();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
    }

    
    }

    
    

