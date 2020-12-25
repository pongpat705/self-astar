package org.maoz.app.astar.engine.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.maoz.app.astar.engine.model.SampleModel;
import org.maoz.app.astar.engine.model.StationNode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Component
public class MapStore {

    private Map<String, StationNode> n;


    @PostConstruct
    public void postConstruct(){

        this.n = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String fileName = "/home/pongpat705/IdeaProjects/upskill/astar/sample.json";
            String content = Files.readString(Path.of(fileName));

            SampleModel sampleModel = mapper.readValue(content, SampleModel.class);
            System.out.println(sampleModel.toString());

            for (StationNode s: sampleModel.getNodeList()) {
                this.n.put(s.getKey(), s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map<String, StationNode> getN() {
        return n;
    }
}
