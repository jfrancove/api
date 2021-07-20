package org.bcp.app.tipocambio.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipocambio")
public class TipoCambio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String monedao;
	private String monedad;
	private Double tcambio;
	
	public TipoCambio() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonedao() {
		return monedao;
	}
	public void setMonedao(String monedao) {
		this.monedao = monedao;
	}
	public String getMonedad() {
		return monedad;
	}
	public void setMonedad(String monedad) {
		this.monedad = monedad;
	}
	public Double getTcambio() {
		return tcambio;
	}
	public void setTcambio(Double tcambio) {
		this.tcambio = tcambio;
	}
	
	public String toString() {
		return "TipoCambio [id=" + id + ", monedao=" + monedao + ", monedad=" + monedad + ", tcambio=" + tcambio +"]";
	}
			
}
