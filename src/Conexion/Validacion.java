/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author migue
 */
public class Validacion {
    private static String doctorEmail;

    public static void startSession(String email) {
        doctorEmail = email;
    }

    public static void endSession() {
        doctorEmail = null;
    }

    public static boolean isSessionActive() {
        return doctorEmail != null;
    }

    public static String getDoctorEmail() {
        return doctorEmail;
    }
}