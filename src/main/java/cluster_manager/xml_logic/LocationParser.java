package cluster_manager.xml_logic;

import cluster_manager.Location;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class LocationParser {

    public static List<Location> parse(File locationsXML) {
        List<Location> items = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(locationsXML);

            NodeList locationList = document.getElementsByTagName("row");

            for (int i = 0; i < locationList.getLength(); i++) {
                Node location = locationList.item(i);
                if (location.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList parameters = location.getChildNodes();
                    int id = 0;
                    String name = null;
                    double latitude = 0;
                    double longitude = 0;

                    for (int j = 0; j < parameters.getLength(); j++) {
                        Node parameter = parameters.item(j);
                        if (parameter.getNodeType() == Node.ELEMENT_NODE) {
                            if (parameter.getNodeName().equals("UniqueID")) {
                                id = Integer.parseInt(parameter.getTextContent());
                                continue;
                            }
                            if (parameter.getNodeName().equals("Name")) {
                                name = parameter.getTextContent();
                                continue;
                            }
                            if (parameter.getNodeName().equals("Latitude")) {
                                latitude = Double.parseDouble(parameter.getTextContent());
                                continue;
                            }
                            if (parameter.getNodeName().equals("Longitude")) {
                                longitude = Double.parseDouble(parameter.getTextContent());
                            }
                        }
                    }
                    items.add(new Location(id, name, latitude, longitude));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return items;
    }
}
