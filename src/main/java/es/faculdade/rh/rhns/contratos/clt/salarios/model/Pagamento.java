package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.uol.pagseguro.api.common.domain.enums.Currency;
import lombok.Data;

@Data
public class Pagamento implements Serializable{

	private Integer idPagamento;
	private Currency moeda;
	private BigDecimal salario;
	private String referencia;
	private Remetente remetente;
	private List<Trabalho> trabalhos;
	private CartaoDeCredito cartaoDeCredito;
}