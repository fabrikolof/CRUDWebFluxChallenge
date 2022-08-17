package com.crudReactive.crudReactive.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "monkey")
public class Monkey {
    @Id
    private String id;
    private String name;
    private Integer edad;
    private Boolean isWorking;

    public Monkey(String id, String name, Integer edad, Boolean isWorking) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.edad = edad;
        this.isWorking = isWorking;
    }

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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
