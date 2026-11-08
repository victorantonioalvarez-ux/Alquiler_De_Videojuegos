package logic;

import dto.Alquiler;
import dto.Juego;
import dto.Usuario;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author v
 */
public class Datos {
    public static final int DIAS_ALQUILER = 3;
    
    private ArrayList<Usuario> Usuarios = new ArrayList<>();
    private ArrayList<Juego> Juegos = new ArrayList<>();
    private ArrayList<Alquiler> alquileres = new ArrayList<>();
    private int siguienteNumero = 1;

    public ArrayList<Usuario> getUsuarios() {
        return Usuarios;
    }

    public ArrayList<Juego> getJuegos() {
        return Juegos;
    }
    
    public ArrayList<Alquiler> getAlquilerDescendiente(){
        ArrayList<Alquiler> resultado = new ArrayList<>();
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            resultado.add(alquileres.get(i));
        }
        return resultado;
    }
    
    public void crearUsuario(Usuario nuevo) throws AlquilerException {
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getDni().equalsIgnoreCase(nuevo.getDni())) {
                throw new AlquilerException(Messages.get("err.usuario.dniDuplicado", nuevo.getDni()));
            }
        }
        Usuarios.add(nuevo);
    }
}
