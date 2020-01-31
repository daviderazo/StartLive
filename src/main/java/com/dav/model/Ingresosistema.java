/**
 * 
 */
package com.dav.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class Ingresosistema extends ModelAuditoria {
	private Long idIngresoSistema;
	private LocalDateTime fechaingreso;
	private Long idUsuario;
	private Long idGrupo;
	private String valortipoDispocitivo;
	private String codigoTipoDispositivo;
	private LocalDateTime fechaSalida;
	private Long tiempoSistema;
	
	public Long getIdIngresoSistema() {
		return idIngresoSistema;
	}
	public void setIdIngresoSistema(Long idIngresoSistema) {
		this.idIngresoSistema = idIngresoSistema;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getValortipoDispocitivo() {
		return valortipoDispocitivo;
	}
	public void setValortipoDispocitivo(String valortipoDispocitivo) {
		this.valortipoDispocitivo = valortipoDispocitivo;
	}
	public String getCodigoTipoDispositivo() {
		return codigoTipoDispositivo;
	}
	public void setCodigoTipoDispositivo(String codigoTipoDispositivo) {
		this.codigoTipoDispositivo = codigoTipoDispositivo;
	}

	public Long getTiempoSistema() {
		return tiempoSistema;
	}
	public void setTiempoSistema(Long tiempoSistema) {
		this.tiempoSistema = tiempoSistema;
	}
	public LocalDateTime getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(LocalDateTime fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
}
