package es.faculdade.rh.rhns.model;

import lombok.Data;

@Data
public class Professor {
	
	//private Integer idProfessor;
	private String cpf;
	private String cnpj;
	private String nomeDoProfessor;
	private Double salarioProfessor;
	private Double horaAula;
	private Integer quantidadeHoras;
}
