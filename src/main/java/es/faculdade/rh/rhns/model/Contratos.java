package es.faculdade.rh.rhns.model;

import lombok.Data;

@Data
public class Contratos {

	private Integer idContrato;
	private Professor professor;
	private EmpresasTerceirizadas empresasTerceirizadas;
	private FuncionariosTerceiros funcionariosTerceiros;
	private Funcionarios funcionarios;
	private Double valorDoContrato;
}
