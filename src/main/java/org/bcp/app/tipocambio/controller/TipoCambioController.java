package org.bcp.app.tipocambio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bcp.app.tipocambio.dao.TipoCambioDao;
import org.bcp.app.tipocambio.entity.TipoCambio;
import org.bcp.app.tipocambio.entity.TipoCambioRequest;
import org.bcp.app.tipocambio.entity.TipoCambioResponse;
import org.bcp.app.tipocambio.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.Subscriber;
import rx.schedulers.Schedulers;

@RestController
public class TipoCambioController {

	@Autowired
	private TipoCambioService tipoCambioService;
	
	@Autowired
	private TipoCambioDao tipoCambioDao;
	
	public TipoCambioController(@Autowired TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }
	
	@GetMapping(value = "/api/listartcambio")
	public List<TipoCambio> findAll() {
		return tipoCambioService.findAll();
	}
	
	
	/*@GetMapping(value = "/api/convertir", produces = MediaType.APPLICATION_JSON_VALUE)
	public TipoCambioResponse convertir(@RequestBody TipoCambioRequest tipoCambioRequest, HttpServletRequest request){
		
				
		List<TipoCambio> tc = tipoCambioDao.findByMonedaoAndMonedad(tipoCambioRequest.getMonedaOrigen(), tipoCambioRequest.getMonedaCambio());
				
		System.out.println("moneda origen " + tipoCambioRequest.getMonedaOrigen());
		System.out.println("moneda destino " + tipoCambioRequest.getMonedaCambio());
		System.out.println("monto " + tipoCambioRequest.getMonto());
		
		TipoCambioResponse tcr=new TipoCambioResponse();
		
		tcr.setMonedaDestino(tc.get(0).getMonedad());		
		tcr.setMonedaOrigen(tc.get(0).getMonedao());
		tcr.setMonto(tipoCambioRequest.getMonto());
		tcr.setMontoCambio(tipoCambioRequest.getMonto()*tc.get(0).getTcambio());
		tcr.setTipoCambio(tc.get(0).getTcambio());
		
		return tcr;
				
	}*/
	
	@GetMapping(value = "/api/convertir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCambioResponse> convertir(@RequestBody TipoCambioRequest tipoCambioRequest, HttpServletRequest request){
						
		List<TipoCambio> tc = tipoCambioDao.findByMonedaoAndMonedad(tipoCambioRequest.getMonedaOrigen(), tipoCambioRequest.getMonedaCambio());
		TipoCambioResponse tcr=new TipoCambioResponse();
		
		tcr.setMonedaDestino(tc.get(0).getMonedad());		
		tcr.setMonedaOrigen(tc.get(0).getMonedao());
		tcr.setMonto(tipoCambioRequest.getMonto());
		tcr.setMontoCambio(tipoCambioRequest.getMonto()*tc.get(0).getTcambio());
		tcr.setTipoCambio(tc.get(0).getTcambio());	
		
		Observable<TipoCambioResponse> source = Observable.just(tcr);
		//source.subscribe(s -> System.out.println("item: "+s.getClass()));
		
		source.subscribe(new Subscriber<TipoCambioResponse>() {

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Complete! ");
			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(TipoCambioResponse t) {
				// TODO Auto-generated method stub
				System.out.println("onNext: " + t.getMonedaDestino());
				System.out.println("onNext: " + t.getMonedaOrigen());
				System.out.println("onNext: " + t.getMonto());
				System.out.println("onNext: " + t.getMontoCambio());
			}
		});
		
		return ResponseEntity.ok(tcr);
				
	}
	

	
	
	
	
}
