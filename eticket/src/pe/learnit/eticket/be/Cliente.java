

package pe.learnit.eticket.be;


/**
 *
 * @author GERSON REVATTA
 */

public class Cliente {

    private String _Codigo;
    private String _Ruc_Dni;
    private String _Razon;
    private String _Direccion;
    private String _Telefono;
    private String _rowStatus;
    private String  _Tipo;
    
    public String getTipo(){
        return _Tipo;
    }
    public void setTipo( String _Tipo){
        this._Tipo =  _Tipo;
    }
    
     public String getRowStatus() {
        return _rowStatus;
    }
    public void setRowStatus(String _rowStatus) {
        this._rowStatus = _rowStatus;
    }
    
    
    
    public String getCodigo() {
        return _Codigo;
    }
    
    
      public void setCodigo(String _Codigo) {
        this._Codigo = _Codigo;
    }
      
      
    public String getRuc_Dni() {
        return _Ruc_Dni;
    }
    
    
      public void setRuc_Dni(String _Ruc_Dni) {
        this._Ruc_Dni = _Ruc_Dni;
    }  
      
    
   
      public String getRazon() {
        return _Razon;
    }
    
    
      public void setRazon(String _Razon) {
        this._Razon = _Razon;
    }
      
     
      
    public String getDireccion() {
        return _Direccion;
    }
    
    
      public void setDireccion(String _Direccion) {
        this._Direccion = _Direccion;
    }  
      
      
      public String getTelefono() {
         return _Telefono;
    }
    
    
      public void setTelefono(String _Telefono) {
        this._Telefono = _Telefono;
    }  
      
       
    
}

