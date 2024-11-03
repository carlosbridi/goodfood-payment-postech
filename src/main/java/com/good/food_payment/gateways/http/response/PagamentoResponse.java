package com.good.food_payment.gateways.http.response;

import java.math.BigDecimal;
import com.good.food_payment.domain.Pagamento;
import lombok.Data;

@Data
public class PagamentoResponse {

  private String idPedido;
  private String qrCode;
  private BigDecimal valor;
  
  public PagamentoResponse(Pagamento pagamento) {
    this.valor = pagamento.getValor();
    this.qrCode = pagamento.getQrCode();
    this.idPedido = pagamento.getIdPedido();
  }
  
}
