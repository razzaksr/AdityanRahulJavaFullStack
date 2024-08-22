package org.controller.demo.SpringBoot_Controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<Entity, Type of Key attribute>
// JpaRepository<Entity, Type of Key attribute>
// Repository, Service, Configuration, Component, Controller

// insert/ update: save(object) >> object

@Repository
public interface CardRepository extends CrudRepository<Creditcard,Long> {
}
