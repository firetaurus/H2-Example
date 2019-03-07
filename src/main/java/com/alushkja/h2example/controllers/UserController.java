package com.alushkja.h2example.controllers;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/rest/users")
@Controller
public class UserController {

//    private static int PAGE_SIZE = 5;   // number of rows to container per page
//    private long totalUserCount;    // total number of rows in DB
//
//    private PageRequest gotoPage(int page){
//        PageRequest request = PageRequest.of(page, PAGE_SIZE, Sort.Direction.ASC, "id");
//        return request;
//    }

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserService service;

    @GetMapping
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {

//        //TODO: make some validation on page number
//        int lastPageNo;
//        int gotoPageNo = Integer.parseInt(pageNo);
//        Set<User> allUsers = new LinkedHashSet<>();
//
//        for (User u:
//             service.findAll(gotoPage(gotoPageNo))) {
//            allUsers.add(u);
//        }
//
//        totalUserCount = service.count();   // total number of users
//        if(totalUserCount % PAGE_SIZE != 0){
//            lastPageNo = (int)(totalUserCount / PAGE_SIZE) + 1; // numero di elementi non divisibile per il numero scelto
//        } else {
//            lastPageNo = (int)(totalUserCount / PAGE_SIZE);     // numero di elementi divisibile
//        }
//        model.addAttribute("lastPageNo", lastPageNo);
//        model.addAttribute("users", allUsers);

        final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(100);

        Page<User> userPage = service.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("userPage", userPage);

        int totalPages = userPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages - 1)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "listUsers.html";
    }

    @PostMapping("/post")
    public String query(@ModelAttribute(value = "userForm") User user, Model uiModel){

//        System.out.println(user.getFirst_name());

        final int currentPage = 1;
        final int pageSize = 100;
        User newUser = user;

        Page<User> userPage = service.findAllFiltered(PageRequest.of(currentPage - 1, pageSize), user.getFirst_name(),user.getLast_name(),user.getUsername(),user.getCountry(),user.getCity(),user.getZip());

        uiModel.addAttribute("userPage", newUser);

        return "listUsers.html";
    }


}
