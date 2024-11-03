package com.good.food_payment.usecase;

import java.math.BigDecimal;

import com.good.food_payment.domain.Pagamento;

public interface PersistirPagamento {

	Pagamento execute(String idPedido, BigDecimal valor, String qrCode);
	
}
