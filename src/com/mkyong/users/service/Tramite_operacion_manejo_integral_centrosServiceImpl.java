package com.mkyong.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ixanaui.utils.MensajeBean;
import com.ixanaui.utils.WrapperTramite;
import com.mkyong.users.dao.Tramite_operacion_manejo_integral_centrosDao;
import com.mkyong.users.model.Tramite_operacion_manejo_integral_centros;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Tramite_operacion_manejo_integral_centrosServiceImpl implements Tramite_operacion_manejo_integral_centrosService {
	
	@Autowired
	Tramite_operacion_manejo_integral_centrosDao tramite_operacion_manejo_integral_centrosDao;

	@Override
	public List<Tramite_operacion_manejo_integral_centros> lista() {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.lista();
	}
	
	@Override
	public List<Tramite_operacion_manejo_integral_centros> lista(String rol) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.lista(rol);
	}


	@Override
	public MensajeBean inserta(Tramite_operacion_manejo_integral_centros nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.inserta(nuevo);
	}

	@Override
	public MensajeBean actualiza(Tramite_operacion_manejo_integral_centros nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.actualiza(nuevo);
	}

	@Override
	public MensajeBean elimina(Tramite_operacion_manejo_integral_centros nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.elimina(nuevo);
	}

	@Override
	public Tramite_operacion_manejo_integral_centros consulta(Tramite_operacion_manejo_integral_centros nuevo, String rol) {
		return tramite_operacion_manejo_integral_centrosDao.consulta(nuevo, rol);
	}

	@Override
	public List<WrapperTramite> listaTramitesByZona(String municipio,
			String colonia) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.listaTramitesByZona(municipio, colonia);
	}

	@Override
	public List<Tramite_operacion_manejo_integral_centros> busquedaById(
			Tramite_operacion_manejo_integral_centros nuevo) {
		// TODO Auto-generated method stub
		return tramite_operacion_manejo_integral_centrosDao.busquedaById(nuevo);
	}
}

