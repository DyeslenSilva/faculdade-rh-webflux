package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.InstallmentBuilder;
import br.com.uol.pagseguro.api.transaction.register.DirectPaymentRegistrationBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Pagamento;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Trabalho;
import es.faculdade.rh.rhns.utils.ConstanteUtil;
import lombok.Data;

@Component
@Data
public class PagamentoComponent {

	private RemetenteComponent remetenteComponent;
	
	private RemessaComponent remessaComponent;
	
	private TrabalhoComponent trabalhoComponent;
	
	public DirectPaymentRegistrationBuilder toDirectPaymentRegistrationBuilder(
			Pagamento pagamento) {
		DirectPaymentRegistrationBuilder registrationBuilder = 
				new DirectPaymentRegistrationBuilder()
				.withPaymentMode(pagamento.getModoDePagamento())
				.withCurrency(pagamento.getMoeda())
				.withExtraAmount(pagamento.getSalario())
				.withNotificationURL(ConstanteUtil.URL_NOTIFICATION)
				.withReference(ConstanteUtil.REFERENCE_LIB_JAVA)
				.withSender(
						remetenteComponent.toSenderBuilder(pagamento.getRemetente()))
				.withShipping(
						remessaComponent.toShippingBuilder(pagamento.getRemessa()));
		
		
		List<Trabalho> trabalhos = pagamento.getTrabalhos();
		
		trabalhos.forEach(trab -> {
			registrationBuilder.addItem(
					TrabalhoComponent.paymentItemBuilder(trab));
			
		});
		
		return registrationBuilder;
		
	}
	
	
	public InstallmentBuilder toInstallmentBuilder(Pagamento pagamento) {
		return new InstallmentBuilder()
				.withQuantity(pagamento.getMesSalario())
				.withValue(pagamento.getSalario());
	}
	
	
}
