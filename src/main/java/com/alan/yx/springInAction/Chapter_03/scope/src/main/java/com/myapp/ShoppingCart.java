package com.alan.yx.springInAction.Chapter_03.scope.src.main.java.com.myapp;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 购物车适合使用会话作用域:
 * <p>
 * - SCOPE_SESSION ==> 告诉Spring为Web应用中的每个会话创建一个ShoppingCart
 * - ScopedProxyMode.INTERFACES ==> 解决将会话或请求作用域的 bean 注入到单例 bean 中所遇到的问题
 *
 * @author yinxing
 * @date 2019/4/24
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    public void buySomething() {
        // do something
    }
    /**
     * 如果 ShoppingCart 是一个具体的类，Spring就没有办法创建基于接口的代理了。此时，它必须使用CGLib来生成基于类的代理。
     * 所以，如果bean类型是具体类的话，我们必须要将proxyMode属性设置为ScopedProxyMode.TARGET_CLASS，以此来表明要以生成目标类扩展的方式创建代理
     */
}
