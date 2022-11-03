package com.asamhussain.springmvc.repository;

import com.asamhussain.springmvc.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    Fruit findFruitByName(String name);
}
