package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Trabalho implements Serializable {
	
	private Integer idTrabalho;
	private String descricao;
	private BigDecimal pretencao;
}
