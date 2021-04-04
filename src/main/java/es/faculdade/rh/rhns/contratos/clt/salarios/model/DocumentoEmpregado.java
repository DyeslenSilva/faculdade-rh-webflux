package es.faculdade.rh.rhns.contratos.clt.salarios.model;

import br.com.uol.pagseguro.api.common.domain.enums.DocumentType;
import lombok.Data;

@Data
public class DocumentoEmpregado {

	private DocumentType documentType;
	private String valor;
}
