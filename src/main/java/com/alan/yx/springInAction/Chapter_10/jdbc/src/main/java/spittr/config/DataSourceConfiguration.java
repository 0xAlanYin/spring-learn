package com.alan.yx.springInAction.Chapter_10.jdbc.src.main.java.spittr.config;

import com.alan.yx.springInAction.Chapter_10.jdbc.src.main.java.spittr.db.SpitterRepository;
import com.alan.yx.springInAction.Chapter_10.jdbc.src.main.java.spittr.db.jdbc.JdbcSpitterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * @author yinxing
 * @date 2019/5/6
 */

public class DataSourceConfiguration {

    /**
     * 生产环境 数据源
     *
     * @return
     */
    @Profile("pro")
    @Bean
    public JndiObjectFactoryBean datasource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/spittrDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        return jndiObjectFactoryBean;
    }

    /**
     * QA 数据源
     *
     * @return
     */
    @Profile("qa")
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    /**
     * 开发 数据源
     *
     * @return
     */
    @Profile("dev")
    @Bean
    public DataSource embeddeddataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:com/alan/yx/springInAction/Chapter_10/jdbc/src/main/resources/spittr/db/jdbc/schema.sql")
                .addScript("classpath:com/alan/yx/springInAction/Chapter_10/jdbc/src/test/resources/spittr/db/jdbc/test-data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate){
        return new JdbcSpitterRepository(jdbcTemplate);
    }
}
