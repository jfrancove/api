package org.bcp.app.tipocambio.entity;

import java.io.Serializable;

public class TipoCambioRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String monedaOrigen;	
	private String monedaCambio;
	private Double monto;
	
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaCambio() {
		return monedaCambio;
	}
	public void setMonedaCambio(String monedaCambio) {
		this.monedaCambio = monedaCambio;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
		
	
}
