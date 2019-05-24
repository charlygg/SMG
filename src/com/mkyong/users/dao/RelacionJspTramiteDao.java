package com.mkyong.users.dao;

import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.model.RelacionJspTramite;

public interface RelacionJspTramiteDao {

	public RelacionJspTramite consultaRelacionJspTramite(CatalogoTramites tramite);
}
