package org.bcp.app.tipocambio.dao;

import java.util.List;

import org.bcp.app.tipocambio.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioDao extends JpaRepository<TipoCambio, Long> {

	List<TipoCambio> findByMonedaoAndMonedad(String monedao, String monedad);
	
}
