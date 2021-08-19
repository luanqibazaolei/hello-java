# Spring 中实现设计模式
## 工厂模式
    简单工厂模式能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象。
    明确区分了各自的职责和权力，有利于整个软件体系结构的优化。
    缺点 ： 工厂类集中了所有 实例的创建逻辑 容易违反GRASPR的高内聚的责任分配原则

工厂类 ：
```java
@Service
public class UserFactory {
//    自动注入工厂需要创建的实现类
    @Autowired
    private Map<String,User> map = new ConcurrentHashMap();
//    传component 作为标识
    public User getStrategy(String component) throws Exception{
        User user= map.get(component);
        if(user == null) {
            throw new RuntimeException("no user defined");
        }
        return user;
    }

}

```
实现类：
```java
@Component("student")
public class Student implements User{
    public String test() {
        return "Student Test!";
    }
}
```

```java
@SpringBootTest
public class FactoryTestApplication {


    @Autowired
    UserFactory userFactory ;

    @Test
    public void test() {
        User user = null;
        try {
//            根据名字注入！
            user = userFactory.getStrategy("student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.test());
    }
}
```


## 策略模式
    策略模式是在实例化策略模式的时候已经创建好了，
    我们可以在策略模式中随意的拼接重写方法

```java

@Service
public class StrategySign {

    private User user;

    public StrategySign() {
    }

    public StrategySign(User user) {
        this.user = user;
    }

//    传入 需要创建的类型
    public StrategySign(String type) {
        if (type.equals("student")) {
            this.user = new Student();
        } else if (type.equals("teacher")) {
            this.user = new Teacher();
        }

    }

    public String test() {
        return this.user.test();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

```