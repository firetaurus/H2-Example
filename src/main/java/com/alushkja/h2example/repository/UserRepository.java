package com.alushkja.h2example.repository;

import com.alushkja.h2example.model.Page;
import com.alushkja.h2example.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

}
