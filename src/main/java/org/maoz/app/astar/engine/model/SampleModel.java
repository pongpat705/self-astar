package org.maoz.app.astar.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleModel {
    private String[] stations;
    private List<StationNode> nodeList;
}
