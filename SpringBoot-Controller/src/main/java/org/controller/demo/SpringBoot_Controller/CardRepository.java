package org.controller.demo.SpringBoot_Controller;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
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


    // Hibernate Query Language >> based on entity and its properties
    @Query("from Creditcard where cardAvailable>=:available")
    List<Creditcard> findAllByGreaterAvailable(int available);

    @Query("select cardNumber from Creditcard where cardAvailable<=:available")
    List<Long> findAllByLesserAvailable(int available);

    // if we try to update/delete based on HQL/SQL need to add Transactional,Modifying
    @Query("delete from Creditcard where cardAvailable <= :limit")
    @Transactional
    @Modifying
    void deleteByLimit(int limit);

    // SQL >> based on table and its columns
    @Query(value = "select * from cardcredit where available_limit>=:available",nativeQuery = true)
    List<Creditcard> findAllBySqlAvailable(int available);

}
