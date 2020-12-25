package org.maoz.app.astar;

import org.maoz.app.astar.engine.ApplicationCommandLineRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AstarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AstarApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new ApplicationCommandLineRunner();
    }
}
