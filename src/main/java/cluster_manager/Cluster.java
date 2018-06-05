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
        //...TO DO
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Location item) {
        items.add(item);
        findCenter();
    }
}
