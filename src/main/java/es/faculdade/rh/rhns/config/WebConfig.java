package es.faculdade.rh.rhns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.PagSeguroEnv;
import br.com.uol.pagseguro.api.credential.Credential;
import br.com.uol.pagseguro.api.http.JSEHttpClient;
import br.com.uol.pagseguro.api.utils.logging.SimpleLoggerFactory;
import es.faculdade.rh.rhns.withConfig.ParamsConfig;
import lombok.Getter;

@EnableWebFlux
@Configuration
public class WebConfig implements  WebFluxConfigurer{
	
	@Getter 
	private String header;
	
	@Getter
	private String allowedOrigins;
	
	private ParamsConfig paramsConfig;
	
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/api/**")
	            .allowedOrigins(getAllowedOrigins())
	            .allowedMethods("GET", "POST","PUT", "DELETE")
	            .allowedHeaders(getHeader())
	            .allowCredentials(true);
	    }
	 
	 public PagSeguro getPagSeguro() {
		 return PagSeguro.instance(
				 new SimpleLoggerFactory(),
				 new JSEHttpClient(),
				 Credential.sellerCredential(paramsConfig.getSellerEmail(), paramsConfig.getToken()), PagSeguroEnv.SANDBOX);
	 }
	 
	 
	
}
