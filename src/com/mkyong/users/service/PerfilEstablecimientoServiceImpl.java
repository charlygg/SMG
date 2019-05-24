package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.PerfilEstablecimientoDao;
import com.mkyong.users.model.CatPerfilEstablecimiento;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PerfilEstablecimientoServiceImpl implements PerfilEstablecimientoService {
	
	@Autowired
	PerfilEstablecimientoDao perfilEstablecimientoDao;

	@Override
	public List<CatPerfilEstablecimiento> lista() {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.lista();
	}

	@Override
	public MensajeBean inserta(CatPerfilEstablecimiento nuevo) {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(CatPerfilEstablecimiento nuevo) {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(CatPerfilEstablecimiento nuevo) {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.elimina(nuevo);
	}

	@Override
	public CatPerfilEstablecimiento consulta(CatPerfilEstablecimiento nuevo) {
		return perfilEstablecimientoDao.consulta(nuevo);
	}

	@Override
	public List<CatPerfilEstablecimiento> consultaListByEmpresa(
			CatPerfilEstablecimiento nuevo) {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.consultaListByEmpresa(nuevo);
	}
	@Override
	public MensajeBean consultaMatriz(CatPerfilEstablecimiento nuevo) {
		return perfilEstablecimientoDao.consultaMatriz(nuevo);
	}

	@Override
	public List<String> getMunicipiosEstablecimientos() {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.getMunicipiosEstablecimientos();
	}

	@Override
	public List<String> getColoniasPorMunicipios(String municipio) {
		// TODO Auto-generated method stub
		return perfilEstablecimientoDao.getColoniasPorMunicipios(municipio);
	}

}
