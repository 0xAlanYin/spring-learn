package com.alan.yx;

import com.alan.yx.springSource.chapter_6.converter.String2DateConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

//@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		testAware();
//        testEvent();
        testConverter();
    }

    /**
     * 例1：测试 BeanFactoryAware
     */
//	@Autowired
//	private ApplicationContext context;
//	private void testAware() {
//		TestAware testAware = (TestAware)context.getBean("testAware");
//		testAware.testAware1();
//	}

    /**
     * 例2：测试 Event
     */
//    @Autowired
//    private ApplicationContext context;
//    private void testEvent() {
//        TestEvent testEvent = new TestEvent("hello", "msg");
//        context.publishEvent(testEvent);
//    }

    /**
     * 例3：测试 Converter
     */
    private void testConverter() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());

        String dateStr = "2019-11-11 11:11:11";
        Date date = conversionService.convert(dateStr, Date.class);
        System.out.println("date is : " + date);
    }


}
