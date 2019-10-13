package com.example.importannotation;

import com.example.importannotation.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportAnnotationApplicationTests {

    @Test
    public void testImportAnnotation(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("---------------------------");
        for (String beanDefinitionName: beanDefinitionNames){
            System.out.println("beanDefinitionName: " + beanDefinitionName);
        }
        System.out.println("---------------------------");
    }

}
