package com.goodfood.payment.usecase;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GerarQRCodeImpl implements GerarQRCode {
	
	private final PersistirPagamento persistirPagamento;
	
	@Override
	public String execute(String numeroPedido, BigDecimal valorPedido) {
		String qrCode = UUID.randomUUID().toString()
		    + "BR.GOV.BCB.PIX2572pix-qr.mercadopago.com/instore/o/v2/"
		    + numeroPedido + "5204" + valorPedido
		    + "53039865802BR5925Grupo 63 6009SAO PAULO62070503***6304B61D";
		
		persistirPagamento.execute(numeroPedido, valorPedido, qrCode);
		
		return qrCode;
	}
	
}
