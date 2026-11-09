/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import dto.Alquiler;
import dto.Juego;
import dto.Plataforma;
import dto.Usuario;
import util.Fechas;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author v
 */
public class Datos {

    public static final int DIAS_ALQUILER = 3;

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Juego> juegos = new ArrayList<>();
    private ArrayList<Alquiler> alquileres = new ArrayList<>();
    private int siguienteNumero = 1;

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public ArrayList<Alquiler> getAlquilerDescendiente() {
        ArrayList<Alquiler> resultado = new ArrayList<>();
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            resultado.add(alquileres.get(i));
        }
        return resultado;
    }

    public void crearUsuario(Usuario nuevo) throws AlquilerException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equalsIgnoreCase(nuevo.getDni())) {
                throw new AlquilerException("Ya existe un usuario con el DNI " + nuevo.getDni() + ".");
            }
        }
        usuarios.add(nuevo);
    }

    public void borrarUsuario(Usuario u) throws AlquilerException {
        if (usuarioTieneAlquileresActivos(u)) {
            throw new AlquilerException("No se puede borrar al usuario " + u.getNombreCompleto() + " porque tiene alquileres activos.");
        }
        usuarios.remove(u);
    }

    private boolean usuarioTieneAlquileresActivos(Usuario u) {
        for (int i = 0; i < alquileres.size(); i++) {
            Alquiler a = alquileres.get(i);
            if (a.getUsuario() == u && !a.isDevuelto()) {
                return true;
            }
        }
        return false;
    }

    public void crearJuego(Juego nuevo) throws AlquilerException {
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getTitulo().equalsIgnoreCase(nuevo.getTitulo())) {
                throw new AlquilerException("Ya existe un juego llamado " + nuevo.getTitulo() + ".");
            }
        }
        juegos.add(nuevo);
    }

    public void borrarJuego(Juego j) throws AlquilerException {
        if (juegoTieneAlquileresActivos(j)) {
            throw new AlquilerException("No se puede borrar el juego " + j.getTitulo() + " porque tiene alquileres activos.");
        }
        juegos.remove(j);
    }

    private boolean juegoTieneAlquileresActivos(Juego j) {
        for (int i = 0; i < alquileres.size(); i++) {
            Alquiler a = alquileres.get(i);
            if (a.getJuego() == j && !a.isDevuelto()) {
                return true;
            }
        }
        return false;
    }

    public Alquiler registrarAlquiler(Usuario u, Juego j, Plataforma p) throws AlquilerException {
        return crearAlquiler(u, j, p, new Date());
    }

    private Alquiler crearAlquiler(Usuario u, Juego j, Plataforma p, Date inicio) throws AlquilerException {
        if (u == null) {
            throw new AlquilerException("No hay ningún usuario seleccionado.");
        }
        if (j == null) {
            throw new AlquilerException("No hay ningún juego seleccionado.");
        }
        if (p == null) {
            throw new AlquilerException("Debes seleccionar una plataforma disponible.");
        }

        if (j.getDisponibles(p) <= 0) {
            throw new AlquilerException("No quedan unidades de " + p + " para el juego " + j.getTitulo() + ".");
        }

        for (int i = 0; i < alquileres.size(); i++) {
            Alquiler a = alquileres.get(i);
            if (a.getUsuario() == u && a.getJuego() == j && !a.isDevuelto()) {
                throw new AlquilerException("El usuario " + u.getNombreCompleto() + " ya tiene un alquiler activo del juego " + j.getTitulo() + ".");
            }
        }
        j.consumirUnidad(p);
        Alquiler nuevo = new Alquiler(siguienteNumero, u, j, p, inicio, Fechas.sumarDias(inicio, DIAS_ALQUILER));
        siguienteNumero++;
        alquileres.add(nuevo);
        return nuevo;
    }

    public void devolverAlquiler(Alquiler a) throws AlquilerException {
        if (a == null) {
            throw new AlquilerException("Debes seleccionar un alquiler de la lista.");
        }
        if (a.isDevuelto()) {
            throw new AlquilerException("Este alquiler ya ha sido devuelto.");
        }
        a.marcarDevuelto();
        a.getJuego().devolverUnidad(a.getPlataforma());
    }
    
    public void cargarDatosIniciales() {
        Date hoy = new Date();
        Usuario laura = new Usuario("Laura", "García", "Pérez", "12345678A", "600111222", hoy);
        Juego cyberpunk = new Juego("Cyberpunk 2077", "Acción", 0, 0, 1, 2);
        try {
            crearUsuario(laura);
            crearJuego(cyberpunk);
            crearAlquiler(laura, cyberpunk, Plataforma.XBOX, hoy);
        } catch (AlquilerException e) {
            System.out.println("Error cargando los datos iniciales: " + e.getMessage());
        }
    }
}
