package com.example.factory;


import com.example.factory.User.StrategySign;
import com.example.factory.User.User;
import com.example.factory.User.UserFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FactoryTestApplication {


    @Autowired
    UserFactory userFactory ;

    @Autowired
    StrategySign studentStrategySign;

    @Value("#{studentStrategySign.user}")
    User user;


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


//        try {
//            strategySign.getStrategy("student");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(user.test());
    }
}
