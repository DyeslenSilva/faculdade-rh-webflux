package es.faculdade.rh.rhns.contratos.clt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.rh.rhns.contratos.clt.SecretariaContratos;
import es.faculdade.rh.rhns.contratos.clt.repo.SecContratosRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secContAPI")
public class SecretariaContratosController {

	private SecContratosRepo contratosRepo;
	
	@PostMapping("/contratosSecCad")
	public Mono<SecretariaContratos> cadsContratosSec(@PathVariable SecretariaContratos contratos){
		return contratosRepo.save(contratos);
	}
	
	@GetMapping("/contratosSec")
	public Flux<SecretariaContratos> getContratosSec(){
		return contratosRepo.findAll();
	}
	
	@GetMapping("/contratoSec/{idContrato}")
	public Mono<SecretariaContratos> getContrato(@PathVariable Integer idContrato){
		return contratosRepo.findById(idContrato);
	}
	
	@PutMapping("/contratosSec/{idContrato}")
	public Mono<SecretariaContratos> updateContratos(@PathVariable Integer idContrato){
		return contratosRepo.updateContratos(idContrato);
	}
	
	@DeleteMapping("/contratosSec/idContrato")
	public Mono<Void> deleteContratos(@PathVariable Integer idContrato){
		return contratosRepo.deleteById(idContrato);
	}

}
