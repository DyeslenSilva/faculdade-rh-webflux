package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartaoDeCredito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String token;
	private Titular titular;
	private SalarioMes mes;
}
