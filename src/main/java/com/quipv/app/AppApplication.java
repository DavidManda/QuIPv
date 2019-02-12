package com.quipv.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
		@PropertySource(value = "classpath:application.properties"),
		@PropertySource(value = "classpath:application.default.properties")
})
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(AppApplication.class, args);
	}

}

