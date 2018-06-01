package words;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CounterTest {
    private Counter counter;

    @Before
    public void set_up(){
        counter = new Counter();
    }

    @Test
    public void count_word(){
        Assert.assertTrue(counter.count("Hello"));
        Assert.assertFalse(counter.count(null));
        Assert.assertFalse(counter.count(""));
        Assert.assertFalse(counter.count(" "));
        Assert.assertFalse(counter.count("   "));
    }

    @Test
    public void frequency(){
        Map<String, Integer> expected = new HashMap<>();


        Assert.assertTrue(counter.getFrequency().isEmpty());
        counter.count("   ");
        counter.count(null);
        Assert.assertTrue(counter.getFrequency().isEmpty());

        counter.count("Hello Rostik");
        counter.count("Hello Rostik bro");
        counter.count("Rostik and Vitalik");

        expected.put("Hello", 2);
        expected.put("Rostik", 3);
        expected.put("bro", 1);
        expected.put("and", 1);
        expected.put("Vitalik", 1);

        Assert.assertFalse(counter.getFrequency().isEmpty());
        Assert.assertEquals(expected, counter.getFrequency());
    }

    @Test
    public void count_multiple_words_in_string(){
        counter.count(" Hello o .");

        Assert.assertEquals(counter.getCount("Hello"), 1);
        Assert.assertEquals(counter.getCount("o"), 1);
        Assert.assertEquals(counter.getCount("."), 1);

        Assert.assertEquals(counter.getCount(" "), 0);

        Assert.assertEquals(counter.getCount("hello"), 0);

        counter.count("o o o Vitalik");

        Assert.assertEquals(counter.getCount("o"), 4);
        Assert.assertEquals(counter.getCount("Vitalik"), 1);
    }


}
