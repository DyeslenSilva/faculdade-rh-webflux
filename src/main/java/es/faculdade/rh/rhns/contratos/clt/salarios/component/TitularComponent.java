package es.faculdade.rh.rhns.contratos.clt.salarios.component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.uol.pagseguro.api.common.domain.builder.HolderBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.DocumentoEmpregado;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.Titular;

@Component
public class TitularComponent {

	private TelefoneComponent telefoneComponent;
	private DocumentoComponent documentoComponent;
	
	
	public HolderBuilder toHolderBuilder(Titular titular) {
		HolderBuilder builder;
		builder = new HolderBuilder()
				.withName(titular.getNome())
				.withPhone(telefoneComponent.toPhoneBuilder(titular.getTelefone()));
		
		try {
			builder.withBithDate(new SimpleDateFormat("dd/mm/yyyy").parse(
					titular.getDataDeAniversario().toString()));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<DocumentoEmpregado> documentoEmpregados = 
				titular.getDocumentoEmpregados();
		documentoEmpregados.forEach(documentos ->{
			builder.addDocument(
					documentoComponent.toDocumentBuilder(documentos));
		});
		
		return builder;
 	}
}