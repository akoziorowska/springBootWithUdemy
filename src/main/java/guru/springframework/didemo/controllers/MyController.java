package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

//    public String hello(){
//        System.out.println("hello world from MyController");
//        return "cos";
//    }


    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello(){
        System.out.println("hello world from MyController");
        System.out.println("hello world from MyController"+greetingService.sayGreeting());
        return "cos";
    }
}
