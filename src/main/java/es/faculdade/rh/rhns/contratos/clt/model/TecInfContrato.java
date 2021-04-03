package es.faculdade.rh.rhns.contratos.clt.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.faculdade.rh.rhns.model.Funcionarios;
import lombok.Data;

@Data
public class TecInfContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTecInfContrato;
	private Funcionarios funcionarioTI;

}
