package com.mkyong.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.users.dao.RelacionJspTramiteDao;
import com.mkyong.users.model.CatalogoTramites;
import com.mkyong.users.model.RelacionJspTramite;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RelacionJspTramiteServiceImpl implements RelacionJspTramiteService {

	@Autowired
	RelacionJspTramiteDao relacionjsptramiteDao;
	
	@Override
	public RelacionJspTramite consultaRelacionJspTramite(
			CatalogoTramites tramite) {
		// TODO Auto-generated method stub
		return relacionjsptramiteDao.consultaRelacionJspTramite(tramite);
	}
	


}
