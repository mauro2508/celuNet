package com.ceiba.compra.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public final class DateUtil {

    private DateUtil(){}

    public static boolean compararMesDia(LocalDate fechaActual, LocalDate fechaComparar){
        return (fechaActual.getMonth().equals(fechaComparar.getMonth())
                && fechaActual.getDayOfMonth() == fechaComparar.getDayOfMonth());
    }

    public static boolean compararDia(LocalDate fechaActual, DayOfWeek diaComparar){
        return fechaActual.getDayOfWeek().equals(diaComparar);
    }

    public static LocalDate obtenerFechaUltimoViernesMes() {
        LocalDate fechaActual = LocalDate.now();

        LocalDate fechaUltimoViernes = LocalDate.of(fechaActual.getYear(),fechaActual.getMonth(),fechaActual.lengthOfMonth());

        while (!fechaUltimoViernes.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
                fechaUltimoViernes = fechaUltimoViernes.minusDays(1);
        }
        return  fechaUltimoViernes;
    }
}
