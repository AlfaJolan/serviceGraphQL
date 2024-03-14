package myservice.service;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
class GraphQLConfig {
    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder ->
                wiringBuilder.scalar(ExtendedScalars.Date);
    }
}
