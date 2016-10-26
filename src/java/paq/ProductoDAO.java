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
public class ProductoDAO{

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
    
    public static List<Producto> getAllRecords(){
        
        List<Producto> list = new ArrayList<>();
        
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from producto");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt("id_p"));
                p.setPrecio(rs.getInt("precio"));
                p.setNombre(rs.getString("nom"));
                p.setStock(rs.getInt("stock"));
                p.setCantidad(rs.getInt("cantidad"));
                list.add(p);
            }
            System.out.println("Se Agregaron todos los productos");
        }catch(SQLException e){ System.out.println(e);}
        
//        System.out.println(list.get(0).getNombre());
        return list;
    }
    
    public static Producto getRecordById(int id){
        Producto p = new Producto();
        Connection con = getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement("select * from producto where id_p=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            //Agregar al objeto la inormacion obtenida de la base de datos;
            rs.next();
            p.setId(id);
            p.setNombre(rs.getString("nom"));
            p.setStock(rs.getInt("stock"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setPrecio(rs.getInt("precio"));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(p);
        return p;
    }
    
    public static int update(Producto p){
        int res = 0;
        
        Connection con = getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement("update producto set nom=?, stock=?, cantidad=?, precio=? where id_p=?");
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getStock());
            ps.setInt(3, p.getCantidad());
            ps.setInt(4, p.getPrecio());
            ps.setInt(5, p.getId());
            
            res = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return res;
    }
    
}
