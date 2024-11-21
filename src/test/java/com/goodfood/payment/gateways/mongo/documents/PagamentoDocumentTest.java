package com.goodfood.payment.gateways.mongo.documents;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import com.goodfood.payment.domain.EStatusPagamentoPedido;
import com.goodfood.payment.domain.Pagamento;

class PagamentoDocumentTest {

    @Test
    void deveConverterParaDominio() {
        PagamentoDocument document = new PagamentoDocument();
        document.setId("id");
        document.setQrCode("qrCode");
        document.setIdPedido("idPedido");
        document.setValor(BigDecimal.TEN);
        document.setDataPagamento(LocalDateTime.now());
        document.setCriadoEm(LocalDateTime.now());

        Pagamento pagamento = document.toDomain();

        assertNotNull(pagamento);
        assertEquals(document.getId(), pagamento.getId());
        assertEquals(document.getQrCode(), pagamento.getQrCode());
        assertEquals(document.getIdPedido(), pagamento.getIdPedido());
        assertEquals(document.getValor(), pagamento.getValor());
        assertEquals(document.getDataPagamento(), pagamento.getDataPagamento());
        assertEquals(document.getCriadoEm(), pagamento.getCriadoEm());
    }

    @Test
    void deveCriarDocumentoAPartirDoDominio() {
        Pagamento pagamento = Pagamento.builder().id("id")
            .statusPagamento(EStatusPagamentoPedido.PENDENTE)
            .qrCode("qrCode").idPedido("idPedido").valor(BigDecimal.TEN).dataPagamento(LocalDateTime.now()).criadoEm(LocalDateTime.now()).build();

        PagamentoDocument document = new PagamentoDocument(pagamento);

        assertNotNull(document);
        assertEquals(pagamento.getId(), document.getId());
        assertEquals(pagamento.getQrCode(), document.getQrCode());
        assertEquals(pagamento.getIdPedido(), document.getIdPedido());
        assertEquals(pagamento.getValor(), document.getValor());
        assertEquals(pagamento.getDataPagamento(), document.getDataPagamento());
        assertNotNull(document.getCriadoEm());
    }

    @Test
    void deveTratarValoresNulosNaConversaoDeDominio() {
        PagamentoDocument document = new PagamentoDocument();

        Pagamento pagamento = document.toDomain();

        assertNotNull(pagamento);
        assertNull(pagamento.getId());
        assertNull(pagamento.getQrCode());
        assertNull(pagamento.getIdPedido());
        assertNull(pagamento.getValor());
        assertNull(pagamento.getDataPagamento());
        assertNull(pagamento.getCriadoEm());
    }
}
