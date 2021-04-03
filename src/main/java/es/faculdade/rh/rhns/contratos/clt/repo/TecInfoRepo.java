package es.faculdade.rh.rhns.contratos.clt.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.clt.model.TecInfContrato;
import reactor.core.publisher.Mono;

public interface TecInfoRepo extends R2dbcRepository<TecInfContrato, Integer> {

	public Mono<TecInfContrato> updateContrato(Integer idTecInfoContrato);
}
