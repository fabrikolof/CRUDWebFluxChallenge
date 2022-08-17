package com.crudReactive.crudReactive.service;

import com.crudReactive.crudReactive.model.Monkey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonkeyService {
    Mono<Monkey> save(Monkey monkey);
    Mono<Monkey> delete(String id);
    Mono<Monkey> update(String id, Monkey monkey);
    Flux<Monkey> findAll();
    Mono<Monkey> findById(String id);
}
