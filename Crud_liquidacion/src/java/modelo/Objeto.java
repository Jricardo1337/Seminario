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
abstract class Objeto {
    private int id;
    private String nombre_liquidacion, fecha_inicio_l,fecha_fin_l;

    
    
    
    public Objeto(){}
    
    public Objeto(int id, String nombre_liquidacion, String fecha_inicio_l, String fecha_fin_l) {
        this.id = id;
        this.nombre_liquidacion = nombre_liquidacion;
        this.fecha_inicio_l = fecha_inicio_l;
        this.fecha_fin_l = fecha_fin_l;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_liquidacion() {
        return nombre_liquidacion;
    }

    public void setNombre_liquidacion(String nombre_liquidacion) {
        this.nombre_liquidacion = nombre_liquidacion;
    }

    public String getFecha_inicio_l() {
        return fecha_inicio_l;
    }

    public void setFecha_inicio_l(String fecha_inicio_l) {
        this.fecha_inicio_l = fecha_inicio_l;
    }

    public String getFecha_fin_l() {
        return fecha_fin_l;
    }

    public void setFecha_fin_l(String fecha_fin_l) {
        this.fecha_fin_l = fecha_fin_l;
    }
    
    
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
    public int mostrar(){return 0;}
     
    
    
}
