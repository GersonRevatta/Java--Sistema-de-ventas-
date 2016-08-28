/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.learnit.eticket.bl;

import java.sql.SQLException;
import java.util.List;
import pe.learnit.eticket.be.Producto;
import pe.learnit.eticket.da.ProductoDA;

/**
 *
 * @author 
 */
public class ProductoBL {
        private ProductoDA _productoDA;
        
         
   
        public ProductoBL(){
            _productoDA = new ProductoDA();
        }
        
         public List<Producto> buscar(String codigo,String descripcion) throws SQLException{
     ProductoDA productoDA = new ProductoDA();
     return productoDA.buscar(codigo,descripcion);
     }
        
    public void insertar(Producto producto) throws SQLException{
        ProductoDA productoDA = new ProductoDA();
        productoDA.insertar(producto);
    }
    
    public void modificar(Producto producto) throws SQLException{
        _productoDA.modificar(producto);
    }
    
  public void eliminar (String codigo) throws SQLException{
        ProductoDA productoDA = new ProductoDA();
        productoDA.eliminar(codigo);
  }
  
  
  public boolean existe(String codigo) throws SQLException{
     ProductoDA productoDA = new ProductoDA();
     return  productoDA.existe(codigo);
  }

  

   
  
   public Producto getByCodigo(String codigo) throws SQLException{
        return _productoDA.getByCodigo(codigo);
    }
   
   
}
