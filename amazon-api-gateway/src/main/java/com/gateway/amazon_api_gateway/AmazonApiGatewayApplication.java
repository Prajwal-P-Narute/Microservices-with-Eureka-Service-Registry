package com.gateway.amazon_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AmazonApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonApiGatewayApplication.class, args);
	}

}
