/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

/**
 *
 * @author v
 */
public class Validacion {
    public static boolean esVacio(String texto) {
        return texto == null || texto.trim().equals("");
    }
    
    public static boolean empiezaPorMayuscula(String texto) {
        if (esVacio(texto)) {
            return false;
        }
        char primera = texto.trim().charAt(0);
        return Character.isUpperCase(primera);
    }
    
    public static boolean dniValido(String dni) {
        if (dni == null) {
            return false;
        }
        dni = dni.trim();
        if (dni.length() != 9) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }
        return Character.isLetter(dni.charAt(8));
    }
    
    public static boolean telefonoValido(String telefono) {
        if (telefono == null) {
            return false;
        }
        telefono = telefono.trim();
        if (telefono.length() != 9) {
            return false;
        }
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static String validarNombre(String nombreDelCampo, String valor) {
        if (esVacio(valor)) {
            return "El campo '" + nombreDelCampo + "' es obligatorio.";
        }
        if (!empiezaPorMayuscula(valor)) {
            return "El campo '" + nombreDelCampo + "' debe empezar obligatoriamente por una letra mayúscula (por ejemplo: Fran).";
        }
        return null;
    }
}
