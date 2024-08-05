/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author migue
 */
import Modelo.Internar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ctlr_Internar {
    private Connection connection;

    public Ctlr_Internar(Connection connection) {
        this.connection = connection;
    }

    public void agregarInternar(Internar internar) throws SQLException {
    String sql = "INSERT INTO Internar (nombre_paciente, rfc, fecha, motivo, area, numero_piso, numero_cuarto, tratamiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, internar.getNombre());
        pstmt.setString(2, internar.getRfc());
        pstmt.setString(3, internar.getFecha());
        pstmt.setString(4, internar.getMotivo());
        pstmt.setString(5, internar.getArea());
        pstmt.setString(6, internar.getNumeroPiso());
        pstmt.setString(7, internar.getNumeroCuarto());
        pstmt.setString(8, internar.getTratamiento());
        pstmt.executeUpdate();
    }
}

    public void actualizarArea(String nuevaArea) throws SQLException {
        String sql = "UPDATE Internar SET area = ? WHERE paciente_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nuevaArea);
            pstmt.executeUpdate();
        }
    }
}