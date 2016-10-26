/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class ClienteDAO {
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen2p","root","");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return con;
    }
    
    public static List<Cliente> getAllRecords(){
        
        List<Cliente> list = new ArrayList<>();
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from cliente");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente u = new Cliente();
                u.setId(rs.getInt("id_c"));
                u.setSaldo(rs.getInt("saldo"));
                u.setNombre(rs.getString("nom"));
                list.add(u);
            }
            System.out.println("Todos los records se hanalmacenado");
        }catch(SQLException e){ System.out.println(e);}
        return list;
    }
    
    public static Cliente getRecordById(int id){
        Cliente c = new Cliente();
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from cliente where id_c=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if(rs != null){
                c.setId(rs.getInt("id_c"));
                c.setNombre(rs.getString("nom"));
                c.setSaldo(rs.getInt("saldo"));
            }
            
            System.out.println("El usuario ha sido obtenido por su ID");
        } catch (Exception e) {
            System.out.println("Error en la query!!");
            System.out.println(e);
        }
        System.out.println(c);
        return c;
    }
    
    public static int update(Cliente c){
        
        Connection con = getConnection();
        int res = -1;
        
//        c = new Cliente();
//        c.setId(2); c.setNombre("Geras"); c.setSaldo(9999);
        
        try {
            PreparedStatement ps = con.prepareStatement("update cliente set nom=? , saldo=? where id_c=?");
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getSaldo());
            ps.setInt(3, c.getId());
            
            res = ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return res;
    }
}
