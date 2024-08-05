/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author migue
 */
public class Paciente {
    private String pacienteId;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String fechaNacimiento;
    private String sexo;
    private String direccion;
    private String CURP;
    private String RFC;
    private String telefono;
    private String correo;
    private String motivo;
    private String modoLlegada;
    private String fechaIngreso;

    public Paciente() {
        this.pacienteId = "";
        this.nombre = "";
        this.apellidoP = "";
        this.apellidoM = "";
        this.fechaNacimiento = ""; 
        this.sexo = "";
        this.direccion = "";
        this.CURP = "";
        this.RFC = "";
        this.telefono = "";
        this.correo = "";
        this.motivo = "";
        this.modoLlegada = "";
        this.fechaIngreso = "";
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getModoLlegada() {
        return modoLlegada;
    }

    public void setModoLlegada(String modoLlegada) {
        this.modoLlegada = modoLlegada;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
    
}
