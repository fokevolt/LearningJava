package cluster_manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cluster {
    LatLng center;
    List<Location> items;

    Cluster(List<Location> locations) {
        items = new ArrayList<>(locations);
        center = findCenter();
    }

    public LatLng getCenter() {
        return center;
    }

    private LatLng findCenter() {
        return center;
    }

    public List<Location> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Location item) {
        items.add(item);
        center = findCenter();
    }
}
