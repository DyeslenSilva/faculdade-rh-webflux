package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.transaction.search.TransactionSummary;
import es.faculdade.rh.rhns.contratos.clt.salarios.repo.ServiceRHRepo;
import es.faculdade.rh.rhns.contratos.clt.salarios.service.CheckoutService;
import es.faculdade.rh.rhns.contratos.clt.salarios.service.CheckoutTranparenceService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {

	@Autowired
	private CheckoutService checkoutService;
	
	@Autowired
	private CheckoutTranparenceService checkoutTranparenceService;

	//private ServiceRHRepo repo;
	
	public ResponseEntity<?> buscarTransacaoesPorDatas(
			@RequestParam(value = "dataInicial", required = true)
			@DateTimeFormat(pattern ="dd-MM-yyyy")Date dataInicial,
			@RequestParam(value = "dataFinal", required = true)
			@DateTimeFormat(pattern = "dd-MM-yyyy")Date dataFinal){
		DataList<? extends TransactionSummary> listaDeTransacoes = 
				checkoutTranparenceService.getTransasaoPorData(dataInicial, dataFinal);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaDeTransacoes);
	}
}
