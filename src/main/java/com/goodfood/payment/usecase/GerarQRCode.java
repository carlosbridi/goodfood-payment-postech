package com.goodfood.payment.usecase;

import java.math.BigDecimal;

public interface GerarQRCode {

	String executar(String numeroPedido, BigDecimal valorPedido);
	
}
