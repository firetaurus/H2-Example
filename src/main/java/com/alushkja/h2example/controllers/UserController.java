package com.alushkja.h2example.controllers;

import com.alushkja.h2example.model.User;
import com.alushkja.h2example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/rest/users")
@Controller
public class UserController {

    private static int PAGE_SIZE = 3;   // number of rows to container per page
    private long totalUserCount;    // total number of rows in DB

    private PageRequest gotoPage(int page){
        PageRequest request = PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id");
        return request;
    }

    @Autowired
    UserService service;

    @GetMapping
    public String index(Model model, @RequestParam(value = "pageNo", required = false, defaultValue = "0") String pageNo){

        //TODO: make some validation on page number
        int lastPageNo;
        int gotoPageNo = Integer.parseInt(pageNo);
        Set<User> allUsers = new LinkedHashSet<>();

        for (User u:
             service.findAll(gotoPage(gotoPageNo))) {
            allUsers.add(u);
        }

        totalUserCount = service.count();   // total number of users
        if(totalUserCount % PAGE_SIZE != 0){
            lastPageNo = (int)(totalUserCount / PAGE_SIZE) + 1; // numero di elementi non divisibile per il numero scelto
        } else {
            lastPageNo = (int)(totalUserCount / PAGE_SIZE);     // numero di elementi divisibile
        }
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("users", allUsers);

        return "index";
    }


}
