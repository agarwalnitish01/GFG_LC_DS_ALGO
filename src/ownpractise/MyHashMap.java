package ownpractise;
import java.util.*;

class Pair{
    int key;
    int val;
    Pair (int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class MyHashMap {
    private int size;
    private List[] map ;

    public MyHashMap() {
        this.size = 10;
        this.map = new List[size];
    }

    public MyHashMap(int size) {
        this.size = size;
        this.map = new List[size];
    }

    public void put(int key, int value) {

        List list = map[key%size];
        if(list == null){
            list = new ArrayList<>();
            list.add(new Pair(key, value));
            map[key%size] = list;
        } else {
            for(Object itm : list){
                Pair pair = (Pair)itm;
                if(pair.key == key){
                    pair.val = value;
                    return;
                }
            }

            list.add(new Pair(key, value));

        }
    }

    public int get(int key) {
        List list = map[key%size];
        if(list == null){
            return -1;
        }

        for(Object itm : list){
            Pair pair = (Pair)itm;
            if(pair.key == key){
                return pair.val;
            }
        }
        return -1;
    }


    public void remove(int key) {
        List list = map[key%size];
        if(list == null){
            return;
        }


        Pair pair;
        for(int i = 0; i < list.size(); i++){
            pair = (Pair)list.get(i);
            if(pair.key == key){
                list.remove(pair);
                break;
            }
        }

    }

    public static void main(String args[]){
        MyHashMap myHashMap = new MyHashMap(10);
        myHashMap.put(1,10);
        myHashMap.put(2,20);
        myHashMap.put(3,30);
        myHashMap.put(4,40);
        myHashMap.put(11,50);
        System.out.print(myHashMap.get(1));
        System.out.print(myHashMap.get(2));
        System.out.print(myHashMap.get(3));
        System.out.print(myHashMap.get(4));
    }
}


