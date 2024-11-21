package com.goodfood.payment.gateways.http.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;

class PagamentoResponseTest {

    @Test
    void deveCriarPagamentoResponseAPartirDoDominio() {
        Pagamento pagamento = Pagamento.builder()
                .idPedido("idPedido")
                .qrCode("qrCode")
                .valor(BigDecimal.TEN)
                .statusPagamento(EStatusPagamentoPedido.PENDENTE)
                .build();

        PagamentoResponse response = new PagamentoResponse(pagamento);

        assertNotNull(response);
        assertEquals(pagamento.getIdPedido(), response.getIdPedido());
        assertEquals(pagamento.getQrCode(), response.getQrCode());
        assertEquals(pagamento.getValor(), response.getValor());
    }
}
