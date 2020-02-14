/**
 * 
 */
package com.dav.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * @author Dhartel
 *
 */
@SuppressWarnings("serial")
@Data
public class ModelAuditoria implements Serializable {
	
	private Boolean estado;
	private LocalDateTime fecha;
	private LocalDateTime fechaModificacion;
	
	
}
