package es.faculdade.rh.rhns.contratos.clt.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.clt.SecretariaContratos;
import reactor.core.publisher.Mono;

public interface SecContratosRepo extends R2dbcRepository<SecretariaContratos, Integer> {

	public Mono<SecretariaContratos> updateContratos(Integer idContratos);
}
