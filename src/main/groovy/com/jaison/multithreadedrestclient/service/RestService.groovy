package com.jaison.multithreadedrestclient.service

import com.jaison.multithreadedrestclient.restclient.RestClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture

@Component
class RestService {
  @Autowired
  RestClient restClient

  @Async
  ListenableFuture<String> postCount(){
    return new AsyncResult<>(restClient.postCount())
  }
}
