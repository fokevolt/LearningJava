package words;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private Map<String, Integer> words = new HashMap<>();

    private String[] convertToArray(String string){
        string = string.trim();
        String[] wordArray = string.split(" ");
        return  wordArray;
    }

    public boolean count(String string){
        if(string == null || convertToArray(string)[0].equals("")){
            return false;
        } else {
            for (String word : convertToArray(string)) {
                if (words.containsKey(word)) {
                    words.put(word, words.get(word) + 1);
                } else {
                    words.put(word, 1);
                }
            }
            return true;
        }
    }

    public int getCount(String word){
        return words.getOrDefault(word, 0);
    }

    public Map<String, Integer> getFrequency(){
        return words;
    }
}
