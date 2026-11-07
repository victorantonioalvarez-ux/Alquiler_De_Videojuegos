/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;


/**
 *
 * @author v
 */
public class Usuario {
    private final String nombre;
    private final String apellido1;
    private final String apellido2;
    private final String dni;
    private final int telefono;
    private final Date fechaRegistro;

    public Usuario(String nombre, String apellido1, String apellido2, String dni, int telefono, Date dataRegistro) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaRegistro = dataRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDni() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    
    public String getNombreCompleto() { 
        return nombre + " " + apellido1 + " " + apellido2; 
    }
    
    @Override
    public String toString() { 
        return getNombreCompleto(); 
    }
}
