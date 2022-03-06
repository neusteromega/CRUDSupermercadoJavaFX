/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.crudjavafx;

import java.util.ArrayList;
import com.pmp.dao.Producto;

/**
 *
 * @author ME
 */
public class ProductosAdapterFactory {
    public static ArrayList<ProductoAdapter> obtenerdelArrayListProductos(ArrayList<Producto> productos) {
        ArrayList<ProductoAdapter> productosAdaptados = new ArrayList();
        
        productos.forEach((producto) -> productosAdaptados.add(new ProductoAdapter(producto)));
        return productosAdaptados;
    }
}
