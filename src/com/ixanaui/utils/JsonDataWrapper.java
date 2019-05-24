package com.ixanaui.utils;

import java.io.Serializable;

public class JsonDataWrapper implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// current page
	private int draw;
	// total number of records for the given entity.
	private int recordsTotal;
	// list of records to be displayed.
	private int recordsFiltered;
	
	private Object[] data;
	
	public Object[] getData() {
		return data;
	}


	public void setData(Object[] data) {
		this.data = data;
	}


	public JsonDataWrapper(int draw,int recordsTotal, int recordsFiltered,Object[] data){
		this.draw=draw;
		this.recordsTotal= recordsTotal;
		this.recordsFiltered= recordsFiltered;
		this.data=data;
	}
	

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}