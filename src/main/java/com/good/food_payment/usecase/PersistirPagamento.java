package com.good.food_payment.usecase;

import org.springframework.stereotype.Component;

import com.good.food_payment.gateways.PagamentoGateway;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersistirPagamento {

	private final PagamentoGateway pagamentoGateway;
	
	public void execute() {
		
		//Validate, persist after
		pagamentoGateway.save(null);
	}
	
}
