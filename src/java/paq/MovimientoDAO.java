
package paq;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {
    
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
    
    public static List<Movimiento> getAllRecords(){
        
        List<Movimiento> lista = new ArrayList();
        
        Connection con = getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement("Select * from movimiento");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Movimiento m = new Movimiento();
                
                m.setId_m(rs.getInt("id_m"));
                m.setCantidad(rs.getInt("cantidad"));
                m.setPrecio(rs.getInt("precio"));
                m.setNom_c(rs.getString("nom_c"));
                m.setNom_p(rs.getString("nom_p"));
                lista.add(m);
            }
            System.out.println("Se leyeron todos los movimientos");
            
//            for(Movimiento mo : lista)
//                System.out.println(mo);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
    
    public static Movimiento getRecordById(int id){
        
        Connection con = getConnection();
        Movimiento m = new Movimiento();
        
        try {
            PreparedStatement ps = con.prepareStatement("Select * from movimiento where id_m=?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            m.setId_m(rs.getInt("id_m"));
            m.setCantidad(rs.getInt("cantidad"));
            m.setPrecio(rs.getInt("precio"));
            m.setNom_c(rs.getString("nom_c"));
            m.setNom_p(rs.getString("nom_p"));
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return m;
    }
    
    public static int save(Movimiento m){
        
        Connection con = getConnection();
        int res=-1;
        try {
            
            PreparedStatement ps = con.prepareStatement("Insert into movimiento (id_m,nom_c,nom_p,cantidad,precio) values (?,?,?,?,?)");
            ps.setInt(1, m.getId_m());
            ps.setString(2, m.getNom_c());
            ps.setString(3, m.getNom_p());
            ps.setInt(4, m.getCantidad());
            ps.setInt(5, m.getPrecio());
            
            res = ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return res;
    }
}
