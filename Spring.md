## Spring

Spring is a open source light weight java development framework

Spring core feature: IOC and AOP

![spring1](./pictures/spring1.png)

![spring2](./pictures/spring2.png)



### Spring IOC

IoC Inverse of Control is a thought of design, not a specific implementation. In java spring, ioc is letting spring container to create object instead of doing so in class.

![ioc1](./pictures/ioc1.png)

* Inverse: give the control to external class (spring framework, IoC container)
* Control: new object instance



#### IoC benefit

1. Decouple class objects
2. Easy to control resource

Example: User classm has Service and Dao layer

Without IoC

```java
public class UserDaoImpl implement IUserDao{
  
}
```

```java
Public class UserServiceImpl implement IUserSercvice {
  private IUserDao userDao = new UserDaoImpl();
}
```

If later there is another implementation class of `IUserDao`, and we need to change it in `UserServiceImpl` class. Which is bad, it there are a lot of classes depend on `IUserDao`



With IoC:

```java
public class UserDaoImpl implement IUserDao{
  
}
```

```java
public class NewUserDaoImpl implement IUserDao{
  
}
```

```java
Public class UserServiceImpl implement IUserSercvice {
  @Autowired
  private IUserDao userDao;
}
```



In spring, IoC container is the container to implement IoC convention. Itself is a key-value map



**IoC and DI**

DI is the most common way to implement IoC.



### Spring Bean

What is spring bean?

A spring bean is an object managed by the spring IoC container along with some metadata

In Spring, we can use XML file to config bean.



#### Annotation to declare class as Bean

* `@Component` general annotation
* `@Repository`: Dao layer, used for JDBC operation
* `@Service`: Service layer, usually need Dao layer
* `@Controller` Spring MVC controller layer, used to receive client request and send responce.



#### @Component and @Bean

* `@Component` annotation upon class, `@Bean` annotation upon on method
* 





### @Autowired

In Spring framework, `@Autowired` is a popular annotation used for automatic dependency injection.

When the Spring sees `@Autowired` on fields, constructors, setter methods, or config methods, it attempts to fulfill the dependency by searching the application context for matching beans.



####  The basics of `@Autowired`

In spring, `@Autowired` annotation is used to auto-wired Spring beans into other beans, let Spring automatically satisfy bean dependencies. 



##### how Spring resolves dependencies

When place `@Autowired` annotation on a field, constructor or method,

1. **By Type:** Spring first tries to find a matching bean in the application context by type. If it finds exactly one match, it wires that bean in.
2. **By Qualifier**: If there are multiple beans of the same type, Spring then tries to narrow down the beans by using the `@Qualifier` annotation, if specified.
3. **By Name**: If a `@Qualifier` isn’t specified, Spring checks if any of the beans’ names match the name of the member variable that the `@Autowired` annotation is applied to.



#### field injection(not recommend)

`@Autowired` can be applied to field (instance variables)



#### Constructor injection

```java
@Service
public class SampleService {

    private final UserRepository userRepository;

    @Autowired
    public SampleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void doSomething() {
        userRepository.doSomething();
    }
}
```



#### Setter method injection

old method, constructor injection is preferred.



* Field injection does not allow to to handle the absence of a bean definition gracefully, application will not start.
* Using autowired can make it hard to understand how the application is wired together, using explicit writing in config might be good





#### Multiple Beans same type

##### Use `@Qualifier`

```java
@Service
public class TransportService {

    private Vehicle vehicle;

    @Autowired
    @Qualifier("car")
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney() {
        vehicle.drive();
    }
}
```

```java
@Component("car")
public class Car implement Vehicle{
  
}
```



#### Use required Attribuye

```java
@Service
public class SampleService {

    @Autowired(required = false)
    private UserRepository userRepository;

    public void doSomething() {
        if (userRepository != null) {
            userRepository.doSomething();
        }
    }
}
```



#### @Autowired and @Resource

* @Autowired is spring annotation, @Resource is JDK annotation
* @Autowired used byType as default, @Resource uses byName as default
* @Autowired use @Qualifier to search by name 





### Bean scope

* **singleton**: only one instant of bean in IoC container
* **prototype**: every get will create a new bean instance



Set bean scope:

* XML

* Annotation

  ```java
import laicode.Person;   @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public Person personProtopyte(){
    return new Person();
  }
  ```

  



### Spring AOP

Encapsulating common logic (session, log, access control)

AspectJ



