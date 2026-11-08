/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author v
 */
public class Fechas {

    public static String formato(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public static Date sumarDias(Date fecha, int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DAY_OF_MONTH, dias);
        return c.getTime();
    }
}
