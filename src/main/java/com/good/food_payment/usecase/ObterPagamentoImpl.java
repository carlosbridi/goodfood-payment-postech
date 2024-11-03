package com.good.food_payment.usecase;

import org.springframework.stereotype.Component;
import com.good.food_payment.domain.Pagamento;
import com.good.food_payment.gateways.PagamentoGateway;
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
