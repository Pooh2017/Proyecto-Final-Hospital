/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author migue
 */
public class Historial {
    private String nombre;
    private String rfc;
    private String descripcion;
    private String fecha;
    private String motivo;
    private String area;
    private String numeroPiso;
    private String numeroCuarto;
    private String tratamiento;

    public Historial() {
        this.nombre = "";
        this.rfc = "";
        this.descripcion = "";
        this.fecha = "";
        this.motivo = "";
        this.area = "";
        this.numeroPiso = "";
        this.numeroCuarto = "";
        this.tratamiento = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(String numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public String getNumeroCuarto() {
        return numeroCuarto;
    }

    public void setNumeroCuarto(String numeroCuarto) {
        this.numeroCuarto = numeroCuarto;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    
    
}