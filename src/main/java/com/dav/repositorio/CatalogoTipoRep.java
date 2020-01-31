/**
 * 
 */
package com.dav.repositorio;

import com.dav.model.CatalogoTipo;

/**
 * @author Dhartel
 *
 */
public interface CatalogoTipoRep extends BaseRep<CatalogoTipo> {
	 CatalogoTipo findById(String id);
}
