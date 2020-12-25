package org.maoz.app.astar.engine;

import lombok.extern.slf4j.Slf4j;
import org.maoz.app.astar.engine.mechanic.SampleMechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Slf4j
public class ApplicationCommandLineRunner implements CommandLineRunner {

    @Autowired  private SampleMechanic sampleMechanic;

    @Override
    public void run(String... args) throws Exception {
        this.sampleMechanic.aStar();
    }
}
