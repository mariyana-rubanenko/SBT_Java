import java.util.ArrayList;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by 11007122 on 18.12.2017.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> someCollection = new ArrayList<>();

        Map m = Streams.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform( p -> new Person(p.geAge() + 30)))
                .toMap(p -> p.geName(), p -> p);
    }
}