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

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GerarQRCodeImplTest {
  
  @InjectMocks
  private GerarQRCodeImpl provider;
  
  @Mock
  private PersistirPagamento persistirPagamento;

  @Captor
  private ArgumentCaptor<String> qrCodeCapture;
  
  @Test
  public void deveGerarQRCode() {
    when(persistirPagamento.executar(any(), any(), qrCodeCapture.capture())).thenReturn(null);

    String qrCode = provider.executar("123", BigDecimal.ONE);
    
    assertEquals(qrCode, qrCodeCapture.getValue());
  }
}
