package com.goodfood.payment.gateways.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.goodfood.payment.domain.expcetions.PagamentoNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(PagamentoNotFoundException.class)
  public HttpEntity<Object> handleNotFoundException(final PagamentoNotFoundException ex) {
    HttpHeaders httpHeaders = new HttpHeaders();
    return new ResponseEntity<>(ex.getMessage(), httpHeaders, HttpStatus.NOT_FOUND);
  }
}
