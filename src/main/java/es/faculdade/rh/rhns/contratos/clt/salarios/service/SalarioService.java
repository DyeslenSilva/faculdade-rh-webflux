package es.faculdade.rh.rhns.contratos.clt.salarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.common.domain.DataList;
import br.com.uol.pagseguro.api.installment.InstallmentDetail;
import br.com.uol.pagseguro.api.installment.InstallmentListingBuilder;
import es.faculdade.rh.rhns.contratos.clt.salarios.model.CartaoDeCredito;

@Service
public class SalarioService {

	@Autowired
	private PagSeguro pagSeguro;
	
	private CartaoDeCredito cartaoDeCredito;

	
	@SuppressWarnings("unchecked")
	public List<InstallmentDetail> getOpcao() throws Exception{
		List<InstallmentDetail> lista = new ArrayList<>();
		
		DataList<? extends InstallmentDetail> dataList =
				pagSeguro.installments().list(new 
						InstallmentListingBuilder()
						.withCardBrand(cartaoDeCredito.getBandeira()
								).withAmount(cartaoDeCredito.getSalarioBigDecimal())
						.withMaxInstallmentNoInterest(cartaoDeCredito.getParcelaSemJuros()));
	
		System.out.println(dataList.getData());
		
		lista = (List<InstallmentDetail>) dataList.getData();
		
		return lista;
	}
}
