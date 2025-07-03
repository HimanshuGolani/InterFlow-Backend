package com.interflow.configserver.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerForInterFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerForInterFlowApplication.class, args);
	}

}
