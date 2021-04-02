package es.faculdade.rh.rhns.model;

import lombok.Data;

@Data
public class Funcionarios {

	private Integer idFuncionario;
	private String cpf;
	private String cnpj;
	private String nomeDoFuncionario;
	private Double salario;
	private Contratos contratos;
	private String cargo;
	private String senioridade;
}
