package es.faculdade.rh.rhns.contratos.clt.salarios.service;

import java.util.Date;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.common.domain.BankName.Name;
import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.common.domain.builder.BankBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.DateRangeBuilder;
import br.com.uol.pagseguro.api.transaction.register.DirectPaymentRegistrationBuilder;
import br.com.uol.pagseguro.api.transaction.search.TransactionDetail;
import br.com.uol.pagseguro.api.transaction.search.TransactionSummary;
import es.faculdade.rh.rhns.contratos.clt.salarios.component.CartaoDeCreditoComponent;
import es.faculdade.rh.rhns.contratos.clt.salarios.component.PagamentoComponent;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Pagamento;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.SalarioMes;
import es.faculdade.rh.rhns.exception.TransacaoAbortadaException;

public class CheckoutTranparenceService {	
	private PagSeguro pagSeguro;
	private PagamentoComponent pagamentoComponent;
	private CartaoDeCreditoComponent cartaoDeCreditoComponent;
	
	public DataList<? extends TransactionSummary> getTransasaoPorData(Date dataInicial,
				Date dataFinal) throws TransacaoAbortadaException{
		try {
			final int pagina =1;
			final int maxResultados =10;
			
			final DataList<? extends TransactionSummary> transacoes = 
					pagSeguro.transactions().search().byDateRange(
							new DateRangeBuilder().between(dataInicial, dataFinal),
							pagina, maxResultados);
			System.out.println(transacoes.size());
			return transacoes;
		}catch (Exception e) {
			e.printStackTrace();
			throw new TransacaoAbortadaException(e.getMessage(),e.getCause());
		}
	}
	
	public TransactionDetail buscaTransacaoPorCodigo(String codigoDaTransacao)
		throws TransacaoAbortadaException{
		try {
			TransactionDetail transactionDetail = pagSeguro.transactions()
					.search().byCode(codigoDaTransacao);
			System.out.println(transactionDetail);
			return transactionDetail;
		}catch (Exception e) {
			e.printStackTrace();
			throw new TransacaoAbortadaException(e.getMessage(),e.getCause());
		}
	}
	
	public TransactionDetail getTransacaoPorCodigoNotificacao(String codigoNotificacao)
		throws TransacaoAbortadaException{
		
		TransactionDetail transactionDetail = pagSeguro.transactions()
				.search().byNotificationCode(codigoNotificacao);
		System.out.println(transactionDetail);
		return transactionDetail;
	}
	
	public void criarTransacaoTransparentePorCartaoDeCredito(Pagamento pagamento) 
		throws TransacaoAbortadaException{
		DirectPaymentRegistrationBuilder builder = 
				pagamentoComponent.toDirectPaymentRegistrationBuilder(pagamento);
		TransactionDetail creditCardTransaction = pagSeguro.transactions()
				.register(builder)
				.withCreditCard(
					cartaoDeCreditoComponent.toCreditCardBuilder(pagamento.getCartaoDeCredito()));
		System.out.println(creditCardTransaction);
	}
	
	
	public void criarTransacaoTransparentePorDebitoOnline(Pagamento pagamento)
		throws TransacaoAbortadaException{
		DirectPaymentRegistrationBuilder registrationBuilder = 
				pagamentoComponent.toDirectPaymentRegistrationBuilder(pagamento);
		TransactionDetail onlineDebitTransaction = 
				pagSeguro.transactions().register(registrationBuilder)
					.withOnlineDebit(new BankBuilder()
							.withName(Name.BANCO_DO_BRASIL));
		System.out.println(onlineDebitTransaction);
	}
	
}
