package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.pojo.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
@Api(value = "Swagger2")
public class SwaggerController {


    @ApiOperation( value = "获取用户信息")
    @GetMapping("getAllCust")
    public String getAllCust()
    {
        Customer shen = new Customer("1", "shen");
        return shen.toString();
    }

    @PostMapping(value = "添加用户信息")
    public String intCust(Customer customer){
        return customer.toString();
    }

}
