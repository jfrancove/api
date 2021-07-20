package org.bcp.app.tipocambio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bcp.app.tipocambio.dao.TipoCambioDao;
import org.bcp.app.tipocambio.entity.TipoCambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Autowired
	private TipoCambioDao tipoCambioDao;
	
	private Map<Long, TipoCambio> map = new HashMap<>();
	
	
	
	@Override
	public List<TipoCambio> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoCambio>) tipoCambioDao.findAll();
	}

	@Override
	public Single<TipoCambio> findById(final Long id) {
		// TODO Auto-generated method stub
		return Single.create(s -> {
			if(map.containsKey(id)) {
				s.onSuccess(map.get(id));
			}else {
				s.onError(new IllegalArgumentException("error"));
			}
		});
	}

	@Override
	public TipoCambio getById(Long id) {
		// TODO Auto-generated method stub
		return tipoCambioDao.getById(id);
	}

	@Override
	public TipoCambio getByIdOrigen(Long id) {
		// TODO Auto-generated method stub
		return tipoCambioDao.getById(id);
	}

		

}
