package com.goodfood.payment.usecase;

import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersistirPagamentoImplTest {
  
  @InjectMocks
  private PersistirPagamentoImpl provider;
  
  @Mock
  private PagamentoGateway pagamentoGateway;
  
  @Test
  public void devePersistirPagamento() {
    Pagamento pagamento = Pagamento.builder()
        .statusPagamento(EStatusPagamentoPedido.PENDENTE)
        .idPedido("123").build();

    when(pagamentoGateway.salvar(any())).thenReturn(pagamento);

    Pagamento pagamentoRetorno = provider.executar("123", BigDecimal.ONE, "qrCode");
    
    assertEquals("123", pagamentoRetorno.getIdPedido());
  }
}
