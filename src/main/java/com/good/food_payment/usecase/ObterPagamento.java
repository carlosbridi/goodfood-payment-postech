package com.good.food_payment.usecase;

import com.good.food_payment.domain.Pagamento;

public interface ObterPagamento {

  Pagamento obterPagamento(final String idPedido);
  
}
