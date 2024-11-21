package com.goodfood.payment.usecase;

import com.goodfood.payment.domain.EStatusPagamentoPedido;

public interface AlterarStatusPagamento {

  void executar(String idPedido, EStatusPagamentoPedido status);
  
}
