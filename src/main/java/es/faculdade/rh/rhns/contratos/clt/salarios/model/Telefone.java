package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Telefone implements  Serializable{

	private Integer idTelefone;
	private String codigoArea;
	private String nome;
	
}