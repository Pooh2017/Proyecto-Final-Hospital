package Controlador;

//import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.xdevapi.Statement;
import Modelo.Doctor;
import java.sql.Connection;
import Conexion.Conexion;
import Modelo.Paciente;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.PreparedStatement;

/**
 *
 * @author migue
 */
public class Ctrl_Usuario {

    public String loginUser(Doctor objeto) {

        String correo = null;
        Connection cn = Conexion.conectar();
        String sql = "select correo from doctor where correo = ? and contraseña = ?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, objeto.getCorreo());
            st.setString(2, objeto.getContraseña());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                correo = rs.getString("correo");
            }
        } catch (Exception e) {
            System.out.println("Error al iniciar sesion: " + e);
        }
        return correo;
    }

    public boolean guardar(Doctor doctor) {
        Connection cn = Conexion.conectar();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO doctor (correo, nombre, apellidoP, apellidoM, rol, telefono, cedulaProf, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, doctor.getCorreo());
            ps.setString(2, doctor.getNombre());
            ps.setString(3, doctor.getApellidoP());
            ps.setString(4, doctor.getApellidoM());
            ps.setString(5, doctor.getEspecialidad());
            ps.setString(6, doctor.getTelefono());
            ps.setString(7, doctor.getCedulaProf());
            ps.setString(8, doctor.getContraseña());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al guardar el doctor: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public boolean correoExiste(String correo) {
       Connection con = Conexion.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(*) FROM doctor WHERE correo = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar el correo: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }
    
    public String getRoleByEmailAndPassword(Doctor doctor) {
        String role = null;
        Connection cn = Conexion.conectar();
        String sql = "select rol from doctor where correo = ? and contraseña = ?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, doctor.getCorreo());
            st.setString(2, doctor.getContraseña());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                role = rs.getString("rol");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el rol del usuario: " + e);
        }
        return role;
    }

}
