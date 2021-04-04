package es.faculdade.rh.rhns.contratos.pj.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.pj.model.ProfessorContrato;

public interface ProfessorContratoRepo extends R2dbcRepository<ProfessorContrato, Integer> {

}
