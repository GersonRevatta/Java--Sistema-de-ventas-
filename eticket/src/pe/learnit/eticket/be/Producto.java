/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.learnit.eticket.be;

/**
 *
 * @author 
 */
public class Producto {
    private int _productoId;
    private String _codigo;
    private String descripcion;
    private String _rowStatus;
    private double _precioUnitario;

    /**
     * @return the _productoId
     */
    public int getProductoId() {
        return _productoId;
    }

    /**
     * @param _productoId the _productoId to set
     */
    public void setProductoId(int _productoId) {
        this._productoId = _productoId;
    }

    /**
     * @return the _codigo
     */
    public String getCodigo() {
        return _codigo;
    }

    /**
     * @param _codigo the _codigo to set
     */
    public void setCodigo(String _codigo) {
        this._codigo = _codigo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
    public String getRowStatus() {
        return _rowStatus;
    }

    /**
     * @param _rowStatus the _rowStatus to set
     */
    public void setRowStatus(String _rowStatus) {
        this._rowStatus = _rowStatus;
    }

    /**
     * @return the _precioUnitario
     */
    public double getPrecioUnitario() {
        return _precioUnitario;
    }

    /**
     * @param _precioUnitario the _precioUnitario to set
     */
    public void setPrecioUnitario(double _precioUnitario) {
        this._precioUnitario = _precioUnitario;
    }
    
}
