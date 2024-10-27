package com.good.food_payment.gateways;

import com.good.food_payment.domain.Pagamento;

public interface PagamentoGateway {

	Pagamento save(final Pagamento pagamento);
	
}
