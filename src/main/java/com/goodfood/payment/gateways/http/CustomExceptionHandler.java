package com.goodfood.payment.gateways.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.goodfood.payment.domain.expcetions.PagamentoNaoEncontradoException;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(PagamentoNaoEncontradoException.class)
  public HttpEntity<Object> handlePagamentoNaoEncontradoException(final PagamentoNaoEncontradoException ex) {
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(ex.getMessage(), httpHeaders, HttpStatus.NOT_FOUND);
  }
}
