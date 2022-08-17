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
        return this.monkeyRepository
                .findById(id).flatMap(p ->
                        this.monkeyRepository
                                .deleteById(p.getId())
                                .thenReturn(p));
    }
    @Override
    public Mono<Monkey> update(String id, Monkey monkey) {
        return this.monkeyRepository.findById(id)
                .flatMap(m -> {
                    m.setId(id);
                    m.setAge(monkey.getAge());
                    m.setName(monkey.getName());
                    m.setWorking(monkey.getWorking());
                    return save(m);
                }).switchIfEmpty(Mono.empty());
    }
    @Override
    public Flux<Monkey> findAll() {
        return monkeyRepository.findAll();
    }
    @Override
    public Mono<Monkey> findById(String id) {
        return this.monkeyRepository.findById(id);
    }
    @Override
    public Mono<Void> deleteAll() {
        return this.monkeyRepository.deleteAll();
    }

    @Override
    public Flux<Monkey> monkeysWorking() {
        return this.monkeyRepository
                .findAll()
                .filter(monkey -> monkey.getWorking().equals(true));
    }


}
