/**
 * 
 */
package com.dav.common;

import lombok.Getter;

/**
 * @author Dhartel
 *
 */
@Getter
public enum EnumEncrytedValues {
	
	DECRYPTING("DC", "Valor desemcriptado"),
	ENCRYPTED("EN", "Valor encriptado");

	private final String valor;
	private final String descripcion;
	
	EnumEncrytedValues(String valor, String descripcion) {
		this.valor = valor;
		this.descripcion = descripcion;
	}

}
