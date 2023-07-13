package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repos extends JpaRepository<EntityClass, Integer> {

}
