package com.good.food_payment.gateways.mongo;

import java.util.Optional;
import org.springframework.stereotype.Component;

import com.good.food_payment.domain.Pagamento;
import com.good.food_payment.domain.expcetions.PagamentoNotFoundException;
import com.good.food_payment.gateways.PagamentoGateway;
import com.good.food_payment.gateways.mongo.documents.PagamentoDocument;
import com.good.food_payment.gateways.mongo.repositories.PagamentoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PagamentoGatewayImpl implements PagamentoGateway {

  private final PagamentoRepository pagamentoRepository;

  @Override
  public Pagamento save(final Pagamento pagamento) {
    return pagamentoRepository.save(new PagamentoDocument(pagamento)).toDomain();
  }

  @Override
  public Pagamento obterPagamento(String idPedido) {
    final Optional<PagamentoDocument> byIdPedido = pagamentoRepository.findByIdPedido(idPedido);
    
    if (byIdPedido.isEmpty())
      throw new PagamentoNotFoundException("Pagamento não encontrado!");
    
    return byIdPedido.get().toDomain();
  }
  
}
