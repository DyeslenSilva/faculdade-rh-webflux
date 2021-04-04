package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.ShippingBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Remessa;

@Component
public class RemessaComponent {

	private EnderecoComponent enderecoComponent;
	
	public ShippingBuilder toShippingBuilder(Remessa remessa) {
		return new ShippingBuilder()
				.withType(remessa.getTipo())
				.withCost(remessa.getCusto())
				.withAddress(enderecoComponent.toAddressBuilder(remessa.getEndereco()));
	}
	
}
