package com.alushkja.h2example.service;

import com.alushkja.h2example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    long count();

    List<User> findAll();

    Page<User> findAllFiltered(Pageable pageable, String name, String surname, String username, String country, String state, Integer zip);
}
