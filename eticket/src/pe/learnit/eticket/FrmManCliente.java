/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.learnit.eticket;


import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import pe.learnit.eticket.be.Cliente;
import pe.learnit.eticket.bl.ClienteBL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author GERSON REVATTA
 */
public class FrmManCliente extends javax.swing.JDialog {
    private ClienteBL _clienteBL;
    private boolean esNuevo;
    

    /**
     * Creates new form FrmManCliente
     */
    public FrmManCliente( java.awt.Frame parent,boolean modal ,String codigo) {
        super (parent,modal);
        initComponents();
        _clienteBL = new ClienteBL();
        ButtonGroup group = new ButtonGroup();
        group.add(rbJuridico);
        group.add(rbNatural);
        if (codigo.isEmpty()) 
            esNuevo=true;
        else
            esNuevo=false;
        
        llenarFormulario(codigo);
    }

    private void llenarFormulario(String codigo){
         if (!codigo.isEmpty()){
            try {
                Cliente cliente = _clienteBL.getByCodigo(codigo);
                
                if (cliente != null)
                {
                    
           
                    txtCodigo.setText(cliente.getCodigo());
                    txtRuc_Dni.setText(cliente.getRuc_Dni());
                    txtRazon.setText(cliente.getRazon());
                    txtDireccion.setText(cliente.getDireccion());
                    txtTelefono.setText(cliente.getTelefono());
                    txtCodigo.setEnabled(false);
                    if (cliente.getTipo().equals("N")) {    
                         rbNatural.setSelected(true);
                    }else if(cliente.getTipo().equals("J")){
                        rbJuridico.setSelected(true);
                    }
                    
                   
                }else{
                    JOptionPane.showMessageDialog(this, "Producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rbJuridico = new javax.swing.JRadioButton();
        rbNatural = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRuc_Dni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRazon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tipo");

        rbJuridico.setText("P.Juridica");
        rbJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJuridicoActionPerformed(evt);
            }
        });

        rbNatural.setText("P.Natural");

        jLabel2.setText("Codigo");

        jLabel3.setText("RUC/DNI");

        jLabel4.setText("Razon Social/Nombre");

        jLabel5.setText("Direccion");

        jLabel6.setText("Telefono");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(txtRuc_Dni)
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbJuridico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNatural))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAceptar)
                                        .addGap(91, 91, 91)
                                        .addComponent(btnCancelar))
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rbJuridico)
                    .addComponent(rbNatural))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRuc_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
            // TODO add your handling code here:
        guardar();
           
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rbJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJuridicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbJuridicoActionPerformed

    private void guardar(){
       
            try {
                 if (esValidoParaGuardar()) {
            
            Cliente cliente =new Cliente();
            cliente.setCodigo(txtCodigo.getText().trim());
            cliente.setRuc_Dni(txtRuc_Dni.getText().trim());
            cliente.setRazon(txtRazon.getText().trim());
            cliente.setDireccion(txtDireccion.getText().trim());
            cliente.setTelefono(txtTelefono.getText().trim());
            
            cliente.setRowStatus("1");
            //cliente.setTipo(esNuevo); 
            //rbJuridico.isSelected()==false && rbNatural.isSelected()==false
                     if (rbJuridico.isSelected()) {
                         cliente.setTipo("J");
                     }else if(rbNatural.isSelected()){
                         cliente.setTipo("N");
                    }
                     
                     if (esNuevo) 
                         _clienteBL.insertar(cliente);
                     else
                     
                         _clienteBL.modificar(cliente);
                     
            
                 JOptionPane.showMessageDialog(this, "Operación ejecutada con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            }
                 
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
            }
            
           
        }
        
       
    
    
    private boolean esValidoParaGuardar() throws SQLException {
     if (txtCodigo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog( this,"Llene el campo Codigo","DANGER",JOptionPane.ERROR_MESSAGE );
            return false;
        }
       if (rbJuridico.isSelected()==false && rbNatural.isSelected()==false) {
                        JOptionPane.showMessageDialog( this,"Selecione al menos 1 ","PELIGRO",JOptionPane.ERROR_MESSAGE );
                        return false ; 

        }
       
        if (txtTelefono.getText().trim().equals("")) {
            JOptionPane.showMessageDialog( this,"Llene el Campo Telefono ","DANGER",JOptionPane.ERROR_MESSAGE );
                        return false ; 
        }
        if (txtDireccion.getText().trim().equals("")) {
            JOptionPane.showMessageDialog( this,"Llene el Campo Direccion ","DANGER",JOptionPane.ERROR_MESSAGE );
                        return false ; 
            
        }
        if (txtRazon.getText().trim().equals("")) {
            
            JOptionPane.showMessageDialog( this,"Llene el Campo Razon  ","DANGER",JOptionPane.ERROR_MESSAGE );
                        return false ; 
        }
    return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton rbJuridico;
    private javax.swing.JRadioButton rbNatural;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtRazon;
    private javax.swing.JTextField txtRuc_Dni;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
