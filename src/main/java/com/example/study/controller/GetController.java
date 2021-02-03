package com.example.study.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(method = RequestMethod.GET,path = "/getmethod")
    public String getRequest(){
        return "Hi getMethod";
    };
    @GetMapping(value="/getParameter")  //Localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParamter(@RequestParam String id,@RequestParam String password){
        System.out.println("id  : "+id);
        System.out.println("password : "+password);

        return id+password;
    }
//    @GetMapping(value="/getParameter")  //Localhost:8080/api/getParameter?id=1234&password=abcd
//    public String getParamter(@RequestParam String id,@RequestParam(name = "password") String pwd){
//        String password ="Sdfsfd";
//        System.out.println("id  : "+id);
//        System.out.println("password : "+pwd);
//
//        return id+pwd;
//    }


}
