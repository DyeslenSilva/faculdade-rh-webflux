package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartaoDeCredito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String token;
	
	private Integer parcelaSemJuros;
	private Pagamento salario;
	
	private Titular titular;
	private SalarioMes salarioMes;
	private Endereco endereco;
	//private SalarioMes salarioMes
	private String bandeira;
	private BigDecimal salarioBigDecimal;
	
}
