package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.transaction.search.TransactionDetail;
import br.com.uol.pagseguro.api.transaction.search.TransactionSummary;
import es.faculdade.rh.rhns.contratos.clt.salarios.service.CheckoutService;
import es.faculdade.rh.rhns.contratos.clt.salarios.service.CheckoutTranparenceService;

@RestController
@RequestMapping(value = "/checkout")

public class CheckoutRestController {

	@Autowired
	private CheckoutService checkoutService;
	
	@Autowired
	private CheckoutTranparenceService checkoutTranparenceService;

	//private Transacoes transacoes;
	
	@GetMapping(value = "/transacoes/data")
	public ResponseEntity<?> buscarTransacaoesPorDatas(
			@RequestParam(value = "dataInicial", required = true)
			@DateTimeFormat(pattern ="dd-MM-yyyy")Date dataInicial,
			@RequestParam(value = "dataFinal", required = true)
			@DateTimeFormat(pattern = "dd-MM-yyyy")Date dataFinal){
		DataList<? extends TransactionSummary> listaDeTransacoes = 
				checkoutTranparenceService.getTransasaoPorData(dataInicial, dataFinal);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaDeTransacoes);
	}
	
	@GetMapping(value = "/transacao/codigo/{codigo}")
	public ResponseEntity<?> buscarTransacaoPorCodigo(
			@PathVariable(value = "codigo")String codigo){
		TransactionDetail transactionDetail = checkoutTranparenceService
				.buscaTransacaoPorCodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(transactionDetail);
	}
	
	@GetMapping(value = "/transacao/codigoNotificacao/{codigoNotificacao}")
	public ResponseEntity<?> buscarTransacaoPorCodigoNotificacao(
			@PathVariable(value = "codigoDaNotificacao") String codigoDaNotificao){
		TransactionDetail detail = checkoutTranparenceService.buscaTransacaoPorCodigo(codigoDaNotificao);
		return ResponseEntity.status(HttpStatus.OK).body(detail);
	}
	
	@PostMapping(value = "/registro")
	public ResponseEntity<?> registrarCheckout(@RequestBody Pagamento pagamento){
		checkoutService.checkoutRegister(pagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
