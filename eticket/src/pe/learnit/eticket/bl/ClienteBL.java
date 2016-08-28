/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.learnit.eticket.bl;

import java.sql.SQLException;
import java.util.List;
import pe.learnit.eticket.be.Cliente;

import pe.learnit.eticket.da.ClienteDA;




/**
 *
 * @author GERSON REVATTA
 */
public class ClienteBL {
    private ClienteDA _clienteDA;
    
    public ClienteBL(){
    _clienteDA = new ClienteDA();
    }
    
    public List<Cliente> buscar(String codigo,String razon ,String tipo) throws SQLException{
     ClienteDA clienteDA = new ClienteDA();
     return clienteDA.buscar(codigo , razon , tipo);
     }
    
    public void insertar(Cliente cliente) throws SQLException{
     
        ClienteDA clienteDA = new ClienteDA();
        clienteDA.insertar(cliente);
        
        
    }
    
    public void modificar(Cliente cliente) throws SQLException {
        _clienteDA.modificar(cliente);
    }
    
    
     public void eliminar (String codigo) throws SQLException{
        ClienteDA clienteDA = new ClienteDA();
        clienteDA.eliminar(codigo);
  }
      public boolean existe(String codigo) throws SQLException{
     ClienteDA clienteDA = new ClienteDA();
     return  clienteDA.existe(codigo);
  }
    
        public Cliente getByCodigo(String codigo) throws SQLException{
          
        return  _clienteDA.getByCodigo(codigo);
    }
       
     
     
}
