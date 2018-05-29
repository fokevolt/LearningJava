package words;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertTrue(counter.getFrequency().isEmpty());
        Assert.assertFalse(counter.count("   "));
        Assert.assertTrue(counter.getFrequency().isEmpty());
        Assert.assertFalse(counter.count(null));
        Assert.assertTrue(counter.getFrequency().isEmpty());

        Assert.assertTrue(counter.count("Hello Rostik"));
        Assert.assertFalse(counter.getFrequency().isEmpty());

        Assert.assertTrue(counter.getFrequency().containsKey("Hello"));
        Assert.assertEquals(counter.getFrequency().get("Hello"), (Integer) 1);
        Assert.assertTrue(counter.getFrequency().containsKey("Rostik"));
        Assert.assertEquals(counter.getFrequency().get("Rostik"), (Integer) 1);

        Assert.assertFalse(counter.getFrequency().containsKey("hello"));
        Assert.assertEquals(counter.getFrequency().get("hello"), null);
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
