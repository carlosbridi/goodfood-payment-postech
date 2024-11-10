package com.goodfood.payment.domain.expcetions;

public class PagamentoNaoEncontradoException extends RuntimeException {

  private static final long serialVersionUID = -7650800379446359145L;

  public PagamentoNaoEncontradoException(String message) {
    super(message);
  }

  public PagamentoNaoEncontradoException(String message, Throwable e) {
    super(message, e);
  }
  
}
