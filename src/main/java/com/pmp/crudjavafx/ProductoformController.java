/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.crudjavafx;

import com.pmp.dao.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author ME
 */
public class ProductoformController implements Initializable {

    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private RadioButton rdbEstadoActivo;
    @FXML
    private ToggleGroup estado;
    @FXML
    private RadioButton rdbEstadoInactivo;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    
    private boolean confirmarAccion = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnConfirmar_click(ActionEvent event) {
        this.confirmarAccion = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        this.confirmarAccion = false;
        App.closeModal(event);
    }
    
    private Producto _producto;
    
    public void setProductoObject(Producto producto) {
        _producto = producto;
        refreshUX();
    }
    
    private void refreshUX() {
        txtNombreProducto.setText(_producto.getNombreProducto());
        txtDescripcion.setText(_producto.getDescripcion());
        txtCategoria.setText(_producto.getCategoria());
        txtMarca.setText(_producto.getMarca());
        txtPrecio.setText(Double.toString(_producto.getPrecio()));
        txtCantidad.setText(Double.toString(_producto.getCantidad()));
        
        boolean estadoEsA = _producto.getEstado().equals("A");
        
        rdbEstadoActivo.setSelected(estadoEsA);
        rdbEstadoInactivo.setSelected(!estadoEsA);
    }
    
    public void setMode(String mode) {
        switch (mode) {
            case "INSERTAR":
            case "ACTUALIZAR":                
                break;
            case "ELIMINAR", "MOSTRAR":
                txtNombreProducto.setEditable(false);
                txtDescripcion.setEditable(false);
                txtCategoria.setEditable(false);
                txtMarca.setEditable(false);
                txtPrecio.setEditable(false);
                txtCantidad.setEditable(false);
                
                rdbEstadoActivo.setDisable(true);
                rdbEstadoInactivo.setDisable(true);
                
                if (mode == "MOSTRAR")
                    btnConfirmar.setVisible(false);
                break;
        }
    }
    
    public Producto getProductoObject() {
        refreshObjFromUx();
        return _producto;
    }
    
    public void refreshObjFromUx() {
        _producto.setNombreProducto(txtNombreProducto.getText());
        _producto.setDescripcion(txtDescripcion.getText());
        _producto.setCategoria(txtCategoria.getText());
        _producto.setMarca(txtMarca.getText());
        _producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
        _producto.setCantidad(Double.parseDouble(txtCantidad.getText()));
        
        _producto.setEstado(rdbEstadoActivo.isSelected()?"A":"I");
    }
    
    public boolean esConfirmarAccion() {
        return confirmarAccion;
    }   
}
