package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//跨域注解
public class UploadImgController {

    @RequestMapping(value = "/upload-img",method = RequestMethod.POST)
    @CrossOrigin//跨域注解
    public String product(){
        return "success!";
    }
}
