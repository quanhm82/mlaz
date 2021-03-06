package com.mlaz.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(DynamoDbConfiguration.class)
public class MlazConfiguration {
	
}
