package cluster_manager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class LocationParser {

    static List<Location> parse(File locations) throws Exception {
        List<Location> items = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(locations);

        NodeList locationList = document.getElementsByTagName("row");

        for (int i = 0; i < locationList.getLength(); i++) {
            Node l = locationList.item(i);
            if (l.getNodeType() == Node.ELEMENT_NODE) {
                Element location = (Element) l;
                NodeList parameters = location.getChildNodes();

                int id = 0;
                String name = null;
                double latitude = 0;
                double longitude = 0;

                for (int j = 0; j < parameters.getLength(); j++) {
                    Node p = parameters.item(j);
                    if (p.getNodeType() == Node.ELEMENT_NODE) {
                        Element parameter = (Element) p;

                        if (parameter.getTagName().equals("UniqueID")) {
                            id = Integer.parseInt(parameter.getTextContent());
                            continue;
                        }
                        if (parameter.getTagName().equals("Name")) {
                            name = parameter.getTextContent();
                            continue;
                        }
                        if (parameter.getTagName().equals("Latitude")) {
                            latitude = Double.parseDouble(parameter.getTextContent());
                            continue;
                        }
                        if (parameter.getTagName().equals("Longitude")) {
                            longitude = Double.parseDouble(parameter.getTextContent());
                        }
                    }
                }
                items.add(new Location(id, name, latitude, longitude));
            }
        }
        return items;
    }
}
