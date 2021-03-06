package com.dot.fashion.retrieval.spring;

import com.dot.fashion.retrieval.spring.annotation.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.TimeUnit;

/**
 * title:
 * author:吉
 * since:2018/12/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MainTest.class)})
@EnableAutoConfiguration
public class ApplicationTest {
    private Logger logger = LoggerFactory.getLogger(ApplicationTest.class);
    @Autowired
    private TestService testService;

    @Test(expected = UndeclaredThrowableException.class)
    public void test() {
        logger.info("执行结果：" + testService.test(1));
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {

        }
    }

}
