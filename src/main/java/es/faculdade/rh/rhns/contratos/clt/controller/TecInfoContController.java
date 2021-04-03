package es.faculdade.rh.rhns.contratos.clt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.rh.rhns.contratos.clt.model.TecInfContrato;
import es.faculdade.rh.rhns.contratos.clt.repo.TecInfoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tecInfContAPI")
public class TecInfoContController {

	private TecInfoRepo infoRepo;
	
	@PostMapping("/tecInfoContCad")
	public Mono<TecInfContrato> 
			cadastroContratoTec(@PathVariable TecInfContrato tecInfContrato){
				return infoRepo.save(tecInfContrato);
	}
	
	@GetMapping("/tecContratos")
	public Flux<TecInfContrato> getContratosTec(){
		return infoRepo.findAll();
	}
	
	@GetMapping("/tecContratos/{idTecInfoContrato")
	public Mono<TecInfContrato> getContratoTec(@PathVariable Integer idTecInfoContrato){
		return infoRepo.findById(idTecInfoContrato);
	}
	
	@PutMapping("/upTecInfContrato/{idTecInfoContrato}")
	public Mono<TecInfContrato> updateContratoTec(@PathVariable Integer idTecInfoContrato){
		return infoRepo.updateContrato(idTecInfoContrato);
	}
	
	@DeleteMapping("/tecnInfoContratos/{idTecInfoContrato}")
	public Mono<Void> deleteContratoTec(@PathVariable Integer idtecInfoContrato){
		return infoRepo.deleteById(idtecInfoContrato);
	}
	
}
