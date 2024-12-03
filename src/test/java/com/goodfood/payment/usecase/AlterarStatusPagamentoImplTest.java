package com.goodfood.payment.usecase;

import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlterarStatusPagamentoImplTest {
  
  @InjectMocks
  private AlterarStatusPagamentoImpl provider;
  
  @Mock
  private PagamentoGateway pagamentoGateway;
  
  @Captor
  private ArgumentCaptor<Pagamento> pagamentoCapture;
  
  @Test
  public void deveAtualizarPedido() {
    
    Pagamento pagamento = Pagamento.builder()
        .statusPagamento(EStatusPagamentoPedido.PENDENTE)
        .idPedido("123").build();
    
    when(pagamentoGateway.obterPagamento(anyString())).thenReturn(pagamento);
    
    when(pagamentoGateway.salvar(pagamentoCapture.capture())).thenReturn(pagamento);    
    provider.executar("123", EStatusPagamentoPedido.PAGO);
    
    assertEquals(EStatusPagamentoPedido.PAGO, pagamentoCapture.getValue().getStatusPagamento());
    
    
  }
  

}
