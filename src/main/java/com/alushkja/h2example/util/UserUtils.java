package com.alushkja.h2example.util;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class UserUtils {

    @Autowired
    UserRepository repository;

//    private Iterable<User> users = repository.findAll();

    private static final int NUM_USERS = 30;

    private static final int MIN_USER_NUM = 1000;

//    public List<User> buildUsers() {
//        if (users.isEmpty()) {
//            IntStream.range(0, NUM_USERS).forEach(n -> {
//                users.add(new User(Long.valueOf(MIN_USER_NUM + n + 1), "Spring User", "AAA", "AAA"));
//            });
//
//        List<User> userList = new ArrayList<>();
//        userList = Lists.newArrayList(users);
//        return userList;
//    }
}
