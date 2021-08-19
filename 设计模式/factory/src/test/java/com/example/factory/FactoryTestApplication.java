package com.example.factory;


import com.example.factory.User.StrategySign;
import com.example.factory.User.User;
import com.example.factory.User.UserFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FactoryTestApplication {


    @Autowired
    UserFactory userFactory ;



    @Test
    public void test() {
        User user = null;
        try {
            user = userFactory.getStrategy("student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.test());
    }


    @Test
    public void test1() {
        User user = null;
        StrategySign strategySign = null;
        try {
            strategySign= new StrategySign("student") ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(strategySign.test());
    }
}
