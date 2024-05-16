package pzn.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pzn.spring.core.listener.LoginAgainSuccessListener;
import pzn.spring.core.listener.LoginSuccessListener;
import pzn.spring.core.listener.UserListener;
import pzn.spring.core.service.UserService;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {

        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("alvenio", "alvenio");
        userService.login("alvenio", "salah");
        userService.login("farhan", "salah");

    }
}
