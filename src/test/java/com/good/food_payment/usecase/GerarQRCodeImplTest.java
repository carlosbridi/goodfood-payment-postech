package com.good.food_payment.usecase;

import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.goodfood.payment.usecase.GerarQRCodeImpl;
import com.goodfood.payment.usecase.PersistirPagamentoImpl;

@RunWith(MockitoJUnitRunner.class)
public class GerarQRCodeImplTest {

  @InjectMocks
  private GerarQRCodeImpl provider;

  @Mock
  private PersistirPagamentoImpl persistirPagamento;

  @Test
  public void shouldGenerateQRCode() {

    String idPedido = UUID.randomUUID().toString();
    BigDecimal valorPedido = BigDecimal.valueOf(127.5);
    String qrCode = provider.execute(idPedido, valorPedido);

    verify(persistirPagamento).execute(idPedido, valorPedido, qrCode);
  }

}
