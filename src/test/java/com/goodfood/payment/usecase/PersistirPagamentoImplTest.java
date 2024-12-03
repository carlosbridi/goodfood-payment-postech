package com.test.java.com.goodfood.payment.usecase;

import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersistirPagamentoImplTest {

  @InjectMocks
  private PersistirPagamentoImpl provider;

  @Mock
  private PagamentoGateway pagamentoGateway;

  @Test
  public void devePersistirPagamento() {

    final String idPedido = UUID.randomUUID().toString();
    final BigDecimal valor = new BigDecimal(10.23d);
    final String qrCode = "qrCodeMP";
    final Pagamento p = Pagamento.builder()
        .idPedido(idPedido)
        .valor(valor).qrCode(qrCode)
        .statusPagamento(EStatusPagamentoPedido.PAGO)
        .build();
    when(pagamentoGateway.salvar(any())).thenReturn(p);

    final Pagamento pagamento = provider.executar(idPedido, valor, qrCode);

    verify(pagamentoGateway).salvar(any());
    assertNotNull(pagamento);
    assertEquals(idPedido, pagamento.getIdPedido());
    assertEquals(EStatusPagamentoPedido.PAGO, pagamento.getStatusPagamento());
    assertEquals(valor, pagamento.getValor());
    assertEquals(qrCode, pagamento.getQrCode());

  }

}
