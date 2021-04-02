package es.faculdade.rh.rhns.contratos.clt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.rh.rhns.contratos.clt.RHContratos;
import es.faculdade.rh.rhns.contratos.clt.repo.RHContratosRepo;
import es.faculdade.rh.rhns.contratos.model.ContratoCLT;
import es.faculdade.rh.rhns.repo.ContratoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/rhContratos")
public class RHContratosController {
	
	@Autowired
	private RHContratosRepo rhContratosRepo;
	
	@PostMapping("/rhcontratos")
	public Mono<RHContratos> cadastroRhContratos(@PathVariable RHContratos clt){
		return rhContratosRepo.save(clt);
	}
	
	@GetMapping("/allRhContratos")
	public Flux<RHContratos> getContratos (){
		return rhContratosRepo.findAll();
	}
	
	@GetMapping("/rhContrato/{idContrato}")
	public Mono<RHContratos> getContratoPorId(@PathVariable Integer idContrato){
		return rhContratosRepo.findById(idContrato);
	}
	
	@PutMapping("/rhContrato/{idContrato}")
	public Mono<RHContratos> updateContratos(@PathVariable Integer idContrato){
		return rhContratosRepo.updateContratos(idContrato);
	}
	
	@DeleteMapping("/rhContrato/{idContrato")
	public Mono<Void> deleteContratos(@PathVariable Integer idContrato){
		return rhContratosRepo.deleteById(idContrato);
	}
	
	
}
