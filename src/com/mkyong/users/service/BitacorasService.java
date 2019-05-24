package com.mkyong.users.service;

import java.util.List;

import com.ixanaui.utils.BitacorasListBean;
import com.ixanaui.utils.MensajeBean;
import com.mkyong.users.model.Bitacoras;


public interface BitacorasService {
	public List<Bitacoras> lista();
	public List<Bitacoras> lista(Bitacoras nuevo);
	public List<BitacorasListBean> bitacoraComboEmpresa();
	public List<BitacorasListBean> bitacoraComboEstablecimiento(Bitacoras nuevo);
	public List<Bitacoras> bitacoraPorEmpresa(Bitacoras nuevo);
	public MensajeBean inserta(Bitacoras nuevo);
	public MensajeBean actualiza(Bitacoras nuevo);
	public MensajeBean elimina(Bitacoras nuevo);
	public Bitacoras consulta(Bitacoras nuevo);
}
