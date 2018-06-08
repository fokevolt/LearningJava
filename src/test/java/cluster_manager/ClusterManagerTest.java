package cluster_manager;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClusterManagerTest {
    private ClusterManager manager;

    @Test
    public void parsing_locations_from_xml() {
        File location = new File("C:\\Users\\vitalii_bondariev\\IdeaProjects\\LearningJava\\locations.xml");
        manager = new ClusterManager(location);
        List<Location> current = manager.getLocations();

        List<Location> expected = new ArrayList<>();

        expected.add(new Location(12, "CHURCH VIEW BP", 51.14, 0.2617));
        expected.add(new Location(14, "CLARENDON BP", 51.6581, 0.2511));

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).toString(), current.get(i).toString());
        }
    }

    @Test
    public void generating_locations_to_xml() {
        int count = 1000;
        manager = new ClusterManager(count);
        List<Location> current = manager.getLocations();

        Assert.assertFalse(current.isEmpty());
        Assert.assertEquals(count, current.size());
    }
}
