package com.mkyong.users.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_reportes", schema="reportes")
public class TramiteGenerico {
	
	@Id
	@Column(name="idreporte")
	private int idReporte;
	
	@Column(name="id_empresa")
	private int idEmpresa;
	
	@Column(name="id_tramite")
	private int idTramite;
	
	@Column(name="id_denuncia")
	private int idDenuncia;
	
	@Column(name="id_sucursal")
	private int idSucursal;
	
	@Column(name="id_responsable")
	private String idResponsable;
	
	@Column(name="vc_estatus")
	private String vc_estatus;
	
	@Column(name="dt_fecha_captura")
	private Date dt_fecha_captura;
	
	@Column(name="dt_fecha_inicio_tramite")
	private Date dt_fecha_inicio_tramite;
	
	@Column(name="dt_fecha_cierre_tramite")
	private Date dt_fecha_cierre_tramite;
	
	@Column(name="vc_asignado_a")
	private String vc_asignado;
	
	@Column(name="vc_departamento")
	private String vc_departamento;
	
	@Column(name="dt_fecha_ultima_modificacion")
	private Date dt_fecha_ultima_modificacion;
	
	@Column(name="vc_etapa")
	private String vc_etapa;
	
	@Column(name="vc_tmp1")
	private int vc_tmp1;
	

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}

	public int getIdDenuncia() {
		return idDenuncia;
	}

	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getidResponsable() {
		return idResponsable;
	}

	public void setidResponsable(String idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getVc_estatus() {
		return vc_estatus;
	}

	public void setVc_estatus(String vc_estatus) {
		this.vc_estatus = vc_estatus;
	}

	public Date getDt_fecha_captura() {
		return dt_fecha_captura;
	}

	public void setDt_fecha_captura(Date dt_fecha_captura) {
		this.dt_fecha_captura = dt_fecha_captura;
	}

	public Date getDt_fecha_inicio_tramite() {
		return dt_fecha_inicio_tramite;
	}

	public void setDt_fecha_inicio_tramite(Date dt_fecha_inicio_tramite) {
		this.dt_fecha_inicio_tramite = dt_fecha_inicio_tramite;
	}

	public Date getDt_fecha_cierre_tramite() {
		return dt_fecha_cierre_tramite;
	}

	public void setDt_fecha_cierre_tramite(Date dt_fecha_cierre_tramite) {
		this.dt_fecha_cierre_tramite = dt_fecha_cierre_tramite;
	}

	public String getVc_departamento() {
		return vc_departamento;
	}

	public void setVc_departamento(String vc_departamento) {
		this.vc_departamento = vc_departamento;
	}

	public int getVc_tmp1() {
		return vc_tmp1;
	}

	public void setVc_tmp1(int vc_tmp1) {
		this.vc_tmp1 = vc_tmp1;
	}
	
	public TramiteGenerico() { }

	public TramiteGenerico(int idReporte, int idEmpresa, int idTramite, int idDenuncia, int idSucursal,
			String idResponsable, String vc_estatus, Date dt_fecha_captura, Date dt_fecha_inicio_tramite,
			Date dt_fecha_cierre_tramite, String vc_departamento, int vc_tmp1) {
		super();
		this.idReporte = idReporte;
		this.idEmpresa = idEmpresa;
		this.idTramite = idTramite;
		this.idDenuncia = idDenuncia;
		this.idSucursal = idSucursal;
		this.idResponsable = idResponsable;
		this.vc_estatus = vc_estatus;
		this.dt_fecha_captura = dt_fecha_captura;
		this.dt_fecha_inicio_tramite = dt_fecha_inicio_tramite;
		this.dt_fecha_cierre_tramite = dt_fecha_cierre_tramite;
		this.vc_departamento = vc_departamento;
		this.vc_tmp1 = vc_tmp1;
	}
	

}
