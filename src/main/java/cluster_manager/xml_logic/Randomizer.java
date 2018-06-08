package cluster_manager.xml_logic;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Randomizer {

    static String getRandomName(int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength) + minLength;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            //[65 - 90] - latin alphabet in unicode(uppercase)
            int code = random.nextInt(90 - 65) + 65;
            char current = (char) code;
            result.append(current);
        }
        return result.toString();
    }

    static String getRandomName() {
        return getRandomName(5, 15);
    }

    static String getRandomLatitude() {
        double random = ThreadLocalRandom.current().nextDouble(-90, 90);
        return String.format("%s", random);
    }

    static String getRandomLongitude() {
        double random = ThreadLocalRandom.current().nextDouble(-180, 180);
        return String.format("%s", random);
    }
}
