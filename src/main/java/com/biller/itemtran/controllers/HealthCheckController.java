package com.biller.itemtran.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping(value = "/keep")
    public String Alive(){
        return "dead (?";
    }
}
