package com.goodfood.payment.usecase;

import java.math.BigDecimal;

public interface GerarQRCode {

	String execute(String numeroPedido, BigDecimal valorPedido);
	
}
