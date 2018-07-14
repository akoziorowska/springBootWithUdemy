package guru.springframework.didemo;

import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.GetterInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");
        myController.hello();

        System.out.println("1"+ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println("2"+ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println("3"+ctx.getBean(ConstructorInjectedController.class).sayHello());
    }
}
