package com.goodfood.payment.usecase;

import org.springframework.stereotype.Component;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObterPagamentoImpl implements ObterPagamento {
  
  private final PagamentoGateway pagamentoGateway;
  
  @Override
  public Pagamento obterPagamento(String idPedido) {
    return pagamentoGateway.obterPagamento(idPedido);
  }

  
  
}
