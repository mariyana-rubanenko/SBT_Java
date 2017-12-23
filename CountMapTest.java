import org.junit.Test;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by 11007122 on 16.12.2017.
 */
public class CountMapTest {
    @Test
    public void addTest() {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        assertEquals(3, map.getCount(10));
        assertEquals(2, map.getCount(5));
        assertEquals(1, map.getCount(6));
    }

    @Test
    public void addAllTest () {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        CountMap<Integer> source = new CountMapImpl<>();
        source.add(8);
        source.add(23);

        map.addAll(source);
        System.out.println(map);
    }
}
