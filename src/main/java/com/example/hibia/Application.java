package com.example.hibia;

import com.example.hibia.config.GracefulShutdown;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Log
@SpringBootApplication
		//스프링시큐리티 기본 로그인 화면 제거
// (exclude = { SecurityAutoConfiguration.class })
@EnableJpaAuditing
public class Application {

	@Value("${server.host.front}")
	private String frontHost;

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		log.info("host:" + frontHost);
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(frontHost);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

		@Bean
		public GracefulShutdown gracefulShutdown() {
			return new GracefulShutdown();
		}

		@Bean
		public ConfigurableServletWebServerFactory webServerFactory(final GracefulShutdown gracefulShutdown) {
			TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
			factory.addConnectorCustomizers(gracefulShutdown);
			return factory;
		}
}
