package com.alushkja.h2example.service.impl;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.repository.UserRepository;
import com.alushkja.h2example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
//
//    @Override
//    public Iterable<User> findAll() {
//        return repository.findAll();
//    }

    @Override
    public <S extends User> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);
    }

    @Override
    public Iterable<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
