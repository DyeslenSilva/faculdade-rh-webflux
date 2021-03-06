package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.CreditCardBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.CartaoDeCredito;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Pagamento;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Titular;
import lombok.Data;

@Component
@Data
public class CartaoDeCreditoComponent {

	private EnderecoComponent enderecoComponent;
	private TitularComponent titularComponent;
	private PagamentoComponent pagamentoComponent;	

	
	public CreditCardBuilder toCreditCardBuilder(CartaoDeCredito cartaoDeCredito) {
		return new CreditCardBuilder()
				.withBillingAddress(
						enderecoComponent.toAddressBuilder(cartaoDeCredito.getEndereco()))
				.withInstallment(pagamentoComponent.toInstallmentBuilder(cartaoDeCredito.getSalario()))
				.withHolder(titularComponent.toHolderBuilder(cartaoDeCredito.getTitular()))
				.withToken(cartaoDeCredito.getToken());
	}
	}