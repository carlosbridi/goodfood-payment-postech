package com.goodfood.payment.usecase;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
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
