package com.goodfood.payment.usecase;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersistirPagamentoImpl implements PersistirPagamento {

	private final PagamentoGateway pagamentoGateway;

	@Override
	public Pagamento execute(String idPedido, BigDecimal valor, String qrCode) {
		return pagamentoGateway.save(Pagamento.builder()
		    .idPedido(idPedido)
		    .valor(valor)
		    .qrCode(qrCode)
		  .build());		
	}
	
	
}