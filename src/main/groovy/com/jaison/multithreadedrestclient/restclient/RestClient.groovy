package com.jaison.multithreadedrestclient.restclient

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url="http://localhost:8080",name="ThreadSafetyDemo")
interface RestClient {
  @RequestMapping(value = "/count", method = RequestMethod.POST)
  String postCount()
}