package com.example.shoppingstore.infraestructure.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public abstract class UtilDate {

    /**
     * @param fecha   fecha de tipo string
     * @param formato El formato con que se deseas formatera la fecha a partir de la constante DateTimeFormatter
     * @return Devuelve la fecha como LocalDateTime
     */
    public static LocalDate convert(String fecha, DateTimeFormatter formato) {
        return LocalDate.parse(fecha, formato);
    }

    /**
     * @param fecha   fecha de tipo string
     * @param formato El formato con que se deseas formatera la fecha a partir de la constante DateTimeFormatter
     * @return Devuelve la fecha como LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(String fecha, DateTimeFormatter formato) {
        return LocalDateTime.parse(fecha, formato);
    }

    /**
     * @param fecha   fecha de tipo LocalDate
     * @param formato El formato con que se deseas formatera la fecha a partir de la constante DateTimeFormatter
     * @return Devuelve la fecha como String
     */
    public static String convert(LocalDate fecha, DateTimeFormatter formato) {
        return fecha.format(formato);
    }

    /**
     * @param fecha   fecha de tipo String
     * @param formato El formato con que se deseas formatera la fecha a partir de la constante DateTimeFormatter
     * @return Devuelve la fecha como Date
     */
    public static Date convertToDate(String fecha, DateTimeFormatter formato) {
        return Date.from(LocalDate.parse(fecha, formato).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param fecha fecha de tipo Date a convertir a LocalDateTime
     * @return Devuelve la fecha convertida a LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(Date fecha) {
        return LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDate convertirToLocalDate(Date fecha) {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * @param fecha fecha de tipo LocalDateTime a convertir a Date
     * @return Devuelve la fecha convertida a Date
     */
    public static Date convert(LocalDateTime fecha) {
        return Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date convert(LocalDate fecha) {
        return Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String convertToDateTime(LocalDate fecha) {
        return LocalDateTime.ofInstant(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault()).toString();
    }

    public static boolean isValid(String fecha, DateTimeFormatter formato) {
        try {
            convert(fecha, formato);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
