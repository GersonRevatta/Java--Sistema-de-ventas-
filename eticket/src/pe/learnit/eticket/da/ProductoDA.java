package pe.learnit.eticket.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.learnit.eticket.be.Producto;

public class ProductoDA {
    public void insertar(Producto producto) throws SQLException {
    Connection connection = ConnectionDA.getConexion();
    String query = "INSERT INTO PRODUCTO (CODIGO,DESCRIPCION,PRECIOUNITARIO,ROWSTATUS) VALUES(?,?,?,?)";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1,producto.getCodigo());
    stmt.setString(2,producto.getDescripcion());
    stmt.setDouble(3,producto.getPrecioUnitario());
    stmt.setString(4,producto.getRowStatus());
    stmt.executeUpdate();
    stmt.close();
    connection.close();
    
        }
    public List<Producto> buscar(String codigo,String descripcion) throws SQLException{
    Connection connection = ConnectionDA.getConexion();
    String query = "SELECT CODIGO, DESCRIPCION, PRECIOUNITARIO" +
                   " FROM PRODUCTO WHERE ROWSTATUS='1' " +
                   " AND CODIGO LIKE ? " +
                   " AND DESCRIPCION LIKE ? ";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1,"%"+codigo+"%");
    stmt.setString(2,"%"+descripcion+"%");
    ResultSet result = stmt.executeQuery();
    ArrayList listaProductos = new ArrayList();
    while(result.next()){
    Producto producto = new Producto();
    producto.setCodigo(result.getString("CODIGO"));
    producto.setDescripcion(result.getString("DESCRIPCION"));
    producto.setPrecioUnitario(result.getDouble("PRECIOUNITARIO"));
    listaProductos.add(producto);
    }
    stmt.close();
    connection.close();
    return listaProductos;
    }
    public void eliminar (String codigo) throws SQLException{
    Connection connection = ConnectionDA.getConexion();
    String query = "UPDATE PRODUCTO SET ROWSTATUS='0' WHERE CODIGO=?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1,codigo);
    stmt.executeUpdate();
    stmt.close();
    connection.close(); 
    }
    
    public boolean existe (String codigo) throws SQLException{
         Connection connection = ConnectionDA.getConexion();
    String query = "SELECT CODIGO FROM PRODUCTO WHERE CODIGO=?";
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1,codigo);
    
    ResultSet result=stmt.executeQuery();
    boolean existe= result.next();
    
    stmt.close();
    connection.close(); 
    
        
        
        return existe;
    }
    
    public void modificar(Producto producto) throws SQLException{
        Connection connection = ConnectionDA.getConexion();
       //   
        //   esta es la conexion del ejemplo Connection con = ConexionDA.GetConexion();
        String query = "UPDATE PRODUCTO SET DESCRIPCION = ?, PRECIOUNITARIO= ? WHERE CODIGO=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, producto.getDescripcion());    
        ps.setDouble(2, producto.getPrecioUnitario());
        ps.setString(3, producto.getCodigo());
        
        ps.executeUpdate();
        ps.close();
        connection.close();
    }
    
    public Producto getByCodigo(String codigo) throws SQLException{
        Connection connection = ConnectionDA.getConexion();
        String query = "SELECT CODIGO, DESCRIPCION, PRECIOUNITARIO FROM PRODUCTO WHERE CODIGO =  ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,  codigo);
        ResultSet rs = ps.executeQuery();
        Producto producto = new Producto();
        if (rs.next()){
            producto.setCodigo(rs.getString("CODIGO"));
            producto.setDescripcion(rs.getString("DESCRIPCION"));
            producto.setPrecioUnitario(rs.getDouble("PRECIOUNITARIO"));
        }else
            producto = null;
        
        ps.close();
        connection.close();
        return producto;
    }
}
