package es.faculdade.rh.rhns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.rh.rhns.model.Professor;
import es.faculdade.rh.rhns.repo.ProfessorRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/professorAPI")
public class ProfessorController {

	@Autowired
	private ProfessorRepo professorRepo;
	
	@PostMapping("/cadastroProfessor")
	public Mono<Professor> cadastroProfessor(@PathVariable Professor professor){
		return professorRepo.save(professor);
	}

	@GetMapping("/professores")
	public Flux<Professor> getProfessores(){
		return professorRepo.findAll();
	}
	
	@GetMapping("/professor/{cpfProfessor}")
	public Mono<Professor> getProfessor(@PathVariable String cpfProfessor){
		return professorRepo.findById(cpfProfessor);
	}
	
	@PutMapping("/professor/{cpfProfessor}")
	public Mono<Professor> updateProfessor(@PathVariable String cpfProfessor){
		return professorRepo.updateProfessor(cpfProfessor);
	}
	
	@DeleteMapping("/professor/{cpfProfessor}")
	public Mono<Void> deleteProfessor(@PathVariable String cpfProfessor){
		return professorRepo.deleteById(cpfProfessor);
	}
}
