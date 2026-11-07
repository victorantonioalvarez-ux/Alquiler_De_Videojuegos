/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author v
 */
public class Juego {
    private final String titulo;
    private final String genero;
    private int [] unidades = new int[4];

    public Juego(String titulo, String genero, int unidadesPS5, int unidadesSwitch, int unidadesXbox, int unidadesPC) {
        this.titulo = titulo;
        this.genero = genero;
        
        unidades[0] = unidadesPS5;
        unidades[1] = unidadesSwitch;
        unidades[2] = unidadesXbox;
        unidades[3] = unidadesPC;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int[] getUnidades() {
        return unidades;
    }
    
    public void consumirUnidad(Plataforma p){
        unidades[p.ordinal()]--;
    }
    
    public void DevolucionUnidad(Plataforma p){
        unidades[p.ordinal()]++;
    }
    
    @Override
    public String toString() {
        return titulo;
    }
    
    
    
    
}
