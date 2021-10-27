package com.example.shoppingstore.infraestructure.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.util.Date;

@Converter(autoApply = true)
public class FechaConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDateTime) {
        return localDateTime != null ? UtilDate.convert(localDateTime) : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date != null ? UtilDate.convertirToLocalDate(date) : null;
    }
}
