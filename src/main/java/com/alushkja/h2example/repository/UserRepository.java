package com.alushkja.h2example.repository;


import com.alushkja.h2example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from user where first_name = ?1 and last_name = ?2 and username = ?3 and country = ?4 and city = ?5 and zip = ?6 ", nativeQuery = true)
    Page<User> findFiltered(Pageable pageable, String name, String surname, String username, String country, String state, Integer zip);

}
