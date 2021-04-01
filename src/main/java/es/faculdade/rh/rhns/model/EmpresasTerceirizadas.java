package es.faculdade.rh.rhns.model;

import lombok.Data;

@Data
public class EmpresasTerceirizadas {

	private Integer idEmpTerc;
	private String cnpj;
	private String nomeDaEmpresa;
	private String funcionarios;
	private Contratos contratos;
	
}