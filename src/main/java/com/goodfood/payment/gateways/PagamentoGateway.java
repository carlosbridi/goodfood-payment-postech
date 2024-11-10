package com.goodfood.payment.gateways;

import com.goodfood.payment.domain.Pagamento;

public interface PagamentoGateway {

	Pagamento salvar(final Pagamento pagamento);
	
	Pagamento obterPagamento(final String idPedido);
	
}
