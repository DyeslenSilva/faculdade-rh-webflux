package es.faculdade.rh.rhns.contratos.pj.model;

import es.faculdade.rh.rhns.model.EmpresasTerceirizadas;
import es.faculdade.rh.rhns.model.FuncionariosTerceiros;
import lombok.Data;

@Data
public class CantinaContrato {
	
	private Integer idContratoPJ;
	private EmpresasTerceirizadas empresasTerceirizadas;
	private FuncionariosTerceiros funcionariosTerceiros;
}
