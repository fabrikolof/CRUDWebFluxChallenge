package com.crudReactive.crudReactive.service.Impl;


import com.crudReactive.crudReactive.model.Monkey;
import com.crudReactive.crudReactive.repository.MonkeyRepository;
import com.crudReactive.crudReactive.service.MonkeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonkeyServiceImpl implements MonkeyService {
    @Autowired
    private MonkeyRepository monkeyRepository;
    @Override
    public Mono<Monkey> save(Monkey monkey) {
        return this.monkeyRepository.save(monkey);
    }
    @Override
    public Mono<Monkey> delete(String id) {
        return null;
    }
    @Override
    public Mono<Monkey> update(String id, Monkey monkey) {
        return null;
    }
    @Override
    public Flux<Monkey> findAll() {
        return monkeyRepository.findAll();
    }
    @Override
    public Mono<Monkey> findById(String id) {
        return this.monkeyRepository.findById(id);
    }

}
