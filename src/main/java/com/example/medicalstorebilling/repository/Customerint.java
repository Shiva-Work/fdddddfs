package com.example.medicalstorebilling.repository;

import com.example.medicalstorebilling.entity.Customers;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Customerint extends JpaRepository<Customers, Id> {

    @Query("select c.id from Customers c where c.name =:name and c.phone =:phone and c.email =:email")
    int findId(@Param("name") String name,@Param("phone") String phone,@Param("email") String email);
}
