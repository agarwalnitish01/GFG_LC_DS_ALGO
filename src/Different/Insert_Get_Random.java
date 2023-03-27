package Different;

import java.util.*;

class Insert_Get_Random {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;
    int size = 0;

    public Insert_Get_Random() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            size++;
            map.put(val, size - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int index = map.get(val);
            int lastelement = list.get(size - 1);
            list.set(index, lastelement);
            list.remove(size - 1);
            size--;
            map.put(lastelement, index);
            map.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
