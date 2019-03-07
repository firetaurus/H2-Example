package com.alushkja.h2example.service.impl;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.repository.UserRepository;
import com.alushkja.h2example.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository repository;

    private List<User> users = new ArrayList<>();

    @Override
    public Page<User> findAll(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        users = findAll();

        List<User> list;

        if (count() < startItem)
            list = Collections.emptyList();
        else {
            int toIndex = Math.min(startItem + pageSize, (int) count());
            list = users.subList(startItem, toIndex);
        }

        Page<User> userPage = new PageImpl<User>(list, PageRequest.of(currentPage, pageSize), users.size());

        return userPage;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Page<User> findAllFiltered(Pageable pageable, String name, String surname, String username, String country, String state, Integer zip) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        Page<User> userPage = findAllFiltered(pageable, name, surname, username, country, state,zip);

        List<User> listUser = Lists.newArrayList(userPage);
        Page<User> usersList = new PageImpl<User>(listUser, PageRequest.of(currentPage, pageSize), (int) userPage.getTotalElements());
        return usersList;
    }
}
