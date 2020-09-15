## learn_record

## spring 实战(4th)

### 20200908-01

- 什么是 spring 的应用上下文？如何理解？

    > 你可以理解为：将你需要Spring帮你管理的对象放入容器的一种容器对象。应用上下文是Spring容器抽象的一种实现。
    >
    > 而我们常见的ApplicationContext本质上说：就是一个维护Bean定义以及对象之间协作关系的高级接口。
  
- DI 与 AOP

    > - DI： 解决紧耦合问题
    > - AOP: 解决分布在系统各处的通用逻辑复用问题(将横切关注点的逻辑与组件的核心业务分离，实现关注点分离)

- 脑图小结 01
    
### 20200909-02

> Spring会拦截对sgtPeppers()的调用并确保返回的是Spring所创建的bean，也就是Spring本身在调用sgtPeppers()时所创建的CompactDiscbean。因此，两个CDPlayer bean会得到相同的SgtPeppers实例。

- 写代码验证是单例；
- 断点查看 spring 如何实现单例(猜测会看 map 是否已经存在相同 bean id 的对象)；
- 是在调用这个加了 @Bean 注解的什么顺序拦截

## spring 源码深度解析(2th)


## 小马哥专栏

#### 20200908-总览-1