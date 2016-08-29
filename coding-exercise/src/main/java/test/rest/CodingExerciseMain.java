package test.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * This is the entry point
 * @author Mahesh
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CodingExerciseMain extends SpringBootServletInitializer {

	/**
	 * @param args
	 */
    public static void main(final String[] args) {
        SpringApplication.run(CodingExerciseMain.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(CodingExerciseMain.class);
    }
}
