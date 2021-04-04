package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.PhoneBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Telefone;

@Component
public class TelefoneComponent {

	public PhoneBuilder toPhoneBuilder(Telefone telefone) {
		return new PhoneBuilder().withAreaCode(telefone.getCodigoArea())
				.withNumber(telefone.getNumero());	
		}
}
