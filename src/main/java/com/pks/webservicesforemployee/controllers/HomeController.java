package com.pks.webservicesforemployee.controllers;

import com.pks.webservicesforemployee.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
     return "Welcome home".toUpperCase();
    }

    @GetMapping("/user")
    public User getUser(){
        return new  User(
                "Wale Aboiodun",
                "Male",
                "wale@gmail.com");
    }
    @GetMapping("/{ID}")
    public String pathVariable(@PathVariable("ID") String id){
      return "The path variable is "+ id;
    }


    @GetMapping("/requestParam")
    public String requestParams(@RequestParam(required = false,defaultValue = "") String name){
   return "my name is  " + name;
    }


}
