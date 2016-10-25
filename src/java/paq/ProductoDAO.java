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
                p.setNombre(rs.getString("nombre"));
                list.add(p);
            }
        }catch(SQLException e){ System.out.println(e);}
        return list;
    }
    
}
