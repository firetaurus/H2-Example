package com.alushkja.h2example.repository;

import com.alushkja.h2example.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public Iterable<User> findAll(Pageable pageable);
}
