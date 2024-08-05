/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author migue
 */
import Conexion.Conexion;
import Modelo.Historial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Generar_historial {
    
    public List<Historial> obtenerHistorialPorRFC(String rfc) {
        List<Historial> historialList = new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = "SELECT * FROM historial WHERE rfc = ?";
        
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, rfc);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Historial historial = new Historial();
                historial.setNombre(rs.getString("nombre_paciente"));
                historial.setRfc(rs.getString("rfc"));
                historial.setDescripcion(rs.getString("descripcion"));
                historial.setFecha(rs.getString("fecha"));
                historial.setMotivo(rs.getString("motivo"));
                historial.setArea(rs.getString("area"));
                historial.setNumeroPiso(rs.getString("numero_piso"));
                historial.setNumeroCuarto(rs.getString("numero_cuarto"));
                historial.setTratamiento(rs.getString("tratamiento"));
                historialList.add(historial);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener historial por RFC: " + e);
        }
        
        return historialList;
    }
}
