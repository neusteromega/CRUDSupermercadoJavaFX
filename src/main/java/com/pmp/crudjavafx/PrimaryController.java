package com.pmp.crudjavafx;

import com.pmp.dao.Producto;
import com.pmp.dao.Productos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import javafx.collections.ObservableList; //Elemento necesario para meter una tabla a un FXML
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
    int contador = 0;
    
    enum FormMode {
        INSERTAR,
        ACTUALIZAR,
        ELIMINAR,
        MOSTRAR
    }
    
    @FXML
    private TableView tblProductos;
    @FXML
    private TableColumn clmProducto;
    @FXML
    private TableColumn clmCategoria;
    @FXML
    private TableColumn clmPrecio;
    @FXML
    private TableColumn clmCantidad;
    @FXML
    private TableColumn clmEstado;
    
    private ObservableList<ProductoAdapter> listaProductos;
    private Productos modeloProductos;
    
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnEliminar;
    
    FormMode mode;
    
    private void recargarDatos() {
        listaProductos = FXCollections.observableArrayList(ProductosAdapterFactory.obtenerdelArrayListProductos(modeloProductos.obtenerProductos()));
        
        this.tblProductos.getItems().clear();
        this.tblProductos.getItems().addAll(listaProductos);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modeloProductos = new Productos();
        
        this.clmProducto.setCellValueFactory(new PropertyValueFactory<ProductoAdapter, String>("nombreProducto"));
        this.clmCategoria.setCellValueFactory(new PropertyValueFactory<ProductoAdapter, String>("cantidad"));
        this.clmPrecio.setCellValueFactory(new PropertyValueFactory<ProductoAdapter, Double>("precio"));
        this.clmCantidad.setCellValueFactory(new PropertyValueFactory<ProductoAdapter, Double>("cantidad"));
        this.clmEstado.setCellValueFactory(new PropertyValueFactory<ProductoAdapter, String>("estado"));
        
        recargarDatos();
    }
    
    private Producto cargarProductoForm(Producto producto) throws IOException {
        try {
            FXMLLoader win = App.getFXMLLoader("productoform");
            Parent winObject = win.load();
            ProductoformController productosWin = (ProductoformController) win.getController();
            productosWin.setProductoObject(producto);
            productosWin.setMode(mode.name());
            App.loadFXMLModal(winObject);
            
            if (productosWin.esConfirmarAccion()) {
                return productosWin.getProductoObject();
            }          
            return null;
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }

    @FXML
    private void btnNuevo_click(ActionEvent event) {
        try {
            mode = FormMode.INSERTAR;
            Producto infoForm = cargarProductoForm(new Producto());
            
            if (infoForm != null) {
                modeloProductos.agregarProducto(infoForm);
                recargarDatos();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    private void btnEditar_click(ActionEvent event) {
        try {
            mode = FormMode.ACTUALIZAR;
            Producto infoForm = cargarProductoForm(((ProductoAdapter)tblProductos.getSelectionModel().getSelectedItem()).getProducto());
            
            if (infoForm != null) {
                modeloProductos.actualizarProducto(infoForm);
                recargarDatos();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    private void btnMostrar_click(ActionEvent event) {
        try {
            mode = FormMode.MOSTRAR;
            Producto infoForm = cargarProductoForm(((ProductoAdapter)tblProductos.getSelectionModel().getSelectedItem()).getProducto());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @FXML
    private void btnEliminar_click(ActionEvent event) {
        try {
            mode = FormMode.ELIMINAR;
            Producto infoForm = cargarProductoForm(((ProductoAdapter)tblProductos.getSelectionModel().getSelectedItem()).getProducto());
            
            if (infoForm != null) {
                modeloProductos.eliminarProducto(infoForm.getId());
                recargarDatos();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
