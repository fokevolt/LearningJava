package words;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Counter {
    private Map<String, Integer> words = new HashMap<>();

    private String[] convertToArray(String input) {
        return input.trim().split(" ");
    }

    public boolean count(String string) {
        if (string == null || convertToArray(string)[0].equals("")) {
            return false;
        } else {
            for (String word : convertToArray(string)) {
                int count = words.getOrDefault(word, 0);
                words.put(word, count + 1);
            }
            return true;
        }
    }

    public int getCount(String word) {
        return words.getOrDefault(word, 0);
    }

    public Map<String, Integer> getFrequency() {
        return Collections.unmodifiableMap(words);
    }
}
