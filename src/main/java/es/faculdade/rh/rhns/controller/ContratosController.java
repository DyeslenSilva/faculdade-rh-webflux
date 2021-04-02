package es.faculdade.rh.rhns.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.rh.rhns.model.Contratos;
import es.faculdade.rh.rhns.repo.ContratoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/contratosAPI")
public class ContratosController {

	private ContratoRepo contratoRepo;
	
	@PostMapping("/contratos")
	public Mono<Contratos> cadastrosDeContratos(@PathVariable Contratos contratos){
		return contratoRepo.save(contratos);
	}
	
	@GetMapping("/contratos")
	public Flux<Contratos> getContratos(){
		return contratoRepo.findAll();
	}
	
	@GetMapping("/contrato/{idContrato}")
	public Mono<Contratos> getContrato(@PathVariable Integer idContrato){
		return contratoRepo.findById(idContrato);
	}
	
	@PutMapping("/contrato/{idContrato}")
	public Mono<Contratos> updateContrato(@PathVariable Integer idContrato){
		return contratoRepo.updateContrato(idContrato);
	}
	
	@DeleteMapping("/contrato/{idContrato}")
	public Mono<Void> deleteContrato(@PathVariable Integer idContrato){
		return contratoRepo.deleteById(idContrato);
	}
	
	
	
}
