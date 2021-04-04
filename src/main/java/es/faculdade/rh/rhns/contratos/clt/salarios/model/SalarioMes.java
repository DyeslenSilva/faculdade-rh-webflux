package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class SalarioMes implements Serializable{

	private Integer nMes;
	private BigDecimal valorSalario;
}
