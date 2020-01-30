/**
 * 
 */
package com.dav.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Dhartel
 *
 */
@SuppressWarnings("serial")
public class ModelAuditoria implements Serializable {
	
	private Boolean estado;
	private LocalDateTime fecha;
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
