package com.alan.yx.springInAction.Chapter_09.thymeleaf.src.main.java.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
// 启用  spring MVC 安全性
@EnableWebMvcSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 指定哪些请求需要认证，哪些请求不需要认证，以及所需要的权限；
     * 提供一个自定义的登录页面，替代原来简单的默认登录页
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 禁用 CSRF 防护功能
                .csrf().disable()
                // 启用默认的登录页
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                // 指定重定向的页面
                .logoutSuccessUrl("/")
                .logoutUrl("/signout")
                .and()
                .rememberMe()
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                .tokenValiditySeconds(2419200)
                .key("spittrKey")
                .and()
                .httpBasic()
                .realmName("Spittr")
                .and()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/spitter/me").authenticated()
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                .anyRequest().permitAll()
                .and()
                // 需要 HTTPS
                .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure();
    }

    /**
     * 程序清单9.3 配置Spring Security使用内存用户存储
     * <p>
     * authorities() 与 roles() 方法等价
     *
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                // 启用内存用户存储
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password2").roles("USER", "ADMIN").and()
//                .withUser("guest").password("password3").authorities("USER");
//    }


//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,true from Spitter where username=?")
//                .authoritiesByUsernameQuery("select username,'ROLE_USER' from Spitter where username=?")
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//    }


//    @Autowired
//    private SpitterRepository spitterRepository;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .userDetailsService(new SpitterUserService(spitterRepository))
//                ;
//    }


}
