package com.jaison.multithreadedrestclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurerSupport
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

import java.util.concurrent.Executor


@EnableAsync
@Configuration
class MyConfig extends AsyncConfigurerSupport {

  @Override
  @Bean
  public Executor getAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor()
    executor.setCorePoolSize(55)
    executor.setMaxPoolSize(55)
    //executor.setQueueCapacity(500)
    executor.setThreadNamePrefix("MyThreads-")
    executor.initialize()
    return executor
  }
}
