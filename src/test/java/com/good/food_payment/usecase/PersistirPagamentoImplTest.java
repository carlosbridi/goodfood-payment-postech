package com.good.food_payment.usecase;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.PagamentoGateway;
import com.goodfood.payment.usecase.PersistirPagamentoImpl;

@RunWith(MockitoJUnitRunner.class)
public class PersistirPagamentoImplTest {

  @InjectMocks
  private PersistirPagamentoImpl provider;

  @Mock
  private PagamentoGateway pagamentoGateway;

  @Test
  public void shouldPersistPayment() {

    final String idPedido = UUID.randomUUID().toString();
    final BigDecimal valor = new BigDecimal(10.23d);
    final String qrCode = "qrCodeMP";
    final Pagamento p = Pagamento.builder().idPedido(idPedido).valor(valor).qrCode(qrCode).build();
    when(pagamentoGateway.save(any())).thenReturn(p);
    
    final Pagamento pagamento = provider.execute(idPedido, valor, qrCode);
    
    verify(pagamentoGateway).save(any());
    assertNotNull(pagamento);
    
  }

}
