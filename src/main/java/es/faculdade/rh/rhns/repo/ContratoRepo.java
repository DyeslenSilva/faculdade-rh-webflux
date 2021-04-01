package es.faculdade.rh.rhns.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.model.Contratos;

public interface ContratoRepo extends R2dbcRepository<Contratos, Integer> {

}
