package cluster_manager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClusterManagerTest {
    private List<Location> expected;
    private List<Location> current;

    @Before
    public void set_up() {
        expected = new ArrayList<>();
    }

    @Test
    public void parsing_locations_from_xml() {
        File location = new File("C:\\Users\\vitalii_bondariev\\IdeaProjects\\LearningJava\\locations.xml");
        try {
            current = LocationParser.parse(location);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        expected.add(new Location(12, "CHURCH VIEW BP", 51.14, 0.2617));
        expected.add(new Location(14, "CLARENDON BP", 51.6581, 0.2511));

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i).toString(), current.get(i).toString());
        }
    }
}
