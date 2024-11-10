package com.goodfood.payment.gateways.mongo.documents;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.goodfood.payment.domain.Pagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document("pagamento")
@NoArgsConstructor
public class PagamentoDocument {

	@Id private String id;
	private String qrCode;
	@Indexed
	private String idPedido;	
	private BigDecimal valor;
	private LocalDateTime dataPagamento;
	private LocalDateTime criadoEm;
	
	public PagamentoDocument(final Pagamento pagamento) {
		this.id = pagamento.getId();
		this.idPedido = pagamento.getIdPedido();
		this.valor = pagamento.getValor();
		this.qrCode = pagamento.getQrCode();
		this.dataPagamento = pagamento.getDataPagamento();
		this.criadoEm = pagamento.getCriadoEm();
	}
	
	public Pagamento toDomain() {
		return Pagamento.builder()
			.id(id)
			.qrCode(qrCode)
			.dataPagamento(dataPagamento)
			.idPedido(idPedido)
			.valor(valor)
			.criadoEm(criadoEm)
		.build();
	}
}
