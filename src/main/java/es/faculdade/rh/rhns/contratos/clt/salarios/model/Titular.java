package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Titular implements Serializable{

	private String nome;
	private Date dataDeAniversario;
	private Telefone telefone;
	private List<DocumentoEmpregado> documentoEmpregados;
}
