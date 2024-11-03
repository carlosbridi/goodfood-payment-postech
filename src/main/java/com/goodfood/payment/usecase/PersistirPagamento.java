package com.goodfood.payment.usecase;

import java.math.BigDecimal;
import com.goodfood.payment.domain.Pagamento;

public interface PersistirPagamento {

	Pagamento execute(String idPedido, BigDecimal valor, String qrCode);
	
}
