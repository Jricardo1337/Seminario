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
abstract class Datos {
    private int id;
    private String nombre_oferta, tipo_oferta, fecha_inicio_o, fecha_fin_o;

    public Datos(){}
    
    public Datos(int id, String nombre_oferta, String tipo_oferta, String fecha_inicio_o, String fecha_fin_o) {
        this.id = id;
        this.nombre_oferta = nombre_oferta;
        this.tipo_oferta = tipo_oferta;
        this.fecha_inicio_o = fecha_inicio_o;
        this.fecha_fin_o = fecha_fin_o;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_oferta() {
        return nombre_oferta;
    }

    public void setNombre_oferta(String nombre_oferta) {
        this.nombre_oferta = nombre_oferta;
    }

    public String getTipo_oferta() {
        return tipo_oferta;
    }

    public void setTipo_oferta(String tipo_oferta) {
        this.tipo_oferta = tipo_oferta;
    }

    public String getFecha_inicio_o() {
        return fecha_inicio_o;
    }

    public void setFecha_inicio_o(String fecha_inicio_o) {
        this.fecha_inicio_o = fecha_inicio_o;
    }

    public String getFecha_fin_o() {
        return fecha_fin_o;
    }

    public void setFecha_fin_o(String fecha_fin_o) {
        this.fecha_fin_o = fecha_fin_o;
    }
    
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
    public int mostrar(){return 0;}   
}
