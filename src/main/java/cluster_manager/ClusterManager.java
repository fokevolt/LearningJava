package cluster_manager;

import cluster_manager.xml_logic.LocationGenerator;
import cluster_manager.xml_logic.LocationParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClusterManager {
    private List<Location> locations;
    private List<Cluster> clusters;
    private final int gridSize = 50;

    ClusterManager(File locationsxml) {
        if (locationsxml != null) {
            locations = LocationParser.parse(locationsxml);
            clusters = Cluster.manageLocations(locations, gridSize);
        } else {
            System.out.println("File doesn't exist!");
        }
    }

    ClusterManager(int count) {
        this(LocationGenerator.generate(count));
    }

    List<Location> getLocations() {
        return Collections.unmodifiableList(locations);
    }

    public List<Cluster> getInBounds(double minLat, double minLng, double maxLat, double maxLng) {
        List<Cluster> clustersInBounds = new ArrayList<>();

        for (Cluster current : clusters) {
            if (current.getCenter().inBounds(minLat, minLng, maxLat, maxLng)) {
                clustersInBounds.add(current);
            }
        }
        return clustersInBounds;
    }
}
