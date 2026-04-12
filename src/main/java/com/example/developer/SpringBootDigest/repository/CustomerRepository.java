package com.example.developer.SpringBootDigest.repository;

import com.example.developer.SpringBootDigest.oneToManyEntity.CustomerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    //1. To avoid N+1 problem
    @EntityGraph(attributePaths = "orders")
    List<CustomerEntity> findAll ();

    //2. To avoid N+1 problem
    @Query("Select c From CustomerEntity c LEFT JOIN FETCH c.orders")
    List<CustomerEntity> fetchCustomerWithOrder ();
}
