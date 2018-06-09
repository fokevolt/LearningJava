package cluster_manager.xml_logic;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class LocationGenerator {

    public static File generate(int count) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document locations = builder.newDocument();

            Element rootElement = locations.createElement("root");
            locations.appendChild(rootElement);

            for (int i = 0; i < count; i++) {
                Element row = locations.createElement("row");
                rootElement.appendChild(row);

                Element uniqueId = locations.createElement("UniqueID");
                uniqueId.appendChild(locations.createTextNode(String.format("%d", i)));
                row.appendChild(uniqueId);

                Element name = locations.createElement("Name");
                name.appendChild(locations.createTextNode(Randomizer.getRandomName()));
                row.appendChild(name);

                Element latitude = locations.createElement("Latitude");
                latitude.appendChild(locations.createTextNode(Randomizer.getRandomLatitude()));
                row.appendChild(latitude);

                Element longitude = locations.createElement("Longitude");
                longitude.appendChild(locations.createTextNode(Randomizer.getRandomLongitude()));
                row.appendChild(longitude);
            }

            File randomizedLocations = new File("randomized_locations.xml");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(locations);
            StreamResult result = new StreamResult(randomizedLocations);

            transformer.transform(source, result);

            return randomizedLocations;
        } catch (ParserConfigurationException | TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }


}
