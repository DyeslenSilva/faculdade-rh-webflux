package es.faculdade.rh.rhns.contratos.clt.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.clt.model.RHContratos;
import reactor.core.publisher.Mono;

public interface RHContratosRepo extends R2dbcRepository<RHContratos, Integer> {

	public Mono<RHContratos> updateContratos(Integer idContrato);
}	
