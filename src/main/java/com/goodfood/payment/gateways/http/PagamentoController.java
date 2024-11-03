package com.goodfood.payment.gateways.http;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.goodfood.payment.gateways.http.response.PagamentoResponse;
import com.goodfood.payment.usecase.GerarQRCode;
import com.goodfood.payment.usecase.ObterPagamento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
@Api(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoController {

  private final GerarQRCode gerarQRCode;
  private final ObterPagamento obterPagamento;

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  @ApiImplicitParams({
      @ApiImplicitParam(name = "idPedido", value = "Identificador do pedido", required = true,
          dataType = "string", paramType = "body"),
      @ApiImplicitParam(name = "valorPedido", value = "Valor do pedido", required = true,
          dataType = "double", paramType = "body")})
  public ResponseEntity<String> generateQRCode(@RequestParam String idPedido,
      @RequestParam BigDecimal valor) {
    return ResponseEntity.ok(gerarQRCode.execute(idPedido, valor));
  }

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Ok")})
  @ResponseStatus(code = HttpStatus.OK)
  @GetMapping
  @ApiImplicitParams({
      @ApiImplicitParam(name = "idPedido", value = "Identificador do pedido", required = true,
          dataType = "string", paramType = "body")})
  public ResponseEntity<PagamentoResponse> obterPagamento(@RequestParam String idPedido) {
    return ResponseEntity.ok(new PagamentoResponse(obterPagamento.obterPagamento(idPedido)));
  }

}
