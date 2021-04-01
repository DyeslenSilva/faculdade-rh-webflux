package es.faculdade.rh.rhns.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.model.Professor;
import reactor.core.publisher.Mono;

public interface ProfessorRepo extends R2dbcRepository<Professor, String> {

	public Mono<Professor> updateProfessor(String cpf);
}
