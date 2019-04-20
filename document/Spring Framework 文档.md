 Spring  Framework 文档
======
版本: Version 5.2.0.BUILD-SNAPSHOT

<font color="blue"></font>

## 文档总览
### 概述
历史，设计理念，反馈，入门。

### 核心	
IoC容器，事件，资源，i18n，验证，数据绑定，类型转换，SpEL，AOP。

### 测试	
模拟对象，TestContext 框架， Spring  MVC 测试，WebTestClient。

### 数据访问	
事务，DAO支持，JDBC，ORM，编组XML。

### Web Servlet	
 Spring  MVC，WebSocket，SockJS，STOMP 消息传递。

### 网络响应
 Spring  WebFlux，WebClient，WebSocket。

### 集成
远程处理，JMS，JCA，JMX，电子邮件，任务，调度，缓存。

### 语言	
Kotlin，Groovy，动态语言。

# I.概述
 Spring 可以轻松创建 Java 企业应用程序。它提供了在企业环境中使用 Java 语言所需的一切，支持Groovy和Kotlin作为JVM上的替代语言，并可根据应用程序的需要灵活地创建多种体系结构。从 Spring  Framework 5.1开始， Spring 需要**JDK 8+（Java SE 8+）**，并为JDK 11 LTS提供开箱即用的支持。

 Spring  支持广泛的应用场景。在大型企业中，应用程序通常已经存在了很长时间，并且这些应用运行的JDK和应用程序服务器更新周期会滞后于开发人员控制。其他人可能在嵌入服务器的情况下作为单个jar运行，可能在云环境中运行。还有一些可能是不需要服务器的独立应用程序（例如批处理或集成工作负载）。

 Spring  是**开源的**。它拥有一个庞大而活跃的社区，可根据各种各样的实际用例提供持续的反馈。这有助于 Spring 在很长一段时间内成功发展。

## 1." Spring "是什么意思
术语" Spring "在不同的背景下意味着不同的东西。它可以用来引用 Spring  Framework项目本身，它就是一切开始的地方。随着时间的推移，其他 Spring 项目已经构建在 Spring  Framework之上。大多数情况下，当人们说" Spring "时，他们就意味着整个项目家族。本参考文档侧重于基础：** Spring  Framework本身**。

 Spring 框架分为几个模块。应用程序可以选择所需的模块。核心是核心容器的模块，包括`配置模型`和`依赖注入机制`。除此之外， Spring  Framework还为不同的应用程序体系结构提供了基础支持，包括`消息传递`，`事务数据`和`持久性以及Web`。它还包括基于Servlet的` Spring  MVC Web框架`，以及` Spring  WebFlux响应式Web框架`。

<font color="red" size=4>什么是`配置模型`和`依赖注入机制`？</font>

> 关于模块的说明： Spring 的框架jar允许部署到JDK 9的模块路径（"Jigsaw"）。为了在支持Jigsaw的应用程序中使用， Spring  Framework 5 jar带有"Automatic-Module-Name"清单条目，它们定义了独立于jar工件的稳定语言级模块名称（" Spring .core"，" Spring .context"等）名称（jar使用相同的命名模式使用"-"而不是"."，例如" Spring -core"和" Spring -context"）。当然， Spring 的框架jar在JDK 8和9+上的类路径上都能正常工作。

## 2.  Spring 的历史和 Spring 框架
 Spring 于2003年成立，是对早期J2EE规范复杂性的回应 。虽然有些人认为Java EE和 Spring 处于竞争中，但 Spring 实际上是**对Java EE的补充**。 Spring 编程模型不包含Java EE平台规范; 相反，它集成了EE保护伞中精心挑选的个别规格：

* Servlet API（JSR 340）

* WebSocket API（JSR 356）

* 并发实用程序（JSR 236）

* JSON绑定API（JSR 367）

* Bean验证（JSR 303）

* JPA（JSR 338）

* JMS（JSR 914）

* 以及必要时用于事务协调的JTA / JCA设置。

 Spring  Framework还支持`依赖注入（JSR 330）`和`Common Annotations（JSR 250）`规范，应用程序开发人员可以选择使用这些规范，而不是 Spring  Framework提供的 Spring 特定机制。

从 Spring  Framework 5.0开始， Spring 至少需要Java EE 7级别（例如Servlet 3.1 +，JPA 2.1+） - 同时在Java EE 8级别提供与新API的开箱即用集成（例如，Servlet 4.0，JSON绑定API）在运行时遇到。这使 Spring 与Tomcat 8和9，WebSphere 9和JBoss EAP 7完全兼容。

随着时间的推移，Java EE在应用程序开发中的作用也在不断发展。在Java EE和 Spring 的早期，创建了应用程序以部署到应用程序服务器。今天，在 Spring  Boot的帮助下，应用程序以devops和云友好的方式创建，Servlet容器嵌入并且变得微不足道。从 Spring  Framework 5开始，WebFlux应用程序甚至不直接使用Servlet API，并且可以在不是Servlet容器的服务器（例如Netty）上运行。

 Spring 继续创新并不断发展。除了 Spring  Framework之外，还有其他项目，例如 Spring  Boot， Spring  Security， Spring  Data， Spring  Cloud， Spring  Batch等。重要的是要记住每个项目都有自己的源代码存储库，问题跟踪器和发布节奏。有关 Spring 项目的完整列表，请参见 Spring .io/projects。

## 3.设计理念
**<font color="blue">当您了解框架时，重要的是不仅要知道它的作用，还要了解它遵循的原则。</font>**以下是 Spring  Framework的指导原则：

* 提供各个层面的选择。 Spring 允许您尽可能晚地**推迟设计决策**。例如，您可以通过配置切换持久性提供程序，而无需更改代码。许多其他基础架构问题以及与第三方API的集成也是如此。

* 适应不同的观点。 Spring 拥抱灵活性，并不认为应该如何做。它以不同的视角支持广泛的应用需求。

* 保持强大的向后兼容性。 Spring 的演变经过精心设计，可以在版本之间进行一些重大改变。 Spring 支持精心挑选的JDK版本和第三方库，以便于维护依赖于 Spring 的应用程序和库。

* 关心API设计。 Spring 团队花了很多心思和时间来制作直观的API，这些API在很多版本和多年中都有用。

* 为代码质量设定高标准。 Spring  Framework非常强调有意义的，最新的和准确的javadoc。它是极少数项目之一，可以声称**干净的代码结构，包之间没有循环依赖**。

## 4.反馈和贡献
对于操作方法问题或诊断或调试问题，我们建议使用StackOverflow，我们有一个问题页面列出了要使用的建议标签。如果您非常确定 Spring  Framework中存在问题或想要建议功能，请使用GitHub问题。

如果您有解决方案或建议的修复，您可以在Github上提交拉取请求 。但是，请记住，对于除了最微不足道的问题以外的所有问题，我们希望在问题跟踪器中提交一张票据，在那里进行讨论并留下记录以供将来参考。

有关更多详细信息，请参阅" 贡献 "顶级项目页面上的指南。

## 5.入门
如果您刚刚开始使用 Spring ，您可能希望通过创建基于 Spring  Boot的应用程序来开始使用 Spring  Framework 。 Spring  Boot提供了一种快速（和 opinionated/自用）的方式来创建一个生产就绪的基于 Spring 的应用程序。它基于 Spring  Framework，支持约定优于配置，旨在帮助您尽快启动和运行。

您可以使用start. Spring .io生成基本项目，也可以按照"入门"指南之一进行操作，例如" 入门构建RESTful Web服务"。除了更容易理解之外，这些指南非常注重任务，而且大多数都基于 Spring  Boot。它们还涵盖了 Spring 组合中您在解决特定问题时可能需要考虑的其他项目。

# II.核心技术
这部分参考文档涵盖了  Spring  Framework 不可或缺的所有技术。

### 核心: 
**控制反转（IoC）容器** 和 **面向切面编程（AOP）技术**

其中最重要的是 Spring  Framework的 **控制反转（IoC）容器** 。 Spring 框架的IoC容器的总体处理将在后文展示，全面覆盖了 Spring 的 **面向切面编程（AOP）技术**。 Spring  Framework有自己的AOP框架，它在概念上易于理解，并且成功地解决了Java企业编程中AOP要求的80％最佳点。

还提供了 Spring 与 `Aspect` 集成的覆盖范围（目前最丰富的 - 在功能方面 - 当然也是Java企业领域中最成熟的AOP实现）。

# 1. IoC容器
本章介绍 Spring 的控制反转（IoC）容器。

## 1.1  Spring  IoC容器和Bean简介
本章介绍了控制反转（IoC）原理的 Spring  Framework实现。IoC也称为依赖注入（DI）。这是一个过程，通过这个过程，对象只能通过 **构造函数参数**，**工厂方法的参数**或在**构造或从工厂方法返回后在对象实例上设置的属性**来定义它们的**依赖关系（即，它们使用的其他对象）** 。然后容器在创建bean时注入这些依赖项。此过程基本上是bean本身的反转（因此名称叫“控制反转”），通过使用类的直接构造或诸如服务定位器模式的机制来控制其依赖关系的实例化或位置。

在 `org. Spring framework.beans` 和 `org. Spring framework.context` 包是 Spring 框架的IoC容器的基础。该 `BeanFactory` 接口提供了一种能够管理任何类型对象的高级配置机制。 `ApplicationContext` 是 `BeanFactory` 一个子接口。它增加了：

* 更容易与 Spring 的AOP功能集成

* 消息资源处理（用于国际化）

* 事件发布

* 应用程序层特定的上下文，例如在 `WebApplicationContext` 中使用上下文。

简而言之， `BeanFactory ` 提供了配置框架和基本功能，并 `ApplicationContext ` 添加了更多特定于企业的功能。 `ApplicationContext ` 是完整的超集， `BeanFactory ` 在本章中仅用于 Spring 的IoC容器的描述。有关使用 `BeanFactory ` 而不是ApplicationContext,看到的BeanFactory更多信息。

在 Spring 中，构成应用程序主干并由  ` Spring  IoC ` 容器管理的对象称为bean。bean 是一个由 ` Spring  IoC ` 容器实例化，组装和管理的对象。否则，bean 只是应用程序中许多对象之一。Bean 及其之间的依赖关系反映在容器使用的配置元数据中。

## 1.2 容器概览
该  `org. Spring framework.context.ApplicationContext ` 接口代表 Spring  IoC容器，负责 **实例化，配置和组装bean** 。容器通过读取配置元数据获取有关要实例化，配置和组装的对象的指令。配置元数据通过 **XML，Java注解或Java代码** 表示。它允许您表达组成应用程序的对象 以及这些对象之间丰富的 相互依赖性。

ApplicationContext   Spring  提供了几种接口实现。在独立应用程序中，通常会创建一个ClassPathXmlApplicationContext 或的实例 FileSystemXmlApplicationContext。虽然XML是定义配置元数据的传统格式，但您可以通过提供少量XML配置来声明容器，使用 **Java注解或代码作为元数据格式，以声明方式启用对这些其他元数据格式的支持**。

在大多数应用程序方案中，不需要显式用户代码来实例化 Spring  IoC容器的一个或多个实例。例如，在Web应用程序场景中，应用程序文件中的简单八行（左右）样板Web描述符XML  **web.xml** 通常就足够了（请参阅Web应用程序的便捷ApplicationContext实例）。如果您使用  Spring  Tool Suite（基于Eclipse的开发环境），只需点击几下鼠标或按键即可轻松创建此样板配置。

下图显示了 Spring 如何工作的高级视图。您的应用程序类与配置元数据相结合，以便在ApplicationContext创建和初始化之后，您拥有完整的配置且可执行的系统或应用程序。

<font color="red">图1.  Spring  IoC容器</font>

pojos + 配置的元数据 ==》  Spring  容器中 ==〉 生产出完整的配置且可执行的系统或应用程序

### 1.2.1 配置元数据
如上图所示， Spring  IoC容器使用一种 **配置元数据** 。此配置元数据表示您作为应用程序开发人员如何告诉 Spring 容器在 **应用程序中实例化，配置和组装对象**。

传统上，配置元数据以简单直观的 **XML格式提供**，本章大部分内容用于传达 Spring  IoC容器的关键概念和功能。

> 基于XML的元数据不是唯一允许的配置元数据形式。 Spring  IoC容器本身完全与实际编写此配置元数据的格式分离。目前，许多开发人员为其 Spring 应用程序选择 基于Java的配置。

有关在 Spring 容器中使用其他形式的元数据的信息，请参阅：

* <font color="blue">基于注解的配置</font>： Spring  2.5引入了对基于注解的配置元数据的支持。

* <font color="blue">基于Java的配置</font>：从 Spring  3.0开始， Spring  JavaConfig项目提供的许多功能成为核心 Spring  Framework的一部分。因此，您可以使用Java而不是XML文件在应用程序类外部定义bean。要使用这些新功能，请参阅 <font color="blue">@Configuration， @Bean， @Import，和@DependsOn注解</font>。

 Spring 配置包含容器必须管理的至少一个且通常不止一个bean定义。基于XML的配置元数据将这些bean配置为<bean/>顶级元素内的<beans/>元素。Java配置通常@Bean在@Configuration类中使用注解方法。

这些bean定义对应于 **构成应用程序的实际对象 **。通常，您定义服务层对象，数据访问对象（DAOs），展示对象（如Struts Action实例），基础结构对象（如Hibernate SessionFactories，JMS Queues等）。通常，不会在容器中配置细粒度域对象，因为DAO和业务逻辑通常负责创建和加载域对象。但是，您可以使用 Spring 与AspectJ的集成来配置在IoC容器控制之外创建的对象。请参阅使用AspectJ使用 Spring 依赖注入域对象。

以下示例显示了基于XML的配置元数据的基本结构：

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www. Spring framework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www. Spring framework.org/schema/beans
        https://www. Spring framework.org/schema/beans/ Spring -beans.xsd">

    <bean id="..." class="...">  1 2 
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <bean id="..." class="...">
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions go here -->
    
</beans>
```

* 1.该id属性是一个标识单个bean定义的字符串。
* 2.该class属性定义bean的类型并使用完全限定的类名。

`id` 属性的值指的是协作对象。在此示例中未显示用于引用协作对象的XML。有关更多信息，请参阅 依赖项。

### 1.2.2 实例化容器
提供给 `ApplicationContext` 构造函数的位置路径是资源字符串，它允许容器从各种外部资源（如本地文件系统，Java等）加载配置元数据 `CLASSPATH`。

``` java
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
```

> 在了解了 Spring 的IoC容器之后，您可能想要了解有关 Spring  Resource抽象的更多信息 （如参考资料中所述），它提供了一种从URI语法中定义的位置读取InputStream的便捷机制。特别是， Resource路径用于构建应用程序上下文，如应用程序上下文和资源路径中所述。

以下示例显示了服务层对象(services.xml)配置文件：

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www. Spring framework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www. Spring framework.org/schema/beans
        https://www. Spring framework.org/schema/beans/ Spring -beans.xsd">

    <!-- services -->

    <bean id="petStore" class="org. Spring framework.samples.jpetstore.services.PetStoreServiceImpl">
        <property name="accountDao" ref="accountDao"/>
        <property name="itemDao" ref="itemDao"/>
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for services go here -->

</beans>
```

以下示例显示了数据访问对象daos.xml文件：

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www. Spring framework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www. Spring framework.org/schema/beans
        https://www. Spring framework.org/schema/beans/ Spring -beans.xsd">

    <bean id="accountDao"
        class="org. Spring framework.samples.jpetstore.dao.jpa.JpaAccountDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="itemDao" class="org. Spring framework.samples.jpetstore.dao.jpa.JpaItemDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for data access objects go here -->

</beans>
```

在前面的示例中，服务层由的 `PetStoreServiceImpl ` 类和两个数据访问对象 `JpaAccountDao `和 `JpaItemDao `（基于JPA对象关系映射标准）类。该 `property name `元素是指 JavaBean 属性的名称，以及 `ref ` 元素指的是另一个bean定义的名称。元素 `id `和 `ref `元素之间的这种联系表达了协作对象之间的依赖关系。有关配置对象的依赖关系的详细信息，请参阅 依赖关系。


#### 编写基于XML的配置元数据
让bean定义跨越多个XML文件会很有用。通常，每个单独的XML配置文件都代表架构中的逻辑层或模块。

您可以使用 **应用程序上下文** 构造函数(application context constructor) 从所有这些XML片段加载bean定义。此构造函数采用多个Resource位置，如上一节中所示 。或者，使用一个或多个<import/>元素来从另一个或多个文件加载bean定义。以下示例显示了如何执行此操作：

``` java
<beans>
    <import resource="services.xml"/>
    <import resource="resources/messageSource.xml"/>
    <import resource="/resources/themeSource.xml"/>

    <bean id="bean1" class="..."/>
    <bean id="bean2" class="..."/>
</beans>
```

在前面的例子中，外部 bean 定义是从三个文件加载： services.xml，messageSource.xml 和themeSource.xml。所有位置路径都与执行导入的定义文件相关，因此services.xml 必须与执行导入的文件位于 相同的目录或类路径位置 ， messageSource.xml 和 themeSource.xml必须位于resources导入文件位置下方的位置。如您所见，忽略前导斜杠。但是，鉴于这些路径是相对的，最好不要使用斜杠。<beans/>根据 Spring  Schema，正在导入的文件的内容（包括顶级元素）必须是有效的XML bean定义。

> 可以（但不建议）使用相对“../”路径引用父目录中的文件。这样做会对当前应用程序之外的文件创建依赖关系。特别是，不建议对classpath:URL（例如，classpath:../services.xml）使用此引用，其中运行时解析过程选择“最近的”类路径根，然后查看其父目录。类路径配置更改可能导致选择不同的，不正确的目录。

> 您始终可以使用完全限定的资源位置而不是相对路径：例如，file:C:/config/services.xml或classpath:/config/services.xml。但是，请注意您将应用程序的配置与特定的绝对位置耦合。通常最好为这些绝对位置保持间接 - 例如，通过在运行时针对JVM系统属性解析的“$ {...}”占位符。

命名空间本身提供了 import 指令功能。 Spring 提供的一系列XML命名空间中提供了除普通bean定义之外的其他配置功能 - 例如，`context` 和 `util` 名称空间。

#### Groovy Bean定义DSL
作为外化配置元数据的另一个示例，bean定义也可以在 Spring 的Groovy Bean定义DSL中表示，如Grails框架中所知。通常，此类配置位于“.groovy”文件中，其结构如下例所示：

``` java
beans {
    dataSource(BasicDataSource) {
        driverClassName = "org.hsqldb.jdbcDriver"
        url = "jdbc:hsqldb:mem:grailsDB"
        username = "sa"
        password = ""
        settings = [mynew:"setting"]
    }
    sessionFactory(SessionFactory) {
        dataSource = dataSource
    }
    myService(MyService) {
        nestedBean = { AnotherBean bean ->
            dataSource = dataSource
        }
    }
}
```

此配置样式在很大程度上等同于XML bean定义，甚至支持 Spring 的XML配置命名空间。它还允许通过importBeans指令导入XML bean定义文件。

### 1.2.3 使用容器
ApplicationContext 是高级工厂的接口，能够 **维护不同bean及其依赖项的注册表 **。通过使用该方法 `T getBean(String name, Class<T> requiredType)` ，您可以检索Bean的实例。

ApplicationContext 允许你读取 bean定义和访问它们，如下例所示：

``` java
// create and configure beans 创建一个配置bean
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance 检索一个配置实例
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance 使用配置实例
List<String> userList = service.getUsernameList();
```

使用Groovy配置，`bootstrapping`看起来非常相似。它有一个不同的上下文实现类，它是Groovy-aware（但也可以理解为 XML bean定义）。以下示例显示了Groovy配置：

``` java
ApplicationContext context = new GenericGroovyApplicationContext("services.groovy", "daos.groovy");
```

最灵活的变体 `GenericApplicationContext` 与 读取器 委托相结合 - 例如，XmlBeanDefinitionReader对于XML文件，如以下示例所示：

``` java
GenericApplicationContext context = new GenericApplicationContext();
new XmlBeanDefinitionReader(context).loadBeanDefinitions("services.xml", "daos.xml");
context.refresh();
```

您还可以使用GroovyBeanDefinitionReader 用在 Groovy文件，如以下示例所示：

``` java
GenericApplicationContext context = new GenericApplicationContext();
new GroovyBeanDefinitionReader(context).loadBeanDefinitions("services.groovy", "daos.groovy");
context.refresh();
```

您可以 `ApplicationContext` 在不同的配置源中读取和匹配此类读取器委托，读取bean定义。

然后，您可以使用 `getBean` 来检索Bean的实例。 `ApplicationContext ` 接口还有一些其他方法可以检索bean，但理想情况下，您的应用程序代码绝不应该使用它们。实际上，您的应用程序代码根本不应该调用该 `getBean() `方法，因此根本不依赖于 Spring  API。例如， Spring 与Web 框架的集成为各种Web框架组件（如控制器和JSF托管bean）提供依赖注入，允许您通过元数据（例如自动装配注解）声明对特定bean的依赖性。

## 1.3 Bean概述
 Spring  IoC容器管理一个或多个bean。这些 bean 是使用您提供给容器的配置元数据创建的（例如，以XML <bean/>定义的形式 ）。

在容器本身内，这些bean定义表示为 `BeanDefinition `对象，其中包含（以及其他信息）以下元数据：

* 包限定的类名：通常是正在定义的bean的实际实现类。

* Bean行为配置元素，说明bean在容器中的行为方式（scope/范围，lifecycle callbacks/生命周期回调等）。

* 引用bean执行其工作所需的其他bean。这些引用也称为协作者或依赖项。

* 要在新创建的对象中设置的其他配置设置 - 例如，在使用 bean 管理一个连接池的池的大小限制或连接数。

此元数据转换为构成每个bean定义的一组属性。下表描述了这些属性：

表1. bean定义

属性 |解释在……|
:---:|:---:
类|实例化 bean
名称|命名 bean
范围|Bean 范围
构造函数参数|依赖注入
属性|依赖注入
自动装配模式|自动化协作者
延迟初始化模式|懒惰初始化的 bean
初始化方法|初始化回调
销毁方法|销毁回调

除了包含有关如何创建特定bean的信息的bean定义之外，这些 `ApplicationContext `实现还允许注册在容器外部（由用户）创建的现有对象。这是通过方法访问 `ApplicationContext ` 的 `BeanFactory `来完成的 `getBeanFactory() `，该方法返回BeanFactory  `DefaultListableBeanFactory `实现。 `DefaultListableBeanFactory ` 通过 `registerSingleton(..) `和 r `egisterBeanDefinition(..) `方法支持此注册。但是，典型的应用程序仅使用通过 **常规bean定义元数据定义的bean** 。

> 需要尽早注册Bean元数据和手动提供的单例实例，以便容器在自动装配和其他内省步骤期间正确推导它们。虽然在某种程度上支持覆盖现有元数据和现有单例实例，但是在运行时注册新bean（与对工厂的实时访问同时）并未得到官方支持，并且可能导致并发访问异常，bean容器中的状态不一致，或者两者都会发生。

### 1.3.1 命名 Beans
每个bean都有一个或多个标识符。这些标识符在托管bean的容器中必须是 **<font color="blue">唯一的</font>** 。bean通常只有一个标识符。但是，如果它需要多个，则额外的可以被视为`别名`。

在基于XML的配置元数据中，您可以使用 `id `属性， `name `属性或两者来指定bean标识符。 `id `属性允许您指定一个id。通常，这些名称是字母数字（'myBean'，'someService'等），但它们也可以包含特殊字符。如果要为bean引入**其他别名**，还可以在 `name ` 属性中指定它们，用逗号（,），分号（;）或空格分隔。作为历史记录，在 Spring  3.1之前的版本中，该id属性被定义为一种xsd:ID类型，它约束了可能的字符。从3.1开始，它被定义为一种xsd:string类型。请注意，id容器仍然强制实施bean 唯一性，但不再是XML解析器。

您不需要一定提供bean  `name `或 bean `id `。如果您不提供 name或id显式提供，则**容器会为该bean生成唯一的名称**。但是，如果要按名称引用该bean，则通过使用ref元素或 Service Locator样式查找，必须提供名称。不提供名称的动机与使用内部bean和自动装配协作者有关。

<font color="blue">推荐显示的指定标识符，便于自己使用和管理</font>

#### Bean命名约定
惯例是在命名bean时使用标准Java约定作为实例字段名称。也就是说，bean名称以小写字母开头，并从那里开始使用驼峰。这样的名字的例子包括 `accountManager `，  `accountService `， `userDao `， `loginController `等等。

命名bean始终使您的配置更易于阅读和理解。此外，如果您使用 Spring  AOP，那么在将建议使用名称相关的一组bean，会有很大帮助。

> 通过类路径中的组件扫描， Spring 按照前面描述的规则为未命名的组件生成bean名称：实质上，采用简单的类名并将其初始字符转换为小写。但是，在（不常见的）特殊情况下，当有多个字符且第一个和第二个字符都是大写字母时，原始外壳将被保留。这些规则与 `java.beans.Introspector.decapitalize `（ Spring 在此处使用）定义的规则相同。

#### 在Bean定义之外别名Bean
在bean定义本身中，您可以为bean提供多个名称，方法是使用 `id `属性指定的最多一个名称和属性中的任意数量的 `其他名称name `。这些名称可以是同一个bean的等效别名，对某些情况很有用，例如让应用程序中的每个组件通过使用特定于该组件本身的bean名称来引用公共依赖项。

但是，指定实际定义bean的所有别名并不总是满足条件的。有时需要为其他地方定义的bean引入别名。在大型系统中通常就是这种情况，其中配置在每个子系统之间分配，每个子系统具有其自己的一组对象定义。在基于XML的配置元数据中，您可以使用该 `<alias/>` 元素来完成此任务。以下示例显示了如何执行此操作：

```
<alias name="fromName" alias="toName"/>
```

在这种情况下，fromName在使用此别名定义之后，命名的bean（在同一容器中）也可以称为toName。

例如，子系统A的配置元数据可以通过名称引用`DataSource subsystemA-dataSource`。子系统B的配置元数据可以通过名称引用DataSource `subsystemB-dataSource`。在编写同时使用这两个子系统的主应用程序时，主应用程序通过名称引用`DataSource myApp-dataSource`。要使所有三个名称引用同一对象，可以将以下别名定义添加到配置元数据中：

``` xml
<alias name="myApp-dataSource" alias="subsystemA-dataSource"/>
<alias name="myApp-dataSource" alias="subsystemB-dataSource"/>
```

现在，每个组件和主应用程序都可以通过一个唯一的名称引用 dataSource ，并保证不与任何其他定义冲突（有效地创建命名空间），但它们引用相同的bean。

Java的配置
> 如果使用Javaconfiguration，则@Bean可以使用注解来提供别名。有关详细信息，请参阅使用@Bean注解。

### 1.3.2 实例化 beans
bean定义 本质上是用于 **创建一个或多个对象的方法 **。容器在被询问时查看命名bean的方法，并使用由该bean定义封装的配置元数据来创建（或获取）实际对象。

如果使用基于 XML 配置元数据，则指定要在元素的class属性中实例化的对象的类型（或类）<bean/>。此 `class`属性（在内部，是 实例Class上的属性 `BeanDefinition `）通常是必需的。（有关例外，请参阅 使用实例工厂方法和Bean定义继承进行实例化。）您可以通过以下两种方式之一使用 Class 属性：

* 方式1:通常，在容器本身通过反向调用其构造函数直接创建bean的情况下指定要构造的bean类，差不多等同于使用 new 运算符的Java代码。

* 方式2:要指定包含 `static `为创建对象而调用的工厂方法的实际类，在不太常见的情况下，容器static在类上调用工厂方法来创建bean。从调用 `static工厂方法 `返回的对象类型可以完全是同一个类或另一个类。<font color="blue">

> Tips:【推荐:静态工厂方法应该优先考虑，然后考虑构造函数的方式】</font>

#### 内部类名
> 如果要为 `static `嵌套类配置bean定义，则必须使用嵌套类的二进制名称。

> 例如，如果`SomeThing`在`com.example`包中调用了一个类，并且此类 SomeThing具有一个 `static `被调用的嵌套类 `OtherThing`，则class bean定义中的属性值将为`com.example.SomeThing$OtherThing`。

> 请注意，使用$名称中的字符将嵌套类名与外部类名分开。

#### 使用构造函数实例化
当您通过构造方法创建bean时，所有普通类都可以使用并与 Spring 兼容。也就是说，正在开发的类不需要实现任何特定接口或以特定方式编码。简单地指定bean类就足够了。但是，根据您为该特定bean使用的IoC类型，您可能需要一个 **默认（空）构造函数**。

Spring  IoC容器几乎可以管理您希望它管理的任何类。它不仅限于管理真正的 JavaBeans 。大多数 Spring 用户更喜欢实际的 JavaBeans ，只有一个默认（无参数）构造函数，并且在容器中的属性之后设置了适当的 setter 和getter。您还可以在容器中拥有更多异国情调的非bean样式类。例如，如果您需要使用不符合 JavaBean 规范的旧连接池，那么 Spring 也可以对其进行管理。

使用基于XML的配置元数据，您可以按如下方式指定bean类：

``` xml
<bean id="exampleBean" class="examples.ExampleBean"/>

<bean name="anotherExample" class="examples.ExampleBeanTwo"/>
```

有关为构造函数提供参数的机制（如果需要）以及在构造对象后设置对象实例属性的详细信息，请参阅 `注入依赖项`。

#### 使用静态工厂方法实例化
定义使用静态工厂方法创建的bean时，请使用该 `class  `属性指定包含 `static `工厂方法的类，并使用 `factory-method `名称的属性指定工厂方法本身的名称。您应该能够调用此方法（使用可选参数，如稍后所述）并返回一个可用对象，随后将其视为通过构造函数创建的对象。这种bean定义的一个用途是 `static `在遗留代码中调用工厂。

以下bean定义指定通过调用工厂方法来创建bean。该定义未指定返回对象的类型（类），仅指定包含工厂方法的类。在此示例中，该createInstance() 方法必须是静态方法。以下示例显示如何指定工厂方法：

``` xml
<bean id="clientService"
    class="examples.ClientService"
    factory-method="createInstance"/>
```

以下示例显示了一个可以使用前面的 bean 定义的类：

``` java
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

	 // 静态工厂方法
    public static ClientService createInstance() {
        return clientService;
    }
}
```

有关在从工厂返回对象后为工厂方法提供（可选）参数和设置对象实例属性的机制的详细信息，请参阅 `依赖关系和详细配置 `。

#### 使用实例工厂方法实例化
与通过静态工厂方法实例化类似，使用实例工厂方法进行实例化会从容器 ==**调用现有bean的非静态方法来创建新bean**==。要使用此机制，请将该`class`属性保留为空，并在`factory-bean`属性中指定当前（或父或祖先）容器中bean的名称，该容器包含要调用以创建对象的实例方法。使用factory-method属性设置工厂方法本身的名称。以下示例显示如何配置此类bean：

``` xml
<!-- the factory bean, which contains a method called createInstance() -->
<!-- 工厂bean: 包含一个方法叫做 createInstance() -->
<bean id="serviceLocator" class="examples.DefaultServiceLocator">
    <!-- inject any dependencies required by this locator bean -->
</bean>

<!-- the bean to be created via the factory bean -->
<bean id="clientService"
    factory-bean="serviceLocator"
    factory-method="createClientServiceInstance"/>
```

以下示例显示了相应的Java类：

``` java
public class DefaultServiceLocator {

    private static ClientService clientService = new ClientServiceImpl();

    public ClientService createClientServiceInstance() {
        return clientService;
    }
}
```

**一个工厂类也可以包含多个工厂方法**，如以下示例所示：

``` xml
<bean id="serviceLocator" class="examples.DefaultServiceLocator">
    <!-- inject any dependencies required by this locator bean -->
</bean>

<bean id="clientService"
    factory-bean="serviceLocator"
    factory-method="createClientServiceInstance"/>

<bean id="accountService"
    factory-bean="serviceLocator"
    factory-method="createAccountServiceInstance"/>
```

以下示例显示了相应的Java类：

``` java
public class DefaultServiceLocator {

    private static ClientService clientService = new ClientServiceImpl();

    private static AccountService accountService = new AccountServiceImpl();

    public ClientService createClientServiceInstance() {
        return clientService;
    }

    public AccountService createAccountServiceInstance() {
        return accountService;
    }
}
```

这种方法表明工厂bean本身可以通过 **依赖注入（DI**）进行管理和配置。请参阅详细信息中的`依赖关系和配置。`

> 在Spring文档中，“工厂bean”是指在Spring容器中配置并通过实例或 静态工厂方法创建对象的bean 。相比之下， FactoryBean（注意大写）指的是特定于Spring的 FactoryBean。(比如上面的`DefaultServiceLocator` 就是一个工厂 bean)

## 1.4 依赖
典型的企业应用程序不是由单个对象组成的（或Spring用法中的bean）。即使是最简单的应用程序也有一些对象可以协同工作，以呈现最终用户所看到的连贯应用程序。下一节将**介绍如何定义多个独立的bean定义，以及对象协作实现目标的完全实现的应用程序。**

### 1.4.1 依赖注入
依赖注入（DI）是一个过程，通过这个过程，对象只能通过 `构造函数参数`， `工厂方法的参数`或 `在构造对象实例后在对象实例上设置的属性`来定义它们的依赖关系（即它们使用的其他对象）。从工厂方法返回。然后容器在创建bean时注入这些依赖项。这个过程基本上是bean本身的反转（因此名称叫做 `控制反转`），它通过使用类的 `直接构造` 或 `服务定位器模式` 来控制其依赖项的实例化或位置。

使用DI原则的代码更清晰，当对象提供其依赖项时，解耦更有效。该对象不查找其依赖项，也不知道依赖项的位置或类。因此，您的类变得更容易测试，特别是当依赖关系在接口或抽象基类上时，这`允许在单元测试中使用stub/存根或模拟实现。`

### DI存在两个主要变体：
**基于构造函数的依赖注入** 和 **基于Setter的依赖注入**。

#### 基于构造函数的依赖注入
基于构造函数的DI由容器调用具有多个参数的构造函数来完成，每个参数表示一个依赖项。调用 `static` 具有特定参数的工厂方法来构造bean几乎是等效的，处理构造函数和static工厂方法的参数相似。以下示例显示了一个只能通过`构造函数注入`进行依赖注入的类：

``` java 
public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on a MovieFinder ：SimpleMovieLister 依赖于 MovieFinder
    private MovieFinder movieFinder;

    // a constructor so that the Spring container can inject a MovieFinder ： 通过这个构造函数， spring 容器可以注入 MovieFinder
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
```

请注意，这个类没有什么特别之处。它是一个POJO，它不依赖于容器特定的接口，基类或注解。

#### 构造函数参数解析
通过使用 **参数的类型** 进行构造函数参数解析匹配。如果bean定义的构造函数参数中不存在潜在的歧义，那么在bean定义中 定义构造函数参数的顺序 是在实例化bean时将这些参数 提供给适当的构造函数的顺序（即构造函数中的参数顺序就是 bean 实例化时参数的顺序）。思考以下类：

``` java
package x.y;

public class ThingOne {

    public ThingOne(ThingTwo thingTwo, ThingThree thingThree) {
        // ...
    }
}
```

假设`ThingTwo`并且`ThingThree`类与继承无关，则不存在潜在的歧义。因此，以下配置工作正常，您不需要在<constructor-arg/> 元素中 **显式指定构造函数参数索引或类型**（spring 默认会按照没有歧义的bean 进行构造函数实例化）。

```
<beans>
    <bean id="beanOne" class="x.y.ThingOne">
        <constructor-arg ref="beanTwo"/>
        <constructor-arg ref="beanThree"/>
    </bean>

    <bean id="beanTwo" class="x.y.ThingTwo"/>

    <bean id="beanThree" class="x.y.ThingThree"/>
</beans>
```

当引用另一个bean时，类型是已知的，并且可以发生匹配（与前面的示例一样）。当使用简单类型时，例如 <value>true</value>，Spring无法确定值的类型，因此 **无法在没有帮助的情况下按类型进行匹配**。思考以下类：

``` java
package examples;

public class ExampleBean {

    // Number of years to calculate the Ultimate Answer
    private int years;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
```

#### 构造函数参数类型匹配
在前面的场景中，如果使用 `type` 属性**显式指定构造函数参数的类型，则容器可以使用与简单类型的类型匹配(见上面的java代码)**。如下例所示：

``` xml
<bean id="exampleBean" class="examples.ExampleBean">
	 <!—-匹配上面的变量 year—->
    <constructor-arg type="int" value="7500000"/>
    <!—-匹配上面的变量 ultimateAnswer-—>
    <constructor-arg type="java.lang.String" value="42"/>
</bean>
```

#### 构造函数参数索引
可以使用 `index` 属性 **显式指定构造函数参数的索引**，如以下示例所示：

``` xml
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg index="0" value="7500000"/>
    <constructor-arg index="1" value="42"/>
</bean>
```

除了解决**多个简单值的歧义**之外，指定索引还可以解决构造函数**具有相同类型的两个参数的歧义**。

> 请注意:**该指数从0开始**

#### 构造函数参数名称
可以使用**构造函数参数名称进行值消歧**，如以下示例所示：

``` xml
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg name="years" value="7500000"/>
    <constructor-arg name="ultimateAnswer" value="42"/>
</bean>
```

请记住，为了方便开箱即用，必须在启用调试标志的情况下编译代码，以便Spring可以从构造函数中查找参数名称。如果您不能或不想使用debug标志编译代码，则可以使用 `@ConstructorProperties` JDK **注解显式命名构造函数参数**。 然后，示例类必须如下所示：

``` java
package examples;

public class ExampleBean {

    // Fields omitted

	 // 注意这个格式
    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
```

#### 基于Setter的依赖注入
在调用无参数构造函数或无参数`static`工厂方法来实例化bean之后，基于setter的 DI 由bean上的容器调用setter方法完成。

以下示例显示了一个只能通过使用纯setter注入进行依赖注入的类。这个类是传统的Java。它是一个POJO，它不依赖于容器特定的接口、基类或注解。

``` java
public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on the MovieFinder
    private MovieFinder movieFinder;

	 // setter 方法进行依赖注入
    // a setter method so that the Spring container can inject a MovieFinder
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
```

`ApplicationContext` 支持它管理的bean的基于构造函数和基于setter的DI。在通过构造函数方法注入了一些依赖项之后，它还支持基于setter的DI。您可以以`BeanDefinition`的形式配置依赖项，并将`BeanDefinition`与`PropertyEditor`实例结合使用，以将属性从一种格式转换为另一种格式。然而，大多数Spring用户不直接使用这些类（即编程的方式），而是用 `XML bean `定义，注解组件（也就是注解类`@Component`，` @Controller`等），或者`@Bean`方法在基于Java的 `@Configuration` 类。然后，这些源在内部转换为实例`BeanDefinition`并用于加载整个 Spring IoC 容器实例。

#### 基于构造函数或基于setter的DI如何选择？
由于您可以混合基于构造函数和基于setter的DI，因此将构造函数用于强制依赖项和setter方法用于可选依赖项的配置方法是一个很好的经验实践。请注意， 在setter方法上使用 `@Required` 注解可用于使属性成为必需的依赖项; 但是，**最好使用编程验证参数的构造函数注入**。

**Spring团队通常提倡构造函数注入**，因为它允许您将应用程序组件实现为不可变对象，并确保所需的依赖项不是null。此外，构造函数注入的组件始终以完全初始化的状态返回到客户端（调用）代码。作为旁注，大量的构造函数参数是一个糟糕的代码风格，暗示该类可能有太多的责任，应该重构以更好地解决关注点的正确分离。

Setter注入应主要仅用于可在类中指定合理默认值的**可选依赖项**。否则，必须在代码使用依赖项的任何位置执行非空检查。setter注入的一个好处是**setter方法使该类的对象可以在以后重新配置或重新注入**。因此，通过JMX MBean进行管理是二次注入的一个引人注目的用例。

使用对特定类最有意义的DI样式。有时，在处理没有源代码的第三方类时，这个选择是为您准备的。例如，如果第三方类没有公开任何setter方法，那么构造函数注入可能是唯一可用的DI形式。

#### 依赖性解决过程
容器执行bean依赖性解析，如下所示：

* 使用`ApplicationContext`描述所有bean的配置元数据创建和初始化。配置元数据可以由**XML，Java代码或注解指定**。

* 对于每个bean，它的依赖关系以`属性，构造函数参数或static-factory方法的参数的形式表示`（如果使用它而不是普通的构造函数）。实际创建bean时，会将这些依赖项提供给bean。

* 每个属性或构造函数参数都是要设置的值的实际定义，或者是对容器中另一个bean的引用。

* 作为值的每个属性或构造函数参数都从其指定的格式转换为该属性或构造函数参数的实际类型。默认情况下，Spring能够转换成`字符串格式`提供给所有内置类型的值，例如int， long，String，boolean，等等。

Spring容器在创建容器时验证每个bean的配置。但是，在实际创建bean之前，不会设置bean属性本身。创建容器时会创建单例作用域并设置为预先实例化（默认值）的Bean。范围在Bean范围中定义。否则，仅在请求时才创建bean。创建bean可能会导致创建bean的图形，因为bean的依赖关系及其依赖关系（依此类推）被创建和分配。请注意，这些依赖项之间的解决方案不匹配可能会较晚出现 - 也就是说，首次创建受影响的bean时。

> **循环依赖** 
> 
> 如果您主要使用构造函数注入，则可以创建无法解析的循环依赖关系场景。

> 例如：类A通过构造函数注入需要类B的实例，而类B通过构造函数注入需要类A的实例。如果将A类和B类的bean配置为相互注入，则Spring IoC容器会在运行时检测到此循环引用，并抛出a BeanCurrentlyInCreationException。

> 一种可能的解决方案是编辑由setter而不是构造函数配置的某些类的源代码。或者，避免构造函数注入并仅使用setter注入。换句话说，尽管不推荐使用，但您可以使用setter注入配置循环依赖项。

> 与典型情况（没有循环依赖）不同，bean A和bean B之间的循环依赖强制其中一个bean在完全初始化之前被注入另一个bean（一个经典的鸡与鸡蛋场景）。

你通常可以相信Spring做正确的事。它在容器加载时检测配置问题，例如对不存在的bean和循环依赖关系的引用。当实际创建bean时，Spring会尽可能晚地设置属性并解析依赖关系。这意味着，如果在创建该对象或其中一个依赖项时出现问题，则在请求对象时，正确加载的Spring容器可以在以后生成异常 - 例如，bean因缺失或无效而抛出异常属性。这可能会延迟一些配置问题的可见性, `ApplicationContext` 默认情况下实现预实例化单例bean。以实际需要之前创建这些bean的一些前期时间和内存为代价，`ApplicationContext` 会在创建时发现配置问题，而不是更晚。您仍然可以覆盖此默认行为，以便单例bean可以惰性地初始化，而不是预先实例化。

如果不存在循环依赖关系，当一个或多个协作bean被注入依赖bean时，每个协作bean在被注入依赖bean之前完全配置完成。这意味着，如果bean A依赖于bean B，则Spring IoC容器在调用bean A上的setter方法之前会完全配置bean B.换句话说，bean被实例化（如果它不是预先实例化的单例），设置其依赖项，并调用相关的生命周期方法（如配置的init方法 或InitializingBean回调方法）。

#### 依赖注入的示例
以下示例将基于XML的配置元数据用于基于 setter 的DI。Spring XML配置文件的一小部分指定了一些bean定义，如下所示：

``` xml
<bean id="exampleBean" class="examples.ExampleBean">
    <!-- setter injection using the nested ref element -->
    <property name="beanOne">
        <ref bean="anotherExampleBean"/>
    </property>

	<!--基于 setter 的依赖注入-->
    <!-- setter injection using the neater ref attribute -->
    <property name="beanTwo" ref="yetAnotherBean"/>
    <property name="integerProperty" value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```

以下示例显示了相应的ExampleBean类：

``` java
public class ExampleBean {

	 // 对应 xml 文件中的 property 标签下的 ref 属性
    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    public void setBeanOne(AnotherBean beanOne) {
        this.beanOne = beanOne;
    }

    public void setBeanTwo(YetAnotherBean beanTwo) {
        this.beanTwo = beanTwo;
    }

    public void setIntegerProperty(int i) {
        this.i = i;
    }
}
```

在前面的示例中，声明setter与XML文件中指定的属性匹配。以下示例使用基于构造函数的DI：

``` xml
<bean id="exampleBean" class="examples.ExampleBean">
    <!-- constructor injection using the nested ref element -->
    <constructor-arg>
        <ref bean="anotherExampleBean"/>
    </constructor-arg>

    <!-- constructor injection using the neater ref attribute -->
    <constructor-arg ref="yetAnotherBean"/>

    <constructor-arg type="int" value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```

以下示例显示了相应的ExampleBean类：

``` java
public class ExampleBean {

    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    public ExampleBean(
        AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {
        this.beanOne = anotherBean;
        this.beanTwo = yetAnotherBean;
        this.i = i;
    }
}
```

bean定义中指定的`构造函数参数`（上面的constructor-arg）用作构造函数的参数`ExampleBean`。

现在考虑这个例子的变体，其中，不是使用构造函数，而是告诉Spring调用`static`工厂方法来返回对象的实例：

``` xml
<bean id="exampleBean" class="examples.ExampleBean" factory-method="createInstance">
    <constructor-arg ref="anotherExampleBean"/>
    <constructor-arg ref="yetAnotherBean"/>
    <constructor-arg value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```

以下示例显示了相应的ExampleBean类：

``` java
public class ExampleBean {

	 // 静态工厂:定一个私有的构造函数
    // a private constructor
    private ExampleBean(...) {
        ...
    }

    // a static factory method; the arguments to this method can be
    // considered the dependencies of the bean that is returned,
    // regardless of how those arguments are actually used.
    public static ExampleBean createInstance (
        AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {

        ExampleBean eb = new ExampleBean (...);
        // some other operations...
        return eb;
    }
}
```

`static` 工厂方法的参数由 `<constructor-arg/>` 元素提供，与实际使用的构造函数完全相同。工厂方法返回的类的类型不必与包含static工厂方法的类相同（尽管在本例中是相同的，即ExampleBean）。实例（非静态）工厂方法可以以基本相同的方式使用（除了使用`factory-bean` 属性而不是 `class` 属性），因此我们不在此讨论这些细节。

### 1.4.2 详细信息的依赖关系和配置
如上一节所述，您可以将bean属性和构造函数参数定义为对其他托管bean（协作者）的引用，或者作为内联定义的值。Spring的基于XML的配置元数据为此目的支持其元素 `<property/>` 和 `<constructor-arg/>` 元素中的子元素类型。

直接值（原始类型(基本数据类型)，字符串等）
在 `value` 所述的属性 `<property/>` 元素指定属性或构造器参数的人类可读的字符串表示。Spring的 转换服务用于将这些值从 `String` 转换为属性或参数的实际类型。以下示例显示了要设置的各种值：

``` xml
<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <!-- results in a setDriverClassName(String) call -->
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
    <property name="username" value="root"/>
    <property name="password" value="masterkaoli"/>
</bean>
```

以下示例使用p命名空间进行更简洁的XML配置：

``` xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource"
        destroy-method="close"
        p:driverClassName="com.mysql.jdbc.Driver"
        p:url="jdbc:mysql://localhost:3306/mydb"
        p:username="root"
        p:password="masterkaoli"/>

</beans>
```

相比前面的XML更简洁。但是，除非您在创建bean定义时使用支持自动属性完成的IDE（例如IntelliJ IDEA或Spring Tool Suite），否则会在运行时而不是设计时发现拼写错误。**强烈建议使用此类IDE帮助（手写容易出错）**。

您还可以配置` java.util.Properties` 实例，如下所示：

``` xml
<bean id="mappings"
    class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">

    <!-- typed as a java.util.Properties -->
    <property name="properties"> 
        <value>
            jdbc.driver.className=com.mysql.jdbc.Driver
            jdbc.url=jdbc:mysql://localhost:3306/mydb
        </value>
    </property>
</bean>
```

Spring容器通过使用 JavaBeans 机制将 `<value/>` 元素内的文本转换为 `java.util.Properties`实例` PropertyEditor`。这是一个很好的快捷方式，也是Spring团队支持 `<value/>` 在value属性样式上使用嵌套元素的少数几个地方之一。

#### `idref` 元素
`idref` 元素只是一种防错方法，可以将 `id` 容器中另一个bean 的（字符串值 - 而不是引用）传递给`<constructor-arg/>` 或 `<property/> ` 元素。以下示例显示了如何使用它：

``` xml
<bean id="theTargetBean" class="..."/>

<bean id="theClientBean" class="...">
    <property name="targetName">
        <idref bean="theTargetBean"/>
    </property>
</bean>
```

前面的bean定义代码段与以下代码段完全等效（在运行时）：

``` xml
<bean id="theTargetBean" class="..." />

<bean id="client" class="...">
    <property name="targetName" value="theTargetBean"/>
</bean>
```

第一种形式优于第二种形式，因为使用`idref`标记**允许容器在部署时验证引用的命名bean实际存在**。在第二个变体中，不对传递给bean 的targetName属性的值执行验证client【不会验证】。只有在client实际实例化bean 时才会发现错别字（很可能是致命的结果）。如果client bean 是 `prototype/原型 bean` ，则只能在部署容器后很长时间才能发现此错误和产生的异常。

> 4.0 beans XSD不再支持 local idref 元素 的属性，因为它不再提供常规bean引用的值。升级到4.0架构时，将现有idref local引用更改idref bean为。

其中一个共同的地方（至少在早期比Spring 2.0版本）`<idref/>` 元素带来的值在配置AOP拦截在 `ProxyFactoryBean` bean定义。在指定拦截器名称时使用`<idref/>` 元素，可防止拼写错误的拦截器ID。

#### 引用其他 Beans（协作者）
引用的`ref`元素是内部的最终元素 `<constructor-arg/>或<property/>` 定义元素。在这里，您将bean的指定属性的值设置为对容器管理的另一个 bean（协作者）的引用。**引用的bean是要设置其属性的bean的依赖项，并且在设置该属性之前根据需要对其进行初始化**。（如果协作者是单例bean，它可能已经被容器初始化。）所有引用最终都是对另一个对象的引用。划定范围和有效性取决于是否通过指定其他对象的ID或名称`bean`，`local` 或 `parent` 属性。

通过标记bean的 <ref/> 属性指定目标`bean` 是最常用的形式，并允许创建对同一容器或父容器中的任何bean的引用，而不管它是否在同一XML文件中。`bean` 属性的值可能与 目标bean 的属性 `id`或者` name `属性中的值之一相同。以下示例显示如何使用ref元素：

``` xml
<ref bean="someBean"/>
```

通过该` parent` 属性指定目标bean 会创建对当前容器的父容器中的bean的引用。`parent` 属性的值可以与 目标bean 的`id`属性或`name` 属性中的值之一相同。目标bean必须位于当前bean的父容器中。您应该使用此bean引用变体，主要是当有**容器层次结构**并且希望**将现有bean包装在父容器中** 时，该容器具有与父bean同名的代理。以下一对列表显示了如何使用 `parent` 属性：

``` xml
<!-- in the parent context -->
<bean id="accountService" class="com.something.SimpleAccountService">
    <!-- insert dependencies as required as here -->
</bean>
```

``` xml
<!-- in the child (descendant) context -->
<bean id="accountService" <!-- bean name is the same as the parent bean: bean名字与父级的bean名字相同 -->
    class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="target">
        <ref parent="accountService"/> <!-- notice how we refer to the parent bean:注意我们如何引用父级的bean -->
    </property>
    <!-- insert other configuration and dependencies as required here -->
</bean>
```

> 4.0 beans XSD不再支持local ref元素的属性，因为它不再提供常规 bean 引用的值。升级到4.0架构时，将现有ref local引用更改为ref bean。

#### 内部 Beans
`<bean/>` 内部的元素 `<property/> `或`<constructor-arg/>` 元素限定内部Beans，如下示例所示：

``` xml
<bean id="outer" class="...">
    <!-- instead of using a reference to a target bean, simply define the target bean inline -->
    <!--不是使用一个目标 bean 的引用，而是简单地在内部定义目标 bean-->
    <property name="target">
        <bean class="com.example.Person"> <!-- this is the inner bean -->
            <property name="name" value="Fiona Apple"/>
            <property name="age" value="25"/>
        </bean>
    </property>
</bean>
```

内部 bean 定义不需要定义的ID或名称。如果指定，则容器不使用此值作为标识符。容器还会`scope`在创建时忽略标志，因为**内部bean始终是匿名的**，并且始终使用外部bean创建。不能独立访问内部bean或将它们注入协作bean而不是封闭bean。

作为一个极端情况，可以从自定义范围接收销毁回调 - 例如，对于包含在单例bean中的请求范围内部bean。内部bean实例的创建与其包含bean相关联，但是销毁回调允许它参与请求范围的生命周期。这不是常见的情况。内部bean通常只是共享他们容器bean的作用域。

#### 集合
`<list/>`、`<set/>`、`<map/>`、和` <props/>`元素分别设置Java Collection类型`List`、`Set`、`Map`，和 `Properties`的属性。下示例展示了如何使用它们：

``` xml
<bean id="moreComplexObject" class="example.ComplexObject">
    <!-- results in a setAdminEmails(java.util.Properties) call -->
    <property name="adminEmails">
        <props>
            <prop key="administrator">administrator@example.org</prop>
            <prop key="support">support@example.org</prop>
            <prop key="development">development@example.org</prop>
        </props>
    </property>
    <!-- results in a setSomeList(java.util.List) call -->
    <property name="someList">
        <list>
            <value>a list element followed by a reference</value>
            <ref bean="myDataSource" />
        </list>
    </property>
    <!-- results in a setSomeMap(java.util.Map) call -->
    <property name="someMap">
        <map>
            <entry key="an entry" value="just some string"/>
            <entry key ="a ref" value-ref="myDataSource"/>
        </map>
    </property>
    <!-- results in a setSomeSet(java.util.Set) call -->
    <property name="someSet">
        <set>
            <value>just some string</value>
            <ref bean="myDataSource" />
        </set>
    </property>
</bean>
```

`map `的 key 或 value 的值或` set `的 value也可以是以下任何元素：

	bean | ref | idref | list | set | map | props | value | null
	
#### 集合合并
Spring容器还支持合并集合。应用程序开发人员可以定义父`<list/>，<map/>，<set/>或<props/>`元素，并有子`<list/>，<map/>，<set/>或<props/>`元素继承和父集合覆盖值。也就是说，**子集合的值是合并父集合和子集合的元素的结果**，**子集合的元素覆盖父集合中指定的值**。

关于合并的这一部分讨论了`父子bean机制`。不熟悉父和子bean定义的读者可能希望在继续之前阅读 相关部分。

以下示例演示了集合合并：

``` xml
<beans>
    <bean id="parent" abstract="true" class="example.ComplexObject">
        <property name="adminEmails">
            <props>
                <prop key="administrator">administrator@example.com</prop>
                <prop key="support">support@example.com</prop>
            </props>
        </property>
    </bean>
    
    <bean id="child" parent="parent">
        <property name="adminEmails">
            <!-- the merge is specified on the child collection definition -->
            <props merge="true">
                <prop key="sales">sales@example.com</prop>
                <prop key="support">support@example.co.uk</prop>
            </props>
        </property>
    </bean>
<beans>
```

注意使用在child bean定义中 `adminEmails` 属性的<props/>的元素上的 `merge=true` 属性。当 `child` 容器解析并实例化 bean 时，生成的实例有一个`adminEmails` `Properties` 集合，其中包含将子集合 `adminEmails` 与父 `adminEmails` 集合合并的结果 。以下清单显示了结果：

```
administrator=administrator@example.com 
sales=sales@example.com 
support=support@example.co.uk
```

子Properties集合的值设置继承父所有属性元素<props/>，并且子 bean 中 support 值将覆盖父集合的值(support@example.co.uk)。

这一合并行为同样适用于 `<list/>`，`<map/>` 和 `<set/>` 集合类型。在` <list/>` 元素的特定情况下，保持与`List`集合类型（即 `ordered` 值集合的概念）相关联的语义。父级的值先于所有子级列表的值。在 Map，Set和Properties集合类型中，没有顺序存在。因此，对于容器内部使用关联映射，Map，Set以及Properties等集合类型，没有排序的语义。**【Map，Set以及Properties 无序】**

#### 集合合并的局限性
无法合并不同的集合类型（例如合并 Map和 List）。如果您尝试这样做，则会引发相应的Exception。merge属性必须在较低的，继承，子定义上指定。merge在父集合定义上指定属性是多余的，且不会导致所期望的合并。

#### 强类型集合
通过在 Java 5 中引入泛型类型，您可以使用强类型集合。也就是说，可以声明一种`Collection`类型，使得它只能包含（例如）String元素。如果使用 Spring 将强类型依赖注入 Collection 到bean中，则可以利用 Spring 的类型转换支持，以便强类型 Collection 实例的元素在添加到之前转换为适当类型的Collection。以下Java类和bean定义显示了如何执行此操作：

``` java 
public class SomeClass {

    private Map<String, Float> accounts;

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }
}
```
``` xml
<beans>
    <bean id="something" class="x.y.SomeClass">
        <property name="accounts">
            <map>
                <entry key="one" value="9.99"/>
                <entry key="two" value="2.75"/>
                <entry key="six" value="3.99"/>
            </map>
        </property>
    </bean>
</beans>
```
当为注入准备bean 的accounts属性时，通过反射可获得something关于强类型的元素类型的泛型信息Map<String, Float>。因此，**Spring的类型转换** 基础结构识别各种值元素为类型Float，并将字符串值（9.99, 2.75，和 3.99）转换为实际`Float`类型。

#### 空字符串值和空字符串值
Spring 将属性等空参视为空字符串。以下基于XML的配置元数据片段将email属性设置为空 String值 ("")。

``` xml
<bean class="ExampleBean">
    <property name="email" value=""/>
</bean>
```
上面的示例等效于以下Java代码：

``` java
exampleBean.setEmail("");
```

该<null/>元素处理null值。以下清单显示了一个示例：

``` xml
<bean class="ExampleBean">
    <property name="email">
        <null/>
    </property>
</bean>
```
上述配置等同于以下Java代码：

``` java
exampleBean.setEmail(null);
```

#### 带有p命名空间的XML快捷方式
p命名空间允许您使用bean元素的属性（而不是嵌套 `<property/>`元素）来描述属性值协作bean，或两者均可。

Spring支持具有命名空间的可扩展配置格式，这些命名空间基于XML Schema定义。beans本章中讨论的配置格式在XML Schema文档中定义。但是，p命名空间未在XSD文件中定义，仅存在于Spring的核心中。

以下示例显示了两个XML片段（第一个使用标准XML格式，第二个使用p命名空间）解析为相同的结果：

``` xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean name="classic" class="com.example.ExampleBean">
        <property name="email" value="someone@somewhere.com"/>
    </bean>

    <bean name="p-namespace" class="com.example.ExampleBean"
        p:email="someone@somewhere.com"/>
</beans>
```

该示例显示p命名空间中的email属性在 bean 定义中的调用。这告诉 Spring 包含一个属性声明。如前所述，p命名空间没有 schema/架构 定义，因此您可以将属性的名称设置为 property的名称。

下一个示例包括另外两个bean定义，它们都引用了另一个相同的bean：

``` xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean name="john-classic" class="com.example.Person">
        <property name="name" value="John Doe"/>
        <property name="spouse" ref="jane"/>
    </bean>

    <bean name="john-modern"
        class="com.example.Person"
        p:name="John Doe"
        p:spouse-ref="jane"/>

    <bean name="jane" class="com.example.Person">
        <property name="name" value="Jane Doe"/>
    </bean>
</beans>
```

此示例不仅包含使用p命名空间的属性值，还使用特殊格式来声明属性引用。第一个bean定义用于 `<property name="spouse" ref="jane"/>` 创建从bean `john` 对bean `jane` 的引用 ，而第二个bean定义`p:spouse-ref="jane"` 用作属性来执行完全相同的操作。在这种情况下，`spouse`是属性名称，而该**`-ref`**部分表示这不是直接值，而是对另一个bean的引用。

> p命名空间不如标准XML格式灵活。例如，声明属性引用的格式与最终的属性冲突Ref，而标准XML格式则不然。我们建议您仔细选择您的方法并将其传达给您的团队成员，以避免生成同时使用三种定义方法的XML文档。

#### 带有c命名空间的XML快捷方式
与带有p-namespace的XML 快捷方式类似，Spring 3.1中引入的 c命名空间允许使用**内联属性来配置构造函数参数**，而不是嵌套`constructor-arg`元素。

以下示例使用`c:`命名空间执行与 **基于构造函数的依赖注入** 相同的操作：

``` xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:c="http://www.springframework.org/schema/c"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="beanTwo" class="x.y.ThingTwo"/>
    <bean id="beanThree" class="x.y.ThingThree"/>

    <!-- traditional declaration with optional argument names -->
    <!--传统使用可选参数名称方式的声明-->
    <bean id="beanOne" class="x.y.ThingOne">
        <constructor-arg name="thingTwo" ref="beanTwo"/>
        <constructor-arg name="thingThree" ref="beanThree"/>
        <constructor-arg name="email" value="something@somewhere.com"/>
    </bean>

    <!-- c-namespace declaration with argument names -->
     <!--使用可选参数名称声明的c命名空间-—>
    <bean id="beanOne" class="x.y.ThingOne" c:thingTwo-ref="beanTwo"
        c:thingThree-ref="beanThree" c:email="something@somewhere.com"/>

</beans>
```

`c:` 命名空间使用相同的约定作为 `p:` 一个（尾部 `-ref` 的bean引用），供他们的名字设置构造函数的参数。类似地，它需要在 XML 文件中声明，即使它没有在XSD模式中定义（`它存在于Spring核心内部`）。

对于构造函数参数名称不可用的罕见情况（通常在没有调试信息的情况下编译字节码），您可以使用回退到参数索引，如下所示：

``` xml
<!-- c-namespace index declaration -->
<bean id="beanOne" class="x.y.ThingOne" c:_0-ref="beanTwo" c:_1-ref="beanThree"
    c:_2="something@somewhere.com"/>
```

> 由于XML语法，索引表示法要求存在前导_，因为XML属性名称不能以数字开头（即使某些IDE允许）。对于<constructor-arg>元素也可以使用相应的索引符号，但不常用，因为通常的声明顺序通常就足够了。

实际上，`构造函数解析机制` 在匹配参数方面非常有效，因此除非确实需要，否则我们建议在整个配置中使用 `名称表示法`。

#### 复合属性名称
设置 bean 属性时，可以使用复合或嵌套属性名称，只要除最终属性名称之外的路径的所有组件都不是null。考虑以下bean定义：

``` xml
<bean id="something" class="things.ThingOne">
    <property name="fred.bob.sammy" value="123" />
</bean>
```

`somethingbean` 具有一个 `fred` 属性，该属性还具有属性bob，bob属性具有sammy 属性，并且最终sammy属性的值设置为123。为了使其生效，在构造bean之后，`something` 的fred属性和bob属性不能为null。否则，将抛出一个 `NullPointerException`。

### 1.4.3 使用depends-on
如果bean是另一个bean的依赖项，那通常意味着将一个bean设置为另一个bean的属性。通常，您可以使用基于XML的配置元数据中的 `<ref/>` 元素来完成此操作。但是，有时bean之间的依赖关系不那么直接。例如，需要触发类中的静态初始化程序，例如数据库驱动程序注册。`depends-on` 能在初始化使用此元素bean之前，显式地强制初始化一个或多个bean。以下示例使用 `depends-on` 属性表示对单个bean的依赖关系：

``` xml
<bean id="beanOne" class="ExampleBean" depends-on="manager"/>
<bean id="manager" class="ManagerBean" />
```

要表示对多个bean的依赖关系，请提供bean名称列表作为 `depends-on` 属性的值（逗号，空格和分号都是有效的分隔符）：

``` xml
<bean id="beanOne" class="ExampleBean" depends-on="manager,accountDao">
    <property name="manager" ref="manager" />
</bean>

<bean id="manager" class="ManagerBean" />
<bean id="accountDao" class="x.y.jdbc.JdbcAccountDao" />
```

> `depends-on`属性既可以指定初始化时依赖，也可以指定单独的 bean，相应依赖的销毁时间。`depends-on` 在给定的 bean 本身被销毁之前，优先销毁依赖的bean。这样，depends-on也可以控制关​关闭的顺序。

1.4.4 惰性初始化 Beans
默认情况下，作为初始化过程的一部分，`ApplicationContext` 实现会急切地创建和配置所有单例 bean。通常，这种预先实例化是可取的，因为配置或周围环境中的错误可以立即发现，而不是几小时甚至几天后。当不希望出现这种情况时，可以通过将bean定义标记为延迟初始化来阻止单例bean的预实例化。**延迟初始化**的bean告诉IoC容器在**第一次请求时创建bean实例，而不是在启动时**。

在XML中，此行为由 元素`lazy-init` 上的属性控制`<bean/>`，如以下示例所示：

``` xml
<bean id="lazy" class="com.something.ExpensiveToCreateBean" lazy-init="true"/>
<bean name="not.lazy" class="com.something.AnotherBean"/>
```

当前面的配置被`ApplicationContext`读取到时，`lazy` bean在`ApplicationContext`启动时不会急切地预先实例化，而`not.lazy` bean被急切地预先实例化。

但是，当延迟初始化的bean是未进行延迟初始化的单例bean的依赖项时，`ApplicationContext`会在启动时创建延迟初始化的bean，因为它必须满足单例的依赖关系。惰性初始化的bean被注入到其他地方的单独的bean中，而这个bean并不是惰性初始化的。(备注:其他 bean 依赖延迟初始化的 bean时，相当于需要调用创建它)

您还可以通过使用在 `<beans/>`元素上的 `default-lazy-init`的属性来控制容器延迟初始化的级别， <beans/>以下示例显示：

``` xml
<beans default-lazy-init="true">
    <!-- no beans will be pre-instantiated…不会被预先实例化 -->
</beans>
```

### 1.4.5 Autowiring/自动装配 协作者
Spring容器可以自动连接协作bean之间的关系。您可以让Spring通过检查 `ApplicationContext` 中bean的内容自动为您的bean解析协作者（其他bean）。自动装配具有以下优点：

* 自动装配可以明显减少指定属性或构造函数参数的需要。（在本章其他地方讨论的其他机制，如bean模板 ，在这方面也很有价值。）

* 自动装配可以随着对象的发展更新配置。例如，如果需要向类添加依赖项，则可以自动满足该依赖项，而无需修改配置。因此，自动装配在开发期间尤其有用，而不会在代码库变得更稳定时切换到显式装配选项带来的负面影响。

使用基于XML的配置元数据（请参阅依赖注入）时，可以使用元素的autowire属性为 bean定义指定`autowire` 模式` <bean/>`。自动装配功能有四种模式。您指定每个bean的自动装配，因此可以选择要自动装配的那些。下表描述了四种自动装配模式：

#### 表2.自动装配模式

|模式|说明|
|:---:|:---:|
no|（默认）无自动装配。Bean引用必须由ref元素定义。不建议对较大的部署更改默认设置，因为明确指定协作者可以提供更好的控制和清晰度。在某种程度上，它记录了系统的结构。
byName|按属性名称自动装配。Spring查找与需要自动装配的属性同名的bean。例如，如果bean定义按名称设置为autowire并且它包含一个master属性（即，它有一个 setMaster(..)方法），则Spring会查找名为bean的定义master并使用它来设置属性。
byType|如果容器中只存在一个属性类型的bean，则允许属性自动装配。如果存在多个，则抛出致命异常，这表示您可能不会byType对该bean 使用自动装配。如果没有匹配的bean，则不会发生任何事情（该属性未设置）。
constructor|类似byType但适用于构造函数参数。如果容器中没有构造函数参数类型的一个bean，则会引发致命错误。

使用`byType` 或`constructor`自动装配模式，您可以连接 arrays 和指定类型的 集合。在这种情况下，提供容器内与预期类型匹配的所有autowire候选者以满足依赖性。Map如果预期的键类型是`String`，则可以自动装配强类型实例。自动装配 Map 实例的值由与预期类型匹配的所有bean实例组成，` Map`实例的键包含相应的bean名称。

#### 自动装配的局限和缺点
当在整个项目中一致地使用自动装配时，自动装配效果最佳。如果一般不使用自动装配，那么开发人员使用它来连接一个或两个bean定义可能会让人感到困惑。

考虑自动装配的局限和缺点：

* 显式依赖项`property`和`constructor-arg`设置始终覆盖自动装配。不能自动装配简单属性，例如原始类型 String，和Classes（以及此类简单属性的数组）。这种限制是设计本身产生的。

* 自动装配不如显式装配**精确**。虽然，如前面的表中所述，Spring 谨慎地避免在可能产生意外结果的模糊性的情况下进行猜测。您不再明确记录 Spring 管理对象之间的关系。

* 可能无法为可能从 Spring 容器生成文档的工具提供装配信息。

* 容器中的多个bean定义可以匹配`setter` 方法或构造函数参数指定的类型以进行自动装配。对于数组，集合或 Map实例，这不一定是个问题。但是，对于期望单个值的依赖关系，这种模糊性不是可以武断解决的。如果没有可用的唯一bean定义，则抛出异常。

在后一种情况下，您有几种选择：

* 放弃自动装配，支持显式装配。

* 通过将其 `autowire-candidate` 属性设置为false，可以避免对bean定义进行自动装配，如下一节所述。

* 通过将<bean/>元素的`primary`属性设置为 true，将单个bean定义指定为主要候选者。

* 实现基于注解的配置可用的更细粒度的控件，如基于注解的容器配置中所述。

#### 从自动装配中排除Bean
在每个bean的基础上，您可以从自动装配中排除bean。在Spring的XML格式中，将<bean/>元素的 `autowire-candidate` 属性设置为false。容器使特定的 bean 定义对自动装配基础结构不可用（包括注解样式配置等 `@Autowired`）。

> `autowire-candidate` 属性旨在仅影响基于类型的自动装配。它不会影响基于名称的显式引用，即使指定的bean未标记为`autowire` 候选，也会解析它。因此**，如果名称匹配，则按名称自动装配会注入bean**。

您还可以根据与bean名称匹配模式来限制 `autowire` 候选者。顶级 `<beans/>` 元素在其 `default-autowire-candidates` 属性中接受一个或多个模式 。例如，要将autowire候选状态限制为名称以`Repository` 结尾的任何bean ，请提供值*Repository。要提供多个模式，请在逗号分隔的列表中定义它们。bean定义的属性的显式值` true` 或 `false` 的优先级优先。对于此类bean，模式匹配规则不适用。

这些技术是针对您永远不希望通过 自动装配注入其他bean的 bean非常有用。这并不意味着排除的bean本身不能使用自动装配进行配置。相反，bean本身不是自动装配其他bean的候选者。

### 1.4.6 方法注入
在大多数应用程序场景中，容器中的大多数bean都是 单例。当单例bean需要与另一个单例bean协作或非单例bean需要与另一个非单例bean协作时，通常通过将一个bean定义为另一个bean的属性来处理依赖关系。当bean生命周期不同步会出现问题。假设单例bean A需要使用 非单例（原型）bean B，可能是在A上的每个方法上调用。容器只创建一次单例bean A，因此只有一次机会来设置属性。每次需要 bean B时，容器都不能为bean A提供bean B的新实例。

解决方案是放弃一些控制反转。你可以通过实现 `ApplicationContextAware` 接口使容器识别出 bean A，并在每次bean A需要 bean B 实例时通过创建一个` getBean("B")` 调用，请求容器给定一个（典型的新）bean B实例。以下示例显示了此方法：

``` java
// a class that uses a stateful Command-style class to perform some processing
package fiona.apple;

// Spring-API imports
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CommandManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Object process(Map commandState) {
        // grab a new instance of the appropriate Command
        // 通过合适的Command获取一个新的实例
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    protected Command createCommand() {
        // notice the Spring API dependency!
        return this.applicationContext.getBean("command", Command.class);
    }

    public void setApplicationContext(
            ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
```

前面的方式不可取，因为业务代码意识并耦合到Spring Framework。方法注入是Spring IoC容器的一个高级功能，可以让您干净地处理这个用例。

> 您可以在[此博客条目中](https://spring.io/blog/2004/08/06/method-injection/)阅读有关方法注入动机的更多信息 。

#### 查找方法注入
Lookup方法注入 是容器覆盖 容器管理bean上的方法 并返回容器中 另一个命名bean的查找结果的能力。查找通常涉及prototype/原型bean，如上一节中描述的场景。Spring Framework通过**使用CGLIB库中的字节码**来动态生成覆盖该方法的子类来实现此方法注入。

<font color="red" size=4>什么是 CGLIB库中的字节码？ </font>

> * 要使这个动态子类生效，Spring bean容器子类不能是 `final`，以及要重写的方法也不能 `final`。

> * 对具有 `abstract`方法的类进行单元测试需要您自己对类进行子类化并提供该`abstract`方法的 stub/存根 实现。

> * 组件扫描也需要具体的方法，这需要具体的类来获取。

> * 另一个关键限制是查找方法`不适用于工厂方法`，特别是 `@Bean` 配置类中的方法，因为在这种情况下，容器不负责创建实例，因此无法创建运行时生成的子类

对于 `CommandManager` 前面代码片段中的类，Spring容器动态地覆盖 `createCommand()` 方法的实现。`CommandManager` 没有任何Spring的依赖，就想下面实例所示：

``` xml
package fiona.apple;

// no more Spring imports!

public abstract class CommandManager {

    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    // okay... but where is the implementation of this method?
    protected abstract Command createCommand();
}
```

在包含要注入的方法的客户端类中（在本例中的 `CommandManager`），要注入的方法需要以下形式的签名：

	<public|protected> [abstract] <return-type> theMethodName(no-arguments);
	
如果方法是 `abstract`，则动态生成的子类实现该方法。否则，动态生成的子类将覆盖原始类中定义的具体方法。请思考以下示例：

``` xml
<!-- a stateful bean deployed as a prototype (non-singleton) -->
<bean id="myCommand" class="fiona.apple.AsyncCommand" scope="prototype">
    <!-- inject dependencies here as required：在这里注入要求的依赖 -->
</bean>

<!-- commandProcessor uses statefulCommandHelper -->
<bean id="commandManager" class="fiona.apple.CommandManager">
    <lookup-method name="createCommand" bean="myCommand"/>
</bean>
```

无论何时，标识为`commandManager`的bean 需要bean的新实例时，会调用自己的`createCommand()`方法创建一个 `myCommand` bean。如果真的需要`myCommand`，您必须小心将 ` myCommand` 部署为原型。如果它是单例，`myCommand` 则每次返回相同的 bean 实例。

或者，在基于注解的组件模型中，您可以通过 `@Lookup` 注解声明查找方法，如以下示例所示：

``` java
public abstract class CommandManager {

    public Object process(Object commandState) {
        Command command = createCommand();
        command.setState(commandState);
        return command.execute();
    }

    @Lookup("myCommand")
    protected abstract Command createCommand();
}
```

或者，更具惯用性，您可以依赖于针对查找方法的声明返回类型解析目标bean：

``` java
public abstract class CommandManager {

    public Object process(Object commandState) {
        MyCommand command = createCommand();
        command.setState(commandState);
        return command.execute();
    }

    @Lookup
    protected abstract MyCommand createCommand();
}
```

请注意，您通常应该使用具体的 stub/存根 实现来声明这种带注解的查找方法，以使它们与Spring的组件扫描规则兼容，其中默认情况下抽象类被忽略。此限制不适用于显式注册或显式导入的bean类。

> 访问不同范围的目标bean的另一种方法是 `ObjectFactory/ Provider` 注入点。请参阅Scoped Beans作为依赖关系。

> 您可能还会发现 `ServiceLocatorFactoryBean`（在 `org.springframework.beans.factory.config` 包中）有用。

#### 任意方法替换
与查找方法注入相比，一种不太有用的方法注入形式是能够使用另一个方法实现替换托管bean中的任意方法。您可以放心地跳过本节的其余部分，直到您确实需要此功能。

使用基于XML的配置元数据，您可以使用该 `replaced-method` 元素将已存在的方法实现替换为已部署的bean。考虑以下类，它有一个我们想要覆盖的 `computeValue` 方法：

``` java
public class MyValueCalculator {

    public String computeValue(String input) {
        // some real code...
    }

    // some other methods...
}
```

实现 `org.springframework.beans.factory.support.MethodReplacer` 接口的类提供新的方法定义，如以下示例所示：

``` java
/**
 * meant to be used to override the existing computeValue(String)
 * implementation in MyValueCalculator
 */
public class ReplacementComputeValue implements MethodReplacer {

    public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
        // get the input value, work with it, and return a computed result
        String input = (String) args[0];
        ...
        return ...;
    }
}
```

部署原始类并指定方法覆盖的bean定义类似于以下示例：

``` xml
<bean id="myValueCalculator" class="x.y.z.MyValueCalculator">
    <!-- arbitrary method replacement -->
    <replaced-method name="computeValue" replacer="replacementComputeValue">
        <arg-type>String</arg-type>
    </replaced-method>
</bean>

<bean id="replacementComputeValue" class="a.b.c.ReplacementComputeValue"/>
```

您可以使用`<replaced-method/>` 元素内部的一个或多个 `<arg-type/>` 元素来指示被覆盖方法的签名。仅当方法重载且类中存在多个变体时，才需要参数的签名。为方便起见，参数的类型字符串可以是完全限定类型名称的 子字符串(一部分) 。例如，以下所有的都能匹配 `java.lang.String`：

```
java.lang.String
String
Str
```

因为参数的数量通常足以区分每个可能的选择，所以通过只键入与参数类型匹配的最短字符串，此快捷方式可以节省大量输入。

## 1.5 Bean范围
创建bean定义时，可以由该bean定义的类创建实际实例类来创建配方。**bean定义是一个配方的想法很重要**，因为它意味着，与一个类一样，您可以从一个配方创建许多对象实例。

您不仅可以控制要插入到 特定bean定义创建的对象中的 **各种依赖项和配置值**，还可以控制从特定bean定义创建的对象的**范围**。这种方法功能强大且灵活，因为您可以选择通过配置创建的对象的范围，而不必在Java类级别斟酌对象的范围。可以将Bean定义部署在多个范围之一。Spring Framework 支持六个范围，其中四个范围仅在您使用 Web感知的` ApplicationContext` 时可用。您还可以创建自定义范围。

下表描述了支持的范围：

#### 表3. Bean范围

范围 | 描述
|:--:|:--:|
singleton/单例|（默认）将单个bean定义范围限定为每个**Spring IoC 容器的单个对象实例**。
prototype/原型| 将单个bean定义范围限定为**任意数量**的对象实例。
request/请求|将单个bean定义范围限定为单个HTTP请求的生命周期。也就是说，每个HTTP请求都有自己的bean实例，它是在单个bean定义的后面创建的。仅在具有Web感知功能的`ApplicationContext` Spring环境中有效
session/会话|将单个bean定义范围限定为HTTP的生命周期 `Session`。仅在具有Web感知功能的 `ApplicationContext` Spring环境中有效。
application/应用|将单个bean定义范围限定为 `ServletContext`的生命周期。仅在具有Web感知功能的 `ApplicationContext` Spring环境中有效。
WebSocket|将单个bean定义范围限定为 `WebSocket` 的生命周期。仅在具有Web感知功能的 `ApplicationContext` Spring环境中有效。

> 从Spring 3.0开始，线程范围可用了(新增的范围)，但默认情况下未注册。有关更多信息，请参阅文档` SimpleThreadScope`。有关如何注册此范围或任何其他自定义范围的说明，请参阅 使用自定义范围。

### 1.5.1 singleton/单例范围
只管理单个 bean 的一个共享实例，并且对具有与该bean定义的ID或匹配bean定义的ID所有请求都会使得Spring容器返回一个特定的bean实例。

换句话说，当您定义bean定义并将其作为单一作用域时，Spring IoC容器只创建该bean定义的对象的一个​​实例。此单个实例存储在此类单例bean的缓存中，并且该名为Bean的所有后续请求和引用都将返回**缓存对象**。下图显示了单例范围的工作原理：

<font color="red">图 1.5.1单例范围</font>

Spring的单例bean概念不同于Gang of Four（GoF）模式书中定义的单例模式。GoF单例对一个对象的范围进行硬编码，使得每个ClassLoader创建一个且只有一个特定类的实例。Spring单例的范围最好描述为每个容器和每个bean。这意味着，如果在单个Spring容器中为特定类定义一个bean，则Spring容器将创建该bean定义所定义的类的一个且仅只有一个实例。单例范围是Spring中的默认范围。要将bean定义为XML中的单例，您可以定义一个bean，如以下示例所示：

``` xml
<bean id="accountService" class="com.something.DefaultAccountService"/>

<!-- the following is equivalent, though redundant (singleton scope is the default) -->
<bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/>
```

### 1.5.2 prototype/原型范围
bean部署的非单例原型范围导致每次发出对该特定bean的请求时都 **创建新的bean实例**。也就是说，bean被注入另一个bean，或者通过`getBean()`对容器的方法调用来请求它。通常，您应该对所有有状态的bean使用原型范围，对无状态bean使用单例范围。

下图说明了Spring原型范围：

<font color="red">图 1.5.2</font>

>（数据访问对象（DAO）通常不配置为原型，因为典型的DAO不会保持任何会话状态。我们更容易重用单例范围。

以下示例将bean定义为XML中的原型：

``` xml
<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/>
```

与其他范围相比，Spring不管理原型bean的完整生命周期。容器实例化，配置和组装原型对象并将其交给客户端，而没有该原型实例的进一步记录。因此，尽管无论范围如何都**在所有对象上调用初始化生命周期回调方法**，但在原型的情况下，不会调用已配置的销毁生命周期回调。客户端代码必须清理原型范围的对象并释放原型bean所拥有的昂贵资源。要使Spring容器释放原型范围的bean所拥有的资源，请尝试使用 `bean post-processor`/自定义bean后处理器，它包含对需要清理的bean的引用。

在某些方面，Spring容器关于原型范围bean的角色是Java `new` 运算符的替代品。超过该点的所有生命周期管理必须由客户端处理。（有关Spring容器中bean的生命周期的详细信息，请参阅Lifecycle Callbacks。）

### 1.5.3 具有原型bean依赖关系的单例Bean
当您使用具有依赖于原型bean的单例作用域bean时，请注意在实例化时解析依赖项。因此，如果依赖项将原型范围的bean注入到单例范围的bean中，则会实例化一个新的原型bean，然后通过依赖注入到单例bean中。原型实例是唯一提供给单例范围bean的实例。

但是，假设您希望单例范围的bean在运行时重复获取原型范围的bean的新实例。您不能将原型范围的bean依赖注入到您的单例bean中，因为当**Spring容器实例化单例bean并解析并注入其依赖项时，该注入只发生一次【尽管依赖了原形bean】**。如果您需要在运行时多次使用原型bean的新实例，请参阅`方法注入`

### 1.5.4 request/请求，session/会话，application/应用程序和WebSocket范围
在`request`，`session`，`application`，`websocket`范围只有当你使用一个web感知的Spring `ApplicationContext` 才可以实现（例如 `XmlWebApplicationContext` ）。如果将这些范围与常规的Spring IoC容器一起使用，例如`ClassPathXmlApplicationContext`，`IllegalStateException`则会引发抛出未知Bean范围的问题。

#### 初始化Web配置
为了支持bean的范围界定在`request`，`session`，`application`，`websocket`（即具有web作用域bean），需要在定义bean之前做少量的初始配置。（**标准范围不需要此初始设置：singleton和prototype。）**

如何完成此初始设置取决于您的特定Servlet环境。

如果您在Spring Web MVC中访问scoped bean，实际上是在Spring处理的请求中，则 `DispatcherServlet` 无需进行特殊设置。` DispatcherServlet`已暴露所有相关的状态。

如果您使用Servlet 2.5 Web容器，并且在Spring之外处理请求 `DispatcherServlet`（例如，使用JSF或Struts时），则需要注册 `org.springframework.web.context.request.RequestContextListener` `ServletRequestListener`。对于Servlet 3.0+，可以使用 `WebApplicationInitializer` 接口以编程方式完成。或者，或者对于旧容器，将以下声明添加到Web应用程序的 `web.xml` 文件中：

``` xml
<web-app>
    ...
    <listener>
        <listener-class>
            org.springframework.web.context.request.RequestContextListener
        </listener-class>
    </listener>
    ...
</web-app>
```

或者，如果您的Listener/侦听器设置存在问题，请考虑使用Spring `RequestContextFilter`。filter/过滤器映射取决于周围的Web应用程序配置，因此您必须根据需要进行更改。以下清单显示了Web应用程序的过滤器部分：

``` xml
<web-app>
    ...
    <filter>
        <filter-name>requestContextFilter</filter-name>
        <filter-class>org.springframework.web.filter.RequestContextFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>requestContextFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ...
</web-app>
```

`DispatcherServlet`，`RequestContextListener`和`RequestContextFilter`所有做同样的事情，即将HTTP请求对象绑定到`Thread`为该请求提供服务的对象。这使得请求和会话范围的bean可以在**调用链**中进一步使用。

#### request/请求范围
考虑bean定义以下的XML配置：

``` xml
<bean id="loginAction" class="com.something.LoginAction" scope="request"/>
```

Spring容器通过`loginAction`使用每个HTTP请求bean定义来创建`LoginAction` bean 的新实例。也就是说， `loginAction` bean的范围是HTTP请求级别。您可以根据需要更改创建的实例的内部状态，因为从同一`loginAction` bean定义创建的其他实例在状态中看不到这些更改。它们是独立地针对个别的请求。当请求完成处理时，将放弃作用于请求的bean。

使用 注解驱动的组件 或Java配置时，`@RequestScope`注解 可用于在request范围 分配组件。以下示例显示了如何执行此操作：

``` java
@RequestScope
@Component
public class LoginAction {
    // ...
}
```

#### session/会话范围
考虑bean定义的以下XML配置：

``` xml
<bean id="userPreferences" class="com.something.UserPreferences" scope="session"/>
```

Spring容器`UserPreferences`通过在单个HTTP的`Session`生存期内使用 `userPreferences` bean定义来创建bean 的新实例。换句话说，`userPreferences` bean在HTTP `Session`级别上有效地作用域。与`request` 范围的bean一样，您可以根据需要更改创建的实例的内部状态，因为`Session`同样使用从同一`userPreferences` bean定义创建的实例在其他的 HTTP 实例在状态中看不到这些更改，因为它们特定作用于单个HTTP `Session`。当`Session`最终丢弃时，这个指定特定 HTTP `Session`的bean也将失效 。

使用注解驱动的组件或Java配置时，可以使用 `@SessionScope` 注解将组件分配为`session`范围。

``` java
@SessionScope
@Component
public class UserPreferences {
    // ...
}
```

#### application/应用范围
考虑bean定义的以下XML配置：

``` xml
<bean id="appPreferences" class="com.something.AppPreferences" scope="application"/>
```

Spring容器通过使用一次 `appPreferences` bean 定义对整个Web应用程序来创建`AppPreferences `bean 的新实例。也就是说， `appPreferencesbean` 在该`ServletContext`级别指定了作用域并存储为常规 `ServletContext`属性。这有点类似于Spring单例bean，但在两个重要方面有所不同：它是一个单独的`ServletContext`，不是每个Spring的 `ApplicationContext`（在任何给定的Web应用程序中可能有几个），它实际上是暴露的，因此作为一个`ServletContext`属性是可见的。

使用注解驱动的组件或Java配置时，可以使用 `@ApplicationScope` 注解将组件分配给 `application`范围。以下示例显示了如何执行此操作：

``` java
@ApplicationScope
@Component
public class AppPreferences {
    // ...
}
```

#### 作为依赖性的Scoped Bean
Spring IoC容器不仅管理**对象（bean）的实例化**，还管理**协作者（或依赖关系）的连接**。如果要将（例如）HTTP request/请求范围的bean注入到生命周期较长范围的另一个bean中，您可以选择注入AOP代理来代替范围内的bean。也就是说，您需要注入一个代理对象，该对象公开与范围对象相同的公共接口，但也可以从相关范围（例如HTTP请求）中检索真实目标对象，并将方法调用委托给真实对象。

> 您还可以使用 `<aop:scoped-proxy/>` 在bean之间使用` singleton` 作为作用域，然后通过引用可序列化的中间代理，从而能够在反序列化时重新获取目标单例bean。

> 当声明`<aop:scoped-proxy/>`范围的bean为 `prototype `时，共享代理上的每个方法调用都会导致创建一个新的目标实例，然后转发该调用。

> 此外，范围代理不是以生命周期安全的方式从较短范围访问bean的唯一方法。您还可以将注入点（即构造函数或setter参数或autowired字段）声明为 `ObjectFactory<MyTargetBean>` 允许 `getObject()` 调用，以便在每次需要时按需检索当前实例 - 无需保留实例或单独存储它。

> 作为扩展变体，您可以声明`ObjectProvider<MyTargetBean>`，它提供了几个额外的访问变体，包括`getIfAvailable`和`getIfUnique`。

> 调用`Provider`的JSR-330变体，在每次检索尝试时使用`Provider<MyTargetBean>` 声明和相应`get()`调用。有关JSR-330整体的更多详细信息，请参见此处。

以下示例中的配置只有一行，但了解“为什么”以及它背后的“如何”非常重要：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- an HTTP Session-scoped bean exposed as a proxy -->
    <bean id="userPreferences" class="com.something.UserPreferences" scope="session">
        <!-- instructs the container to proxy the surrounding bean -->
        <aop:scoped-proxy/> 【1】
    </bean>

    <!-- a singleton-scoped bean injected with a proxy to the above bean -->
    <bean id="userService" class="com.something.SimpleUserService">
        <!-- a reference to the proxied userPreferences bean -->
        <property name="userPreferences" ref="userPreferences"/>
    </bean>
</beans>
```

【1】定义代理行。

要创建此类代理，请将子 `<aop:scoped-proxy/>` 元素插入到作用域 bean 定义中（请参阅选择要创建的代理类型和 基于XML架构的配置）。bean定义为什么是`request`，`session`和`自定义范围`作用域的级别要求 `<aop:scoped-proxy/>`元素？考虑以下单例bean定义，并将其与您需要的上述范围定义的内容进行对比（请注意，以下 `userPreferences` bean定义不完整）：

``` xml
<bean id="userPreferences" class="com.something.UserPreferences" scope="session"/>

<bean id="userManager" class="com.something.UserManager">
    <property name="userPreferences" ref="userPreferences"/>
</bean>
```

在上面的示例中，singleton bean（`userManager`）注入了对HTTP `Session-scoped` bean（`userPreferences`）的引用。这里的重点是 `userManager` bean是一个单例：它的每个容器只实例化一次，它的依赖关系（在这种情况下只有一个，`userPreferences` bean）也只注入一次。这意味着`userManager` bean只在完全相同的`userPreferences`对象（即最初注入它的对象）上运行。

当将一个生命周期较短的`scoped bean`注入一个生命周期较长的scoped bean时，这不是你想要的行为（例如，将一个HTTP` Session-scoped` 协作bean作为依赖注入` singleton bean`）。相反，您需要一个`userManager `对象，并且，在HTTP的生命周期中`Session`，您需要一个 `userPreferences` 特定于HTTP 的对象`Session`。因此，容器创建一个对象，该对象公开与 `UserPreferences`该类完全相同的公共接口（理想情况下是一个`UserPreferences`实例的对象），该`UserPreferences`对象可以从作用域机制（HTTP `request`,`Session`,等）中获取真实对象。容器将此代理对象注入到 `userManager` bean中，该bean不知道此 `UserPreferences引用` 是代理。在这个例子中，当一个` UserManager `实例在依赖注入的 `UserPreferences` 对象上调用一个方法，它实际上是在代理上调用一个方法。然后，代理 `UserPreferences`从（在这种情况下）HTTP中 `Session`获取真实的 `UserPreferences`对象，并将方法调用委托给检索到的真实对象。

因此，在将`request-bean` 和`session-scoped `bean 注入协作对象时，您需要以下（正确和完整）配置 ，如以下示例所示：

``` xml
<bean id="userPreferences" class="com.something.UserPreferences" scope="session">
    <aop:scoped-proxy/>
</bean>

<bean id="userManager" class="com.something.UserManager">
    <property name="userPreferences" ref="userPreferences"/>
</bean>
```

#### 选择要创建的代理类型
默认情况下，当Spring容器为使用该 `<aop:scoped-proxy/>` 元素标记的bean创建代理时，将创建基于CGLIB的类代理。

> 【注意！】CGLIB代理只拦截公共方法调用！不要在这样的代理上调用非公共方法。它们不会委托给实际的作用域目标对象。

或者，您可以通过指定元素属性`false`的值，将Spring容器配置为为此类作用域bean创建基于JDK接口的标准代理。使用基于JDK接口的代理意味着您不需要在应用程序类路径中使用其他库来影响此类代理。但是，这也意味着作用域bean的类必须至少实现一个接口，并且注入了作用域bean的所有协作者必须通过其中一个接口引用bean。以下示例显示了基于接口的代理：`proxy-target-class<aop:scoped-proxy/>`

``` xml
<!-- DefaultUserPreferences implements the UserPreferences interface -->
<bean id="userPreferences" class="com.stuff.DefaultUserPreferences" scope="session">
    <aop:scoped-proxy proxy-target-class="false"/>
</bean>

<bean id="userManager" class="com.stuff.UserManager">
    <property name="userPreferences" ref="userPreferences"/>
</bean>
```

有关选择基于类或基于接口的代理的更多详细信息，请参阅代理机制。

### 1.5.5。自定义范围
bean范围机制是可扩展的。您可以定义自己的范围，甚至可以重新定义现有范围，单重新定义被认为是不好的做法，无法覆盖内置 `singleton`和 `prototype` 范围。

#### 创建自定义范围
要将自定义作用域集成到Spring容器中，需要实现 `org.springframework.beans.factory.config.Scope` 本节中描述的 接口。有关如何实现自己的作用域的想法，请参阅`Scope` Spring Framework本身和`Scope` javadoc 提供的实现 ，它们解释了您需要更详细地实现的方法。

`Scope` 接口有四种方法可以从作用域中获取对象，将其从作用域中删除，然后将其销毁。

例如，`session` 范围实现返回`session`范围的bean（如果它不存在，则该方法在将其绑定到会话以供将来引用之后 返回该bean的新实例）。以下方法从基础范围返回对象：

``` java
Object get(String name, ObjectFactory objectFactory)
```

例如，`session` 范围实现从基础会话中删除 `session` 范围的bean。应返回该对象，但如果找不到具有指定名称的对象，则可以返回null。以下方法从基础范围中删除对象：

``` java
Object remove(String name)
```

以下方法记录范围在销毁时或范围中指定对象被销毁时应执行的回调：

``` java
void registerDestructionCallback(String name, Runnable destructionCallback)
```

有关销毁回调的更多信息，请参阅javadoc或Spring作用域实现。

以下方法获取基础范围的对话标识符：

``` java
String getConversationId()
```

每个范围的标识符都不同。对于`session` 范围的实现，该标识符可以是 `session` 标识符。

#### 使用自定义范围
在编写并测试一个或多个自定义 `Scope` 实现之后，需要让Spring容器知道您的新范围。以下方法是使用Spring容器注册新的`Scope` 核心方法：

``` java
void registerScope(String scopeName, Scope scope);
```

此方法在 `ConfigurableBeanFactory` 接口上声明，该接口可通过 Spring 随附的 `BeanFactory` 属性大多数具体 `ApplicationContext`实现的获得。

`registerScope(..)` 方法的第一个参数是与范围关联的唯一名称。Spring容器本身中的这些名称的示例是` singleton` 和 `prototype`。`registerScope(..)` 方法的第二个参数是您希望注册和使用的自定义实现的 `Scope` 实际实例。

假设编写自定义 `Scope` 实现，然后注册它，如下一个示例所示。

下一个示例使用`SimpleThreadScope`，它包含在Spring中，但默认情况下未注册。这个说明与您自己的自定义 `Scope` 实现是相同的。

``` java
Scope threadScope = new SimpleThreadScope();
beanFactory.registerScope("thread", threadScope);
```

然后，您可以创建符合自定义 `Scope` 的作用域规则的bean定义， 如下所示：

``` java
<bean id="..." class="..." scope="thread">
```

使用自定义Scope实现，您不仅限于范围的编程注册。您还可以使用 `CustomScopeConfigurer `类实现Scope声明式注册通过以 ，如下示例所示：

``` java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean class="org.springframework.beans.factory.config.CustomScopeConfigurer">
        <property name="scopes">
            <map>
                <entry key="thread">
                    <bean class="org.springframework.context.support.SimpleThreadScope"/>
                </entry>
            </map>
        </property>
    </bean>

    <bean id="thing2" class="x.y.Thing2" scope="thread">
        <property name="name" value="Rick"/>
        <aop:scoped-proxy/>
    </bean>

    <bean id="thing1" class="x.y.Thing1">
        <property name="thing2" ref="thing2"/>
    </bean>

</beans>
```

在FactoryBean实现中放置`<aop:scoped-proxy/>`时，工厂bean本身是有作用域的，而不是从 `getObject()` 中返回对象。

## 1.6 自定义Bean的本质
Spring Framework 提供了许多可用于自定义bean特性的接口。本节将它们分组如下：

* 生命周期回调

* `ApplicationContextAware` 和 `BeanNameAware`

* 其他`Aware`接口

### 1.6.1 生命周期回调
要与容器的bean生命周期管理进行交互，可以实现Spring `InitializingBean` 和 `DisposableBean` 接口。容器先调用 `afterPropertiesSet()`，后调用 `destroy()` 让bean在初始化和销毁​​bean时执行某些操作。

> JSR-250 `@PostConstruct` 和 `@PreDestroy` 注解通常被认为是在现代Spring应用程序中接收生命周期回调的最佳实践。使用这些注解意味着您的bean不会耦合到特定的 Spring 接口。有关详细信息，请参阅使用 `@PostConstruct` 和 `@PreDestroy` 。

> 如果您不想使用JSR-250注解但仍想删除耦合，请考虑 `init-method` 和 `destroy-method` bean定义元数据。

在内部，Spring Framework 使用 `BeanPostProcessor` 实现来处理它可以找到的任何回调接口并调用适当的方法。如果您需要自定义功能或其他Spring默认不提供的生命周期行为，您可以自己实现 `BeanPostProcessor`。有关更多信息，请参阅 容器扩展点/ Container Extension Points(见 1.8.1. Customizing Beans by Using a BeanPostProcessor)。

除了初始化和销毁​​回调之外，Spring管理的对象还可以实现 `Lifecycle` 接口，以便这些对象可以参与启动和关闭过程，这是由容器自身的生命周期驱动的。

本节描述了生命周期回调接口。

#### 初始化回调
`org.springframework.beans.factory.InitializingBean` 接口允许在容器在bean上设置所有必要属性后，让bean进行初始化工作。`InitializingBean` 接口规定了一个单例方法：

``` java
void afterPropertiesSet() throws Exception;
```

我们建议您不要使用 `InitializingBean` 接口，因为它会不必要地将代码耦合到Spring。或者，我们**建议使用 `@PostConstruct` 注解或指定 `POJO` 初始化方法**。对于基于XML的配置元数据，您可以使用该`init-method` 属性指定具有void无参数签名的方法的名称。使用Java配置，您可以使用`initMethod`的属性` @Bean`。请参阅 接收生命周期回调。请考虑以下示例：

``` xml
<bean id="exampleInitBean" class="examples.ExampleBean" init-method="init"/>
``` 

``` java
public class ExampleBean {

    public void init() {
        // do some initialization work
    }
}
``` 

前面的示例与以下示例几乎完全相同（包含两个列表）：

``` xml
<bean id="exampleInitBean" class="examples.AnotherExampleBean"/>
``` 

``` java
public class AnotherExampleBean implements InitializingBean {

    public void afterPropertiesSet() {
        // do some initialization work
    }
}
``` 

但是，前两个示例中的第一个没有将代码耦合到Spring。

#### 销毁回调
实现 `org.springframework.beans.factory.DisposableBean` 接口允许bean在包含它的容器被销毁时获得回调。 `DisposableBean` 接口规定了一个方法：

``` java
void destroy() throws Exception;
``` 

我们建议您不要使用 `DisposableBean` 回调接口，因为它会不必要地将代码耦合到Spring。或者，我们建议使用`@PreDestroy`注解或指定bean定义支持的泛型方法。使用基于XML的配置元数据，您可以使用该`destroy-method` 的属性 `<bean/>`。使用Java配置，您可以使用 `destroyMethod` 的属性` @Bean`。请参阅 接收生命周期回调。考虑以下定义：

``` xml
<bean id="exampleInitBean" class="examples.ExampleBean" destroy-method="cleanup"/>
``` 
``` java
public class ExampleBean {

    public void cleanup() {
        // do some destruction work (like releasing pooled connections)
    }
}
``` 
前面的定义与以下定义几乎完全相同：

``` xml
<bean id="exampleInitBean" class="examples.AnotherExampleBean"/>
``` 

``` java
public class AnotherExampleBean implements DisposableBean {

    public void destroy() {
        // do some destruction work (like releasing pooled connections)
    }
}
``` 

但是，前面两个定义中的第一个没有将代码耦合到Spring。

> 您可以为 ` <bean>` 元素的 `destroy-method` 属性指定一个特殊 `(inferred)`值，该值指示Spring自动检测特定bean类的公共 `close` 或 `shutdown` 方法。（任何实现 `java.lang.AutoCloseable` 或 `java.io.Closeable` 将会匹配该类。）您还可以在`<beans>`元素的 `default-destroy-method`属性上设置此`(inferred)`特殊值，以将此行为应用于整组bean（请参阅 `默认初始化和销毁​​方法`）。请注意，这是Java配置的默认行为。

#### 默认初始化和销毁​​方法
当你写的初始化和销毁不使用Spring的具体方法回调 `InitializingBean` 和 `DisposableBean` 回调接口，你通常写有名字，如方法 `init()`，`initialize()`，`dispose()` 等等。理想情况下，此类生命周期回调方法的名称在项目中是标准化的，以便所有开发人员使用相同的方法名称并确保一致性。

您可以将Spring容器配置为 “查找” 每个bean上的命名过的初始化和销毁回调方法名称。这意味着，作为应用程序开发人员，您可以编写应用程序类并使用调用的初始化回调 `init()`，而无需为 每个bean定义配置属性 `init-method="init"`【每个bean如果都配置的话，有点繁琐】。Spring IoC容器在创建bean时调用该方法（并且符合前面描述的标准生命周期回调协定）。此功能还强制执行 初始化和销毁​​方法回调的一致命名约定。

假设您的初始化回调方法已命名为 `init()`，销毁回调方法已命名为 `destroy()`。然后，您的类类似于以下示例中的类：

``` java
public class DefaultBlogService implements BlogService {

    private BlogDao blogDao;

    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    // this is (unsurprisingly) the initialization callback method
    public void init() {
        if (this.blogDao == null) {
            throw new IllegalStateException("The [blogDao] property must be set.");
        }
    }
}
``` 

然后，您可以在类似于以下 bean中使用该类：

``` xml
<beans default-init-method="init">

    <bean id="blogService" class="com.something.DefaultBlogService">
        <property name="blogDao" ref="blogDao" />
    </bean>

</beans>
``` 

顶级`<beans/>`元素 `default-init-method `属性上会引导 Spring IoC容器将 bean类上名为 `init`的方法识别为初始化方法回调。当bean被创建和组装时，如果bean类具有这样的方法，则在适当的时候调用它。

您可以通过使用顶级`<beans/>`元素上的 `default-destroy-method` 属性来类似地配置destroy方法回调（在XML中） 。

如果现有的bean类已经具有与约定一致的回调方法，则可以通过使用 自身的 `init-method` 和 `destroy-method` 属性指定（在XML中，即方法名称）来覆盖默认值<bean/>。

Spring容器保证在为bean提供所有依赖项后 立即调用 已配置的初始化回调。因此，在原始bean引用上调用初始化回调，这意味着AOP拦截器等尚未应用于bean。首先完全创建目标bean，然后应用带有拦截器链的AOP代理（例如）。如果目标bean和代理是分开定义的，那么您的代码甚至可以绕过代理与原始目标bean进行交互。因此，将拦截器应用于 `init` 方法是不合逻辑的，因为这样做会将目标bean的生命周期耦合到其代理或拦截器，并在代码直接与原始目标bean交互时留下奇怪的语义。

#### 结合生命周期机制
从Spring 2.5开始，您有三个控制bean生命周期行为的选项：

* 在`InitializingBean`和 `DisposableBean`回调接口

* 定制`init() `和 `destroy()` 方法

* 在 `@PostConstruct` 和 `@PreDestroy` 注解。您可以组合这些机制来控制给定的bean。

> 如果为bean配置了多个生命周期机制，并且每个机制都配置了不同的方法名称，则每个配置的方法都按照此注解列出的顺序执行。但是，如果为多个相同的方法名称 配置了多个生命周期机制（例如， 对于`init()`初始化方法），则该方法将执行一次，如上 一节中所述。

为同一个bean配置的多个生命周期机制具有不同的初始化方法，如下所示：

* 用注解 `@PostConstruct` 注解方法

* 由`InitializingBean`回调接口定义 `afterPropertiesSet()`

* 自定义配置的 `init()` 方法

Destroy方法以相同的顺序调用：

* 用注解 `@PreDestroy` 注解方法

* 由`DisposableBean`回调接口定义 `destroy()`

* 自定义配置的 `destroy()` 方法

#### 启动和关闭回调
`Lifecycle` 接口为任何具有自己的生命周期要求的对象（例如启动和停止某些后台进程）定义了基本方法：

``` java
public interface Lifecycle {

    void start();

    void stop();

    boolean isRunning();
}
``` 

任何Spring管理的对象都可以实现`Lifecycle`接口。然后，当` ApplicationContext`自己接收到启动和停止信号时（例如，对于运行时的停止/重启场景），它将这些调用级联到`Lifecycle` 该上下文中定义的所有实现。它通过委托给 `LifecycleProcessor` 来实现，如下面的清单所示：

``` java
public interface LifecycleProcessor extends Lifecycle {

    void onRefresh();

    void onClose();
}
``` 

请注意，`LifecycleProcessor`它本身扩展自 `Lifecycle` 接口。它还添加了另外两种方法来响应刷新和关闭的上下文。

> 请注意，常规 `org.springframework.context.Lifecycle` 接口是显式启动和停止通知的简单约定，并不意味着在上下文刷新时自动启动。要对特定bean的自动启动（包括启动阶段）进行细粒度控制，请考虑实现 `org.springframework.context.SmartLifecycle`。

> 此外，请注意，在销毁之前不保证停止通知。在常规关闭时，所有`Lifecycle` bean 一般在传播销毁回调之前首先收到停止通知。但是，在上下文生命周期中的热刷新或中止刷新尝试时，仅调用destroy方法。

启动和关闭调用的顺序非常重要。如果任何两个对象之间存在“依赖”关系，则依赖方在其依赖之后开始，并且在其依赖之前停止。但是，有时，直接依赖性是未知的。您可能只知道某种类型的对象应该在另一种类型的对象之前开始。在这些情况下，`SmartLifecycle` 接口定义了另一个选项，即 `getPhase()` 在其超级接口上定义的方法 `Phased`。以下清单显示了`Phased` 接口的定义：

``` java
public interface Phased {

    int getPhase();
}
``` 

以下清单显示了 `SmartLifecycle` 接口的定义：

``` java
public interface SmartLifecycle extends Lifecycle, Phased {

    boolean isAutoStartup();

    void stop(Runnable callback);
}
```

启动时，具有最小 Phase 的对象首先开始。停止时，遵循相反的顺序。因此，实现`SmartLifecycle` `getPhase()`返回其方法的对象 `Integer.MIN_VALUE` 将是第一个开始和最后一个停止的对象。在范围的另一端，Phase值 `Integer.MAX_VALUE`将指示对象应该最后启动并首先停止（可能因为它依赖于正在运行的其他进程）。当考虑Phase值，同样重要的是要知道，对于任何“正常”的默认阶段 `Lifecycle`对象没有实现`SmartLifecycle`接口的阶段值为 0。因此，任何负阶段值都表示对象应该在这些标准组件之前启动（并在它们之后停止）。任何正阶段值都是相反的。

由`SmartLifecycle`定义的stop方法接受回调。任何实现在该实现的关闭过程完成后必须调用回调方法 `run()` 。这样就可以在必要时启用异步关闭，因为` LifecycleProcessor `接口 的默认实现`DefaultLifecycleProcessor` 等待每个阶段内的对象组的超时值来调用该回调。默认的每阶段超时为30秒。您可以通过定义` lifecycleProcessor `在上下文中命名的bean来覆盖缺省生命周期处理器实例 。如果您只想修改超时，则定义以下内容就足够了：

``` xml
<bean id="lifecycleProcessor" class="org.springframework.context.support.DefaultLifecycleProcessor">
    <!-- timeout value in milliseconds -->
    <property name="timeoutPerShutdownPhase" value="10000"/>
</bean>
``` 

如前所述，`LifecycleProcessor` 接口还定义了用于刷新和关闭上下文的回调方法。后者驱动关闭过程就好像 `stop()` 已经显式调用一样，但它在上下文关闭时发生。另一方面，refresh回调启用了`SmartLifecyclebean` 的另一个功能 。刷新上下文时（在实例化并初始化所有对象之后），将调用该回调。此时，默认生命周期处理器检查每个 `SmartLifecycle` 对象的 `isAutoStartup()` 方法返回的布尔值 。如果true，那个对象是在那个点开始的，而不是等待显式调用上下文或它自己的对象`start()`方法（与上下文刷新不同，上下文启动不会自动发生在标准上下文实现中）。`phase`值与任何“依赖式”的关系确定为前面所述的启动顺序。

#### 在非Web应用程序中优雅地关闭Spring IoC容器
> 本节仅适用于非Web应用程序。Spring的基于Web的 `ApplicationContext` 实现已经具有代码，可以在相关Web应用程序关闭时正常关闭Spring IoC容器。

如果在非Web应用程序环境中使用Spring的IoC容器（例如，在富客户机桌面环境中），请使用JVM注册关闭hook/钩子。这样做可确保正常关闭并在单例bean上调用相关的destroy方法，以便释放所有资源。您仍然必须正确配置和实现这些destroy回调。

要注册关闭挂钩，请调用 `ConfigurableApplicationContext` 接口上声明的方法  `registerShutdownHook()` ，如以下示例所示：

``` java
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Boot {

    public static void main(final String[] args) throws Exception {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // add a shutdown hook for the above context...
        ctx.registerShutdownHook();

        // app runs here...

        // main method exits, hook is called prior to the app shutting down...
    }
}
``` 

### 1.6.2 `ApplicationContextAware`和 `BeanNameAware`
当 `ApplicationContext` 创建实现 `org.springframework.context.ApplicationContextAware` 接口的对象实例时，将为该实例提供对 `ApplicationContext` 实例的引用。以下清单显示了`ApplicationContextAware` 接口的定义：

``` java
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
``` 

因此，bean可以以编程方式操纵 创建 `ApplicationContext `的方法,通过 `ApplicationContext` 接口或通过将引用转换为此接口的已知子类（例如暴露额外功能的 `ConfigurableApplicationContext`）。一种用途是对其他bean进行编程检索。有时这种能力很有用。但是，一般情况下，您应该避免使用它，因为它将代码耦合到Spring并且不遵循 控制反转 的样式，其中协作者作为属性提供 bean。其他 `ApplicationContext `方法提供对文件资源的访问，发布应用程序事件和访问 `MessageSource`。这些附加功能在附加ApplicationContext功能中描述 。

自动装配是另一种获取 ApplicationContext 引用的方法 。传统的 `constructor` 和 `byType` 自动装配模式（在自动装配协作者章节中描述的）可以提供 `ApplicationContext` 类型的依赖 单独使用构造器参数或 setter 方法参数。要获得更多灵活性，包括自动装配字段和多参数方法的功能，请使用基于注解的自动装配功能。如果需要需要字段、构造函数参数或方法参数等类型，通过 `@Autowired` 注解，ApplicationContext 则自动注入一个字段、构造函数参数或方法参数。有关更多信息，请参阅 使用 @Autowired。

当 `ApplicationContext` 创建实现 `org.springframework.beans.factory.BeanNameAware` 接口的类时，将为该类提供对其关联对象定义中定义名称的引用。以下清单显示了BeanNameAware接口的定义：

``` java
public interface BeanNameAware {

    void setBeanName(String name) throws BeansException;
}
``` 

这个回调在正常bean属性入口之后，但在初始化回调诸如调用`InitializingBean`，`afterPropertiesSet`或`自定义的初始化方法`之前被调用。

### 1.6.3 其他Aware接口
除了 `ApplicationContextAware` 和 `BeanNameAware` 讨论（之前讨论的），Spring提供了广泛的 `Aware`，让 bean 指示，他们需要一定的基础设施的依赖容器回调接口。作为一般规则，名称表示依赖关系类型。下表总结了最重要的Aware接口：

**表4.感知接口**

|名称|注入依赖|解释|
| :----:| :---- | :----:| 
ApplicationContextAware| 声明ApplicationContext | `ApplicationContextAware `和 `BeanNameAware`
ApplicationEventPublisherAware| 封闭的事件发布者ApplicationContext| `ApplicationContext` 附加功能 
BeanClassLoaderAware| 用于加载bean类的类加载器 | 实例化豆​ beans
BeanFactoryAware | 声明BeanFactory | `ApplicationContextAware` 和 `BeanNameAware`
BeanNameAware |声明bean的名称 |  `ApplicationContextAware` 和 `BeanNameAware`
BootstrapContextAware | BootstrapContext 容器运行的资源适配器。通常仅在JCA感知ApplicationContext实例中可用| JCA CCI
LoadTimeWeaverAware|定义的weaver用于在加载时处理类定义|在Spring框架中使用AspectJ进行加载时编织
MessageSourceAware|用于解析消息的已配置策略（支持参数化和国际化）|附加功能 ApplicationContext
NotificationPublisherAware|Spring JMX通知发布者|通知
ResourceLoaderAware|配置的加载程序，用于对资源进行低级访问|资源
ServletConfigAware|当前ServletConfig容器运行。仅在Web感知弹簧中有效 ApplicationContext|Spring MVC
ServletContextAware|当前ServletContext容器运行。仅在Web感知弹簧中有效 ApplicationContext\Spring MVC

请再次注意，使用这些接口会将您的代码绑定到Spring API，而不会遵循 控制反转 的样式。因此，我们建议将它们用在需要以编程方式访问容器的基础架构bean。

## 1.7 Bean定义继承
bean定义可以包含许多配置信息，包括构造函数参数，属性值和特定于容器的信息，例如初始化方法，静态工厂方法名称等。**子bean定义从父定义继承配置数据。子定义可以覆盖某些值或根据需要添加其他值**。使用父bean和子bean定义可以节省大量的输入。实际上，这是一种模板形式。

如果以 `ApplicationContext` 编程方式使用接口，则子bean定义由 `ChildBeanDefinition` 类表示。大多数用户不在此级别上使用它们。相反，它们在 `ClassPathXmlApplicationContext `类中以声明方式配置bean定义。使用基于XML的配置元数据时，可以使用`parent`属性指定子bean定义，并将父bean指定为此属性的值。以下示例显示了如何执行此操作：

``` xml
<bean id="inheritedTestBean" abstract="true"
        class="org.springframework.beans.TestBean">
    <property name="name" value="parent"/>
    <property name="age" value="1"/>
</bean>

<bean id="inheritsWithDifferentClass"
        class="org.springframework.beans.DerivedTestBean"
        parent="inheritedTestBean" init-method="initialize">  1
    <property name="name" value="override"/>
    <!-- the age property value of 1 will be inherited from parent -->
</bean>
``` 

1 注意`parent`属性。

如果没有指定，则 bean定义使用父定义中的bean类属性，但也可以覆盖它。在后一种情况下，子bean类必须与父类兼容（即必须接受父类的属性值）。

子bean定义从父级继承范围，构造函数参数值，属性值和方法覆盖，并可选择添加新值。任何范围，包括初始化方法，销毁方法或 static工厂方法设置都会覆盖相应的父设置。

其余设置始终取自子定义：依赖，autowire模式，依赖性检查，单例和惰性初始化。

前面的示例通过使用 `abstract` 属性将父bean定义显式标记为abstract 。如果父定义未指定类，`abstract` 则根据需要显式标记父bean定义，如以下示例所示：

``` xml
<bean id="inheritedTestBeanWithoutClass" abstract="true">
    <property name="name" value="parent"/>
    <property name="age" value="1"/>
</bean>

<bean id="inheritsWithClass" class="org.springframework.beans.DerivedTestBean"
        parent="inheritedTestBeanWithoutClass" init-method="initialize">
    <property name="name" value="override"/>
    <!-- age will inherit the value of 1 from the parent bean definition-->
</bean>
``` 

父bean不能单独实例化，因为它不完整，并且也明确标记为`abstract`。定义时`abstract`，它仅可用作纯模板bean定义，用作子定义的父定义。尝试使用这样的`abstract`父bean，通过将其称为另一个bean的`ref` 属性或 `getBean()` 使用父bean ID 进行显式调用，将返回错误。类似地，容器的内部 `preInstantiateSingletons()` 方法忽略定义为 `abstract` 的bean定义。

> `ApplicationContext`默认情况下预先实例化所有单例。因此，重要的是（至少对于单例bean），如果你有一个（父）bean定义，你只打算用作模板，并且这个定义指定了一个类，你必须确保将`abstract`属性设置为true， 否则应用程序上下文将实际（尝试）预先实例化`abstract` bean。
## 1.8 容器扩展点
通常，应用程序开发人员不需要子类化 `ApplicationContext` 的实现类。相反，可以通过插入特殊集成接口的实现来扩展 Spring IoC 容器。接下来的几节将介绍这些集成接口。

### 1.8.1 使用 `BeanBeanPostProcessor` 定制beans
`BeanPostProcessor` 接口定义了您可以实现的回调方法，以提供您定义自己的（或覆盖容器的默认）实例化逻辑，依赖关系解析逻辑等。如果要在Spring容器完成实例化，配置和初始化bean之后实现某些自定义逻辑，则可以插入一个或多个自定义 `BeanPostProcessor` 实现。

您可以配置多`个BeanPostProcessor`实例，并且可以 `BeanPostProcessor` 通过设置 `order` 属性来控制这些实例的执行顺序。只有在 `BeanPostProcessor `实现 `Ordered` 接口时才能设置此属性。如果你自己编写 `BeanPostProcessor`，你也应该考虑实现这个` Ordered `接口。有关更多详细信息，请参阅 `BeanPostProcessor` 和 `Ordered`接口的javadoc 。另见关于实例的程序化注册BeanPostProcessor的说明。

> `BeanPostProcessor`实例在bean（或对象）实例上运行。也就是说，Spring IoC容器实例化一个bean实例，然后`BeanPostProcessor` 实例执行它们的工作。

> `BeanPostProcessor`实例的范围是每个容器。仅当您使用容器层次结构时，这才是相关的。如果`BeanPostProcessor`在一个容器中定义一个容器，它只会对该容器中的bean进行**后处理**。换句话说，即使两个容器 `BeanPostProcessor` 都是同一层次结构的一部分，在一个容器中定义的bean也不会被另一个容器中定义的bean进行后处理。

> 要更改实际的bean定义（即定义bean的蓝图），您需要使用` BeanFactoryPostProcessor`，如 使用定制配置元数据中所述 `BeanFactoryPostProcessor`。

`org.springframework.beans.factory.config.BeanPostProcessor` 接口由两个回调方法组成。当这样的类用容器注册为后处理器时，对于由容器创建的每个bean实例，后处理器在容器初始化方法（例如`InitializingBean.afterPropertiesSet()`或任何声明的init方法）之前都从容器获得回调。并在任何bean初始化后回调。后处理器可以对bean实例执行任何操作，包括完全忽略回调。bean后处理器通常检查回调接口，或者它可以用代理包装bean。一些Spring AOP基础结构类实现为bean后处理器，以便提供代理包装逻辑。

`ApplicationContext` 自动检测实现了 `BeanPostProcessor` 接口的配置元数据中定义的任何 bean 。将 `ApplicationContext` 这些bean注册为后处理器，以便在创建bean时可以稍后调用它们。Bean后处理器可以以与任何其他bean以相同的方式部署在容器中。

请注意，在配置类 `BeanPostProcessor` 上 使用 `@Bean` 工厂方法声明时，工厂方法的**返回类型应该是实现类本身或至少是`org.springframework.beans.factory.config.BeanPostProcessor` 接口**，清楚地表明该bean的后处理器性质。否则，`ApplicationContext`在完全创建之前， 无法按类型自动检测它。由于BeanPostProcessor需要尽早实例化以便应用于上下文中其他bean的初始化，因此这种早期类型检测至关重要。

> 以编程方式注册 `BeanPostProcessor` 实例
> 虽然推荐的BeanPostProcessor注册方法是通过 ApplicationContext自动检测（如前所述），但您可以`ConfigurableBeanFactory`使用该`addBeanPostProcessor` 方法以编程方式对其进行注册。当您需要在注册前评估条件逻辑或甚至跨层次结构中的上下文复制Bean post处理器时，这非常有用。**但请注意，以`BeanPostProcessor`编程方式添加的实例不遵从Ordered接口**。这里，注册的顺序决定了执行的顺序。另请注意，以 `BeanPostProcessor` 编程方式注册的实例**始终在通过自动检测注册的实例之前处理，而不管任何显式排序**。

> `BeanPostProcessor` 实例和AOP自动代理
> 实现`BeanPostProcessor`接口的类是特殊的，容器会对它们进行不同的处理。`BeanPostProcessor`他们直接引用的所有实例和bean都会在启动时实例化，作为`ApplicationContext`特殊启动阶段的一部分。接下来，所有`BeanPostProcessor`实例都**以排序方式注册**，并应用于容器中的所有其他bean。因为AOP自动代理是作为一个`BeanPostProcessor`自身实现的，所以`BeanPostProcessor `实例和它们直接引用的bean都不符合自动代理的条件，因此没有aspects woven/织入他们。

对于任何此类bean，您应该看到一条信息性日志消息：`Bean someBean is not eligible for getting processed by all BeanPostProcessor interfaces (for example: not eligible for auto-proxying)`。

如果通过使用自动装配或 `@Resource（`可能回退到自动装配）将bean连接到您的 `BeanPostProcessor` ，Spring可能会在搜索类型匹配依赖项候选项时访问意外的bean，因此，使它们不符合自动代理或其他类型的bean post -处理。例如，如果您有一个依赖项，@Resource其中字段或setter名称与bean的声明名称没有直接对应，并且没有使用name属性，则Spring会访问其他bean以按类型匹配它们。

以下示例显示如何在 `ApplicationContext` 中编写，注册和使用 `BeanPostProcessor` 实例。

#### 示例：Hello World，BeanPostProcessor-style
第一个例子说明了基本用法。该示例显示了一个自定义 `BeanPostProcessor` 实现，该实现在容器创建的每个bean上调用 toString() 方法，并将生成的字符串输出到系统控制台。

以下清单显示了自定义 `BeanPostProcessor` 实现类定义：

``` java
package scripting;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    // simply return the instantiated bean as-is
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean; // we could potentially return any object reference here...
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}
``` 

以下`beans`元素使用`InstantiationTracingBeanPostProcessor`：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:lang="http://www.springframework.org/schema/lang"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/lang
        https://www.springframework.org/schema/lang/spring-lang.xsd">

    <lang:groovy id="messenger"
            script-source="classpath:org/springframework/scripting/groovy/Messenger.groovy">
        <lang:property name="message" value="Fiona Apple Is Just So Dreamy."/>
    </lang:groovy>

    <!--
    when the above bean (messenger) is instantiated, this custom
    BeanPostProcessor implementation will output the fact to the system console
    -->
    <bean class="scripting.InstantiationTracingBeanPostProcessor"/>

</beans>
``` 

请注意 `InstantiationTracingBeanPostProcessor` 是如何定义的。它甚至没有名称，并且，因为它是一个bean，它可以像任何其他bean一样依赖注入。（前面的配置还定义了一个由Groovy脚本支持的bean。在动态语言支持一章中详细介绍了Spring 动态语言支持。）

以下Java应用程序运行上述代码和配置：

``` java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scripting.Messenger;

public final class Boot {

    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("scripting/beans.xml");
        Messenger messenger = (Messenger) ctx.getBean("messenger");
        System.out.println(messenger);
    }

}
```

上述应用程序的输出类似于以下内容：

```
Bean'sensenger' created：org.springframework.scripting.groovy.GroovyMessenger@272961 
org.springframework.scripting.groovy.GroovyMessenger@272961
```

#### 示例：`RequiredAnnotationBeanPostProcessor`
将回调接口或注解与自定义`BeanPostProcessor`实现结合使用是扩展Spring IoC容器的常用方法。一个例子是Spring `RequiredAnnotationBeanPostProcessor` —— 一个 `BeanPostProcessor`随Spring发行版一起提供的实现，它确保标记有（任意）注解的bean上的JavaBean属性实际上（配置为）依赖注入值。

### 1.8.2 使用自定义配置元数据 `BeanFactoryPostProcessor`
我们看到的下一个扩展点是 `org.springframework.beans.factory.config.BeanFactoryPostProcessor`。这个接口的语义类似于`BeanPostProcessor`。它的一个主要区别：`BeanFactoryPostProcessor`对bean配置元数据进行操作。也就是说，Spring IoC容器允许`BeanFactoryPostProcessor` 读取配置元数据，并可能在容器实例化任何 bean 之前更改它而不是`BeanFactoryPostProcessor` 实例。

您可以配置多个`BeanFactoryPostProcessor` 实例，并且可以`BeanFactoryPostProcessor`通过设置`order`属性来**控制这些实例的运行顺序**。但是，如果 `BeanFactoryPostProcessor` 实现 Ordered接口，则只能设置此属性。如果你自己编写BeanFactoryPostProcessor，你也**应该考虑实现这个Ordered接口**。有关更多详细信息，请参阅BeanFactoryPostProcessor和Ordered接口的javadoc 。

> 如果要更改实际的bean实例（即，从配置元数据创建的对象），则需要使用 `BeanPostProcessor `（前面在使用定制Bean中进行了描述BeanPostProcessor）。虽然技术上可以在`BeanFactoryPostProcessor`中使用 bean 实例（例如，通过使用 `BeanFactory.getBean()`），但这样做会导致过早的bean实例化，从而违反标准的容器生命周期。这可能会导致负面影响，例如绕过bean后期处理。

> 此外，`BeanFactoryPostProcessor`实例的范围是每个容器的范围。仅当您使用容器层次结构时，这才有意义。如果`BeanFactoryPostProcessor`在一个容器中定义一个容器，则它仅应用于该容器中的bean定义。即使两个容器都是`BeanFactoryPostProcessor`同一层次结构的一部分，一个容器中的Bean定义也不会被另一个容器中的实例进行后处理。

Bean工厂后处理器在其内部声明时会自动执行` ApplicationContext`，以便将更改应用于定义容器的配置元数据。Spring包含许多**预定义的bean工厂后处理器**，例如`PropertyOverrideConfigurer`和 `PropertySourcesPlaceholderConfigurer`。您还可以使用自定义`BeanFactoryPostProcessor` - 例如，注册自定义属性编辑器。

`ApplicationContext`自动检测部署在它内部中实现了任何`BeanFactoryPostProcessor`接口的 bean 。它在适当的时候使用这些bean作为`bean工厂后处理器`。您可以像处理任何其他bean一样部署这些后处理器bean。

> 与`BeanPostProcessors`一样，您通常不希望 `BeanFactoryPostProcessor` 配置为延迟初始化。如果没有其他bean引用 `Bean(Factory)PostProcessor`，则该后处理器根本不会被实例化。因此，将其标记为延迟初始化将被忽略， `Bean(Factory)PostProcessor` 会急切地实例化，即使对你的声明<beans/>元素设定 `default-lazy-init` 属性true。

#### 示例：类名替换 `PropertySourcesPlaceholderConfigurer`
您可以使用 `PropertySourcesPlaceholderConfigurer` 借助标准Java` Properties` 格式从 bean 定义 在单独的文件中外部化属性值。这样做可以使部署应用程序的人员自定义特定环境的属性，例如数据库URL和密码，而不会出现修改主XML定义文件或容器文件的复杂性或风险。

请考虑以下基于XML的配置元数据片段，其中 `DataSource` 定义了占位符值：

``` xml
<bean class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
    <property name="locations" value="classpath:com/something/jdbc.properties"/>
</bean>

<bean id="dataSource" destroy-method="close"
        class="org.apache.commons.dbcp.BasicDataSource">
    <property name="driverClassName" value="${jdbc.driverClassName}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
</bean>
```

该示例显示了从外部`Properties`文件配置的属性。在运行时，`PropertySourcesPlaceholderConfigurer` 将应用于替换DataSource的某些属性的元数据。要替换的值被指定为表单的占位符`${property-name}`，它遵循Ant和log4j以及JSP EL样式。

实际值来自标准Java `Properties` 格式的另一个文件：

```
jdbc.driverClassName = org.hsqldb.jdbcDriver
jdbc.url = JDBC:HSQLDB:HSQL://product:9002
jdbc.username = SA
jdbc.password =root
```

因此，`${jdbc.username}` 在运行时使用值“sa”替换字符串，这同样适用于与属性文件中的键匹配的其他占位符值。在`PropertySourcesPlaceholderConfigurer`为大多数属性和bean定义的属性占位符提供检查。此外，您可以自定义占位符前缀和后缀。

在Spring 2.5 中引入 `context `的命名空间，您可以使用专用配置元素配置属性占位符。您可以在 `location` 属性中提供一个或多个位置作为逗号分隔列表，如以下示例所示：

```
<context:property-placeholder location="classpath:com/something/jdbc.properties"/>
```

`PropertySourcesPlaceholderConfigurer`不仅将查找在属性`Properties` 指定的文件。默认情况下，如果它在指定的属性文件中找不到属性，则会检查Spring `Environment`属性和常规Java `System`属性。

> 您可以使用PropertySourcesPlaceholderConfigurer替换类名称，这在您必须在运行时选择特定实现类时有时很有用。以下示例显示了如何执行此操作：

``` xml
<bean class="org.springframework.beans.factory.config.PropertySourcesPlaceholderConfigurer">
    <property name="locations">
        <value>classpath:com/something/strategy.properties</value>
    </property>
    <property name="properties">
        <value>custom.strategy.class=com.something.DefaultStrategy</value>
    </property>
</bean>

<bean id="serviceStrategy" class="${custom.strategy.class}"/>
```

> 如果类不能在运行时被解析为一个有效的类，当bean即将被创造时将解析失败，这是在`ApplicationContext` 进行非延迟实例化的bean的 `preInstantiateSingletons()` 的阶段发生的。

#### 示例： `PropertyOverrideConfigurer`
`PropertyOverrideConfigurer` 是另一个bean工厂后置处理器，类似于 `PropertySourcesPlaceholderConfigurer`，但后者不同的是，原来的定义可以有缺省值或者根本没有值的bean属性。如果覆盖 `Properties` 文件没有某个bean属性的条目，则使用默认上下文定义。

请注意，bean定义不知道被覆盖，因此从XML定义文件中可以立即看出正在使用覆盖配置。如果多个`PropertyOverrideConfigurer`实例为同一个bean属性定义了不同的值，则由于覆盖机制，最后一个实例会获胜。

属性文件配置行采用以下格式：

```
beanName.property =value
```

以下清单显示了格式的示例：

```
dataSource.driverClassName = com.mysql.jdbc.Driver
dataSource.url = jdbc:mysql:mydb
```

此示例文件可以与包含名为`dataSourcehas`带有 `driver`和`url`属性 的bean的容器定义一起使用 。

也支持复合属性名称，只要路径的每个组件（重写的最终属性除外）都已经非空（可能由构造函数初始化）。在下面的例子中，`sammy`所属的属性`bob`的`fred`的`tom` bean被设置为标量值123：

```
tom.fred.bob.sammy = 123
```

> 指定的覆盖值始终是文字值。它们不会被翻译成bean引用。当XML bean定义中的原始值指定bean引用时，此约定也适用。

Spring 2.5中引入 `context` 的命名空间，可以使用专用配置元素配置属性覆盖，如以下示例所示：

<context:property-override location="classpath:override.properties"/>

### 1.8.3 使用自定义实例化逻辑` FactoryBean`
您可以使用 `org.springframework.beans.factory.FactoryBean` 为自己工厂的对象实现接口。

`FactoryBean`接口是**Spring IoC容器实例化逻辑的可插拔点**。如果你有一个复杂的初始化代码，用Java表示，而不是（可能）冗长的XML，你可以创建自己的 `FactoryBean`，在该类中编写复杂的初始化，然后将自定义`FactoryBean`插入容器。

`FactoryBean`接口提供了三种方法：

* `Object getObject()`：返回此工厂创建的对象的实例。可以共享实例，具体取决于此工厂是返回单例还是原型。

* `boolean isSingleton()`：如果`FactoryBean`返回单例则返回 true 或 其他返回 false 。
 
* `Class getObjectType()`：返回通过 `getObject()`方法返回对象类型，或者如果事先不知道类型返回 null。

在Spring框架内` FactoryBean `概念和接口在很多地方被使用。Spring自身提供超过50个 `FactoryBean` 接口的实现。

当你需要向一个容器询问一个实际的 `FactoryBean` 实例本身而不是它生成的bean 时，在调用`ApplicationContext`的 `getBean()`方法时在bean 的id 前面加上符号（&）作为前缀。因此，对于带有一个 id 的 myBean 的FactoryBean，调用在容器 getBean("myBean")返回 FactoryBean 的产品，反之而调用 getBean("&myBean")返回的`FactoryBean` 实例本身。

## 1.9 基于注解的容器配置
#### 注解是否比配置 Spring 的 XML 更好？
> 基于注解的配置的引入引发了这种方法是否比XML“更好”的问题。简短的回答是“它取决于具体情况。”长期的答案是每种方法都有其优点和缺点，通常，由开发人员决定哪种策略更适合他们。由于它们的定义方式，注解在其声明中提供了大量上下文，从而导致更短更简洁的配置。但是，XML擅长在不触及源代码或重新编译它们的情况下连接组件。一些开发人员更喜欢将装配靠近源码，而另一些开发人员则认为注解类不再是POJO，而且配置变得分散且难以控制。

> 无论选择如何，Spring都可以兼顾两种风格，甚至可以将它们混合在一起。值得指出的是，通过其JavaConfig选项，Spring允许以非侵入方式使用注解，而无需触及目标组件源代码，并且在工具方面，Spring Tool Suite支持所有配置样式 。

基于注解的配置提供了XML设置的替代方案，该配置依赖于字节码元数据来连接组件而不是尖括号声明。开发人员不是使用XML来描述bean连接，而是通过在相关的类，方法或字段声明上使用注解**将配置移动到组件类本身**。如示例中所述：`RequiredAnnotationBeanPostProcessor`使用`BeanPostProcessor`与注解结合使用是扩展 Spring IoC 容器的常用方法。例如，Spring 2.0引入了使用`@Required` 注解强制执行所需属性的可能性。使得 Spring 2.5 有可能采用相同的通用方法来驱动Spring的依赖注入。基本上，`@Autowired` 注解提供与自动装配协作者中描述的相同的功能，但具有更细粒度的控制和更广泛的适用性。Spring 2.5还增加了对JSR-250注解的支持，例如` @PostConstruct` 和 `@PreDestroy`。Spring 3.0增加了对`javax.inject` 包中包含的JSR-330（Java的依赖注入）注解的支持，例如 `@Inject `和 `@Named`。有关这些注解的详细信息，请参阅 相关章节。

> 注解注入在XML注入之前执行。因此，XML配置会覆盖通过这两种方法配置的属性的注解。

与往常一样，您可以将它们注册为单独的bean定义，但也可以通过在基于XML的Spring配置中包含以下标记来隐式注册它们（请注意包含`context`命名空间）：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

</beans>
```

（在隐式注册后处理器包括 `AutowiredAnnotationBeanPostProcessor`， `CommonAnnotationBeanPostProcessor`， `PersistenceAnnotationBeanPostProcessor` 和前面提到的 `RequiredAnnotationBeanPostProcessor`。）

> `<context:annotation-config/>` 仅查找在定义它的同一应用程序上下文中的bean上的注解。这意味着，如果你在` <context:annotation-config/>` 给`DispatcherServlet` 输入一个`WebApplicationContext` ，它只检查控制器中 `@Autowired `的bean，而不是你的服务。有关更多信息，请参阅 DispatcherServlet。

### 1.9.1 @Required【已经废弃】
`@Required` 注解适用于bean属性setter方法，如下面的例子：

``` java 
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Required
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
```

此注解指示必须在配置时通过bean定义中的显式属性值或通过自动装配填充受影响的bean属性。如果尚未填充受影响的bean属性，则容器将引发异常。这允许急切和明确的失败，以避免 `NullPointerException` 实例等。我们仍然建议您将**断言放入bean类本身（例如，转换为init方法）**。即使您在容器外部使用类，这样做也会强制执行那些必需的引用和值。

> 从Spring Framework 5.1开始，`@Required`注解正式被弃用，支持使用构造函数注入所需的设置（或者用bean属性setter方法 的InitializingBean.afterPropertiesSet()的自定义实现 ）。

### 1.9.2 使用@Autowired
> 在本节中包含的示例中，`@Inject` 可以使用JSR 330的注解代替Spring的 `@Autowired `注解。有关详细信息，请参见此处

您可以将 `@Autowired` 注解应用于构造函数，如以下示例所示：

``` java 
public class MovieRecommender {

    private final CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }

    // ...
}
```

> 从Spring Framework 4.3开始，如果目标bean只定义了一个开头的构造函数，则不再需要对这样的构造函数进行`@Autowired`注解。但是，如果有几个构造函数可用，则必须至少一个构造函数用 `@Autowired` 注解以指示容器使用哪个构造函数。

您还可以将`@Autowired`注解应用于传统的 `setter`方法，如以下示例所示：

``` java 
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
``` 

您还可以将注解应用于具有`任意名称和多个参数的方法`，如以下示例所示：

``` java
public class MovieRecommender {

    private MovieCatalog movieCatalog;

    private CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public void prepare(MovieCatalog movieCatalog,
            CustomerPreferenceDao customerPreferenceDao) {
        this.movieCatalog = movieCatalog;
        this.customerPreferenceDao = customerPreferenceDao;
    }

    // ...
}
``` 

您也可以对字段应用 `@Autowired `，甚至可以将其与构造函数混合使用，如下例所示：

``` java
public class MovieRecommender {

    private final CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    private MovieCatalog movieCatalog;

    @Autowired
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }

    // ...
}
``` 

> 确保目标组件（例如，`MovieCatalog`或`CustomerPreferenceDao`）始终按照用于`@Autowired`注解注入点的类型声明。否则，由于在运行时未找到类型匹配，注入可能会失败。

> 对于通过类路径扫描找到的XML定义的bean或组件类，容器通常预先知道具体类型。但是，对于`@Bean`工厂方法，您需要**确保声明的返回类型具有足够的表达含义**。对于实现多个接口的组件或可能由其实现类型引用的组件，请考虑在工厂方法上声明最具体的返回类型（至少与引用bean的注入点所要求的具体相同）。

您还可以从 `ApplicationContext` 通过将注解添加到需要该类型数组的字段或方法 来提供特定类型的所有bean ，如以下示例所示：

``` java
public class MovieRecommender {

    @Autowired
    private MovieCatalog[] movieCatalogs;

    // ...
}
``` 

这同样适用于同一类型集合，如以下示例所示：

``` java
public class MovieRecommender {

    private Set<MovieCatalog> movieCatalogs;

    @Autowired
    public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    // ...
}
``` 

如果希望按特定顺序对数组或列表中的项进行排序，则目标bean可以实现`org.springframework.core.Ordered`接口或使用 `@Order `或标准 `@Priority` 注解。否则，它们的顺序遵循容器中相应目标bean定义的注册顺序。

您可以在目标类级别和`@Bean`方法上声明 `@Order` 注解，可能是通过单个bean定义（在多个定义使用相同bean类的情况下）。`@Order` 值可能会影响注入点的优先级，但要注意它们不会影响单例启动顺序，这是由依赖关系和 `@DependsOn` 声明确定的正交关注点。

请注意，标准`javax.annotation.Priority`注解在该`@Bean`级别不可用 ，因为它无法在方法上声明。它的语义可以在单个bean上为每种类型通过 `@Order`值与`@Primary`的结合来模版化。

只要预期的 key 类型是String，甚至 Map 实例也可以自动装配。Map 值包含所有期望类型的bean，并且 key 包含相应的bean名称，如以下示例所示：

``` java
public class MovieRecommender {

    private Map<String, MovieCatalog> movieCatalogs;

    @Autowired
    public void setMovieCatalogs(Map<String, MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    // ...
}
``` 

默认情况下，当给定注入点没有匹配的候选bean时，自动装配失败。对于声明的数组，集合或映射，至少需要一个匹配元素。

默认行为是将带注解的方法和字段视为指示所需的依赖项。您可以更改此行为，如以下示例所示，使框架能够通过将其标记为`非必需`来跳过不可满足的注入点：

``` java
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Autowired(required = false)
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
``` 
如果不依赖于其依赖关系（或多个参数的依赖关系之一），则根本不会调用非必需的方法。在这种情况下，根本不会填充非必填字段，保留其默认值。

注入的构造函数和工厂方法参数是一种特殊情况，因为由于Spring的构造函数解析算法可能涉及多个构造函数，因此'required'标志的 `@Autowired` 含义有些不同。默认情况下构造函数和工厂方法需要有效的参数，但在单构造函数方案中有一些特殊规则，例如，如果没有匹配的bean可用，则解析为空实例的多元素注入点（数组，集合，映射）。这允许一个通用的实现模式，其中所有依赖项都可以在一个唯一的多参数构造函数中声明，例如声明为没有 `@Autowired` 注解的单个公共构造函数。

> 每个类只能标记一个带注解的构造函数，但可以注解多个非必需的构造函数。在这种情况下，每个都被认为是候选者之一，Spring使用最贪婪的构造函数，其依赖性可以得到满足 - 也就是说，具有最多参数的构造函数。构造函数解析算法与具有重载构造函数的非注解类相同，只是将候选者缩小到带注解的构造函数。

> 建议使用 `@Autowired`的“required”属性而不是setter方法上的 `@Required` 的注解。`“required”` 属性表示该属性不是自动装配所必需的。如果无法自动装配，则会忽略该属性。另一方面，`@Required` 更强大，因为它强制通过容器支持的任何方式设置属性。如果未定义任何值，则会引发相应的异常。

或者，您可以通过Java 8表达特定依赖关系的非必需特性`java.util.Optional`，如以下示例所示：

``` java
public class SimpleMovieLister {

    @Autowired
    public void setMovieFinder(Optional<MovieFinder> movieFinder) {
        ...
    }
}
``` 

从Spring Framework 5.0开始，您还可以使用`@Nullable`注解（任何包中的任何类型的注解 - 例如，`javax.annotation.Nullable`来自JSR-305）：

``` java
public class SimpleMovieLister {

    @Autowired
    public void setMovieFinder(@Nullable MovieFinder movieFinder) {
        ...
    }
}
``` 
您还可以将 `@Autowired` 用在那些众所周知的解析依赖接口：`BeanFactory`，`ApplicationContext`，`Environment`，`ResourceLoader`， `ApplicationEventPublisher` 和`MessageSource`。这些接口及其扩展接口（如`ConfigurableApplicationContext` 或 `ResourcePatternResolver`）会自动解析，无需特殊设置。以下示例自动装配一个 ` ApplicationContext` 对象：

``` java
public class MovieRecommender {

    @Autowired
    private ApplicationContext context;

    public MovieRecommender() {
    }

    // ...
}
``` 

`@Autowired`，`@Inject`，`@Value` 和 `@Resource` 注解由Spring `BeanPostProcessor`实现处理。这意味着您无法在自己的类型`BeanPostProcessor`或 `BeanFactoryPostProcessor`类型（如果有）中应用这些注解。必须使用XML或Spring `@Bean`方法显式地“连接”这些类型。

### 1.9.3 基于注解自动装配用 `@Primary` 微调
由于按类型自动装配可能会导致多个候选者，因此通常需要对选择过程进行更多控制。实现这一目标的一种方法是使用Spring的 `@Primary`注解。`@Primary`表示当多个bean可以自动装配到单值依赖项时，应该**优先选择特定的bean**。如果候选者中只存在一个主bean，则它将成为自动装配的值。

请思考以下定义`firstMovieCatalog`为主要的配置`MovieCatalog`：

``` java
@Configuration
public class MovieConfiguration {

    @Bean
    @Primary
    public MovieCatalog firstMovieCatalog() { ... }

    @Bean
    public MovieCatalog secondMovieCatalog() { ... }

    // ...
}
``` 

使用上述配置，以下`MovieRecommender` 自动装配 `firstMovieCatalog`：

``` java
public class MovieRecommender {

    @Autowired
    private MovieCatalog movieCatalog;

    // ...
}
``` 

相应的bean定义如下：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="example.SimpleMovieCatalog" primary="true">
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="example.SimpleMovieCatalog">
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean id="movieRecommender" class="example.MovieRecommender"/>

</beans>
```

### 1.9.4 使用限定符微调基于注解的自动装配
当可以确定一个主要候选者时，@Primary 是在具有多个实例时通过使用类型的自动装配的有效方式。当您需要更多控制选择过程时，可以使用Spring的 `@Qualifier `注解。您可以将**限定符值与特定参数相关联，缩小类型匹配集**，以便为每个参数选择特定的bean。在最简单的情况下，这可以是一个简单的描述性值，如以下示例所示：

``` java
public class MovieRecommender {

    @Autowired
    @Qualifier("main")
    private MovieCatalog movieCatalog;

    // ...
}
``` 

您还可以在各个构造函数参数或方法参数上指定 `@Qualifier `注解，如以下示例所示：

``` java
public class MovieRecommender {

    private MovieCatalog movieCatalog;

    private CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public void prepare(@Qualifier("main") MovieCatalog movieCatalog,
            CustomerPreferenceDao customerPreferenceDao) {
        this.movieCatalog = movieCatalog;
        this.customerPreferenceDao = customerPreferenceDao;
    }

    // ...
}
``` 

以下示例显示了相应的bean定义。

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="example.SimpleMovieCatalog">
        <qualifier value="main"/>  1

        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="example.SimpleMovieCatalog">
        <qualifier value="action"/>  2

        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean id="movieRecommender" class="example.MovieRecommender"/>

</beans>
``` 

1,2说明如下:

* 1 具有main限定符值的bean与使用相同值限定的构造函数参数连接。
* 2 具有action限定符值的bean与使用相同值限定的构造函数参数连接。


对于回退匹配，bean名称被视为默认 qualifier/限定符 值。因此，可以用一个定义bean `main` 的 `id` 代替嵌套限定符元素，产生相同的匹配结果。但是，虽然您可以使用此约定来按名称引用特定bean，但`@Autowired` 基本上是关于具有可选语义限定符的类型驱动注入。这意味着即使使用bean名称回退，限定符值在类型匹配集中也总是具有缩小的语义。它们在语义上不表示对唯一bean的引用id。良好限定的值是 `main` 或` EMEA `或 `persistent`，表达独立于从所述 bean 的特定部件的特性id，在匿名bean定义的情况下可以自动生成，例如前面例子中的定义。

限定符也适用于类型集合，如前所述 - 例如 Set<MovieCatalog>。在这种情况下，根据声明的限定符，所有匹配的bean都作为集合注入。这意味着限定符不必是唯一的。相反，它们构成了过滤标准。例如，您可以使用相同的限定符值 `“action”` 定义多个 `MovieCatalog` bean，所有这些bean 都用 `@Qualifier("action")` 注入 `Set<MovieCatalog>`。

在类型匹配候选项中，根据目标bean名称选择限定符值，在注入点处不需要` @Qualifier `的注解。如果没有其他解析指示符（例如限定符或主要标记），则对于非唯一依赖性情况，Spring会将注入点名称（即字段名称或参数名称）与目标bean名称进行匹配，然后选择同名的候选者，如果有的话。

也就是说，如果您打算**按名称表达注解驱动的注入**，请不要主要使用@Autowired，即使它能够在类型匹配候选项中通过bean名称进行选择。**相反，使用JSR-250 @Resource注解**，该注解在语义上定义为**通过其唯一名称标识特定目标组件，声明的类型与匹配过程无关**。`@Autowired`具有相当不同的语义：在按类型选择候选bean之后，指定的` String `限定符值仅在那些类型选择的候选中考虑（例如，**将account限定符与标记有相同限定符标签的 bean 匹配**，就是匹配相同限定符的标签）。

对于自身定义为集合Map或数组类型的bean来说，`@Resource` 是一个很好的解决方案，它通过**唯一名称**引用特定的集合或数组bean。也就是说，从4.3开始，只要在返回类型签名或集合继承层次结构中保留元素类型信息，就可以通过Spring的 `@Autowired `类型匹配算法匹配 Map和数组类型的 @Bean。在这种情况下，您可以使用限定符值在相同类型的集合中进行选择，如上一段所述。

从4.3开始，`@Autowired` 还考虑了自引用注入（即，引用回到当前注入的bean）。请注意，自我注入是一种后备。对其他组件的常规依赖性始终具有优先权。从这个意义上说，自我引用并不参与常规的候选人选择，因此特别尤其不是主要的。相反，它们总是最低优先级。在实践中，您应该仅使用自引用作为最后的手段（例如，通过bean的事务代理调用同一实例上的其他方法）。考虑在这种情况下将受影响的方法分解为单独的委托bean。或者，您可以使用 `@Resource`，它可以通过其唯一名称获取代理回到当前bean。

`@Autowired`适用于字段、构造函数和多参数方法，允许在参数级别通过限定符注解缩小范围。相反，`@Resource` 仅支持具有**单个参数的字段和bean属性setter方法**。因此，如果注入对象是构造函数或多参数方法，则应该使用限定符。


您可以创建自己的自定义限定符注解。为此，请定义注解并在定义中提供` @Qualifier `注解，如以下示例所示：

``` java
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Genre {

    String value();
}
```

然后，您可以在自动装配的字段和参数上提供自定义限定符，如以下示例所示：

``` java
public class MovieRecommender {

    @Autowired
    @Genre("Action")
    private MovieCatalog actionCatalog;

    private MovieCatalog comedyCatalog;

    @Autowired
    public void setComedyCatalog(@Genre("Comedy") MovieCatalog comedyCatalog) {
        this.comedyCatalog = comedyCatalog;
    }

    // ...
}
```

接下来，您可以提供候选bean定义的信息。您可以将`<qualifier/>`标记添加为标记的子元素，<bean/>然后指定 `type` 和` value `匹配自定义限定符注解。类型与注解的完全限定类名匹配。或者，为方便起见，如果不存在冲突名称的风险，您可以使用短类名称。以下示例演示了这两种方法：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="example.SimpleMovieCatalog">
        <qualifier type="Genre" value="Action"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="example.SimpleMovieCatalog">
        <qualifier type="example.Genre" value="Comedy"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean id="movieRecommender" class="example.MovieRecommender"/>

</beans>
``` 

在类路径扫描和托管组件中，您可以看到基于注解的替代方法，即在XML中提供限定符元数据。具体来说，请参阅使用注解提供限定符元数据。

在某些情况下，使用没有值的注解可能就足够了。当注解用于更通用的目的并且可以应用于多种不同类型的依赖项时，这可能很有用。例如，您可以提供可在没有Internet连接时搜索的脱机目录。首先，定义简单注解，如以下示例所示：

``` java 
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Offline {

}
``` 

然后将注解添加到要自动装配的字段或属性中，如以下示例所示：

``` java
public class MovieRecommender {

    @Autowired
    @Offline	1 
    private MovieCatalog offlineCatalog;

    // ...
}
``` 

1 此行添加`@Offline`注解。

现在bean定义只需要一个限定符type，如下例所示：

``` xml
<bean class="example.SimpleMovieCatalog">
    <qualifier type="Offline"/> 1
    <!-- inject any dependencies required by this bean -->
</bean>
```

1 此元素指定限定符。

您还可以定义除简单value属性之外或代替简单属性接受命名属性的自定义限定符注解。如果随后在要自动装配的字段或参数上指定了多个属性值，则bean定义必须匹配所有此类属性值才能被视为自动装配候选。例如，请考虑以下注解定义：

``` java
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MovieQualifier {

    String genre();

    Format format();
}
```

在这种情况下Format是一个枚举，定义如下：

``` java
public enum Format {
    VHS, DVD, BLURAY
}
```
要自动装配的字段使用自定义限定符进行注解，并包含两个属性的值：`genre` 和 `format`，如以下示例所示：

``` java
public class MovieRecommender {

    @Autowired
    @MovieQualifier(format=Format.VHS, genre="Action")
    private MovieCatalog actionVhsCatalog;

    @Autowired
    @MovieQualifier(format=Format.VHS, genre="Comedy")
    private MovieCatalog comedyVhsCatalog;

    @Autowired
    @MovieQualifier(format=Format.DVD, genre="Action")
    private MovieCatalog actionDvdCatalog;

    @Autowired
    @MovieQualifier(format=Format.BLURAY, genre="Comedy")
    private MovieCatalog comedyBluRayCatalog;

    // ...
}
```

最后，bean定义应包含匹配的限定符值。此示例还演示了您可以使用bean 元数据属性而不是` <qualifier/>`元素。如果可用，则`<qualifier/>`元素及其属性优先，但`<meta/>`如果不存在此类限定符，则自动装配机制将回退到标记内提供的值 ，如以下示例中的最后两个bean定义：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <bean class="example.SimpleMovieCatalog">
        <qualifier type="MovieQualifier">
            <attribute key="format" value="VHS"/>
            <attribute key="genre" value="Action"/>
        </qualifier>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="example.SimpleMovieCatalog">
        <qualifier type="MovieQualifier">
            <attribute key="format" value="VHS"/>
            <attribute key="genre" value="Comedy"/>
        </qualifier>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="example.SimpleMovieCatalog">
        <meta key="format" value="DVD"/>
        <meta key="genre" value="Action"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

    <bean class="example.SimpleMovieCatalog">
        <meta key="format" value="BLURAY"/>
        <meta key="genre" value="Comedy"/>
        <!-- inject any dependencies required by this bean -->
    </bean>

</beans>
```

### 1.9.5 使用泛型作为自动装配限定符
除了@Qualifier注解之外，您还可以使用Java泛型类型作为隐式的限定形式。例如，假设您具有以下配置：

```
@Configuration
public class MyConfiguration {

    @Bean
    public StringStore stringStore() {
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore() {
        return new IntegerStore();
    }
}
```

假设前面的bean实现了一个通用接口（即Store<String>和， Store<Integer>），您可以 @Autowire 将Store接口和泛型用作限定符，如下例所示：

``` java
@Autowired
private Store<String> s1; // <String> qualifier, injects the stringStore bean

@Autowired
private Store<Integer> s2; // <Integer> qualifier, injects the integerStore bean
```

通用限定符也适用于自动装配list，Map实例和数组。以下示例自动装配通用List：

```
// Inject all Store beans as long as they have an <Integer> generic
// Store<String> beans will not appear in this list
@Autowired
private List<Store<Integer>> s;
```

### 1.9.6 使用 `CustomAutowireConfigurer`
`CustomAutowireConfigurer` 是一个 `BeanFactoryPostProcessor` 允许您注册自己的自定义限定符注解类型的，即使它们没有使用Spring的`@Qualifier`注解进行注解。以下示例显示如何使用`CustomAutowireConfigurer`:

``` xml
<bean id="customAutowireConfigurer"
        class="org.springframework.beans.factory.annotation.CustomAutowireConfigurer">
    <property name="customQualifierTypes">
        <set>
            <value>example.CustomQualifier</value>
        </set>
    </property>
</bean>
```

通过以下方式`AutowireCandidateResolver`确定`autowire`候选者：

* `autowire-candidate `每个bean定义的值

* 元素 `default-autowire-candidates` 上可用的任何模式`<beans/>`

* `@Qualifier` 注解的存在以及注册的任何自定义注解 `CustomAutowireConfigurer`

当多个bean有资格作为autowire候选者时，“primary”的确定如下：如果候选者中只有一个bean定义具有 `primary` 设置为的属性 `true`，则选择它。

### 1.9.7 用 `@Resource` 注入
Spring还通过在字段或bean属性setter方法上使用JSR-250 `@Resource` 注解（`javax.annotation.Resource`）来支持注入。这是Java EE中的常见模式：例如，在JSF管理的bean和JAX-WS端点中。Spring也支持Spring管理对象的这种模式。

`@Resource`采用名称属性。默认情况下，Spring将该值解释为要注入的bean名称。换句话说，它遵循按名称语义，如以下示例所示：**【按名称匹配】**

``` java
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Resource(name="myMovieFinder")  1
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
```

1 这行注入了一个`@Resource`。

如果未明确指定名称，则默认名称是从字段名称或setter方法派生的。如果是字段，则采用字段名称。在setter方法的情况下，它采用bean属性名称。下面的例子将把名为` movieFinder` 的bean注入其setter方法：

``` java
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Resource
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
``` 

> 注解提供的名称 ，由其中的`CommonAnnotationBeanPostProcessor`知道的`ApplicationContext` 解析为一个bean的名称。如果 `SimpleJndiBeanFactory` 明确配置Spring，则可以通过`JNDI`解析名称 。但是，我们建议您依赖于默认行为并使用Spring的`JNDI`查找功能来保留间接级别。

在未指定显式名称情况下，在唯一的情况下 `@Resource`不指定明确的名称，类似 `@Autowired `的使用，`@Resource` 查找的主要类型匹配，而不是一个具体名称的bean并解析众所周知的解析依存关系：`BeanFactory`，` ApplicationContext`，`ResourceLoader`，`ApplicationEventPublisher` 和 `MessageSource` 接口。

因此，在以下示例中，`customerPreferenceDao`字段首先查找名为`“customerPreferenceDao”`的bean，然后返回的主要类型匹配 `CustomerPreferenceDao`类型：

``` java
public class MovieRecommender {

    @Resource
    private CustomerPreferenceDao customerPreferenceDao;

    @Resource
    private ApplicationContext context; 1

    public MovieRecommender() {
    }

    // ...
}
``` 

1 `context` 根据已知的可解析依赖类型`ApplicationContext`注入该字段

### 1.9.8 使用@PostConstruct和@PreDestroy
`CommonAnnotationBeanPostProcessor` 不仅识别 `@Resource`注解也识别 JSR-250的生命周期注解：`javax.annotation.PostConstruct`和 `javax.annotation.PreDestroy`。在Spring 2.5中引入，对这些注解的支持提供了初始化回调和 销毁回调中描述的生命周期回调机制的替代 方法。如果 CommonAnnotationBeanPostProcessor在Spring中注册ApplicationContext，则在生命周期的同一点调用带有这些注解之一的方法，作为相应的Spring生命周期接口方法或显式声明的回调方法。在以下示例中，缓存在初始化时预填充并在销毁时清除：

``` java
public class CachingMovieLister {

    @PostConstruct
    public void populateMovieCache() {
        // populates the movie cache upon initialization...
    }

    @PreDestroy
    public void clearMovieCache() {
        // clears the movie cache upon destruction...
    }
}
``` 

有关组合各种生命周期机制的效果的详细信息，请参阅 组合生命周期机制。

> 例如`@Resource`，`@PostConstruct`和`@PreDestroy`注解类型是JDK 6到8的标准Java库的一部分。但是，整个`javax.annotation` 包再JDK 9中的核心Java模块分离，最终在JDK 11中删除。如果需要，`javax.annotation-api`工件需要是现在通过Maven Central获得，只需像任何其他库一样添加到应用程序的类路径中。

## 1.10 类路径扫描和管理组件
本章中的大多数示例都使用XML来指定BeanDefinition在Spring容器中生成每个元素的配置元数据。上一节（基于注解的容器配置）演示了如何通过源码级别注解提供大量配置元数据。但是，即使在这些示例中，“基本”bean定义也在XML文件中显式定义，而注解仅驱动依赖项注入。本节介绍**通过扫描类路径隐式检测候选组件的选项**。候选组件是与筛选条件匹配的类，并且具有向容器注册的相应bean定义。这消除了使用XML执行bean注册的需要。相反，您可以使用**注解（例如，@Component），AspectJ类型表达式或您自己的自定义筛选条件**来选择哪些类具有向容器注册的bean定义。

> 从Spring 3.0开始，Spring JavaConfig项目提供的许多功能都是核心Spring Framework的一部分。这允许您使用Java而不是使用传统的XML文件来定义bean。看看的`@Configuration`，`@Bean`， `@Import` 和 `@DependsOn` 注解有关如何使用这些新功能的例子。

### 1.10.1 `@Component`和进一步的模板注解
`@Repository` 注解是针对满足的存储库（也被称为数据访问对象或DAO）的角色或者固定型的任何类的标记。此标记的用法之一是异常的自动转换，如 异常转换中所述。

Spring提供了进一步典型注解：`@Component`，`@Service` 和 `@Controller`。`@Component` 是任何Spring管理组件的通用构造型。 `@Repository`，`@Service` 和 `@Controller`是 `@Component` 更具体的用例的专业化（分别在持久层，服务层和表示层）。因此，您可以用 ` @Component `来注解你的组件类，但是，通过 `@Repository`，`@Service` 和 `@Controller`注解它们 ，你的类能更好地被工具处理，或与切面进行关联。例如，这些模板注解成为切入点的理想目标。 `@Repository`，`@Service` 和 `@Controller`还可以在Spring Framework的未来版本中携带其他语义。因此，如果您对于您的服务层在使用`@Component`或者`@Service`之间进行选择，`@Service` 显然是更好的选择。同样，如前所述，`@Repository` 已经支持将其作为持久层中自动异常转换的标记。

### 1.10.2 使用元注解和组合注解
Spring提供的许多注解都可以在您自己的代码中用作`元注解`。元注解是可以应用于另一个注解的注解。例如，前面提及的 `@Service` 注解 使用了元注解 `@Component` ，如下面的示例所示：

``` 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component  1
public @interface Service {

    // ....
}
``` 
1 `@Component` 导致了 `@Service `以 `@Component` 同样的方式处理。

您还可以组合元注解来创建“组合注解”。例如，Spring MVC 的 `@RestController` 的注解由` @Controller `和 `@ResponseBody` 组成。

此外，组合注解可以选择从元注解重新声明属性以允许自定义。当您只想公开元注解属性的子集时，这可能特别有用。例如，Spring的` @SessionScope` 注解将范围名称硬编码为session但仍允许自定义 `proxyMode`。以下清单显示了`SessionScope`注解的定义 ：

``` 
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(WebApplicationContext.SCOPE_SESSION)
public @interface SessionScope {

    /**
     * Alias for {@link Scope#proxyMode}.
     * <p>Defaults to {@link ScopedProxyMode#TARGET_CLASS}.
     */
    @AliasFor(annotation = Scope.class)
    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;

}
``` 

然后您可以使用`@SessionScope`而不声明proxyMode如下：

``` 
@Service
@SessionScope
public class SessionScopedService {
    // ...
}
``` 

您还可以覆盖该值proxyMode，如以下示例所示：

``` 
@Service
@SessionScope(proxyMode = ScopedProxyMode.INTERFACES)
public class SessionScopedUserService implements UserService {
    // ...
}
``` 
有关更多详细信息，请参阅 `Spring Annotation Programming Model` wiki页面。

### 1.10.3 自动检测类和注册Bean定义
Spring可以自动检测构造型类并用` ApplicationContext `注册相应的 `BeanDefinition` 实例。例如，以下两个类符合此自动检测类的条件：

``` 
@Service
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Autowired
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
``` 

``` 
@Repository
public class JpaMovieFinder implements MovieFinder {
    // implementation elided for clarity
}
``` 

要自动检测这些类并注册相应的bean，您需要添加` @ComponentScan`到您的 `@Configuration`类，其中该`basePackages`属性是两个类的公共父包。（或者，您可以指定包含每个类的父包 的逗号或分号或空格分隔列表。）

```
@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig  {
    ...
}
```

为简洁起见，前面的示例可能使用`value` 注解的属性（即 `@ComponentScan("org.example")`）。
以下替代方法使用XML：

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="org.example"/>

</beans>
```

使用`<context:component-scan>` 隐式启用 `<context:annotation-config>` 功能 。当使用 `<context:component-scan>` 时通常不需要包含 `<context:annotation-config>` 元素。

> 扫描类路径包需要在类路径中存在相应的目录条目。使用Ant构建JAR时，请确保不要激活JAR任务的文件开关。此外，在某些环境中，基于安全策略可能不会暴露类路径目录 - 例如，JDK 1.7.0_45及更高版本上的独立应用程序（需要在清单中设置“Trusted-Library” - 请参阅 https://stackoverflow.com/ questions / 19394570 / java-jre-7u45-breaks-classloader-getresources）。

> 在JDK 9的模块路径（Jigsaw）上，Spring的类路径扫描通常按预期工作。但是，请确保在 `module-info` 描述符中导出组件类。如果您希望Spring调用类的非公共成员，请确保它们已“打开”（即，它们在描述符中使用`opens`声明而不是 `exports` 声明 `module-info`）。

此外，当您使用`component-scan`元素时，隐式包含 `AutowiredAnnotationBeanPostProcessor` 和 `CommonAnnotationBeanPostProcessor`。这意味着这两个组件是自动检测并连接在一起的 - 所有这些都没有在XML中提供任何bean配置元数据。

您可以通过包含`annotation-config`值为的属性 `false` 禁用 `AutowiredAnnotationBeanPostProcessor` 和 `CommonAnnotationBeanPostProcessor` 注册。

### 1.10.4。使用过滤器进行自定义扫描
默认情况下，类有 `@Component`，`@Repository`，`@Service`，`@Controller`， `@Configuration` 等注解或者本身都标注有一个自定义的注解 `@Component` 是唯一检测到的候选组件。但是，您可以通过应用自定义筛选器来修改和扩展此行为。在 `@ComponentScan` 注解上添加为 `includeFilters` 或 `excludeFilters` 的属性（或者在XML配置中  作为`<context:component-scan>` 的`<context:include-filter />` 或 `<context:exclude-filter />` 所述的子元素）。每个过滤器元素都需要` type` 和` expression `属性。下表介绍了过滤选项：

表5.过滤器类型

过滤器类型|示例表达|描述
:---:|:---:|:---:
annotation (default)/注解（默认）|org.example.SomeAnnotation|在目标组件中的类型级别存在或元数据存在的注解
assignable/分配|org.example.SomeClass|目标组件可分配给（扩展或实现）的类（或接口）
AspectJ|org.example..*Service+|由目标组件匹配的AspectJ类型表达式。
正则表达式|`org\.example\.Default.*`|由目标组件的类名匹配的正则表达式。
custom/自定义|org.example.MyTypeFilter|org.springframework.core.type.TypeFilter接口的自定义实现。

以下示例显示忽略所有 `@Repository` 注解并使用“stub/存根”存储库的配置：

```
@Configuration
@ComponentScan(basePackages = "org.example",
        includeFilters = @Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository"),
        excludeFilters = @Filter(Repository.class))
public class AppConfig {
    ...
}
```

以下清单显示了等效的XML：

```
<beans>
    <context:component-scan base-package="org.example">
        <context:include-filter type="regex"
                expression=".*Stub.*Repository"/>
        <context:exclude-filter type="annotation"
                expression="org.springframework.stereotype.Repository"/>
    </context:component-scan>
</beans>
```

您还可以通过设置`useDefaultFilters=false` 注解或提供元素`use-default-filters="false"`属性来 禁用默认过滤器`<component-scan/>`。这样有效地禁止类注解的自动检测或使用 `@Component`，`@Repository`，`@Service`，`@Controller`，` @RestController`或 `@Configuration` 元注解。

### 1.10.5 在组件中定义 Bean 元数据
Spring组件还可以向容器提供bean定义元数据。您可以在 `@Configuration` 注解的类中用相同的` @Bean` 注解使用用于定义bean元数据上执行此操作。以下示例显示了如何执行此操作：

```
@Component
public class FactoryMethodComponent {

    @Bean
    @Qualifier("public")
    public TestBean publicInstance() {
        return new TestBean("publicInstance");
    }

    public void doWork() {
        // Component method implementation omitted
    }
}
```

前面的类是一个Spring组件，在 `doWork()` 方法中具有特定于应用程序的代码 。但是，它还提供了一个bean定义，该定义具有引用该方法的工厂方法publicInstance()。该@Bean注解标识工厂方法和其它bean定义特性，如通过一个限定值 `@Qualifier` 注解。可以使用` @Scope`，`@Lazy`和自定义限定器注解指定其他方法级别。

> 除了组件初始化的作用外，您还可以将 `@Lazy` 注解放在标有 `@Autowired`或`@Inject`的注入点上。在这种情况下，它会导致惰性解析代理注入。

如前所述，支持自动装配的字段和方法，以及额外支持对 @Bean方法的自动装配。以下示例显示了如何执行此操作：

```
@Component
public class FactoryMethodComponent {

    private static int i;

    @Bean
    @Qualifier("public")
    public TestBean publicInstance() {
        return new TestBean("publicInstance");
    }

    // use of a custom qualifier and autowiring of method parameters
    @Bean
    protected TestBean protectedInstance(
            @Qualifier("public") TestBean spouse,
            @Value("#{privateInstance.age}") String country) {
        TestBean tb = new TestBean("protectedInstance", 1);
        tb.setSpouse(spouse);
        tb.setCountry(country);
        return tb;
    }

    @Bean
    private TestBean privateInstance() {
        return new TestBean("privateInstance", i++);
    }

    @Bean
    @RequestScope
    public TestBean requestScopedInstance() {
        return new TestBean("requestScopedInstance", 3);
    }
}
```

该示例将` String ` 方法参数`country` 自动装配另一个名为 `privateInstance` 的bean 的` age`值的属性中。Spring Expression Language元素通过符号 `#{ <expression> }` 定义属性的值。对于 `@Value` 注解，表达式解析器预先配置为在解析表达式文本时查找bean名称。

从Spring Framework 4.3开始，您还可以声明 `InjectionPoint `类型的工厂方法参数 （或其更具体的子类:`DependencyDescriptor`)，以获取触发当前bean创建的请求注入点。请注意，这仅适用于实例创建bean实例，而不适用于注入现有实例。因此，此功能对原型范围的bean最有意义。对于其他作用域，工厂方法只能看到在给定作用域中 触发创建新Bean实例的注入点（例如，触发创建惰性单例bean的依赖项）。在这种情况下，您可以使用提供的注入点元数据和语义关注。以下示例显示了如何使用 `InjectionPoint`：

```
@Component
public class FactoryMethodComponent {
    @Bean @Scope("prototype")
    public TestBean prototypeInstance(InjectionPoint injectionPoint) {
        return new TestBean("prototypeInstance for " + injectionPoint.getMember());
    }
}
```

在普通的Spring组件的 `@Bean` 方法 比 Spring 内部的 `@Configuration`类处理方式不同。不同之处在于 `@Component` ，`CGLIB` 不会增强类来拦截方法和字段的调用。CGLIB代理是调用 `@Configuration` 类中 @Bean方法中的方法或字段 创建对协作对象的bean元数据引用的方法。这些方法不是用普通的Java语义调用的，而是**通过容器来提供通常的生命周期管理和Spring bean的代理**，即使在通过对 `@Bean` 方法的编程调用引用其他bean时也是如此。相反，在清晰的 @Component 类中的 `@Bean` 方法中 调用方法或字段有标准的Java语义，没有特殊的CGLIB处理或其他约束应用。

> 您可以将` @Bean `方法声明为`static`，允许在不创建包含配置类作为实例的情况下调用它们。这在定义后处理器bean（例如，类型 `BeanFactoryPostProcessor` 或 `BeanPostProcessor`）时特别有意义，因为这样的bean在容器生命周期的早期就会初始化，并且应该避免在那时触发配置的其他部分。

> 由于技术限制，对静态 `@Bean` 方法的调用永远不会被容器拦截，甚至在 `@Configuration` 类中也不会被拦截（如本节前面所述）：CGLIB子类化只能覆盖**非静态方法**。因此，直接调用另一个 `@Bean`方法具有标准的Java语义，从而导致直接从工厂方法本身返回一个独立的实例。

> 方法的Java语言可见性 `@Bean` 不会立即影响Spring容器中的结果bean定义。您可以根据自己的需要在非 `@Configuration`类中自由声明工厂方法，也可以在任何地方自由声明静态方法。但是，类中的常规@Bean方法@Configuration需要可以覆盖 - 也就是说，它们不能声明为private或final。

> `@Bean` 还可以在给定组件或配置类的基类上以及在由组件或配置类实现的接口中声明的Java 8缺省方法上发现方法。这使得在编写复杂的配置安排时具有很大的灵活性，从Spring 4.2开始，甚至可以通过Java 8默认方法实现多重继承。

> 最后，单个类可以 `@Bean` 为同一个bean 保存多个方法，作为根据运行时可用依赖性使用多个工厂方法的安排。这与在其他配置方案中选择“最贪婪”构造函数或工厂方法的算法相同：在构造时选择具有最多可满足依赖项的变体，类似于容器在多个@Autowired构造函数之间进行选择的方式。

### 1.10.6 命名自动检测的组件
当组件作为扫描过程的一部分自动检测时，其bean名称由该扫描程序已知的 `BeanNameGenerator` 策略生成。默认情况下，任何Spring刻板印象注解（`@Component`，`@Repository`，`@Service`，和`@Controller` ）包含一个属性名 `value`，从而提供了名字相应的bean定义。

如果此类注解不包含任何名称value或任何其他检测到的组件（例如自定义过滤器发现的那些组件），则默认的bean名称生成器将返回未大写的非限定类名称。例如，如果检测到以下组件类，则名称将为：`myMovieLister` 和 `movieFinderImpl`：

```
@Service("myMovieLister")
public class SimpleMovieLister {
    // ...
}
```
```
@Repository
public class MovieFinderImpl implements MovieFinder {
    // ...
}
```

如果您不想依赖默认的bean命名策略，则可以提供自定义bean命名策略。首先，实现 BeanNameGenerator 接口，并确保包含默认的无参数构造函数。然后，在配置扫描程序时提供完全限定的类名，如以下示例注解和bean定义所示：

```
@Configuration
@ComponentScan(basePackages = "org.example", nameGenerator = MyNameGenerator.class)
public class AppConfig {
    ...
}
```

```
<beans>
    <context:component-scan base-package="org.example"
        name-generator="org.example.MyNameGenerator" />
</beans>
```
作为一般规则，考虑在其他组件可能对其进行显式引用时使用指定名称注解。另一方面，只要容器负责连接，自动生成的名称就足够了。

1.10.7。为自动检测组件提供范围
与Spring管理的组件一样，自动检测组件的默认和最常见的范围是`singleton`。但是，有时您需要一个可以由 `@Scope` 注解指定的不同范围。您可以在注解中提供范围的名称，如以下示例所示：

```
@Scope("prototype")
@Repository
public class MovieFinderImpl implements MovieFinder {
    // ...
}
```

> `@Scope`注解仅在具体bean类（对于带注解的组件）或工厂方法（对于`@Bean`方法）上进行了内省。与XML bean定义相比，没有bean定义继承的概念，类级别的继承层次结构与元数据的意图无关。

有关特定于Web的范围（如Spring上下文中的“request”或“session”）的详细信息，请参阅请求，会话，应用程序和WebSocket范围。与这些范围的预构建注解一样，您也可以使用Spring的元注解方法编写自己的范围注解：例如，自定义注解元注解@Scope("prototype")，可能还声明自定义范围代理模式。

> 要为范围解析提供自定义策略而不是依赖基于注解的方法，您可以实现 `ScopeMetadataResolver` 接口。请确保包含默认的无参数构造函数。然后，您可以在配置扫描程序时提供完全限定的类名，如下注解和bean定义示例展示的：

```
@Configuration
@ComponentScan(basePackages = "org.example", scopeResolver = MyScopeResolver.class)
public class AppConfig {
    ...
}
```

```
<beans>
    <context:component-scan base-package="org.example" scope-resolver="org.example.MyScopeResolver"/>
</beans>
```

使用某些非单例作用域时，可能需要为作用域对象生成代理。这种推理在Scoped Beans中描述为Dependencies。为此，component-scan元素上提供了scoped-proxy属性。三个可能的值是：no，interfaces，和targetClass。例如，以下配置导致标准JDK动态代理：

```
@Configuration
@ComponentScan(basePackages = "org.example", scopedProxy = ScopedProxyMode.INTERFACES)
public class AppConfig {
    ...
}
```
```
<beans>
    <context:component-scan base-package="org.example" scoped-proxy="interfaces"/>
</beans>
```

### 1.10.8 使用注解提供限定符元数据
在`@Qualifier`注解中讨论 与基于注解微调的自动连接。该部分中的示例演示了@Qualifier在解析自动线候选时使用注解和自定义限定符注解来提供细粒度控制。因为这些示例基于XML bean定义，所以通过使用XML中bean元素的子元素的qualifier或meta元素在候选bean定义上提供限定符元数据。当依靠类路径扫描来自动检测组件时，可以在候选类上为类型级注解提供限定符元数据。以下三个示例演示了此技术：

```
@Component
@Qualifier("Action")
public class ActionMovieCatalog implements MovieCatalog {
    // ...
}
```
```
@Component
@Genre("Action")
public class ActionMovieCatalog implements MovieCatalog {
    // ...
}
```
```
@Component
@Offline
public class CachingMovieCatalog implements MovieCatalog {
    // ...
}
```

与大多数基于注解的备选方案一样，请记住注解元数据绑定到类定义本身，而使用 XML 允许多个相同类型的bean在其限定符元数据中提供变体，因为每个元数据都是按照 - 实例而不是每个类。

### 1.10.9 生成候选组件索引
虽然类路径扫描速度非常快，但可以通过在 **编译时创建候选的静态列表** 来提高大型应用程序的`启动性能`。在此模式下，所有作为组件扫描目标的模块都必须使用此机制。

> 现有`@ComponentScan` 或 `<context:component-scan>` 指令必须保持原样，以请求上下文扫描某些包中的候选项。当 `ApplicationContext`检测到这样的索引时，它会自动使用它而不是扫描类路径。

要生成索引，请为包含组件扫描指令对象的组件的每个模块添加其他依赖项。以下示例显示了如何使用 Maven 执行此操作：

```
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context-indexer</artifactId>
        <version>5.2.0.BUILD-SNAPSHOT</version>
        <optional>true</optional>
    </dependency>
</dependencies>
```

对于Gradle 4.5及更早版本，应在 `compileOnly` 配置中声明依赖项，如以下示例所示：

```
dependencies {
    compileOnly "org.springframework:spring-context-indexer:5.2.0.BUILD-SNAPSHOT"
}
```

使用Gradle 4.6及更高版本时，应在 `annotationProcessor` 配置中声明依赖项，如以下示例所示：

```
dependencies {
    annotationProcessor "org.springframework:spring-context-indexer:5.2.0.BUILD-SNAPSHOT"
}
```

该进程生成一个 `META-INF/spring.components`包含在jar文件中的文件。

在IDE中使用此模式时，`spring-context-indexer` 必须将其注册为注解处理器，以确保在更新候选组件时索引是最新的。
在类路径中找到 `META-INF/spring.components` 时，将自动启用索引。如果索引部分可用一些库（或用例），但整个应用程序无法建立，可以通过设置 `spring.index.ignore` 为 true 回退到普通类路径安排（好像没有索引存在的话），无论是作为一个系统属性或类路径根目录下的 `spring.properties` 文件。

## 1.11 使用JSR 330标准注解
从Spring 3.0开始，Spring提供对JSR-330标准注解（依赖注入）的支持。这些注解的扫描方式与Spring注解相同。要使用它们，您需要在类路径中包含相关的jar。

> 如果您使用Maven，则可在标准Maven存储库中找到 `javax.inject` 工件（ https://repo1.maven.org/maven2/javax/inject/javax.inject/1/）。您可以将以下依赖项添加到文件pom.xml：

> 
```
<dependency>
    <groupId>javax.inject</groupId>
    <artifactId>javax.inject</artifactId>
    <version>1</version>
</dependency>
```
> 

### 1.11.1 用 `@Inject` 和 `@Named` 依赖注入
而不是 `@Autowired` s，您可以使用 `@javax.inject.Inject` 如下：

```
import javax.inject.Inject;

public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void listMovies() {
        this.movieFinder.findMovies(...);
        ...
    }
}
```

与 `@Autowired` 一样，您可以将 `@Inject` 用在字段级别，方法级别和构造函数 参数级别。此外，您可以将注入点声明为` Provider`，允许按需访问较短范围的bean或通过 `Provider.get()`调用对其他bean进行延迟访问。以下示例提供了上述示例的变体：

```
import javax.inject.Inject;
import javax.inject.Provider;

public class SimpleMovieLister {

    private Provider<MovieFinder> movieFinder;

    @Inject
    public void setMovieFinder(Provider<MovieFinder> movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void listMovies() {
        this.movieFinder.get().findMovies(...);
        ...
    }
}
```

如果要为注入的依赖项使用限定名称，则应使用`@Named`注解，如以下示例所示：

```
import javax.inject.Inject;
import javax.inject.Named;

public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(@Named("main") MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
```

与 `@Autowired` 一样，`@Inject`也可以与`java.util.Optional`或 `@Nullable` 一起使用。这更适用于此，因为`@Inject`没有`required`属性。以下一对示例显示了如何使用`@Inject`和 `@Nullable`：

```
public class SimpleMovieLister {

    @Inject
    public void setMovieFinder(Optional<MovieFinder> movieFinder) {
        ...
    }
}
```

```
public class SimpleMovieLister {

    @Inject
    public void setMovieFinder(@Nullable MovieFinder movieFinder) {
        ...
    }
}
```

### 1.11.2 `@Named`和 `@ManagedBean`：`@Component`注解的标准等价物
若不使用 `@Component`，您可以使用 `@javax.inject.Named`或 `javax.annotation.ManagedBean` 代替，如下例所示：

```
import javax.inject.Inject;
import javax.inject.Named;

@Named("movieListener")  // @ManagedBean("movieListener") could be used as well
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
```

`@Component` 不指定组件名称的情况下使用是很常见的。` @Named` 可以以类似的方式使用，如以下示例所示：

```
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Inject
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}
```

使用`@Named`或 `@ManagedBean` 时，可以使用与使用Spring注解时完全相同的方式使用组件扫描，如以下示例所示：

```
@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig  {
    ...
}
```

与`@Component`相反，JSR-330` @Named`和JSR-250 `ManagedBean `注解不可组合。您应该使用Spring的构造型模型来构建自定义组件注解。

### 1.11.3 JSR-330标准注解的局限性
使用标准注解时，您应该知道某些重要功能不可用，如下表所示：

表6. Spring组件模型元素与JSR-330变体

Spring	|javax.inject。*	|javax.inject restrictions / comments 限制/评论
:---:|:---:|:---:
@Autowired|@Inject|@Inject没有“required”属性。可以与Java 8一起使用`Optional`。
@Component|@Named / @ManagedBean|JSR-330不提供可组合模型，只是一种识别命名组件的方法。
@Scope("singleton")|@Singleton|JSR-330的默认范围就像Spring一样prototype。但是，为了使其与Spring的一般默认值保持一致，singleton默认情况下在Spring容器中声明的JSR-330 bean是一个默认值。为了使用除以外的范围singleton，您应该使用Spring的 `@Scope` 注解。javax.inject还提供了` @Scope`注解。然而，这个仅用于创建自己的注解。
@Qualifier|@Qualifier / @Named|javax.inject.Qualifier只是构建自定义限定符的元注解。具体String限定符（如@Qualifier带有值的Spring ）可以通过关联javax.inject.Named。
@Value| ——|没有等价物
@Required| ——|没有等价物
@Lazy| ——|没有等价物
ObjectFactory|Providerjavax.inject.Provider是Spring的直接替代品ObjectFactory，只有较短的get()方法名称。它也可以与Spring @Autowired或非注解构造函数和setter方法结合使用。

## 1.12 基于Java的容器配置
本节介绍如何在Java代码中使用注解来配置Spring容器。它包括以下主题：

* 基本概念：@Bean和@Configuration

* 使用 `AnnotationConfigApplicationContext` 实例化Spring容器 
 
* 使用`@Bean`注解
 
* 使用`@Configuration`注解
 
* 基于Java编写配置
 
* Bean定义配置文件
 
* PropertySource 抽象化
 
* 运用 `@PropertySource`
 
* Statements/声明中的占位符解析

### 1.12.1 基本概念：`@Bean` 和 `@Configuration`
Spring的新Java配置支持中的中心组成是 `@Configuration`注解类和 `@Bean`注解方法。

`@Bean` 注解被用于指示一个方法实例，配置和初始化为 Spring IoC容器进行管理的新对象。对于那些熟悉Spring的`<beans/>` XML配置的人来说，`@Bean`注解与`<bean/>`元素扮演的角色相同。你可以在任何使用了 `@Component`的Spring中使用 `@Bean` 来注解方法 。但是，它们最常用于 `@Configuration` bean。

对带有 `@Configuration` 的类进行注解表明其主要目的是作为bean定义的来源。此外，`@Configuration` 类允许通过在同一类中调用 `@Bean` 的其他方法来定义bean间依赖关系。最简单的`@Configuration`类如下：

```
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

上面的`AppConfig`类等效于以下Spring `<beans/>` XML：

```
<beans>
    <bean id="myService" class="com.acme.services.MyServiceImpl"/>
</beans>
```

#### 完整`@Configuration` vs `“lite” @Bean ` 模式？
> 当`@Bean`在没有 `@Configuration`注解的类中声明方法时 ，它们被称为以“精简”模式处理。在一个@Component或甚至在一个普通的旧类中声明的Bean方法被认为是“精简”，包含类的主要目的不同，并且@Bean方法在那里是一种奖励。例如，服务组件可以通过@Bean每个适用组件类的附加方法将管理视图公开给容器。在这种情况下，@Bean方法是通用的工厂方法机制。

>与完整`@Configuration`不同，`lite @Bean`方法不能声明bean间依赖关系。相反，它们对其包含组件的内部状态进行操作，并且可选地，对它们可以声明的参数进行操作。因此 `@Bean` 方法不应该引用其他 `@Bean`方法。每个这样的方法实际上只是特定bean引用的工厂方法，没有任何特殊的运行时语义。这里的积极副作用是不必在运行时应用CGLIB子类，因此在类设计方面没有限制（也就是说，包含类可能是`final`等等）。

>在常见的场景中，`@Bean` 方法将在`@Configuration`类中声明，确保始终使用“完整”模式，并因此将交叉方法引用重定向到容器的生命周期管理。这可以防止`@Bean` 通过常规Java调用意外地调用相同的方法，这有助于减少在“精简”模式下操作时难以跟踪的细微错误。

>【结论】建议使用完整的`@Configuration`

在以下章节中讨论`@Bean`和`@Configuration`注解的深度介绍。首先，我们将介绍使用基于Java的配置创建 Spring容器的各种方法。

### 1.12.2 `使用 AnnotationConfigApplicationContext `实例化Spring容器
以下部分介绍了在Spring 3.0中引入的Spring `AnnotationConfigApplicationContext`。这种通用 `ApplicationContext `实现不仅能够接受`@Configuration`类作为输入，还能接受使用JSR-330元数据 `@Component` 注解的类和普通类。

当`@Configuration`提供类作为输入时，`@Configuration`类本身被注册为bean定义，并且`@Bean`类中的所有声明的方法也被注册为bean定义。

当@Component和JSR-330类被提供时，它们被注册为bean定义，并且假定DI元数据 例如`@Autowired`或`@Inject`在必要时在这些类中使用。

#### 简单构造
`ClassPathXmlApplicationContext` 与实例化 Spring XML文件时用作输入的方式大致相同，可以在实例化`AnnotationConfigApplicationContext` 时使用 `@Configuration` 作为输入。这允许完全无XML使用Spring容器，如以下示例所示：

```
public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
}
```

如前所述，`AnnotationConfigApplicationContext`并不仅限于使用`@Configuration`类。`@Component` 或 JSR-330带注解的类也可以作为输入提供给构造函数，如以下示例所示：

```
public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(MyServiceImpl.class, Dependency1.class, Dependency2.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
}
```

前面的例子中假定`MyServiceImpl，Dependency1以及Dependency2` 使用Spring依赖注入注解，例如`@Autowired`。

#### 使用` register(Class<?>…​)` 编程方式构建容器 
您可以使用无参构造函数实例化一个 `AnnotationConfigApplicationContext`，然后使用 `register()` 方法对其进行配置。这种方法在以编程方式构建 `AnnotationConfigApplicationContext `时特别有用。以下示例显示了如何执行此操作：

```
public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(AppConfig.class, OtherConfig.class);
    ctx.register(AdditionalConfig.class);
    ctx.refresh();
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
}
```

#### 使用 ` scan(String…​) `启用组件扫描
要启用组件扫描，您可以按如下方式注解您的 `@Configuration`类：

```
@Configuration
@ComponentScan(basePackages = "com.acme")  1
public class AppConfig  {
    ...
}
```

1 此注解可启用组件扫描。

> 有经验的Spring用户可能熟悉与Spring context:命名空间等效的XML声明，如下例所示：

> ```
<beans>
    <context:component-scan base-package="com.acme"/>
</beans>
> ```

在前面的示例中，`com.acme`包被扫描以查找任何有` @Component`注解的类，并将这些类注册为容器中的Spring bean定义。`AnnotationConfigApplicationContext` 暴露 `scan(String…​)`方法以允许相同的组件扫描功能，如以下示例所示：

```
public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.acme");
    ctx.refresh();
    MyService myService = ctx.getBean(MyService.class);
}
```

请记住，`@Component` 是 `@Configuration类` 的元注解 ，因此它们是组件扫描的候选者。在前面的示例中，假设AppConfig在com.acme包（或下面的任何包）中声明了它，它在调用期间被扫描 `scan()` 之后`refresh()`，它的所有 `@Bean `方法都被处理并在容器中注册为bean定义。

#### 支持Web应用程序的 `AnnotationConfigWebApplicationContext`
`AnnotationConfigWebApplicationContext` 是可用的 `WebApplicationContext`变体。在配置Spring servlet侦听器，Spring MVC等时 ，可以使用此实现。以下代码段配置典型的Spring MVC Web应用程序（请注意 `contextClass `context-param和init-param的使用）：

```
<web-app>
    <!-- Configure ContextLoaderListener to use AnnotationConfigWebApplicationContext
        instead of the default XmlWebApplicationContext -->
    <context-param>
        <param-name>contextClass</param-name>
        <param-value>
            org.springframework.web.context.support.AnnotationConfigWebApplicationContext
        </param-value>
    </context-param>

    <!-- Configuration locations must consist of one or more comma- or space-delimited
        fully-qualified @Configuration classes. Fully-qualified packages may also be
        specified for component-scanning -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>com.acme.AppConfig</param-value>
    </context-param>

    <!-- Bootstrap the root application context as usual using ContextLoaderListener -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- Declare a Spring MVC DispatcherServlet as usual -->
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- Configure DispatcherServlet to use AnnotationConfigWebApplicationContext
            instead of the default XmlWebApplicationContext -->
        <init-param>
            <param-name>contextClass</param-name>
            <param-value>
                org.springframework.web.context.support.AnnotationConfigWebApplicationContext
            </param-value>
        </init-param>
        <!-- Again, config locations must consist of one or more comma- or space-delimited
            and fully-qualified @Configuration classes -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>com.acme.web.MvcConfig</param-value>
        </init-param>
    </servlet>

    <!-- map all requests for /app/* to the dispatcher servlet -->
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/app/*</url-pattern>
    </servlet-mapping>
</web-app>
```

### 1.12.3 使用`@Bean`注解
`@Bean`是方法级注解和`XML <bean/>`元素的直接模拟。注解支持一些`<bean/>`提供的属性，例如：`* init-method * destroy-method * autowiring * name`。

您可以在带`@Configuration` 或带 `@Component`注解的类中使用`@Bean`注解。

#### 声明一个Bean
要声明bean，可以使用注解`@Bean` 注解方法。您可以使用此方法在 `ApplicationContext` 指定为方法的返回值的类型中注册为bean定义。**默认情况下，bean名称与方法名称相同**。以下示例显示了`@Bean`方法声明：

```
@Configuration
public class AppConfig {

    @Bean
    public TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}
```

上述配置与以下Spring XML完全等效：

```
<beans>
    <bean id="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```

这两个声明都在`ApplicationContext`中将一个名为`transferService` 的bean绑定到 `TransferServiceImpl`类型的对象实例，如下图所示：

```
transferService  - > com.acme.TransferServiceImpl
```

您还可以使用接口（或基类）声明您的`@Bean`方法返回类型，如以下示例所示：

```
@Configuration
public class AppConfig {

    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
}
```

但是，这会将父级类型预测的可见性限制为指定的接口类型（`TransferService`）。然后，只使用容器已知的完整类型（`TransferServiceImpl`）一次，就会实例化受影响的单例bean。非延迟单例bean根据其声明顺序进行实例化，因此您可能会看到不同的类型匹配结果，具体取决于另一个组件何时尝试通过非声明类型进行匹配（例如`@Autowired` `TransferServiceImpl`，只有`transferService`在实例化bean之后才会解析）。

> 如果您始终通过声明的服务接口引用您的类型，则您的` @Bean`返回类型可以安全地加入该设计决策。但是，对于实现多个接口的组件或可能由其实现类型引用的组件，更可能声明可能的最具体的返回类型（至少与引用您的bean的注入点所需的具体相同）。

#### Bean依赖项
带`@Bean` 注解的方法可以有任意数量的参数来描述构建该bean所需的依赖关系。例如，如果我们`TransferService `需要依赖` AccountRepository`，我们可以使用方法参数来实现该依赖关系，如下例所示：

```
@Configuration
public class AppConfig {

    @Bean
    public TransferService transferService(AccountRepository accountRepository) {
        return new TransferServiceImpl(accountRepository);
    }
}
```

解析机制与基于构造函数的依赖注入非常相似。有关详细信息，请参阅相关部分。

#### 接收生命周期回调
使用@Bean注解定义的任何类都支持常规生命周期回调，并且可以使用JSR-250中的注解`@PostConstruct`和`@PreDestroy`注解。有关更多详细信息，请参阅 JSR-250注解。

完全支持常规的Spring 生命周期回调。如果bean实现`InitializingBean`，`DisposableBean`或者`Lifecycle`，它们各自的方法由容器调用。

还完全支持标准`*Aware`接口集（例如`BeanFactoryAware， BeanNameAware， MessageSourceAware， ApplicationContextAware`等）。

`@Bean`注解支持指定任意初始化和销毁回调方法，就像Spring XML的bean元素 的 `init-method` 和 `destroy-method` 属性，如下例所示：

```
public class BeanOne {

    public void init() {
        // initialization logic
    }
}

public class BeanTwo {

    public void cleanup() {
        // destruction logic
    }
}

@Configuration
public class AppConfig {

    @Bean(initMethod = "init")
    public BeanOne beanOne() {
        return new BeanOne();
    }

    @Bean(destroyMethod = "cleanup")
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }
}
```

> 默认情况下，使用Java配置定义的具有公共 `close`或`shutdown` 方法的bean 会自动使用销毁回调注册。如果您有公共 `close`或`shutdown` 方法，并且您不希望在容器关闭时调用它，则可以添加`@Bean(destroyMethod="")`到bean定义以禁用默认(`inferred`)模式。

> 对于使用JNDI获取的资源，您可能希望默认执行此操作，因为其生命周期在应用程序之外进行管理。特别是，确保始终为一个 `DataSource`执行此操作，因为已知它在Java EE应用程序服务器上存在问题。

> 以下示例显示如何防止对 `DataSource`自动销毁回调 ：

> ```
@Bean(destroyMethod="")
public DataSource dataSource() throws NamingException {
    return (DataSource) jndiTemplate.lookup("MyDS");
}
> ```

> 此外，使用`@Bean`方法，您通常使用编程JNDI查找，通过使用Spring `JndiTemplate`或`JndiLocatorDelegate`助手 或直接使用JNDI `InitialContext` 而不是使用`JndiObjectFactoryBean`变量（这将强制您将返回类型声明为`FactoryBean`类型而不是实际对象的类型，使得更难以用于其他 打算在此处引用所提供资源的@Bean方法交叉引用调用。

在BeanOne前面注解中的示例的情况下，在构造期间直接调用 ` init() `方法同样有效，如以下示例所示：

```
@Configuration
public class AppConfig {

    @Bean
    public BeanOne beanOne() {
        BeanOne beanOne = new BeanOne();
        beanOne.init();
        return beanOne;
    }

    // ...
}
```

> 当您直接使用Java工作时，您可以使用对象执行任何您喜欢的操作，并且不必总是依赖于容器生命周期。

#### 指定Bean范围
Spring包含`@Scope`注解，以便您可以指定bean的范围。

#### 使用`@Scope`注解
您可以指定使用`@Bean`注解定义的bean 应具有特定范围。您可以使用**Bean Scopes**部分中指定的任何标准作用域 。

默认范围是`singleton`，但您可以使用`@Scope`注解覆盖它，如以下示例所示：

```
@Configuration
public class MyConfiguration {

    @Bean
    @Scope("prototype")
    public Encryptor encryptor() {
        // ...
    }
}
```

#### @Scope 和 scoped-proxy
Spring提供了一种通过作用域代理处理作用域依赖项的便捷方法 。使用XML配置时创建此类代理的最简单方法是`<aop:scoped-proxy/>`元素。使用`@Scope`注解在Java中配置bean 提供了对`proxyMode`属性的等效支持。默认值为`no proxy（ScopedProxyMode.NO）`，但您可以指定`ScopedProxyMode.TARGET_CLASS`或`ScopedProxyMode.INTERFACES`。

如果将scoped代理示例从XML参考文档（请参阅范围代理）移植使用Java的`@Bean`，它类似于以下内容：

```
// an HTTP Session-scoped bean exposed as a proxy
@Bean
@SessionScope
public UserPreferences userPreferences() {
    return new UserPreferences();
}

@Bean
public Service userService() {
    UserService service = new SimpleUserService();
    // a reference to the proxied userPreferences bean
    service.setUserPreferences(userPreferences());
    return service;
}
```

#### 自定义Bean命名
默认情况下，配置类使用`@Bean`**方法的名称作为结果bean的名称**。但是，可以使用`name`属性覆盖此功能，如以下示例所示：

```
@Configuration
public class AppConfig {

    @Bean(name = "myThing")
    public Thing thing() {
        return new Thing();
    }
}
```

#### Bean 别名
正如命名 Beans中所讨论的，有时需要为单个bean提供多个名称，也称为bean别名。 为此目的，`@Bean`注解的`name`属性接受String数组。以下示例显示如何为bean设置多个别名：

```
@Configuration
public class AppConfig {

    @Bean({"dataSource", "subsystemA-dataSource", "subsystemB-dataSource"})
    public DataSource dataSource() {
        // instantiate, configure and return DataSource bean...
    }
}
```

#### Bean 描述
有时，提供更详细的bean文本描述会很有帮助。当bean（可能通过JMX）进行监视时，这可能特别有用。

要向`@Bean`添加描述，可以使用` @Description` 注解，如以下示例所示：

```
@Configuration
public class AppConfig {

    @Bean
    @Description("Provides a basic example of a bean")
    public Thing thing() {
        return new Thing();
    }
}
```

### 1.12.4 使用`@Configuration`注解
`@Configuration`是一个类级别的注解，指示对象是bean定义的源。`@Configuration`类通过公共`@Bean`注解方法声明bean 。`@Configuration`类上对` @Bean `方法的调用也可用于定义bean间依赖项。请参阅基本概念：`@Bean`和`@Configuration`一般性介绍。

#### 注入bean间依赖关系
当bean彼此依赖时，表达该依赖关系就像让一个bean方法调用另一个bean一样简单，如下例所示：

```
@Configuration
public class AppConfig {

    @Bean
    public BeanOne beanOne() {
        return new BeanOne(beanTwo());
    }

    @Bean
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }
}
```

在前面的示例中，`beanOne`接收对`beanTwo`构造函数注入的引用。

> 这种**声明bean间依赖关系**的`@Bean`方法只有在 `@Configuration` 类中声明方法时才有效。您不能使用普通`@Component`类声明bean间依赖项。

#### 查找方法注入
如前所述，查找方法注入是一项很少使用的高级功能。在单例范围的bean依赖于原型范围的bean的情况下，它很有用。将Java用于此类配置提供了实现此模式的自然方法。以下示例显示如何使用查找方法注入：

```
public abstract class CommandManager {
    public Object process(Object commandState) {
        // grab a new instance of the appropriate Command interface
        Command command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    // okay... but where is the implementation of this method?
    protected abstract Command createCommand();
}
```

通过使用Java配置，您可以创建一个子类，`CommandManager` 中的抽象`createCommand()`方法被覆盖，以便查找新的（原型）命令对象。以下示例显示了如何执行此操作：

```
@Bean
@Scope("prototype")
public AsyncCommand asyncCommand() {
    AsyncCommand command = new AsyncCommand();
    // inject dependencies here as required
    return command;
}

@Bean
public CommandManager commandManager() {
    // return new anonymous implementation of CommandManager with createCommand()
    // overridden to return a new prototype Command object
    return new CommandManager() {
        protected Command createCommand() {
            return asyncCommand();
        }
    }
}
```

#### 有关基于Java的配置如何在内部工作的更多信息
请考虑以下示例，该示例显示了 `@Bean` 注解的方法被调用两次：

```
@Configuration
public class AppConfig {

    @Bean
    public ClientService clientService1() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientService clientService2() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientDao clientDao() {
        return new ClientDaoImpl();
    }
}
```

`clientDao()` 被 `clientService1()` 调用一次和 `clientService2()` 调用一次。由于此方法创建了一个新实例`ClientDaoImpl`并将其返回，因此通常需要两个实例（每个服务一个）。这肯定会有问题：在Spring中，实例化的bean 默认具有` singleton `范围。这就是神奇所在：所有`@Configuration`类都在启动时借助` CGLIB `子类化。在子类中，子方法在调用父方法并创建新实例之前，首先检查容器是否有任何缓存（作用域）bean。

> 根据bean的范围，行为可能会有所不同。我们在这里谈论 singletons。
>
> 从Spring 3.2开始，不再需要将CGLIB添加到类路径中，因为CGLIB类已经在 `org.springframework.cglib` 重新打包并直接包含在`spring-core` JAR中。

> 由于CGLIB在启动时动态添加功能，因此存在一些限制。特别是，配置类不能是 final 。但是，从4.3开始，配置类允许使用任何构造函数，包括使用` @Autowired` 默认注入的单个非默认构造函数声明。
>
> 如果您希望避免任何CGLIB强加的限制，请考虑在非`@Configuration`类上声明您的 `@Bean` 方法（例如，在普通@Component类上）。在 @Bean方法之间的跨方法调用不会被拦截，因此您必须完全依赖于构造函数或方法级别的依赖注入。

### 1.12.5 编写基于Java的配置
Spring的基于Java的配置功能允许您撰写注解，这可以降低配置的复杂性。

#### 使用 `@Import `注解
就像在Spring XML文件中使用 `<import/> `元素来帮助模块化配置一样，`@Import` 注解允许 `@Bean` 从另一个配置类加载定义，如以下示例所示：

```
@Configuration
public class ConfigA {

    @Bean
    public A a() {
        return new A();
    }
}

@Configuration
@Import(ConfigA.class)
public class ConfigB {

    @Bean
    public B b() {
        return new B();
    }
}
```

现在，实例化上下文时不需要同时指定`ConfigA.class`和`ConfigB.class`，只需要` ConfigB` 显式提供，如下例所示：

```
public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);

    // now both beans A and B will be available...
    A a = ctx.getBean(A.class);
    B b = ctx.getBean(B.class);
}
```

这种方法简化了容器实例化，因为只需要处理一个类，而不是要求在构造期间记住可能大量的`@Configuration`类。

> 从Spring Framework 4.2开始，`@Import`还支持引用常规组件类，类似于`AnnotationConfigApplicationContext.register`方法。如果要避免组件扫描，这一点特别有用，可以使用一些配置类作为明确定义所有组件的入口点。

#### 在导入的 `@Bean`定义上注入依赖性
前面的例子有效，但很简单。在大多数实际情况中，bean跨配置类彼此依赖。使用XML时，这不是问题，因为不涉及编译器，并且您可以声明 `ref="someBean"`并信任Spring在容器初始化期间解决它。使用`@Configuration` 类时，Java编译器会对配置模型施加约束，因为对其他bean的引用必须是有效的Java语法。

幸运的是，解决这个问题很简单。正如我们已经讨论过的，一个 `@Bean` 方法可以有任意数量的参数来描述bean的依赖关系。考虑以下更多真实场景​​，其中包含几个 `@Configuration` 类，每个类都依赖于其他类中声明的bean：

```
@Configuration
public class ServiceConfig {

    @Bean
    public TransferService transferService(AccountRepository accountRepository) {
        return new TransferServiceImpl(accountRepository);
    }
}

@Configuration
public class RepositoryConfig {

    @Bean
    public AccountRepository accountRepository(DataSource dataSource) {
        return new JdbcAccountRepository(dataSource);
    }
}

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {

    @Bean
    public DataSource dataSource() {
        // return new DataSource
    }
}

public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
    // everything wires up across configuration classes...
    TransferService transferService = ctx.getBean(TransferService.class);
    transferService.transfer(100.00, "A123", "C456");
}
```

还有另一种方法可以达到相同的效果。请记住，`@Configuration` 类最终只是容器中的另一个bean：这意味着它们可以利用 `@Autowired` 和 `@Value` 注入以实现与任何其他bean相同的功能。

确保以这种方式注入的依赖项只是最简单的类型。`@Configuration类` 在上下文初始化期间很早就处理了，并且强制以这种方式注入依赖项可能会导致意外的过早初始化。尽可能采用基于参数的注入，如前面的示例所示。

另外，要特别注意`BeanPostProcessor` 和 `BeanFactoryPostProcessor` 定义的 @Bean。这些通常应该声明为`static @Bean`方法，不要触发包含配置类的实例化。否则，`@Autowired`和 `@Value`在配置类本身不生效，因为它被作为一个bean实例创建为时尚早。

以下示例显示了如何将一个bean自动连接到另一个bean：

```
@Configuration
public class ServiceConfig {

    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl(accountRepository);
    }
}

@Configuration
public class RepositoryConfig {

    private final DataSource dataSource;

    @Autowired
    public RepositoryConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository(dataSource);
    }
}

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {

    @Bean
    public DataSource dataSource() {
        // return new DataSource
    }
}

public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
    // everything wires up across configuration classes...
    TransferService transferService = ctx.getBean(TransferService.class);
    transferService.transfer(100.00, "A123", "C456");
}
```

> `@Configuration` 仅在Spring Framework 4.3中支持类中的构造函数注入。另请注意，目标bean只定义了一个构造函数则无需指定`@Autowired`。在前面的示例中，`@Autowired` 在 `RepositoryConfig `构造函数上没有必要。

#### 完全符合条件的导入的bean，便于导航
在前面的场景中，使用`@Autowired`效果很好并提供了所需的模块性，但确定声明自动装配的bean定义的确切位置仍然有些模棱两可。例如，作为开发人员查找 `ServiceConfig`，您如何确切地知道 `@Autowired AccountRepository` bean的声明位置？它在代码中并不明确，这种情况可能也还好。请记住， `Spring Tool Suite`提供的工具可以提供图形展示，显示所有内容的连接方式，这可能就是您所需要的。此外，您的Java IDE可以轻松找到该`AccountRepository`类型的所有声明和用法，并快速显示`@Bean`返回该类型的方法的位置。

如果这种歧义是不可接受的，并且您希望从IDE中直接从一个 `@Configuration` 类导航到另一个类，请考虑自行装配配置类本身。以下示例显示了如何执行此操作：

```
@Configuration
public class ServiceConfig {

    @Autowired
    private RepositoryConfig repositoryConfig;

    @Bean
    public TransferService transferService() {
        // navigate 'through' the config class to the @Bean method!
        return new TransferServiceImpl(repositoryConfig.accountRepository());
    }
}
```

在前面的情况中，`AccountRepository`定义的位置是完全明确的。但是，`ServiceConfig`现在与 `RepositoryConfig` 紧紧联系在一起。这是权衡。通过使用基于接口的或基于`@Configuration`类的抽象类，可以在某种程度上减轻这种紧密耦合。请考虑以下示例：

```
@Configuration
public class ServiceConfig {

    @Autowired
    private RepositoryConfig repositoryConfig;

    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl(repositoryConfig.accountRepository());
    }
}

@Configuration
public interface RepositoryConfig {

    @Bean
    AccountRepository accountRepository();
}

@Configuration
public class DefaultRepositoryConfig implements RepositoryConfig {

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository(...);
    }
}

@Configuration
@Import({ServiceConfig.class, DefaultRepositoryConfig.class})  // import the concrete config!
public class SystemTestConfig {

    @Bean
    public DataSource dataSource() {
        // return DataSource
    }

}

public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
    TransferService transferService = ctx.getBean(TransferService.class);
    transferService.transfer(100.00, "A123", "C456");
}
```

现在`ServiceConfig`与具体的 `DefaultRepositoryConfig`松耦合 ，内置的IDE工具仍然有用：您可以轻松获得实现的`RepositoryConfig` 类型层次结构。通过这种方式，导航`@Configuration`类及其依赖关系与导航基于接口的代码的常规过程没有什么不同。

> 如果要影响某些bean的启动创建顺序，可以考虑将它们中的一些声明为`@Lazy`（用于在第一次访问时创建而不是在启动时）或`@DependsOn`某些其他bean（确保在当前bean之前创建特定的其他bean，超出后者的直接依赖的含义）

#### 有条件地包括 `@Configuration`类或 `@Bean`方法
基于某些任意系统状态，有条件地启用或禁用完整 `@Configuration`类或甚至单个`@Bean`方法通常很有用。一个常见的例子是只有在Spring中启用了特定的配置文件时才使用 `@Profile` 注解来激活bean `Environment（` 有关详细信息，请参阅Bean定义配置文件）。

`@Profile` 注解是通过使用一种称为更灵活的注解实际执行 `@Conditional`。`@Conditional` 注解指示特定 `org.springframework.context.annotation.Condition` 实现，应该在一个@Bean被注册前被查询出来。

`Condition`接口的实现提供了一个`matches(…​)方法` 返回true 或 false。例如，以下清单显示了实际的 `Condition` 实现用于 `@Profile`：

```
@Override
public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    if (context.getEnvironment() != null) {
        // Read the @Profile annotation attributes
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Profile.class.getName());
        if (attrs != null) {
            for (Object value : attrs.get("value")) {
                if (context.getEnvironment().acceptsProfiles(((String[]) value))) {
                    return true;
                }
            }
            return false;
        }
    }
    return true;
}
```

有关 `@Conditional` 更多详细信息，请参阅javadoc。

#### 结合Java和XML配置
Spring的`@Configuration`类支持并非旨在成为Spring XML的100％完全替代品。某些工具（如Spring XML命名空间）仍然是配置容器的理想方法。在方便或必要的情况下，您可以选择XML：例如，通过使用“以XML为中心”的方式实例化容器 `ClassPathXmlApplicationContext`，或者通过使用 `AnnotationConfigApplicationContext` 和 `@ImportResource` 注解以“以Java为中心”的方式实例化它。 根据需要导入XML。

#### 以XML为中心的`@Configuration`类的使用
最好引导Spring容器从 XML 并包含 `@Configuration` 类以ad-hoc方式使用。例如，在使用Spring XML的大型现有代码库中，可以根据需要更轻松地创建 `@Configuration` 类，并将其包含在现有XML文件中。在本节的后面部分，我们将介绍`@Configuration`在这种“以XML为中心”的情况下使用类的选项。

#### 将`@Configuration`类声明为普通的Spring `<bean/>`元素
请记住，`@Configuration` 类最终是容器中的bean定义【本质上是一个bean】。在本系列示例中，我们创建了一个名为`@Configuration`的类，`AppConfig`并将其`system-test-config.xml`作为`<bean/>`定义包含在其中。因为 `<context:annotation-config/>`已打开(这样就能确保处理`@Autowired`，`@Configuration`等注解)，容器会识别 @Configuration注解并 正确处理`AppConfig`声明的`@Bean`方法。

以下示例显示了Java中的普通配置类：

```
@Configuration
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository(dataSource);
    }

    @Bean
    public TransferService transferService() {
        return new TransferService(accountRepository());
    }
}
```

以下示例显示了示例`system-test-config.xml`文件的一部分：

```
<beans>
    <!-- enable processing of annotations such as @Autowired and @Configuration -->
    <context:annotation-config/>
    <context:property-placeholder location="classpath:/com/acme/jdbc.properties"/>

    <bean class="com.acme.AppConfig"/>

    <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
</beans>
```

以下示例显示了一个可能的`jdbc.properties`文件：

```
jdbc.url = JDBC：HSQLDB：HSQL：//本地主机/ XDB
jdbc.username = SA
jdbc.password =
```

```
public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/acme/system-test-config.xml");
    TransferService transferService = ctx.getBean(TransferService.class);
    // ...
}
```

> 在`system-test-config.xml`文件中，`AppConfig` `<bean/>`不声明 `id` 元素。虽然这样做是可以接受的，但是没有必要，因为没有其他bean引用它，并且不太可能通过名称从容器中明确地获取它。类似地，`DataSourcebean`只是按类型自动装配，因此id 不严格要求显式bean 。

#### 使用 `<context：component-scan />` 来获取 `@Configuration` 类
因为`@Configuration`带有元注解`@Component`，`@Configuration`注解类自动成为组件扫描的候选者。使用与前一个示例中描述的相同的方案，我们可以重新定义`system-test-config.xml`以利用组件扫描。请注意，在这种情况下，我们不需要显式声明 `<context:annotation-config/>`，因为 `<context:component-scan/> `启用相同的功能。

以下示例显示了已修改的`system-test-config.xml`文件：

```
<beans>
    <!-- picks up and registers AppConfig as a bean definition -->
    <context:component-scan base-package="com.acme"/>
    <context:property-placeholder location="classpath:/com/acme/jdbc.properties"/>

    <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
</beans>
```

#### 带有 `@ImportResource ` 使用XML 以 `@Configuration` 类为中心的 
在以 `@Configuration`类作为配置容器的主要机制的应用程序中，仍然可能需要使用至少一些XML。在这些场景中，您可以根据需要使用和定义尽可能多的`@ImportResource`引入XML。这样做可以实现“以Java为中心”的方法来配置容器并将XML保持在最低限度。以下示例（包括配置类，定义bean的XML文件，属性文件和`main`类）显示了如何使用`@ImportResource`注解来实现根据需要使用XML的“以Java为中心”的配置：

```
@Configuration
@ImportResource("classpath:/com/acme/properties-config.xml")
public class AppConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }
}
```
```
properties-config.xml
<beans>
    <context:property-placeholder location="classpath:/com/acme/jdbc.properties"/>
</beans>
```

```
jdbc.properties
jdbc.url = JDBC：HSQLDB：HSQL：//本地主机/ XDB
jdbc.username = SA
jdbc.password =
```

```
public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    TransferService transferService = ctx.getBean(TransferService.class);
    // ...
}
```

## 1.13 环境抽象
`Environment` 接口是集成在容器模型应用环境的两个关键方面的抽象：profiles/概述 和 properties/属性。

配置文件是仅在给定配置文件处于活动状态时才向容器注册的`Bean`定义的命名逻辑组。可以将Bean分配给配置文件，无论是以XML还是使用注解定义。`Environment`与配置文件相关的对象的作用是确定哪些配置文件（如果有）当前处于活动状态，以及默认情况下哪些配置文件（如果有）应处于活动状态。

属性在几乎所有应用程序中都发挥着重要作用，可能源自各种来源**：属性文件，JVM系统属性，系统环境变量，JNDI，servlet上下文参数，ad-hoc Properties对象，Map对象等**。Environment与属性相关的对象的作用是为用户提供方便的服务接口，用于配置属性源并从中解析属性。

### 1.13.1 Bean定义配置文件
Bean定义配置文件在核心容器中提供了一种机制，允许在不同环境中注册不同的bean。“环境”这个词对不同的用户来说意味着不同的东西，这个功能可以帮助解决许多用例，包括：

* 在 QA 或生产环境中，针对开发中的内存数据源而不是从JNDI查找相同的数据源。

* 仅在将应用程序部署到性能环境时注册监视基础结构。

* 为客户A和客户B部署注册bean提供自定义实现。

考虑实际应用中需要的第一个用例 `DataSource`。在测试环境中，配置可能类似于以下内容：

```
@Bean
public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("my-schema.sql")
        .addScript("my-test-data.sql")
        .build();
}
```

现在考虑如何将此应用程序部署到QA或生产环境中，假设应用程序的数据源已在生产应用程序服务器的JNDI目录中注册。我们的`dataSource `bean现在看起来如下：

```
@Bean(destroyMethod="")
public DataSource dataSource() throws Exception {
    Context ctx = new InitialContext();
    return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
}
```

> 问题是如何根据当前环境在使用这两种变体之间切换。随着时间的推移，Spring用户已经设计了许多方法来完成这项工作，通常依赖于系统环境变量和 `<import/>` 包含` ${placeholder} `令牌的XML 语句的组合，这些令牌根据环境变量的值解析为正确的配置文件路径。`Bean` 定义配置文件是核心容器功能，可为此问题提供解决方案。

如果我们概括了前面的特定于环境的bean定义示例中显示的用例，我们最终需要在某些上下文中注册某些bean定义，而在其他上下文中则不需要。您可以说您希望在情境A中注册特定的bean定义配置文件，在情况B中注册不同的配置文件。我们首先更新配置以反映此需求。

#### 使用 `@Profile`
通过@Profile 注解，您可以指示当一个或多个指定的配置文件处于活动状态时，组件符合注册条件。使用前面的示例，我们可以按如下方式重写 `dataSource` 配置：

```
@Configuration
@Profile("development")
public class StandaloneDataConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:com/bank/config/sql/schema.sql")
            .addScript("classpath:com/bank/config/sql/test-data.sql")
            .build();
    }
}
```

```
@Configuration
@Profile("production")
public class JndiDataConfig {

    @Bean(destroyMethod="")
    public DataSource dataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
}
```

如前所述，对于@Bean方法，您通常选择使用编程JNDI查找，使用Spring的`JndiTemplate/ JndiLocatorDelegatehelper`或  前面显示的直接JNDI `InitialContext` 用法，而不是 `JndiObjectFactoryBean` 变量，这会强制您将返回类型声明为 `FactoryBean` 类型。
配置profile字符串可以包含简单的配置profile名称（例如production）或配置profile表达式。profile表达式允许表达更复杂的概要逻辑（例如，`production & us-east`）。配置profile表达式支持以下运算符：

* !：配置文件的逻辑“not”

* &：配置文件的逻辑“and”
 
* |：配置文件的逻辑“or”

> 在不使用括号时，不能混合使用`&和|`运算符。例如， `production & us-east | eu-central`不是有效的表达式。它必须表达为 `production & (us-east | eu-central)`。

您可以将 `@Profile`用作元注解，以创建自定义组合注解。以下示例定义了一个自定义 `@Production` 注解，您可以将其用作 `@Profile("production")` 的替代品 ：

```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("production")
public @interface Production {
}
```

> 如果`@Configuration`标记了类，则除非一个或多个指定的配置文件处于活动状态，否则将绕过与该类关联的`@Profile`所有`@Bean`方法和 `@Import`注解。如果` @Component`或`@Configuration` 类被标记 `@Profile({"p1", "p2"})`，则除非已激活配置文件'p1'或'p2'，否则不会注册或处理该类。如果给定的配置文件以NOT运算符`（!）`作为前缀，则仅在配置文件未激活时才注册带注解的元素。例如，`@Profile({"p1", "!p2"})`如果配置文件“p1”处于活动状态或配置文件“p2”未激活，则会发生注册。

`@Profile `也可以在方法级别声明只包含配置类的一个特定bean（例如，对于特定bean的替代变体），如以下示例所示：

```
@Configuration
public class AppConfig {

    @Bean("dataSource")
    @Profile("development") 1
    public DataSource standaloneDataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:com/bank/config/sql/schema.sql")
            .addScript("classpath:com/bank/config/sql/test-data.sql")
            .build();
    }

    @Bean("dataSource")
    @Profile("production") 2
    public DataSource jndiDataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
}
```

1 `standaloneDataSource`方法仅在`development`配置文件中可用。
2 `jndiDataSource`方法仅在`production`配置文件中可用。

在 `@Bean`方法上使用`@Profile`，可能会应用特殊方案：对于相同Java方法名称的重载 `@Bean`方法（类似于构造函数重载），`@Profile`需要在所有重载方法上一致地声明条件。如果条件不一致，则只有重载方法中第一个声明的条件才匹配。因此，`@Profile`不能用于选择具有特定参数签名的重载方法。在创建时，Spring的构造函数解析算法遵循同一bean所有工厂方法之间的解析方式。

如果要定义具有不同配置文件条件的备用Bean，请使用通过在同Java方法名称上使用`@Bean` name属性指向相同bean名称，如上例所示。如果参数签名都是相同的（例如，所有变体都具有空参工厂方法），那么这是唯一的方式在第一个地方表示这样一个有效的Java类排列（因为只有一个特定名称和参数签名的方法）。

#### XML Bean定义 profile
XML对应物是`<beans>`元素的`profile`属性。我们之前的示例配置可以在两个XML文件中重写，如下所示：

```
<beans profile="development"
    xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:jdbc="http://www.springframework.org/schema/jdbc"
    xsi:schemaLocation="...">

    <jdbc:embedded-database id="dataSource">
        <jdbc:script location="classpath:com/bank/config/sql/schema.sql"/>
        <jdbc:script location="classpath:com/bank/config/sql/test-data.sql"/>
    </jdbc:embedded-database>
</beans>
```

```
<beans profile="production"
    xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:jee="http://www.springframework.org/schema/jee"
    xsi:schemaLocation="...">

    <jee:jndi-lookup id="dataSource" jndi-name="java:comp/env/jdbc/datasource"/>
</beans>
```

也可以在同一文件中使用避免 `split和nest` <beans/> 元素，如下例所示：

```
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:jdbc="http://www.springframework.org/schema/jdbc"
    xmlns:jee="http://www.springframework.org/schema/jee"
    xsi:schemaLocation="...">

    <!-- other bean definitions -->

    <beans profile="development">
        <jdbc:embedded-database id="dataSource">
            <jdbc:script location="classpath:com/bank/config/sql/schema.sql"/>
            <jdbc:script location="classpath:com/bank/config/sql/test-data.sql"/>
        </jdbc:embedded-database>
    </beans>

    <beans profile="production">
        <jee:jndi-lookup id="dataSource" jndi-name="java:comp/env/jdbc/datasource"/>
    </beans>
</beans>
```

在spring-bean.xsd 限制了使这些元素只能作为文件中的最后一个。这应该有助于提供灵活性，而不会扰乱 XML文件。

> XML副本不支持前面描述的配置文件表达式。但是，可以通过使用!运算符来取反profile。也可以通过嵌套配置文件来应用逻辑`“and”`，如以下示例所示：

```
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:jdbc="http://www.springframework.org/schema/jdbc"
    xmlns:jee="http://www.springframework.org/schema/jee"
    xsi:schemaLocation="...">
    <!-- other bean definitions -->

    <beans profile="production">
        <beans profile="us-east">
            <jee:jndi-lookup id="dataSource" jndi-name="java:comp/env/jdbc/datasource"/>
        </beans>
    </beans>
</beans>
```
> 

> 在前面的示例中，如果两个`production`和 `us-east`配置文件都处于活动状态，则会暴露`dataSource `Bean 。

#### 激活 `profile`
现在我们已经更新了配置，我们仍然需要指示Spring哪个配置文件处于活动状态。如果我们现在开始我们的示例应用程序，我们会看到`NoSuchBeanDefinitionException`抛出，因为容器找不到名为`dataSource`的Spring bean 。

激活配置文件可以通过多种方式完成，但最直接的方法是以编程方式通过`ApplicationContext `对`Environment`提供的API进行操作 。以下示例显示了如何执行此操作：

```
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.getEnvironment().setActiveProfiles("development");
ctx.register(SomeConfig.class, StandaloneDataConfig.class, JndiDataConfig.class);
ctx.refresh();
```

此外，您还可以通过`spring.profiles.active`属性声明性地激活配置文件，该 属性可以通过**系统环境变量，JVM系统属性，web.xml 中的 servlet上下文参数，甚至作为JNDI中的条目来指定**（请参阅`PropertySource` 抽象）。在集成测试中，可以使用 模块中的`@ActiveProfiles`注解声明活动配置文件 `spring-test`（请参阅具有环境配置文件的上下文配置）。

请注意，配置文件不是“either-or”命题。您可以一次激活多个配置文件。以编程方式，您可以用`setActiveProfiles()`方法为多个配置文件提供名称，方法接受`String…​varargs`。以下示例激活多个配置文件

```
ctx.getEnvironment().setActiveProfiles("profile1", "profile2");
```

声明性地，`spring.profiles.active`可以接受以逗号分隔的配置文件名称列表，如以下示例所示：

```
-Dspring.profiles.active="profile1,profile2"
```

#### 默认配置文件
默认配置文件表示默认启用的配置文件。请考虑以下示例：

```
@Configuration
@Profile("default")
public class DefaultDataConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:com/bank/config/sql/schema.sql")
            .build();
    }
}
```

如果没有激活配置文件，则创建该配置`dataSource`文件。您可以将此视为一种为一个或多个bean提供默认定义的方法。如果启用了任何配置文件，则默认配置文件不适用。

您可以通过`setDefaultProfiles()` 方法更改默认的配置文件的名称上`Environment`，或者通过使用 `spring.profiles.default` 属性声明。

### 1.13.2 PropertySource抽象化
Spring的`Environment`抽象提供了对可配置的属性源层次结构的搜索操作。请考虑以下列表：

```
ApplicationContext ctx = new GenericApplicationContext();
Environment env = ctx.getEnvironment();
boolean containsMyProperty = env.containsProperty("my-property");
System.out.println("Does my environment contain the 'my-property' property? " + containsMyProperty);
```

在前面的代码片段中，我们看到了一种向Spring询问是否`my-property`为当前环境定义属性的高级方法。要回答此问题，`Environment`对象将对一组对象执行搜索`PropertySource` 。` PropertySource`是对任何键值对源的简单抽象，Spring `StandardEnvironment` 配置有两个`PropertySource`对象 - 一个表示JVM系统属性集`（System.getProperties()`），另一个表示系统环境变量集（`System.getenv()`）。

> 这些`StandardEnvironment`默认属性源适用于独立应用程序。`StandardServletEnvironment` 填充了其他默认属性源，包括servlet配置和servlet上下文参数。它可以选择启用` JndiPropertySource`。有关详细信息，请参阅javadoc。

具体来说，当您使用时`StandardEnvironment` 的 `env.containsProperty("my-property")`时， 如果运行时存在`my-property`系统属性或`my-property`环境变量，则调用返回true 。

> 执行的搜索是分层的。**默认情况下，系统属性优先于环境变量**。因此，如果`my-property`在调用期间恰好在两个位置都设置了属性 `env.getProperty("my-property")`，则系统属性值“胜出”并返回。请注意，属性值不会合并，而是由前面的条目完全覆盖。

> 对于公共StandardServletEnvironment层次结构，完整层次结构如下，最高优先级条目位于顶部：

> 1. ServletConfig参数（如果适用 - 例如，在DispatcherServlet上下文的情况下）

> 2. ServletContext参数（web.xml context-param条目）

> 3. JNDI环境变量（java:comp/env/条目）

> 4. JVM系统属性（-D命令行参数）

> 5. JVM系统环境（操作系统环境变量）

最重要的是，整个机制是可配置的。您可能希望将自定义的属性源集成到此搜索中。为此，请实现并实例化您自己的PropertySource并将其添加到PropertySources当前的集合中Environment。以下示例显示了如何执行此操作：

```
ConfigurableApplicationContext ctx = new GenericApplicationContext();
MutablePropertySources sources = ctx.getEnvironment().getPropertySources();
sources.addFirst(new MyPropertySource());
```

在上面的代码中，`MyPropertySource`在搜索中添加了最高优先级。如果它包含`my-property`属性，则检测并返回该属性，以支持`PropertySource`任何其他`my-property`属性。所述 `MutablePropertySources` API公开了大量的，允许该组的属性源的精确操作方法。

### 1.13.3 使用 `@PropertySource`
`@PropertySource` 注解提供便利和声明的机制添加 `PropertySource` 到Spring的 `Environment`。

给定一个名为`app.properties`包含键值对`testbean.name=myTestBean`的文件，以下`@Configuration`类使用以下`@PropertySource`方式调用`testBean.getName() 返回` myTestBean`：

```
@Configuration
@PropertySource("classpath:/com/myco/app.properties")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testbean.name"));
        return testBean;
    }
}
```

存在于`@PropertySource`资源位置的任何 `${…​}` 占位符都将被已经被环境注册的属性源集合解析，如以下示例所示：

```
@Configuration
@PropertySource("classpath:/com/${my.placeholder:default/path}/app.properties")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testbean.name"));
        return testBean;
    }
}
```

假设 `my.placeholder`已存在于已注册的其中一个属性源中（例如，系统属性或环境变量），则占位符将解析为相应的值。如果没有，则`default/path`用作默认值。如果未指定默认值且无法解析属性， 则抛出 `IllegalArgumentException`。

> `@PropertySource` 注解是可重复的，根据Java8 的约定。但是，所有这些`@PropertySource`注解都需要在**同一级别声明**，可以直接在配置类上声明，也可以在同一自定义注解中作为元注解声明。不建议混合直接注解和元注解，因为直接注解有效地覆盖了元注解。

### 1.13.4 Statements/声明中的占位符解析
从历史上看，元素中占位符的值只能针对JVM系统属性或环境变量进行解析。这已不再是这种情况。因为`Environment`抽象集成在整个容器中，所以很容易通过它来解决占位符的解析。这意味着您可以以任何您喜欢的方式配置解析过程。您可以更改搜索系统属性和环境变量的优先级，或完全删除它们。您也可以根据需要将自己的属性源添加到混合中。

具体而言，以下语句无论 `customer` 属性的定义位置如何都可以使用，只要它在`Environment`位置可用：

```
<beans>
    <import resource="com/bank/service/${customer}-config.xml"/>
</beans>
```

1.14。注册一个LoadTimeWeaver
在LoadTimeWeaver用于由Spring动态变换的类，因为它们被装载到Java虚拟机（JVM）。

要启用加载时编织，可以将其添加@EnableLoadTimeWeaving到其中一个 @Configuration类中，如以下示例所示：

@Configuration
@EnableLoadTimeWeaving
public class AppConfig {
}
或者，对于XML配置，您可以使用以下context:load-time-weaver元素：

<beans>
    <context:load-time-weaver/>
</beans>
一旦为其中的ApplicationContext任何bean 配置，就ApplicationContext 可以实现LoadTimeWeaverAware，从而接收对加载时weaver实例的引用。这与Spring的JPA支持结合使用特别有用， 其中JPA类转换可能需要加载时编织。有关LocalContainerEntityManagerFactoryBean 更多详细信息，请参阅 javadoc。有关AspectJ加载时编织的更多信息，请参阅Spring Framework中使用AspectJ的加载时编织。

1.15。附加功能ApplicationContext
