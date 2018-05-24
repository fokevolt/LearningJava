package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {
    private Tree<User> tree;
    private final User rostik = new User(170);
    private final User vitalik = new User(182);
    private final User rusik = new User(180);
    private final User andrii = new User(160);
    private final User misha = new User(175);

    @Before
    public void set_up() throws Exception {
        tree = new Tree<>();
    }

    @Test
    public void is_empty() {
        assertTrue(tree.isEmpty());

        tree.add(vitalik);
        assertFalse(tree.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_one_node_multiple_times() {
        tree.add(vitalik);
        tree.add(vitalik);
        tree.add(vitalik);
        tree.add(vitalik);

    }

    @Test
    public void add_and_contains() {
        assertFalse("do not contain 4", tree.contains(vitalik));
        tree.add(vitalik);
        assertTrue("contains 4", tree.contains(vitalik));

        assertFalse("do not contain 2", tree.contains(rostik));
        assertFalse("do not contain 6", tree.contains(rusik));

        tree.add(rostik);
        tree.add(rusik);

        assertTrue("contains 2", tree.contains(rostik));
        assertTrue("contains 6", tree.contains(rusik));
    }

    @Test
    public void get_elements() {
        User[] arr = new User[]{vitalik, rostik, rusik, andrii, misha};
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }


        List<User> nodes = tree.getElements();
        for (int i = 0; i < arr.length; i++) {
            assertTrue(nodes.contains(arr[i]));
        }
    }
}