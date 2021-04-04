package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Endereco  implements Serializable{

	private String codigoPostal;
	private String pais;
	private String estado;
	private String cidade;
	private String complemento;
	private String distrito;
	private String numero;
	private String rua;
}
