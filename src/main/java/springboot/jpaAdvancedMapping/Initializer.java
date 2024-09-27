package springboot.jpaAdvancedMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello all");
    }
}
