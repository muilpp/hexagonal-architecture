package architecture.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"architecture"})
//@ComponentScan(basePackages = {"architecture.port"})
public class SpringArchitectureApp {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringArchitectureApp.class);
    }
}
