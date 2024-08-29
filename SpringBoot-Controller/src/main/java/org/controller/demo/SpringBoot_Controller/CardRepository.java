package org.controller.demo.SpringBoot_Controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CrudRepository<Entity, Type of Key attribute>
// JpaRepository<Entity, Type of Key attribute>
// Repository, Service, Configuration, Component, Controller

// insert/ update: save(object) >> object
// select/ read: findAll >> fetch all rows from table, convert into list of entity objects
//              findById >> read one records based on primary key and convert into entity object
//              findAllByProperty

@Repository
public interface CardRepository extends CrudRepository<Creditcard,Long> {
    List<Creditcard> findAllByCardPin(int pinNumber);
    List<Creditcard> findAllByCardAvailable(int available);


    // Hibernate Query Language
    @Query("from Creditcard where cardAvailable>=:available")
    List<Creditcard> findAllByGreaterAvailable(int available);

    @Query("select cardNumber from Creditcard where cardAvailable<=:available")
    List<Long> findAllByLesserAvailable(int available);
}
