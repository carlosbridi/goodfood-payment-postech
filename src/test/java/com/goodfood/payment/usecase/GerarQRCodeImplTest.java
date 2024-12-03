package com.test.java.com.goodfood.payment.usecase;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GerarQRCodeImplTest {

  @InjectMocks
  private GerarQRCodeImpl provider;

  @Mock
  private PersistirPagamentoImpl persistirPagamento;

  @Test
  public void deveGerarQRCode() {

    String idPedido = "idPedidoUUID";
    BigDecimal valorPedido = BigDecimal.valueOf(127.5);
    String qrCode = provider.executar(idPedido, valorPedido);

    assertNotNull(qrCode);
    assertTrue(qrCode.endsWith("BR.GOV.BCB.PIX2572pix-qr.mercadopago.com/instore/o/v2/idPedidoUUID5204127.553039865802BR5925Grupo 63 6009SAO PAULO62070503***6304B61D"));

    verify(persistirPagamento).executar(idPedido, valorPedido, qrCode);
  }

}
