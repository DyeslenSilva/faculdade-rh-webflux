package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import br.com.uol.pagseguro.api.common.domain.builder.PaymentItemBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Trabalho;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TrabalhoComponent {
		
	public static PaymentItemBuilder paymentItemBuilder(Trabalho trabalho) {
		return new PaymentItemBuilder()
				.withId(Integer.toString(trabalho.getIdTrabalho()))
				.withDescription(trabalho.getDescricao())
				.withAmount(trabalho.getPretencao());
	}
}
