package org.maoz.app.astar.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkPath {
    private String from;
    private String to;
    private int cost;
}
