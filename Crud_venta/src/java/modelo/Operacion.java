/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
abstract class Operacion {
    private int id, cantidad_venta;
    private String nombre_venta,fecha_venta;

    
    public Operacion(){}
    
    public Operacion(int id, int cantidad_venta, String nombre_venta, String fecha_venta) {
        this.id = id;
        this.cantidad_venta = cantidad_venta;
        this.nombre_venta = nombre_venta;
        this.fecha_venta = fecha_venta;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public String getNombre_venta() {
        return nombre_venta;
    }

    public void setNombre_venta(String nombre_venta) {
        this.nombre_venta = nombre_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
    
}
