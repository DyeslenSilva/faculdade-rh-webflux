package es.faculdade.rh.rhns.contratos.clt.salarios.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import es.faculdade.rh.rhns.contratos.clt.salarios.service.CheckoutService;

public interface ServiceRHRepo extends R2dbcRepository<CheckoutService, Integer>{

}
