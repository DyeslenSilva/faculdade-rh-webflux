package es.faculdade.rh.rhns.contratos.pj.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.faculdade.rh.rhns.contratos.pj.model.CantinaContrato;
import es.faculdade.rh.rhns.contratos.pj.repo.CantinaContratoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cantinaCntAPI")
public class CantinaContratoController {

	
	private CantinaContratoRepo cantinaContratoRepo;
	
	@RequestMapping(path = "/saveContratoCantina",method = RequestMethod.POST)
	public Mono<CantinaContrato> cadastroCantinaContrato(@PathVariable CantinaContrato 
				cantinaContrato){
		return cantinaContratoRepo.save(cantinaContrato);
		
	}
	
	@RequestMapping(path = "/cantinaContratos" , method =  RequestMethod.GET)
	public Flux<CantinaContrato> getCantinaContratos(){
		return cantinaContratoRepo.findAll();
	}
	
	@RequestMapping(path = "/cantinaContratos/{idCantinaContratos}" , method = RequestMethod.GET)
	public Mono<CantinaContrato> getContratoPorID(@PathVariable Integer idCantinaContrato){
		return cantinaContratoRepo.findById(idCantinaContrato);
	}
	
	@RequestMapping(path = "/cantinaContratos/{idContratos}" , method = RequestMethod.PUT)
	public Mono<CantinaContrato> updateContrato(@PathVariable Integer idCantinaContrato){
		return cantinaContratoRepo.updateCantinaContrato(idCantinaContrato);
	}
	
	@RequestMapping(path = "/cantinaContratos/{idContratos}",method = RequestMethod.DELETE)
	public Mono<Void> deleteContrato(@PathVariable Integer idCantinaContrato){
		return cantinaContratoRepo.deleteById(idCantinaContrato);
	}
	
	
}
