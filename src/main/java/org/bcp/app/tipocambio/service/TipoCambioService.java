package org.bcp.app.tipocambio.service;

import java.util.List;

import org.bcp.app.tipocambio.entity.TipoCambio;

import rx.Observable;
import rx.Single;

public interface TipoCambioService {
	
	public List<TipoCambio> findAll();
	public Single<TipoCambio> findById(Long id);
	public TipoCambio getById(Long id);
	public TipoCambio getByIdOrigen(Long id);
	
	//public TipoCambio getMonto(String monedao, String monedad);
	

}
