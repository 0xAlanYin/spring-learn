# 第16章 使用Spring MVC创建REST API
本章内容：

- 编写处理REST资源的控制器
- 以XML、JSON及其他格式来表述资源
- 使用REST资源

数据为王。

作为开发人员，我们经常关注于构建伟大的软件来解决业务问题。数据只是软件完成工作时要处理的原材料。但是如果你问一下业务人员，数据和软件谁更重要的话，他们很可能会选择数据。数据是许多业务的生命之血。软件通常是可以替换的，但是多年积累的数据是永远不能替换的。

你是不是觉得有些奇怪，既然数据如此重要，为何在开发软件的时候却经常将其视为事后才考虑的事情？以我们前面上一章所介绍的远程服务为例，这些服务是以操作和处理为中心的，而不是信息和资源。

近几年来，以信息为中心的**表述性状态转移（Representational State Transfer，REST）**已成为替换传统SOAP Web服务的流行方案。SOAP一般会关注行为和处理，而REST关注的是要处理的数据。

- **表述性状态转移（Representational State Transfer，REST）**

从Spring 3.0版本开始，Spring为创建REST API提供了良好的支持。Spring的REST实现在Spring 3.1、3.2和如今的4.0版本中不断得到发展。

好消息是Spring对REST的支持是构建在Spring MVC之上的，所以我们已经了解了许多在Spring中使用REST所需的知识。在本章中，我们将基于已了解的Spring MVC知识来开发处理RESTful资源的控制器。但在深入了解细节之前，先让我们看看使用REST到底是什么。

##16.1 了解REST
我敢打赌这并不是你第一次听到或读到REST这个词。近些年来，关于REST已经有了许多讨论，在软件开发中你可能会发现有一种很流行的做法，那就是在推动REST替换SOAP Web服务的时候，会谈论到SOAP的不足。

诚然，对于许多应用程序而言，使用SOAP可能会有些大材小用了，而REST提供了一个更简单的可选方案。另外，很多的现代化应用都会有移动或富JavaScript客户端，它们都会使用运行在服务器上REST API。

问题在于并不是每个人都清楚REST到底是什么。结果就出现了许多误解。有很多打着REST幌子的事情其实并不符合REST真正的本意。在谈论Spring如何支持REST之前，我们需要对REST是什么达成共识。

### 16.1.1 REST的基础知识
当谈论REST时，有一种常见的错误就是将其视为“基于URL的Web服务”——将REST作为另一种类型的远程过程调用（remote procedure call，RPC）机制，就像SOAP一样，只不过是通过简单的HTTP URL来触发，而不是使用SOAP大量的XML命名空间。

恰好相反，REST与RPC几乎没有任何关系。RPC是面向服务的，并关注于行为和动作；而REST是面向资源的，强调描述应用程序的事物和名词。

为了理解REST是什么，我们将它的首字母缩写拆分为不同的构成部分：

- 表述性（Representational）：REST资源实际上可以用各种形式来进行表述，包括XML、JSON（JavaScript Object Notation）甚至HTML——最适合资源使用者的任意形式；
- 状态（State）：当使用REST的时候，我们更关注资源的状态而不是对资源采取的行为；
- 转移（Transfer）：REST涉及到转移资源数据，它以某种表述性形式从一个应用转移到另一个应用。

更简洁地讲，REST就是将资源的状态以最适合客户端或服务端的形式从服务器端转移到客户端（或者反过来）。

在REST中，资源通过URL进行识别和定位。至于RESTful URL的结构并没有严格的规则，但是URL应该能够识别资源，而不是简单的发一条命令到服务器上。再次强调，关注的核心是事物，而不是行为。

REST中会有行为，它们是通过HTTP方法来定义的。具体来讲，也就是GET、POST、PUT、DELETE、PATCH以及其他的HTTP方法构成了REST中的动作。这些HTTP方法通常会匹配为如下的CRUD动作：

- Create：POST
- Read：GET
- Update：PUT或PATCH
- Delete：DELETE

尽管通常来讲，HTTP方法会映射为CRUD动作，但这并不是严格的限制。有时候，PUT可以用来创建新资源，POST可以用来更新资源。实际上，POST请求非幂等性（non-idempotent）的特点使其成为一个非常灵活的方法，对于无法适应其他HTTP方法语义的操作，它都能够胜任。

基于对REST的这种观点，所以我尽量避免使用诸如REST服务、REST Web服务或类似的术语，这些术语会不恰当地强调行为。相反，我更愿意强调REST面向资源的本质，并讨论RESTful资源。

### 16.1.2 Spring是如何支持REST的
Spring很早就有导出REST资源的需求。从3.0版本开始，Spring针对Spring MVC的一些增强功能对REST提供了良好的支持。当前的4.0版本中，Spring支持以下方式来创建REST资源：

- 控制器可以处理所有的HTTP方法，包含四个主要的REST方法：GET、PUT、DELETE以及POST。Spring 3.2及以上版本还支持PATCH方法；
- 借助@PathVariable注解，控制器能够处理参数化的URL（将变量输入作为URL的一部分）；
- 借助Spring的视图和视图解析器，资源能够以多种方式进行表述，包括将模型数据渲染为XML、JSON、Atom以及RSS的View实现；
- 可以使用ContentNegotiatingViewResolver来选择最适合客户端的表述；
- 借助@ResponseBody注解和各种HttpMethodConverter实现，能够替换基于视图的渲染方式；
- 类似地，@RequestBody注解以及HttpMethodConverter实现可以将传入的HTTP数据转化为传入控制器处理方法的Java对象；
- 借助RestTemplate，Spring应用能够方便地使用REST资源。

本章中，我们将会介绍Spring RESTful的所有特性，首先介绍如何借助Spring MVC生成资源。然后在16.4小节中，我们会转向REST的客户端，看一下如何使用这些资源。那么，就从了解RESTful Spring MVC控制器是什么样子开始吧。

## 16.2 创建第一个REST端点
借助Spring的支持来实现REST功能有一个很有利的地方，那就是我们已经掌握了很多创建RESTful控制器的知识。从第5章到第7章中，我们学到了创建Web应用的知识，它们可以用在通过REST API暴露资源上。首先，我们会在名为SpittleApiController的新控制器中创建第一个REST端点。

```
@Controller
@RequestMapping("/spittlesx")
public class SpittleApiController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleApiController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

}
```

如下的程序清单展现了这个新REST控制器起始的样子，它会提供Spittle资源。这是一个很简单的开始，但是在本章中，随着不断学习Spring REST编程模型的细节，我们将会不断构建这个控制器。

程序清单16.1 实现RESTful功能的Spring MVC控制器

```
@Controller
@RequestMapping("/spittlesx")
public class SpittleApiController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleApiController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

}
```

让我们仔细看一下程序清单16.1。你能够看出来它服务于一个REST资源而不是Web页面吗？

可能看不出来！按照这个控制器的写法，并没有地方表明它是RESTful、服务于资源的控制器。实际上，你也许能够认出这个spittles()方法，我们曾经在第5章（5.3.1小节）见过它。

我们回忆一下，当发起对“/spittles”的GET请求时，将会调用spittles()方法。它会查找并返回Spittle列表，而这个列表会通过注入的SpittleRepository获取到。列表会放到模型中，用于视图的渲染。对于基于浏览器的Web应用，这可能意味着模型数据会渲染到HTML页面中。

但是，我们现在讨论的是创建REST API。在这种情况下，HTML并不是合适的数据表述形式。

表述是REST中很重要的一个方面。它是关于客户端和服务器端针对某一资源是如何通信的。任何给定的资源都几乎可以用任意的形式来进行表述。如果资源的使用者愿意使用JSON，那么资源就可以用JSON格式来表述。如果使用者喜欢尖括号，那相同的资源可以用XML来进行表述。同时，如果用户在浏览器中查看资源的话，可能更愿意以HTML的方式来展现（或者PDF、Excel及其他便于人类阅读的格式）。资源没有变化——只是它的表述方式变化了。

> 注意：尽管Spring支持多种资源表述形式，但是在定义REST API的时候，不一定要全部使用它们。对于大多数客户端来说，用JSON和XML来进行表述就足够了。

当然，如果内容要由人类用户来使用的话，那么我们可能需要支持HTML格式的资源。根据资源的特点和应用的需求，我们还可能选择使用PDF文档或Excel表格来展现资源。

对于非人类用户的使用者，比如其他的应用或调用REST端点的代码，资源表述的首选应该是XML和JSON。借助Spring同时支持这两种方案非常简单，所以没有必要做一个非此即彼的选择。

按照我的意见，我推荐至少要支持JSON。JSON使用起来至少会像XML一样简单（很多人会说JSON会更加简单），并且如果客户端是JavaScript（最近一段时间以来，这种做法越来越常见）的话，JSON更是会成为优胜者，因为在JavaScript中使用JSON数据根本就不需要编排和解排（marshaling/demarshaling）。

需要了解的是控制器本身通常并不关心资源如何表述。控制器以Java对象的方式来处理资源。控制器完成了它的工作之后，资源才会被转化成最适合客户端的形式。

Spring提供了两种方法将资源的Java表述形式转换为发送给客户端的表述形式：

- 内容协商（Content negotiation）：选择一个视图，它能够将模型渲染为呈现给客户端的表述形式；
- 消息转换器（Message conversion）：通过一个消息转换器将控制器所返回的对象转换为呈现给客户端的表述形式。

鉴于我们在第5章和第6章中已经讨论过视图解析器，并且已经熟悉了基于视图的渲染（在第6章中），所以首先看一下如何使用内容协商来选择视图或视图解析器，它们将资源渲染为客户端能够接受的形式。

### 16.2.1 协商资源表述
你可以回忆一下在第5章中（以及图5.1所示），当控制器的处理方法完成时，通常会返回一个逻辑视图名。如果方法不直接返回逻辑视图名（例如方法返回void），那么逻辑视图名会根据请求的URL判断得出。DispatcherServlet接下来会将视图的名字传递给一个视图解析器，要求它来帮助确定应该用哪个视图来渲染请求结果。在面向人类访问的Web应用程序中，选择的视图通常来讲都会渲染为HTML。视图解析方案是个简单的一维活动。如果根据视图名匹配上了视图，那这就是我们要用的视图了。
当要将视图名解析为能够产生资源表述的视图时，我们就有另外一个维度需要考虑了。视图不仅要匹配视图名，而且所选择的视图要适合客户端。如果客户端想要JSON，那么渲染HTML的视图就不行了——尽管视图名可能匹配。Spring的ContentNegotiatingViewResolver是一个特殊的视图解析器，它考虑到了客户端所需要的内容类型。按照其最简单的形式，ContentNegotiatingViewResolver可以按照下述形式进行配置：在这个简单的bean声明背后会涉及到很多事情。要理解ContentNegotiatingViewResolver是如何工作的，这涉及内容协商的两个步骤：1．确定请求的媒体类型；2．找到适合请求媒体类型的最佳视图。让我们深入了解每个步骤来了解ContentNegotiatingViewResolver是如何完成其任务的，首先从弄明白客户端需要什么类型的内容开始。确定请求的媒体类型在内容协商两步骤中，第一步是确定客户端想要什么类型的内容表述。表面上看，这似乎是一个很简单的事情。难道请求的Accept头部信息不是已经很清楚地表明要发送什么样的表述给客户端吗？遗憾的是，Accept头部信息并不总是可靠的。如果客户端是Web浏览器，那并不能保证客户端需要的类型就是浏览器在Accept头部所发送的值。Web浏览器一般只接受对人类用户友好的内容类型（如text/html），所以没有办法（除了面向开发人员的浏览器插件）指定不同的内容类型。ContentNegotiatingViewResolver将会考虑到Accept头部信息并使用它所请求的媒体类型，但是它会首先查看URL的文件扩展名。如果URL在结尾处有文件扩展名的话，ContentNegotiatingViewResolver将会基于该扩展名确定所需的类型。如果扩展名是“.json”的话，那么所需的内容类型必须是“application/json”。如果扩展名是“.xml”，那么客户端请求的就是“application/xml”。当然，“.html”扩展名表明客户端所需的资源表述为HTML（text/html）。如果根据文件扩展名不能得到任何媒体类型的话，那就会考虑请求中的Accept头部信息。在这种情况下，Accept头部信息中的值就表明了客户端想要的MIME类型，没有必要再去查找了。最后，如果没有Accept头部信息，并且扩展名也无法提供帮助的话，ContentNegotiatingViewResolver将会使用“/”作为默认的内容类型，这就意味着客户端必须要接收服务器发送的任何形式的表述。
一旦内容类型确定之后，ContentNegotiatingViewResolver就该将逻辑视图名解析为渲染模型的View。与Spring的其他视图解析器不同，ContentNegotiatingViewResolver本身不会解析视图。而是委托给其他的视图解析器，让它们来解析视图。ContentNegotiatingViewResolver要求其他的视图解析器将逻辑视图名解析为视图。解析得到的每个视图都会放到一个列表中。这个列表装配完成后，ContentNegotiatingViewResolver会循环客户端请求的所有媒体类型，在候选的视图中查找能够产生对应内容类型的视图。第一个匹配的视图会用来渲染模型。影响媒体类型的选择在上述的选择过程中，我们阐述了确定所请求媒体类型的默认策略。但是通过为其设置一个ContentNegotiationManager，我们能够改变它的行为。借助ContentNegotiationManager我们所能做到的事情如下所示：指定默认的内容类型，如果根据请求无法得到内容类型的话，将会使用默认值；通过请求参数指定内容类型；忽视请求的Accept头部信息；将请求的扩展名映射为特定的媒体类型；将JAF（Java Activation Framework）作为根据扩展名查找媒体类型的备用方案。有三种配置ContentNegotiationManager的方法：直接声明一个ContentNegotiationManager类型的bean；通过ContentNegotiationManagerFactoryBean间接创建bean；重载WebMvcConfigurerAdapter的configureContentNegotiation()方法。直接创建ContentNegotiationManager有一些复杂，除非有充分的原因，否则我们不会愿意这样做。后两种方案能够让创建ContentNegotiationManager更加简单。ContentNegotiationManager是在Spring 3.2中加入的ContentNegotiationManager是Spring中相对比较新的功能，是在Spring 3.2中引入的。在Spring 3.2之前，ContentNegotiatingViewResolver的很多行为都是通过直接设置ContentNegotiatingViewResolver的属性进行配置的。从Spring 3.2开始，ContentNegotiatingViewResolver的大多数Setter方法都废弃了，鼓励通过ContentNegotiationManager来进行配置。尽管我不会在本章中介绍配置ContentNegotiatingViewResolver的旧方法，但是我们在创建ContentNegotiationManager所设置的很多属性，在ContentNegotiatingViewResolver中都有对应的属性。如果你使用较早版本的Spring的话，应该能够很容易地将新的配置方式对应到旧配置方式中。一般而言，如果我们使用XML配置ContentNegotiationManager的话，那最有用的将会是ContentNegotiationManagerFactoryBean。例如，我们可能希望在XML中配
置ContentNegotiationManager使用“application/json”作为默认的内容类型：因为ContentNegotiationManagerFactoryBean是FactoryBean的实现，所以它会创建一个ContentNegotiationManager bean。这个ContentNegotiationManager能够注入到ContentNegotiatingViewResolver的contentNegotiationManager属性中。如果使用Java配置的话，获得ContentNegotiationManager的最简便方法就是扩展WebMvcConfigurerAdapter并重载configureContentNegotiation()方法。在创建Spring MVC应用的时候，我们很可能已经扩展了WebMvcConfigurerAdapter。例如，在Spittr应用中，我们已经有了WebMvcConfigurerAdapter的扩展类，名为WebConfig，所以需要做的就是重载configureContentNegotiation()方法。如下就是configureContentNegotiation()的一个实现，它设置了默认的内容类型：我们可以看到，configureContentNegotiation()方法给定了一个ContentNegotiationConfigurer对象。ContentNegotiationConfigurer中的一些方法对应于ContentNegotiationManager的Setter方法，这样我们就能在ContentNegotiationManager创建时，设置任意内容协商相关的属性。在本例中，我们调用defaultContentType()方法将默认的内容类型设置为“application/json”。现在，我们已经有了ContentNegotiationManagerbean，接下来就需要将它注入到ContentNegotiatingViewResolver的contentNegotiationManager属性中。这需要我们稍微修改一下之前声明ContentNegotiatingViewResolver的@Bean方法：这个@Bean方法注入了ContentNegotiationManager，并使用它调用了setContentNegotiationManager()。这样的结果就是ContentNegotiatingView、Resolver将会使用ContentNegotiationManager所定义的行为。配置ContentNegotiationManager有很多的细节，在这里无法对它们进行一一介绍。如下的程序清单是一个非常简单的配置样例，当我使用ContentNegotiatingViewResolver的时候，通常会采用这种用法：它默认会使用HTML视图，但是对特定的视图名称将会渲染为JSON输出。
程序清单16.2 配置ContentNegotiationManager除了程序清单16.2中的内容以外，还应该有一个能够处理HTML的视图解析器（如InternalResourceViewResolver或TilesViewResolver）。在大多数场景下，ContentNegotiatingViewResolver会假设客户端需要HTML，如ContentNegotiationManager配置所示。但是，如果客户端指定了它想要JSON（通过在请求路径上使用“.json”扩展名或Accept头部信息）的话，那么ContentNegotiatingViewResolver将会查找能够处理JSON视图的视图解析器。如果逻辑视图的名称为“spittles”，那么我们所配置的BeanNameViewResolver将会解析spittles()方法中所声明的View。这是因为bean名称匹配逻辑视图的名称。如果没有匹配的View的话，ContentNegotiatingViewResolver将会采用默认的行为，将其输出为HTML。ContentNegotiatingViewResolver一旦能够确定客户端想要什么样的媒体类型，接下来就是查找渲染这种内容的视图。ContentNegotiatingViewResolver的优势与限制ContentNegotiatingViewResolver最大的优势在于，它在Spring MVC之上构建了REST资源表述层，控制器代码无需修改。相同的一套控制器方法能够为面向人类的用户产生HTML内容，也能针对不是人类的客户端产生JSON或XML。如果面向人类用户的接口与面向非人类客户端的接口之间有很多重叠的话，那么内容协商是一种很便利的方案。在实践中，面向人类用户的视图与REST API在细节上很少能够处于相同的级别。如果面向人类用户的接口与面向非人类客户端的接口之间没有太多重叠的话，那么ContentNegotiatingViewResolver的优势就体现不出来了。ContentNegotiatingViewResolver还有一个严重的限制。作为ViewResolver的实现，它只能决定资源该如何渲染到客户端，并没有涉及到客户端要发送什么样的表述给控制器使用。如果客户端发送JSON或XML的话，那么ContentNegotiatingViewResolver就无法提供帮助了。
ContentNegotiatingViewResolver还有一个相关的小问题，所选中的View会渲染模型给客户端，而不是资源。这里有个细微但很重要的区别。当客户端请求JSON格式的Spittle对象列表时，客户端希望得到的响应可能如下所示：而模型是key-value组成的Map，那么响应可能会如下所示：尽管这不是很严重的问题，但确实可能不是客户端所预期的结果。因为有这些限制，我通常建议不要使用ContentNegotiatingViewResolver。我更加倾向于使用Spring的消息转换功能来生成资源表述。接下来，我们看一下如何在控制器代码中使用Spring的消息转换器。16.2.2 使用HTTP信息转换器消息转换（message conversion）提供了一种更为直接的方式，它能够将控制器产生的数据转换为服务于客户端的表述形式。当使用消息转换功能时，DispatcherServlet不再需要那么麻烦地将模型数据传送到视图中。实际上，这里根本就没有模型，也没有视图，只有控制器产生的数据，以及消息转换器（mes



```

```


