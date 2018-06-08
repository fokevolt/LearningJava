package cluster_manager;

class LatLng {
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

    boolean inBounds(double minLat, double minLng, double maxLat, double maxLng) {
        return (latitude >= minLat && latitude <= maxLat) && (longitude >= minLng && longitude <= maxLng);
    }
}
