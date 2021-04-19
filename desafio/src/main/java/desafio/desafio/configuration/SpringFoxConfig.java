package desafio.desafio.configuration;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//http://localhost:8080/swagger-ui/index.html
@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
