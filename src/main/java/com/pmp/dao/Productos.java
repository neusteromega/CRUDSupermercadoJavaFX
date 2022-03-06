/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

/**
 *
 * @author ME
 */
public class Productos {
    private Connection _conexion = null;
    
    public Productos() {
        _conexion = Conexion.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS productos"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombreProducto TEXT NOT NULL,"
                + " descripcion TEXT NOT NULL,"
                + " categoria TEXT NOT NULL,"
                + " marca TEXT NOT NULL,"
                + " precio DECIMAL(10,2) NOT NULL,"
                + " cantidad DECIMAL(10,2) NOT NULL,"
                + " estado TEXT NOT NULL);";
        
        try {
            Statement comando = _conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Producto> obtenerProductos() {
        try {
            ArrayList productos = new ArrayList<Producto>();
            Statement comandoSQL = _conexion.createStatement();
            ResultSet registroTabla = comandoSQL.executeQuery("SELECT * FROM productos;");
            
            while (registroTabla.next()) {
                Producto producto = new Producto();
                producto.setId(registroTabla.getInt("id"));
                producto.setNombreProducto(registroTabla.getString("nombreProducto"));
                producto.setDescripcion(registroTabla.getString("descripcion"));
                producto.setCategoria(registroTabla.getString("categoria"));
                producto.setMarca(registroTabla.getString("marca"));
                producto.setPrecio(registroTabla.getDouble("precio"));
                producto.setCantidad(registroTabla.getDouble("cantidad"));
                producto.setEstado(registroTabla.getString("estado"));
                productos.add(producto);
            }
            return productos;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<Producto>();
        }
    }
    
    public Producto obtenerProducto (int id) {
        try {
            PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM productos where id = ?;");
            comandoSQL.setInt(1, id);
            ResultSet registroTabla = comandoSQL.executeQuery();
            Producto producto = new Producto();
            
            while (registroTabla.next()) {
                producto.setId(registroTabla.getInt("id"));
                producto.setNombreProducto(registroTabla.getString("nombreProducto"));
                producto.setDescripcion(registroTabla.getString("descripcion"));
                producto.setCategoria(registroTabla.getString("categoria"));
                producto.setMarca(registroTabla.getString("marca"));
                producto.setPrecio(registroTabla.getDouble("precio"));
                producto.setCantidad(registroTabla.getDouble("cantidad"));
                producto.setEstado(registroTabla.getString("estado"));
                break;
            }
            return producto;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int agregarProducto(Producto nuevoProducto) {
        try {
            String insertarSQL = "INSERT INTO productos (nombreProducto, descripcion, categoria, marca, precio, cantidad, estado) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement comandoSQL = _conexion.prepareStatement(insertarSQL);
            
            comandoSQL.setString(1, nuevoProducto.getNombreProducto());
            comandoSQL.setString(2, nuevoProducto.getDescripcion());
            comandoSQL.setString(3, nuevoProducto.getCategoria());
            comandoSQL.setString(4, nuevoProducto.getMarca());
            comandoSQL.setDouble(5, nuevoProducto.getPrecio());
            comandoSQL.setDouble(6, nuevoProducto.getCantidad());
            comandoSQL.setString(7, nuevoProducto.getEstado());
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int actualizarProducto (Producto productoActualizado) {
        try {
            String actualizarSQL = "UPDATE productos SET nombreProducto=?, descripcion=?, categoria=?, marca=?, precio=?, cantidad=?, estado=? where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(actualizarSQL);
            
            comandoSQL.setString(1, productoActualizado.getNombreProducto());
            comandoSQL.setString(2, productoActualizado.getDescripcion());
            comandoSQL.setString(3, productoActualizado.getCategoria());
            comandoSQL.setString(4, productoActualizado.getMarca());
            comandoSQL.setDouble(5, productoActualizado.getPrecio());
            comandoSQL.setDouble(6, productoActualizado.getCantidad());
            comandoSQL.setString(7, productoActualizado.getEstado());
            comandoSQL.setInt(8, productoActualizado.getId());
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int eliminarProducto(int id) {
        try {
            String eliminarSQL = "DELETE FROM productos where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(eliminarSQL);
            
            comandoSQL.setInt(1, id);
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
