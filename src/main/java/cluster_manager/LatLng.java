package cluster_manager;

public class LatLng {
    private final double latitude;
    private final double longitude;

    LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    double getLatitude() {
        return latitude;
    }

    double getLongitude() {
        return longitude;
    }
}
