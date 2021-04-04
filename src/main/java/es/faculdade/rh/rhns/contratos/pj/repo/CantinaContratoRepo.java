package es.faculdade.rh.rhns.contratos.pj.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.pj.model.CantinaContrato;
import reactor.core.publisher.Mono;

public interface CantinaContratoRepo extends R2dbcRepository<CantinaContrato, Integer> {
	
	public Mono<CantinaContrato> updateCantinaContrato(Integer idCanitnaContrato);
}
