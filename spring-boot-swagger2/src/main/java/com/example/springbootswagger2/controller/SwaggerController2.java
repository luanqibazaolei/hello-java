package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.pojo.Customer;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
@Api(value = "Swagger2")
public class SwaggerController2 {


    @GetMapping("getAllCust2")
    public String getAllCust()
    {
        Customer shen = new Customer("1", "shen");
        return shen.toString();
    }

    @PostMapping("intCust2")
    public String intCust(Customer customer){
        return customer.toString();
    }

}
