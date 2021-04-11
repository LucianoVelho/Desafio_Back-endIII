package desafio.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@PropertySources({
		@PropertySource("classpath:application.properties"),
})
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
