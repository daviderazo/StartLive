/**
 * 
 */
package com.dav.repositorio;

import com.dav.model.GrupoPermiso;

/**
 * @author Dhartel
 *
 */
public interface GrupoPermisoRep extends BaseRep<GrupoPermiso> {

	GrupoPermiso findById(long... id);

}
