package com.good.food_payment.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.good.food_payment.gateways.mongo"})
public class MongoDatabaseConfiguration {

	@Bean
	@Primary
	public MongoTemplate mongoTemplate(final MongoDatabaseFactory mongoDatabaseFactory, final MongoConverter mongoConverter) {
		return new MongoTemplate(mongoDatabaseFactory, mongoConverter);
	}
	
}
