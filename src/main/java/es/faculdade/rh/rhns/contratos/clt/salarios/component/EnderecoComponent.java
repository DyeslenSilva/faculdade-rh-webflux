package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.AddressBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Endereco;

@Component
public class EnderecoComponent {
	public AddressBuilder toAddressBuilder(Endereco endereco) {
		return new AddressBuilder()
				.withPostalCode(endereco.getCodigoPostal())
				.withCountry(endereco.getPais())
				.withState(endereco.getEstado())
				.withCity(endereco.getCidade())
				.withComplement(endereco.getComplemento())
				.withDistrict(endereco.getDistrito())
				.withNumber(endereco.getNumero())
				.withStreet(endereco.getRua());
	}
}