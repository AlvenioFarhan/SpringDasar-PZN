package pzn.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pzn.spring.core.factory.PaymentGatewayClientFactoryBean;

@Configuration
@Import({
        PaymentGatewayClientFactoryBean.class
})
public class FactoryConfiguration {

}
