package cluster_manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClusterManager {
    private List<Location> locations;

    ClusterManager(File locationxml) {
        locations = LocationParser.parse(locationxml);
    }


    public List<Cluster> getInBounds(double minLat, double minLng, double maxLat, double maxLng) {
        return new ArrayList<>();
    }
}
