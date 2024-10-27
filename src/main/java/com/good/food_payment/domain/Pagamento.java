package com.good.food_payment.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pagamento {

	private String id;
	private String numeroPedido;
	private BigDecimal valor;
	
}
