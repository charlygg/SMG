package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_operacion_manejo_integral_establecimientosDao;
import com.mkyong.users.model.Tramite_operacion_manejo_integral_establecimientos;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_operacion_manejo_integral_establecimientosServiceImpl implements Tramite_operacion_manejo_integral_establecimientosService {
	
	@Autowired
	Tramite_operacion_manejo_integral_establecimientosDao tramite_operacion_manejo_integral_establecimientosDao;

	@Override
	public List<Tramite_operacion_manejo_integral_establecimientos> lista() {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.lista();
	}
	
	@Override
	public List<Tramite_operacion_manejo_integral_establecimientos> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.lista(rol);
	}


	@Override
	public MensajeBean inserta(Tramite_operacion_manejo_integral_establecimientos nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_operacion_manejo_integral_establecimientos nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_operacion_manejo_integral_establecimientos nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.elimina(nuevo);
	}

	@Override
	public Tramite_operacion_manejo_integral_establecimientos consulta(Tramite_operacion_manejo_integral_establecimientos nuevo, String rol) {
		return tramite_operacion_manejo_integral_establecimientosDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_operacion_manejo_integral_establecimientos> busquedaById(
			Tramite_operacion_manejo_integral_establecimientos nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_establecimientosDao.busquedaById(nuevo);
	}
}

