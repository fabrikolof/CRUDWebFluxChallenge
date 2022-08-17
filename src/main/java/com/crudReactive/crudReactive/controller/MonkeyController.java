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
    @DeleteMapping("/deleteMonkey/{id}")
    private Mono<ResponseEntity<String>> delete
            (@PathVariable("id") String id) {

        return this.monkeyService.delete(id)
                .flatMap(monkey -> Mono.just(ResponseEntity
                        .ok("Deleted Successfully")))
                .switchIfEmpty(Mono.just(ResponseEntity
                        .notFound().build()));
    }
    @DeleteMapping("/deleteAllMonkeys")
    Mono<Void> deleteAll() {
        return this.monkeyService.deleteAll();
    }
    @PutMapping("/updateMonkey/{id}")
    private Mono<ResponseEntity<Monkey>> update
            (@PathVariable("id") String id,
             @RequestBody Monkey monkey) {
        return this.monkeyService.update(id, monkey)
                .flatMap(monkey1 -> Mono.just(ResponseEntity
                        .ok(monkey1))).switchIfEmpty(Mono
                        .just(ResponseEntity.notFound().build()));
    }
    @GetMapping(value = "/monkeys")
    private Flux<Monkey> findAll() {
        return this.monkeyService.findAll();
    }
    @GetMapping("/getMonkey/{id}")
    private Mono<Monkey> findById(@PathVariable("id") String id) {
        return this.monkeyService.findById(id);
    }
    @GetMapping("/getWorkingMonkeys")
    private Flux<Monkey> monkeysWorking() {
        return this.monkeyService.monkeysWorking();
    }

}
