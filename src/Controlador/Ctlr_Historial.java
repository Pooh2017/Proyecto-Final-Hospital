/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Historial;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author migue
 */
public class Ctlr_Historial {

    public Ctlr_Historial(Connection connection) {
    }
    public boolean guardar(Historial objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            String sql = "INSERT INTO historial (nombre_paciente, rfc, descripcion, fecha, motivo, area, numero_piso, numero_cuarto, tratamiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getRfc());
            consulta.setString(3, objeto.getDescripcion());
            consulta.setString(4, objeto.getFecha());
            consulta.setString(5, objeto.getMotivo());
            consulta.setString(6, objeto.getArea());
            consulta.setString(7, objeto.getNumeroPiso());
            consulta.setString(8, objeto.getNumeroCuarto());
            consulta.setString(9, objeto.getTratamiento());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar Historial: " + e.getMessage());

        }
        return respuesta;
    }
}
