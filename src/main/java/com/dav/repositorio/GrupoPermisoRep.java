/**
 * 
 */
package com.dav.repositorio;

import java.util.List;

import com.dav.model.GrupoPermiso;

/**
 * @author Dhartel
 *
 */
public interface GrupoPermisoRep extends BaseRep<GrupoPermiso> {

	GrupoPermiso findById(long... id);

	List<GrupoPermiso> findById(long id);

}
