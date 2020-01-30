/**
 * 
 */
package com.dav.repositorio;

import com.dav.model.CatalogoValor;

/**
 * @author Dhartel
 *
 */
public interface CatalogoValorRep  extends BaseRep<CatalogoValor> {
	CatalogoValor findById(String id);
}
