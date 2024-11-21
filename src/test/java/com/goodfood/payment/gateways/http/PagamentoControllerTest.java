package com.goodfood.payment.gateways.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.gateways.http.response.PagamentoResponse;
import com.goodfood.payment.usecase.AlterarStatusPagamento;
import com.goodfood.payment.usecase.GerarQRCode;
import com.goodfood.payment.usecase.ObterPagamento;

@ExtendWith(MockitoExtension.class)
class PagamentoControllerTest {

    @InjectMocks
    private PagamentoController pagamentoController;

    @Mock
    private GerarQRCode gerarQRCode;

    @Mock
    private ObterPagamento obterPagamento;
    
    @Mock
    private AlterarStatusPagamento alterarPagamento;

    @Test
    void deveGerarQRCodeComSucesso() {
        String idPedido = "idPedidoUUID";
        BigDecimal valorPedido = BigDecimal.valueOf(127.5);
        String expectedQRCode = "expectedQRCode";
        when(gerarQRCode.executar(idPedido, valorPedido)).thenReturn(expectedQRCode);

        ResponseEntity<String> response = pagamentoController.gerarQRCode(idPedido, valorPedido);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedQRCode, response.getBody());
    }

    @Test
    void deveRetornarPagamentoResponseComSucesso() {
        String idPedido = "idPedidoUUID";
        final Pagamento pagamento = Pagamento.builder().idPedido(idPedido).statusPagamento(EStatusPagamentoPedido.PENDENTE).qrCode("qrCode").valor(BigDecimal.TEN).build();
        PagamentoResponse expectedResponse = new PagamentoResponse(pagamento);
        when(obterPagamento.obterPagamento(idPedido)).thenReturn(pagamento);

        ResponseEntity<PagamentoResponse> response = pagamentoController.obterPagamento(idPedido);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
    
    @Test
    void deveAlterarStatusPagamento() {
      String idPedido = "idPedidoUUID";
      final Pagamento pagamento = Pagamento.builder().idPedido(idPedido).statusPagamento(EStatusPagamentoPedido.PAGO).qrCode("qrCode").valor(BigDecimal.TEN).build();
      PagamentoResponse expectedResponse = new PagamentoResponse(pagamento);
      when(alterarPagamento.executar(idPedido, EStatusPagamentoPedido.PAGO)).thenReturn(pagamento);

      ResponseEntity<PagamentoResponse> response = pagamentoController.alterarStatus(idPedido, EStatusPagamentoPedido.PAGO);

      assertNotNull(response);
      assertEquals(HttpStatus.OK, response.getStatusCode());
      assertEquals(expectedResponse, response.getBody());
    }

}
