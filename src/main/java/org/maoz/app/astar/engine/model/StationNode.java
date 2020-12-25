package org.maoz.app.astar.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationNode {
    private String key;
    private List<LinkPath> link;
}
