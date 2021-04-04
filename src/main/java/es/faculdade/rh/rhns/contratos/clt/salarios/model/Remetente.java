package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Remetente implements Serializable{

	private Integer idRemetente;
	
	private String nome;
	private String cpf;
	private String email;
	private Telefone telefone;
	private String hash;
}
