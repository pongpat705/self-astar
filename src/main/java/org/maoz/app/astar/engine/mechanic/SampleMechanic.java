package org.maoz.app.astar.engine.mechanic;

import lombok.extern.slf4j.Slf4j;
import org.maoz.app.astar.engine.model.LinkPath;
import org.maoz.app.astar.engine.model.ResultPath;
import org.maoz.app.astar.engine.model.StationNode;
import org.maoz.app.astar.engine.store.MapStore;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SampleMechanic {

    private MapStore mapStore;

    public SampleMechanic(MapStore mapStore) {
        this.mapStore = mapStore;
    }

    public void aStar() {

        String origin = "A";
        String destination = "Z";

        List<ResultPath> resultPaths = new ArrayList<>();


        int loopAttempt = 1;
        boolean isReach = false;
        while (!isReach) {
            log.info(" loopAttempt {}", loopAttempt);
            if (resultPaths.isEmpty()) {
                log.info(" init path finder ");
                StationNode startNode = this.mapStore.getN().get(origin);

                for (LinkPath l: startNode.getLink()) {

                    ResultPath resultPath = new ResultPath();
                    List<StationNode> stationNodeList = new ArrayList<>();
                    stationNodeList.add(startNode);
                    StringBuilder pathCode = new StringBuilder(startNode.getKey());
                    StationNode dn = this.mapStore.getN().get(l.getTo());
                    pathCode.append(dn.getKey());
                    stationNodeList.add(dn);

                    int count = resultPath.getCount();
                    resultPath.setResult(stationNodeList);
                    resultPath.setTotalCost(l.getCost());
                    resultPath.setCount(count++);
                    resultPath.setPathCode(pathCode.toString());
                    resultPaths.add(resultPath);
                }
            } else {
                log.info(" sorting founded path ");
                resultPaths = resultPaths.stream().sorted(
                        Comparator.comparing(ResultPath::getTotalCost)
                                .thenComparing(ResultPath::getCount)).collect(Collectors.toList());
                log.info(" pick 1st to calculate ");
                ResultPath resultPath = resultPaths.get(0);
                List<StationNode> stationNodeList = resultPath.getResult();
                String currentPathCode = resultPath.getPathCode();
                log.info(" currentPathCode {}", currentPathCode);
                StationNode latestNode = stationNodeList.get(stationNodeList.size()-1);

                isReach = latestNode.getKey().equals(destination);
                log.info(" check isReach {}", isReach);
                if(isReach){
                    log.info(" found!! ");
                    break;
                }

                for (LinkPath l: latestNode.getLink()) {
                    if (!currentPathCode.contains(l.getTo())) {
                        StringBuilder pathCode = new StringBuilder(currentPathCode);
                        StationNode dn = this.mapStore.getN().get(l.getTo());
                        pathCode.append(dn.getKey());
                        int count = resultPath.getCount();
                        resultPath.setResult(stationNodeList);
                        resultPath.setTotalCost(l.getCost());
                        resultPath.setCount(count++);
                        resultPath.setPathCode(pathCode.toString());
                        stationNodeList.add(dn);
                        resultPaths.stream().
                    }
                }



            }
            loopAttempt++;
        }
        for (ResultPath k : resultPaths) {
            log.info(k.toString());

        }
    }
}
