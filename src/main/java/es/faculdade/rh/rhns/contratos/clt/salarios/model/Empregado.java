package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import lombok.Data;

@Data
public class Empregado {
	
	private Integer idEmpremgado;
	private Endereco endereco;
	private SalarioMes salarioMes;
	private Telefone telefone;
	private Titular titular;
}
