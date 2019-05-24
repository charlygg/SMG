package com.mkyong.users.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ixanaui.utils.WrapperTramiteCorrespondencia;
import com.mkyong.users.model.TramiteGenerico;
import com.mysql.jdbc.CallableStatement;

@Repository("tramiteGenerico")
public class TramiteGenericoDaoImpl implements TramiteGenericoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TramiteGenerico> lista(String rol) {
		@SuppressWarnings("unchecked")
		List<TramiteGenerico> listado = sessionFactory.getCurrentSession().createCriteria(TramiteGenerico.class).list();
		System.out.println("Tamaño del listado " + listado.size());
		return listado;
	}

	@Override
	public List<WrapperTramiteCorrespondencia> listado(int modo, Date fechaInicio, Date fechaFin) {
		List<WrapperTramiteCorrespondencia> listado = new ArrayList<WrapperTramiteCorrespondencia>();
		@SuppressWarnings("deprecation")
		Connection cn = sessionFactory.openStatelessSession().connection();
		try {
			CallableStatement sp = (CallableStatement) cn.prepareCall("CALL testsecurity.sp_relaciones_diarias_solicitudes(?, ?)");
			sp.setString(1,"2016-06-01");
			sp.setString(2,"2016-06-30");
			ResultSet res = sp.executeQuery();
			while(res.next()){
				WrapperTramiteCorrespondencia t = new WrapperTramiteCorrespondencia();
				t.setIdTramite(res.getInt("NO_TRAMITE"));
				t.setTramite(res.getString("TRAMITE"));
				t.setEmpresa(res.getString("EMPRESA"));
				t.setRep_legal(res.getString("REPRESENTANTE_LEGAL"));
				t.setAsunto(res.getString("ASUNTO"));
				t.setTurnado(res.getString("TURNADO"));
				listado.add(t);
			}
			
			res.close();
			sp.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listado;
	}

}
