package com.goodfood.payment.domain;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatusPagamentoPedido {

    PENDENTE("Pendente"), //
    PAGO("Pago"), //
    RECUSADO("Recusado");

    public String name;

    public static EStatusPagamentoPedido getByName(final String enumName) {
      return Stream.of(EStatusPagamentoPedido.values())
      .filter(status -> status.name.equals(enumName)).findFirst().orElse(PENDENTE);
    }
    
}
