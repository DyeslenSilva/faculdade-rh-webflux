package es.faculdade.rh.rhns.contratos.clt;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.faculdade.rh.rhns.model.Funcionarios;
import lombok.Data;

@Data
public class SecretariaContratos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContratoSecretaria;
	
	private Funcionarios funcionariosSecretaria;
}
