## Spring

Spring is a open source light weight java development framework

Spring core feature: IOC and AOP

![spring1](/Users/jackpu/Desktop/work/javaguide/pictures/spring1.png)

![spring2](/Users/jackpu/Desktop/work/javaguide/pictures/spring2.png)



### Spring IOC

IoC Inverse of Control is a thought of design, not a specific implementation. In java spring, ioc is letting spring container to create object instead of doing so in class.

![ioc1](/Users/jackpu/Desktop/work/javaguide/pictures/ioc1.png)

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

Bean is Object in IoC container

In Spring, we can use XML file to config bean.



#### Annotation to declear a class as Bean

* `@Component` general annotation
* `@Repository`: Dao layer, used for JDBC operation
* `@Service`: Service layer, ususally need Dao layer
* `@Controller` Spring MVC controller layer, used to receive client request and send responce.