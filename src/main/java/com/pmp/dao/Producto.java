/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author ME
 */
public class Producto {

    public String getNombreProducto() {
        return _nombreProducto;
    }

    public void setNombreProducto(String _nombreProducto) {
        this._nombreProducto = _nombreProducto;
    }


    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }


    public String getCategoria() {
        return _categoria;
    }

    public void setCategoria(String _categoria) {
        this._categoria = _categoria;
    }


    public String getMarca() {
        return _marca;
    }

    public void setMarca(String _marca) {
        this._marca = _marca;
    }

    
    public double getPrecio() {
        return _precio;
    }

    public void setPrecio(double _precio) {
        this._precio = _precio;
    }


    public double getCantidad() {
        return _cantidad;
    }

    public void setCantidad(double _cantidad) {
        this._cantidad = _cantidad;
    }


    public String getEstado() {
        return _estado;
    }

    public void setEstado(String _estado) {
        this._estado = _estado;
    }


    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
    
    private String _nombreProducto;
    private String _descripcion;
    private String _categoria;
    private String _marca;
    private double _precio;
    private double _cantidad;
    private String _estado = "A";
    private int _id;
}
