package com.example.springbootswagger2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    /**
     * 客户Id
     */
    String custId;

    /**
     * 客户姓名
     */
    String custName;

    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", custName='" + custName + '\'' +
                '}';
    }
}
