package es.faculdade.rh.rhns.contratos.pj;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.faculdade.rh.rhns.model.EmpresasTerceirizadas;
import es.faculdade.rh.rhns.model.FuncionariosTerceiros;
import lombok.Data;

@Data
public class LimpezaFaxinaContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContratolimpezaFaxina;
	
	private FuncionariosTerceiros funcionariosTerceiros;
	private EmpresasTerceirizadas empresasTerceirizadas;
	
}
