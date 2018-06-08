package cluster_manager;

public class Location extends LatLng {
    private final int id;
    private final String name;

    public Location(int id, String name, double latitude, double longitude) {
        super(latitude, longitude);
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    public String toString() {
        return String.format("Location ID: %d - %s (lat: %f, lng: %f)", id, name, getLatitude(), getLongitude());
    }
}
