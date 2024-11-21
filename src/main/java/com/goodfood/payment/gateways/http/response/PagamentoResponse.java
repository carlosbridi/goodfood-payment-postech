package com.goodfood.payment.gateways.http.response;

import java.math.BigDecimal;
import com.goodfood.payment.domain.Pagamento;
import lombok.Data;

@Data
public class PagamentoResponse {

  private String idPedido;
  private String qrCode;
  private BigDecimal valor;
  private String status;
  
  public PagamentoResponse(Pagamento pagamento) {
    this.valor = pagamento.getValor();
    this.qrCode = pagamento.getQrCode();
    this.idPedido = pagamento.getIdPedido();
    this.status = pagamento.getStatusPagamento().name;
  }
  
}
