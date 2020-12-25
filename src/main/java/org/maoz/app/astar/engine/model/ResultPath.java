package org.maoz.app.astar.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultPath {

    private String pathCode;
    private List<StationNode> result;
    private int count = 0;
    private int totalCost;

}
