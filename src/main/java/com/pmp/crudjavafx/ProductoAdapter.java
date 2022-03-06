/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.crudjavafx;
import com.pmp.dao.Producto;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author ME
 */
public class ProductoAdapter {

    public String getNombreProducto() {
        return nombreProducto.get();
    }

    public void setNombreProducto(String _nombreProducto) {
        this.nombreProducto.set(_nombreProducto);
    }


    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String _descripcion) {
        this.descripcion.set(_descripcion);
    }


    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String _categoria) {
        this.categoria.set(_categoria);
    }


    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String _marca) {
        this.marca.set(_marca);
    }


    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double _precio) {
        this.precio.set(_precio);
    }


    public Double getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(Double _cantidad) {
        this.cantidad.set(_cantidad);
    }


    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String _estado) {
        this.estado.set(_estado);
    }


    public int getId() {
        return id.get();
    }

    public void setId(int _id) {
        this.id.set(_id);
    }
    
    private Producto _producto;
    
    public Producto getProducto() {
        _producto.setNombreProducto(nombreProducto.get());
        _producto.setDescripcion(descripcion.get());
        _producto.setCategoria(categoria.get());
        _producto.setMarca(marca.get());
        _producto.setPrecio(precio.get());
        _producto.setCantidad(cantidad.get());
        _producto.setEstado(estado.get());
        _producto.setId(id.get());
        
        return this._producto;
    }
    
    public ProductoAdapter() {
        this._producto = new Producto();
        nombreProducto = new SimpleStringProperty("");
        descripcion = new SimpleStringProperty("");
        categoria = new SimpleStringProperty("");
        marca = new SimpleStringProperty("");
        precio = new SimpleDoubleProperty(0);
        cantidad = new SimpleDoubleProperty(0);
        estado = new SimpleStringProperty("");
    }
    
    public ProductoAdapter(Producto _producto) {
        this._producto = _producto;
        nombreProducto = new SimpleStringProperty("");
        descripcion = new SimpleStringProperty("");
        categoria = new SimpleStringProperty("");
        marca = new SimpleStringProperty("");
        precio = new SimpleDoubleProperty(0);
        cantidad = new SimpleDoubleProperty(0);
        estado = new SimpleStringProperty("");
        id = new SimpleIntegerProperty(0);
        
        nombreProducto.set(_producto.getNombreProducto());
        descripcion.set(_producto.getDescripcion());
        categoria.set(_producto.getCategoria());
        marca.set(_producto.getMarca());
        precio.set(_producto.getPrecio());
        cantidad.set(_producto.getCantidad());
        estado.set(_producto.getEstado());
        id.set(_producto.getId());
    }
    
    private SimpleStringProperty nombreProducto;
    private SimpleStringProperty descripcion;
    private SimpleStringProperty categoria;
    private SimpleStringProperty marca;
    private SimpleDoubleProperty precio;
    private SimpleDoubleProperty cantidad;
    private SimpleStringProperty estado;
    private SimpleIntegerProperty id;
}
