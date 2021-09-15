/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
abstract class Datos2 {
    private int id, cantidad_compra;
    private String nombre_compra, fecha_compra;
    
    public Datos2(){
    }

    public Datos2(int id, int cantidad_compra, String nombre_compra, String fecha_compra) {
        this.id = id;
        this.cantidad_compra = cantidad_compra;
        this.nombre_compra = nombre_compra;
        this.fecha_compra = fecha_compra;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(int cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public String getNombre_compra() {
        return nombre_compra;
    }

    public void setNombre_compra(String nombre_compra) {
        this.nombre_compra = nombre_compra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
    
public int agregar(){return 0;}
public int modificar(){return 0;}
public int eliminar(){return 0;}
}
