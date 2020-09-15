package com.alan.yx.springInAction.Chapter_03.scope.src.main.java.com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 假设我们要将 ShoppingCart bean 注入到单例StoreService bean 的Setter方法中
 *
 * @author yinxing
 * @date 2019/4/24
 */

@Component
public class StoreService {

    private ShoppingCart shoppingCart;

    @Autowired
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * 1.
     * 因为StoreService是一个单例的bean，会在Spring应用上下文加载的时候创建。
     * 当它创建的时候，Spring会试图将ShoppingCart bean注入到setShoppingCart()方法中。
     * 但是ShoppingCart bean是会话作用域的，此时并不存在。
     * 直到某个用户进入系统，创建了会话之后，才会出现ShoppingCart实例。
     */

    /**
     * 2.
     * 另外，系统中将会有多个ShoppingCart实例：每个用户一个。
     * 我们并不想让Spring注入某个固定的ShoppingCart实例到StoreService中。
     * 我们希望的是当StoreService处理购物车功能时，它所使用的ShoppingCart实例恰好是当前会话所对应的那一个。
     */

    /**
     * 3.
     * Spring并不会将实际的ShoppingCart bean注入到StoreService中，Spring会注入一个到ShoppingCart bean的代理。
     * 这个代理会暴露与ShoppingCart相同的方法，所以StoreService会认为它就是一个购物车。
     * 但是，当StoreService调用ShoppingCart的方法时，代理会对其进行「懒解析」并将调用委托给会话作用域内真正的ShoppingCart bean
     */

    /**
     * 作用域代理可以延迟注入请求和会话作用域的 bean
     */

}
