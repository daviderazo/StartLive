/**
 * 
 */
package com.dav.repositorio;

import java.util.List;

import com.dav.model.CatalogoValor;

/**
 * @author Dhartel
 *
 */
public interface CatalogoValorRep  extends BaseRep<CatalogoValor> {
	CatalogoValor findById(String id);
	List<CatalogoValor> findByIdPadre(String id);
}
