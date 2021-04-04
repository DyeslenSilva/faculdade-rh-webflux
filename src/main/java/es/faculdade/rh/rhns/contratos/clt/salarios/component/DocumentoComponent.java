package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.DocumentBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.DocumentoEmpregado;

@Component
public class DocumentoComponent {
	
	public DocumentBuilder toDocumentBuilder(DocumentoEmpregado documentoEmpregado) {
		return new 	DocumentBuilder()
				.withType(documentoEmpregado.getDocumentType())
				.withValue(documentoEmpregado.getValor());
	}
	
	
	
}
