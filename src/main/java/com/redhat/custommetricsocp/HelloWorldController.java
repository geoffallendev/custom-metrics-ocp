package com.redhat.custommetricsocp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Gauge;

@Controller
public class HelloWorldController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/hello-world")
  @ResponseBody
  public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }


  /* HelloWorldController(MeterRegistry registry) {

    Gauge.builder("usercontroller.usercount",counter).
      tag("version","v1").
      description("usercontroller descrip").
      register(registry);
  } */

}