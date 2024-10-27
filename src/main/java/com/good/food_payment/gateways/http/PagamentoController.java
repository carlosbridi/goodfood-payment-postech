package com.good.food_payment.gateways.http;

import java.math.BigDecimal;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.good.food_payment.domain.Pagamento;
import com.good.food_payment.gateways.PagamentoGateway;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
@Api(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoController {
	
	private final PagamentoGateway pagamentoGateway;
	
	@GetMapping
	public ResponseEntity<String> helloWorld(){
		Pagamento save = pagamentoGateway.save(Pagamento.builder().numeroPedido("1231").valor(BigDecimal.TEN).build());
		return ResponseEntity.ok("Hello world!!");
	}

}
