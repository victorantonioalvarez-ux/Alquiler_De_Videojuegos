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
public class Alquiler {
    public enum Estado { ACTIVO, DEVUELTO, FUERA_DE_PLAZO }
    
    private final int numero;
    private final Usuario usuario;
    private final Juego juego;
    private final Plataforma plataforma;
    private boolean devuelto;
    private final Date fechaInicio;
    private final Date fechaPrevista;
    private Date fechaDevuelto;

    public Alquiler(int numero, Usuario usuario, Juego juego, Plataforma plataforma, Date fechaInicio, Date fechaPrevista) {
        this.numero = numero;
        this.usuario = usuario;
        this.juego = juego;
        this.plataforma = plataforma;
        this.fechaInicio = fechaInicio;
        this.fechaPrevista = fechaPrevista;
        this.devuelto = false;
    }

    public int getNumero() {
        return numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Juego getJuego() {
        return juego;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaPrevista() {
        return fechaPrevista;
    }

    public Date getFechaDevuelto() {
        return fechaDevuelto;
    }
    
    public void marcarDevuelto(){
        devuelto = true;
        fechaDevuelto = new Date();
    }
    
    public Estado getEstado() {
        if (devuelto) {
            return Estado.DEVUELTO;
        }
        if (new Date().after(fechaPrevista)) {
            return Estado.FUERA_DE_PLAZO;
        }
        return Estado.ACTIVO;
    }
    
}
