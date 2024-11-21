package com.goodfood.payment.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagamento {

	private String id;
	private String idPedido;
	private BigDecimal valor;
	private String qrCode;
	private EStatusPagamentoPedido statusPagamento;
	private LocalDateTime dataPagamento;
	private LocalDateTime criadoEm;

}
