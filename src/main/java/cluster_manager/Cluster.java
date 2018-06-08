package cluster_manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cluster {
    private LatLng center;
    private List<Location> items;

    Cluster(List<Location> locations) {
        items = new ArrayList<>(locations);
        findCenter();
    }

    public LatLng getCenter() {
        return center;
    }

    private void findCenter() {
        double latitude = 0;
        double longitude = 0;

        for (Location item : items) {
            latitude += item.getLatitude();
            longitude += item.getLongitude();
        }
        center = new LatLng(latitude / items.size(), longitude / items.size());
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Location item) {
        items.add(item);
        findCenter();
    }

    static List<Cluster> manageLocations(List<Location> locations, int gridSize) {
        List<Cluster> clusters = new ArrayList<>();
        //... TO DO
        return clusters;
    }
}
