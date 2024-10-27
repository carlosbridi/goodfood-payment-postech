package com.good.food_payment.gateways.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.good.food_payment.gateways.mongo.documents.PagamentoDocument;

public interface PagamentoRepository extends MongoRepository<PagamentoDocument, String> {

}
