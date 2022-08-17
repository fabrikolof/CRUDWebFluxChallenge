package com.crudReactive.crudReactive.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "monkey")
public class Monkey {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private Integer age;
    private Boolean isWorking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monkey)) return false;
        Monkey monkey = (Monkey) o;
        return Objects.equals(getId(), monkey.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
