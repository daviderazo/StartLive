/**
 * 
 */
package com.dav.common;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class TimeConvertTypes {
	private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";
	
	private static TimeConvertTypes instancia;
	
	private static TimeConvertTypes getInstancia() {
		if(instancia == null) {
			instancia = new TimeConvertTypes();
		}
		
		return instancia;
	}
	
	public static Date getDateOfLo(LocalDate localDate) {
		Date dateSalida = Date.from(
				localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()
			);
		return dateSalida;
	}
	
	public static LocalDateTime getLocalDateTimeOfTimestamp(Timestamp timestamp) {
		if(timestamp == null) {
			return null;
		} else {
			return timestamp.toLocalDateTime();
		}
	}
	
	public static String dateStringFormat(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
       return  localDateTime.format(formatter);
        
	}
	
	public static LocalDateTime aumentarFecha(LocalDateTime localDateTime, Long milisegundos) {
		Instant instantPlus = localDateTime.atZone(ZoneId.systemDefault()).toInstant().plusMillis(milisegundos);
		return instantPlus.atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		
	}
}
