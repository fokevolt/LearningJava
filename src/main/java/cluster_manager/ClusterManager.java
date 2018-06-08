package cluster_manager;

import cluster_manager.xml_logic.LocationGenerator;
import cluster_manager.xml_logic.LocationParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClusterManager {
    private List<Location> locations;
    private File locationsxml;

    ClusterManager(File xml) {
        if (xml != null) {
            locationsxml = xml;
            locations = LocationParser.parse(locationsxml);
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
        List<Cluster> clusters = new ArrayList<>();
        //...TO DO
        return clusters;
    }
}
