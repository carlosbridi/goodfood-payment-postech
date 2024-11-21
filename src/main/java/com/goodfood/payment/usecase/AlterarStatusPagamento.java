package com.goodfood.payment.usecase;

import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;

public interface AlterarStatusPagamento {

  Pagamento executar(String idPedido, EStatusPagamentoPedido status);
  
}
