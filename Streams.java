import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by 11007122 on 18.12.2017.
 */
public class Streams<T> {
    private final List<? extends T> list;

    public Streams(List<? extends T> list) {
        this.list = list;
    }

    public static<T> Streams<T> of(List<? extends T> list){
        return new Streams<>(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate){
        List<T> result = new ArrayList<>();
        for (T t:list){
            if (predicate.test(t)){
                result.add(t);
            }
        }
        return new Streams<>(result);
    }

    public <R> Streams<R> transform(Function<T, R> function){
        List<R> list = new ArrayList<>();
        for (T t : this.list) {
            list.add(function.apply(t));
        }
        return new Streams<>(list);
    }

    public <K,V> Map<K,V> toMap(Function<T, K> key, Function<T, V> value){
        Map<K,V> map = new HashMap<>();
        for (T t : list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }
}