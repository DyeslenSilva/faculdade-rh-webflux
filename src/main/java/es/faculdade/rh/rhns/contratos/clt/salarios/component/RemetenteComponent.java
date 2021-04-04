package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.SenderBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Remetente;

@Component
public class RemetenteComponent {

	private TelefoneComponent telefoneComponent;
	
	@SuppressWarnings("unused")
	private SenderBuilder toSenderBuilder(Remetente remetente) {
		return new SenderBuilder()
				.withEmail(remetente.getEmail())
				.withName(remetente.getNome())
				.withCPF(remetente.getCpf())
				.withHash(remetente.getHash())
				.withPhone(telefoneComponent.toPhoneBuilder(remetente.getTelefone()));
	}
}
