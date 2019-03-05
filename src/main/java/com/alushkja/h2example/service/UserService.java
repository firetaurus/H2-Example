package com.alushkja.h2example.service;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.repository.UserRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService{

//    List<User> findAll();

    <S extends User> S save(S entity);

    Optional<User> findById(Long aLong);

    void deleteById(Long aLong);

    void delete(User entity);

    Iterable<User> findAll(Pageable pageable);

    long count();
}
