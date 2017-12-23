import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11007122 on 16.12.2017.
 */
public class CountMapImpl<T> implements CountMap<T>{
    private final Map<T, Integer> countMap = new HashMap<>();

    @Override
    public void add(T o) {
        Integer amount = 1;
        if(countMap.containsKey(o)) {
            amount = countMap.get(o) + 1;
        }
        countMap.put(o, amount);
    }

    @Override
    public int getCount(T o) {
        int amount = 0;
        if(countMap.containsKey(o)) {
            amount = countMap.get(o);
        }
        return amount;
    }

    @Override
    public int remove(T o) {
        int amount = getCount(o);
        countMap.remove(o);
        return  amount;
    }

    @Override
    public int size() {
        return countMap.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        source.toMap(countMap);
    }

    @Override
    public Map toMap() {
        return countMap;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        destination.putAll(countMap);
    }
}
