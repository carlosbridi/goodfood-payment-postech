package com.goodfood.payment.usecase;

import org.springframework.stereotype.Component;
import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlterarStatusPagamentoImpl implements AlterarStatusPagamento {
  
  
  private final PagamentoGateway pagamentoGateway;
  
  @Override
  public void executar(String idPedido, EStatusPagamentoPedido status) {
    Pagamento pagamento = pagamentoGateway.obterPagamento(idPedido);
    
    pagamento.setStatusPagamento(status);
    pagamentoGateway.salvar(pagamento);
    
    
  }

}
