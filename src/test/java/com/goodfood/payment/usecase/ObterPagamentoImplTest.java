package com.goodfood.payment.usecase;

import com.goodfood.payment.domain.Pagamento;
import com.goodfood.payment.domain.expcetions.PagamentoNaoEncontradoException;
import com.goodfood.payment.gateways.PagamentoGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObterPagamentoImplTest {

    @InjectMocks
    private ObterPagamentoImpl provider;

    @Mock
    private PagamentoGateway pagamentoGateway;

    @Test
    void deveRetornarPagamentoQuandoIdForValido() {
        String idPedido = "validId";
        Pagamento expectedPagamento = Pagamento.builder().build();
        when(pagamentoGateway.obterPagamento(idPedido)).thenReturn(expectedPagamento);

        Pagamento pagamento = provider.obterPagamento(idPedido);

        assertNotNull(pagamento);
        assertEquals(expectedPagamento, pagamento);
    }

    @Test
    void deveRetornarNuloQuandoPagamentoNaoForEncontrado() {
        String idPedido = "nonExistentId";
        when(pagamentoGateway.obterPagamento(idPedido)).thenThrow(new PagamentoNaoEncontradoException("Pagamento não encontrado!"));

        assertThrows(PagamentoNaoEncontradoException.class, () -> provider.obterPagamento(idPedido));
    }
}
