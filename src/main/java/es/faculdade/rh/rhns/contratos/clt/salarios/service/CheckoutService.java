package es.faculdade.rh.rhns.contratos.clt.salarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.checkout.CheckoutRegistrationBuilder;
import br.com.uol.pagseguro.api.checkout.RegisteredCheckout;
import br.com.uol.pagseguro.api.common.domain.builder.AcceptedPaymentMethodsBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.PaymentMethodBuilder;
import br.com.uol.pagseguro.api.common.domain.enums.PaymentMethodGroup;
import es.faculdade.rh.rhns.contratos.clt.salarios.component.RemessaComponent;
import es.faculdade.rh.rhns.contratos.clt.salarios.component.RemetenteComponent;
import es.faculdade.rh.rhns.contratos.clt.salarios.component.TrabalhoComponent;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Pagamento;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Trabalho;
import es.faculdade.rh.rhns.exception.TransacaoAbortadaException;

public class CheckoutService {
	
	@Autowired
	private PagSeguro pagSeguro;
	
	@Autowired
	private RemetenteComponent remetenteComponent;
	
	@Autowired
	private RemessaComponent remessaComponent;
	
	@Autowired
	private TrabalhoComponent trabalhoComponent;

	
	public void checkoutRegister(Pagamento pagamento) throws TransacaoAbortadaException{
		try {
			CheckoutRegistrationBuilder registrationBuilder = new
					CheckoutRegistrationBuilder()
					.withCurrency(pagamento.getMoeda())
					.withExtraAmount(pagamento.getSalario())
					.withReference(pagamento.getReferencia())
					.withSender(remetenteComponent.toSenderBuilder(pagamento.getRemetente()))
					.withShipping(remessaComponent.toShippingBuilder(pagamento.getRemessa()));
			
			
			registrationBuilder.withAcceptedPaymentMethods(new AcceptedPaymentMethodsBuilder()
					.addInclude(new PaymentMethodBuilder()
							.withGroup(PaymentMethodGroup.BALANCE))
					.addInclude(new PaymentMethodBuilder()
							.withGroup(PaymentMethodGroup.BANK_SLIP))
					.addInclude(new PaymentMethodBuilder()
							.withGroup(PaymentMethodGroup.CREDIT_CARD))
					.addInclude(new PaymentMethodBuilder()
							.withGroup(PaymentMethodGroup.DEPOSIT))
					.addInclude(new PaymentMethodBuilder()
							.withGroup(PaymentMethodGroup.ONLINE_DEBIT)));
			
			
			List<Trabalho> trabalhos = pagamento.getTrabalhos();
			trabalhos.forEach(trb ->{
				registrationBuilder.addItem(TrabalhoComponent.paymentItemBuilder(trb));
			});
			
			
			RegisteredCheckout checkout = pagSeguro.checkouts().register(registrationBuilder);
			System.out.println(checkout.getRedirectURL());
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new TransacaoAbortadaException(e.getMessage(),e.getCause());
		}
	}
}
