/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.learnit.eticket.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.learnit.eticket.be.Cliente;

/**
 *
 * @author GERSON REVATTA
 */
public class ClienteDA {
    
    public void insertar(Cliente cliente) throws SQLException{
        Connection connection = ConnectionDA.getConexion();
        String query = "INSERT INTO CLIENTE (CODIGO ,RAZONSOCIAL ,NRODOCUMENTO, DIRECCION ,TELEFONO,ROWSTATUS,TIPO ) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        //falta agregar  ser bastante incicivo
        stmt.setString(1,cliente.getCodigo());
        stmt.setString(2,cliente.getRazon());
        stmt.setString(3,cliente.getRuc_Dni());
        stmt.setString(4,cliente.getDireccion());
        stmt.setString(5,cliente.getTelefono());
        stmt.setString(6,cliente.getRowStatus());
        stmt.setString(7,cliente.getTipo());
        stmt.executeUpdate();
        stmt.close();
        connection.close();
        
        
    }
    public List<Cliente> buscar(String codigo,String razon ,String tipo) throws SQLException{
    Connection connection = ConnectionDA.getConexion();
    String query = "SELECT CODIGO, RAZONSOCIAL , NRODOCUMENTO , DIRECCION ,TELEFONO  " +
                   " FROM CLIENTE WHERE ROWSTATUS='1' " +
                   " AND CODIGO LIKE ? " +
                   " AND RAZONSOCIAL LIKE ?"+
                   " AND TIPO LIKE ?" ;
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setString(1,"%"+codigo+"%");
    stmt.setString(2,"%"+razon+"%");
    stmt.setString(3,"%"+tipo+"%");
    //stmt.setString(3,""++"");
    ResultSet result = stmt.executeQuery();
    ArrayList listaClientes = new ArrayList();
    while(result.next()){
    Cliente cliente = new Cliente();
    cliente.setCodigo(result.getString("CODIGO"));
    cliente.setRazon(result.getString("RAZONSOCIAL"));
    cliente.setRuc_Dni(result.getString("NRODOCUMENTO"));
    cliente.setDireccion(result.getString("DIRECCION"));
    cliente.setTelefono(result.getString("TELEFONO"));
    
    listaClientes.add(cliente);
    }
    stmt.close();
    connection.close();
    return listaClientes;
    }
    
     public void eliminar (String codigo) throws SQLException{
    Connection connection = ConnectionDA.getConexion();
    String query = "UPDATE CLIENTE SET ROWSTATUS='0' WHERE CODIGO=?";
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
    
    
    
    
    
    
    
    public void modificar(Cliente cliente) throws SQLException{
    
   
         Connection connection = ConnectionDA.getConexion();
         String query = "UPDATE CLIENTE SET RAZONSOCIAL = ? , NRODOCUMENTO = ? ,DIRECCION = ? , TELEFONO = ? ,TIPO = ?    WHERE CODIGO=?" ;
         PreparedStatement ps = connection.prepareStatement(query);
         
         ps.setString(1,cliente.getRazon() );
         ps.setString(2,cliente.getRuc_Dni() );
         ps.setString(3,cliente.getDireccion() );
         ps.setString(4,cliente.getTelefono() );
         ps.setString(5,cliente.getTipo());
         ps.setString(6,cliente.getCodigo() );
         
         
         ps.executeUpdate();
         ps.close();
         connection.close();
        
    }
    
    
     public Cliente getByCodigo(String codigo) throws SQLException{
        Connection connection = ConnectionDA.getConexion();
        String query = "SELECT CODIGO, RAZONSOCIAL, NRODOCUMENTO,DIRECCION,TELEFONO , TIPO  FROM CLIENTE WHERE CODIGO =  ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,  codigo);
        ResultSet rs = ps.executeQuery();
        Cliente cliente = new Cliente();
        if (rs.next()){
    cliente.setCodigo(rs.getString("CODIGO"));
    cliente.setRazon(rs.getString("RAZONSOCIAL"));
    cliente.setRuc_Dni(rs.getString("NRODOCUMENTO"));
    cliente.setDireccion(rs.getString("DIRECCION"));
    cliente.setTelefono(rs.getString("TELEFONO"));
    cliente.setTipo(rs.getString("TIPO"));
        }else
            cliente = null;
        
        ps.close();
        connection.close();
        return cliente;
    }
   

}