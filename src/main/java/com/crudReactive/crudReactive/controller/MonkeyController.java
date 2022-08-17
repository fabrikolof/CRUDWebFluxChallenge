package com.crudReactive.crudReactive.controller;

import com.crudReactive.crudReactive.model.Monkey;
import com.crudReactive.crudReactive.service.MonkeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MonkeyController {

    @Autowired
    private MonkeyService monkeyService;

    @PostMapping("/monkey")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Monkey> save(@RequestBody Monkey monkey) {
        return this.monkeyService.save(monkey);
    }
    @DeleteMapping("/users/{id}")
    private Mono<ResponseEntity<String>> delete
            (@PathVariable("id") String id) {

        return this.monkeyService.delete(id)
                .flatMap(user -> Mono.just(ResponseEntity
                        .ok("Deleted Successfully")))
                .switchIfEmpty(Mono.just(ResponseEntity
                        .notFound().build()));
    }
    @GetMapping(value = "/monkeys")
    private Flux<Monkey> findAll() {
        return this.monkeyService.findAll();
    }

}
