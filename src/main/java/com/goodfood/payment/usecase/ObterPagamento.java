package com.goodfood.payment.usecase;

import com.goodfood.payment.domain.Pagamento;

public interface ObterPagamento {

  Pagamento obterPagamento(final String idPedido);
  
}
