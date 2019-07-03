

- 代码清单2-5构建在IoC之上可重用的FXNewsProvider使用演示

``` java
FXNewsProvider1 aNewsProvider = new FXNewsProvider1(new aIFXNewsListen() , new aIFXNewsPesister());
    
FXNewsProvider1 bNewsProvider = new FXNewsProvider1(new bIFXNewsListen() , new bIFXNewsPesister());
    
```