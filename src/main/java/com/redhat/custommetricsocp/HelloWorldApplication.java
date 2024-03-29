package com.redhat.custommetricsocp;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class HelloWorldApplication {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

  @GetMapping("/hello-world")
  @ResponseBody
  public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

}