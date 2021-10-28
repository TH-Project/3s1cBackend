package com.s1c.rtp.controller;

import java.util.Arrays;
import java.util.List;

import com.s1c.rtp.service.WholeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UpdateController {

    @Autowired
    WholeDataService wholeDataService;

//    @GetMapping("/updateTest")
//    public void updateTest() {
//        wholeDataService.updateWholeDataTable();
//    }
}
