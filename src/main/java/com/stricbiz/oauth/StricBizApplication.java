package com.stricbiz.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("com.stricbiz.oauth.persistence")
public class StricBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(StricBizApplication.class, args);
	}

}
