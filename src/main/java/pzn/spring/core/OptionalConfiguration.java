package pzn.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pzn.spring.core.data.Bar;
import pzn.spring.core.data.Foo;
import pzn.spring.core.data.FooBar;

import java.util.Optional;

@Configuration
public class OptionalConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar) {
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
