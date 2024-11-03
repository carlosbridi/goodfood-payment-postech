package com.goodfood.payment.domain.expcetions;

public class PagamentoNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -7650800379446359145L;

  public PagamentoNotFoundException(String message) {
    super(message);
  }

  public PagamentoNotFoundException(String message, Throwable e) {
    super(message, e);
  }
  
}
