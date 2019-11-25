package com.alan.yx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring 揭秘示例
 */
@SpringBootApplication
public class SpringLearnApplication2 implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication2.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //
        testMyTestBean();
    }

    /**
     * c
     */
    private void testMyTestBean() {

    }


}
