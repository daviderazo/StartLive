/**
 * 
 */
package com.dav.common;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class TimeConvertTypes {
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
}
