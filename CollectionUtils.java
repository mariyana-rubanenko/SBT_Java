import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Created by 11007122 on 16.12.2017.
 */
public class CollectionUtils<T> {
    private final List<T> list = new ArrayList<>();

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> int indexOf(List<?extends T> source, Object o) {
        return source.indexOf(o);
    }

    // Не поняла, что нужно
    public static<T> int limit(List<? extends T> source, int size) {
        return source.size();
    }

    public static<T> void add(List <? super T> destination, T o) {
        destination.add(o);
    }

    public static<T> void removeAll(List <? super T> removeFrom, List <? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return  c1.containsAll(c2);
    }

    public static<T> List range(List <? super T> list, Object min, Object max) {
        return range(list, min, max, new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return 0;
            }
        });
    }



    public static<T> List range(List list, Object min, Object max, Comparator comparator) {
        return  list;
    }
}

