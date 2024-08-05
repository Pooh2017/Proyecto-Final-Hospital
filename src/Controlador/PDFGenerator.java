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
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PDFGenerator {

    public boolean generatePDF(String rfc, String email) {
        // Especifica la ruta del archivo PDF
        String filePath = "historial_" + rfc + ".pdf";

        try {
            // Conectar a la base de datos y obtener datos del historial
            Connection cn = Conexion.conectar();
            String sql = "SELECT * FROM historial WHERE rfc = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, rfc);
            ResultSet rs = st.executeQuery();

            // Crear documento PDF
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agregar título
            document.add(new Paragraph("Historial del Paciente")
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER)
                .setBold());

            // Crear una tabla con los datos del historial
            Table table = new Table(2); // 2 columnas: Campo y Valor
            table.addHeaderCell("Campo");
            table.addHeaderCell("Valor");

            // Agregar filas con los datos del historial
            while (rs.next()) {
                table.addCell("Nombre del Paciente");
                table.addCell(rs.getString("nombre_paciente"));

                table.addCell("Descripción");
                table.addCell(rs.getString("descripcion"));

                table.addCell("Fecha");
                table.addCell(rs.getString("fecha"));

                table.addCell("Motivo");
                table.addCell(rs.getString("motivo"));

                table.addCell("Área");
                table.addCell(rs.getString("area"));

                table.addCell("Número de Piso");
                table.addCell(rs.getString("numero_piso"));

                table.addCell("Número de Cuarto");
                table.addCell(rs.getString("numero_cuarto"));

                table.addCell("Tratamiento");
                table.addCell(rs.getString("tratamiento"));
            }

            document.add(table);
            document.close();

            // Aquí se puede implementar el envío del PDF por correo (si es necesario)
            // EnviarCorreo.sendEmail(email, filePath);

            return true; // PDF generado correctamente

        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error al generar el PDF
        }
    }
}