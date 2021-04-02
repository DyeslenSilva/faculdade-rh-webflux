package es.faculdade.rh.rhns.contratos.clt;

import javax.persistence.Id;

import es.faculdade.rh.rhns.model.Funcionarios;
import lombok.Data;

@Data
public class RHContratos {

	@Id
	private Integer idRhContratos;

	private Funcionarios funcionariosRh;
}
