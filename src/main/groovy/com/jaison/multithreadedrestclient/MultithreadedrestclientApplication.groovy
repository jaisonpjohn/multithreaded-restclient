package com.jaison.multithreadedrestclient

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableFeignClients
@EnableAsync
class MultithreadedrestclientApplication {

	static void main(String[] args) {
		SpringApplication.run MultithreadedrestclientApplication, args
	}
}
