package com.jaison.multithreadedrestclient

import com.jaison.multithreadedrestclient.service.RestService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Component

import java.time.LocalDateTime
import java.util.concurrent.Executor
import java.util.concurrent.Future

@Component
class MyRunner implements CommandLineRunner{

  @Autowired
  RestService restService
  @Autowired Executor executor

  private static final Logger LOG = LoggerFactory.getLogger(MyRunner.class)

  @Override
  void run(final String... args) throws Exception {

    LOG.info("Start Time: "+LocalDateTime.now())
    List<Future> futures = new ArrayList<>()
    for(int i=0;i<5000;i++){
      futures.add(restService.postCount())
    }


    while (true) {
      boolean done = true
      for (Future<String> future : futures) {
        if (!(future.isDone())) {
          done = false
          break
        }
      }
      if(done) break
      Thread.sleep(10) //10-millisecond pause between each check
    }

    LOG.info("Process Completed: "+LocalDateTime.now())


    ((ThreadPoolTaskExecutor)executor).shutdown()

  }
}
