package es.faculdade.rh.rhns.contratos.pj.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.pj.model.LimpezaFaxinaContrato;

public interface LimpezaFaxinaRepo extends R2dbcRepository<LimpezaFaxinaContrato, Integer> {

}
