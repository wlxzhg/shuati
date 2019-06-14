package cn.xiaozhigang.code.basic.BasicGramer.LruCache;

import java.util.*;

public class MyLRUCache<K,V> {
    private static final float HASH_MAP_LOADFACTOR = 0.75F;
    private int cacheSize;
    private LinkedHashMap<K,V> map;

    public MyLRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        int hashMapCapacity = (int) Math.ceil(cacheSize / HASH_MAP_LOADFACTOR) + 1;

        map = new LinkedHashMap<K, V>(hashMapCapacity,HASH_MAP_LOADFACTOR,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > MyLRUCache.this.cacheSize;
            }
        };
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key,V value) {
        map.put(key,value);
    }

    public String toString() {
        String ans = "";
        Set<HashMap.Entry<K,V>> set = map.entrySet();
        for(HashMap.Entry<K,V> e : set) {
            ans += "[" + e.getKey() + " : " + e.getValue() + "],";
        }
        return ans;
    }

    public static void main(String[] args) {
        MyLRUCache<Integer,String> cache = new MyLRUCache<Integer, String>(3);
        cache.put(1,"one");
        System.out.println(cache.toString());
        cache.put(2, "two");
        System.out.println(cache.toString());
        cache.put(3, "three");
        System.out.println(cache.toString());
        cache.put(4, "three");
        System.out.println(cache.toString());
        cache.get(3);
        System.out.println(cache.toString());

    }
}
