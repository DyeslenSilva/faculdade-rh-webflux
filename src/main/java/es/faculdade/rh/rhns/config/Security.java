package es.faculdade.rh.rhns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

import lombok.Getter;

@EnableWebFluxSecurity
public class Security {

	@Getter
	private String admin;
	
	  @Bean
	    public SecurityWebFilterChain springSecurityFilterChain(
	      ServerHttpSecurity http) {
	        http.csrf().disable()
	          .authorizeExchange()
	          .pathMatchers(HttpMethod.GET, "/resource/").hasRole(getAdmin()	)
	          .pathMatchers("/**").permitAll()
	          .and()
	          .httpBasic();
	        return http.build();
	    }
}
