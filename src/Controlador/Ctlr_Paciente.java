/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Paciente;
import Conexion.Conexion;
import java.sql.ResultSet;

public class Ctlr_Paciente {

    public boolean guardar(Paciente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            String sql = "INSERT INTO pacientes (nombre, apellido_paterno, apellido_materno, fecha_nacimiento, sexo, direccion, curp, rfc, telefono, motivo, modo_llegada, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellidoP());
            consulta.setString(3, objeto.getApellidoM());
            consulta.setString(4, objeto.getFechaNacimiento());
            consulta.setString(5, objeto.getSexo());
            consulta.setString(6, objeto.getDireccion());
            consulta.setString(7, objeto.getCURP());
            consulta.setString(8, objeto.getRFC());
            consulta.setString(9, objeto.getTelefono());
            consulta.setString(10, objeto.getMotivo());
            consulta.setString(11, objeto.getModoLlegada());
            consulta.setString(12, objeto.getFechaIngreso());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar paciente: " + e.getMessage());

        }
        return respuesta;
    }

    public boolean existePaciente(String rfc) {
        boolean respuesta = false;
        String sql = "SELECT rfc FROM pacientes WHERE rfc = ?";
        try (Connection cn = Conexion.conectar(); PreparedStatement st = cn.prepareStatement(sql)) {
            st.setString(1, rfc);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    respuesta = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar paciente: " + e.getMessage());

        }
        return respuesta;
    }

    public boolean actualizarPaciente(Paciente paciente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "UPDATE pacientes SET nombre=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, sexo=?, direccion=?, curp=?, telefono=?, motivo=?, modo_llegada=?, fecha_ingreso=? WHERE rfc=?";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellidoP());
            ps.setString(3, paciente.getApellidoM());
            ps.setString(4, paciente.getFechaNacimiento());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getDireccion());
            ps.setString(7, paciente.getCURP());
            ps.setString(8, paciente.getTelefono());
            ps.setString(9, paciente.getMotivo());
            ps.setString(10, paciente.getModoLlegada());
            ps.setString(11, paciente.getFechaIngreso());
            ps.setString(12, paciente.getRFC());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar paciente: " + e);
        }
        return respuesta;
    }
    
    public boolean actualizarPaciente2(Paciente paciente) {
        Connection cn = Conexion.conectar();
        String sql = "UPDATE pacientes SET nombre = ?, apellidoP = ?, apellidoM = ?, fechaNacimiento = ?, sexo = ?, direccion = ?, CURP = ?, RFC = ?, telefono = ?, motivo = ?, modoLlegada = ?, fechaIngreso = ? WHERE rfc = ?";
        try (PreparedStatement pstmt = cn.prepareStatement(sql)) {
            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellidoP());
            pstmt.setString(3, paciente.getApellidoM());
            pstmt.setString(4, paciente.getFechaNacimiento());
            pstmt.setString(5, paciente.getSexo());
            pstmt.setString(6, paciente.getDireccion());
            pstmt.setString(7, paciente.getCURP());
            pstmt.setString(8, paciente.getRFC());
            pstmt.setString(9, paciente.getTelefono());
            pstmt.setString(10, paciente.getMotivo());
            pstmt.setString(11, paciente.getModoLlegada());
            pstmt.setString(12, paciente.getFechaIngreso());
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar paciente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPaciente(String rfc) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "DELETE FROM pacientes WHERE rfc=?";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, rfc);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar paciente: " + e);
        }
        return respuesta;
    }
}
