package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.uol.pagseguro.api.common.domain.ShippingType;
import lombok.Data;

@Data
public class Remessa implements Serializable {

	private ShippingType.Type tipo;
	
	private BigDecimal custo;
	
	private Endereco endereco;
}
