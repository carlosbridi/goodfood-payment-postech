package com.good.food_payment.gateways.mongo.documents;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.good.food_payment.domain.Pagamento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document("pagamento")
@NoArgsConstructor
public class PagamentoDocument {

	@Id private String id;
	
	private String numeroPedido;
	
	private BigDecimal valor;
	
	public PagamentoDocument(final Pagamento pagamento) {
		this.id = pagamento.getId();
		this.numeroPedido = pagamento.getNumeroPedido();
		this.valor = pagamento.getValor();
	}
	
	public Pagamento toDomain() {
		return Pagamento.builder()
			.id(id)
			.numeroPedido(numeroPedido)
			.valor(valor)
		.build();
	}
}
