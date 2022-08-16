package com.crudReactive.crudReactive.repository;

import com.crudReactive.crudReactive.model.Monkey;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MonkeyRepository extends ReactiveMongoRepository<Monkey, Long> {
}
