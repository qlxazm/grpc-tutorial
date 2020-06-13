package com.demo.grpc;

import com.google.common.collect.*;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qlx
 * @date 2020/6/13 9:03
 */
public class GuavaMapTest {

    @Test
    public void immutableMapTest() {
        Map<String, Integer> map = ImmutableMap.<String, Integer>builder()
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();
        assertEquals(1000, map.get("John").intValue());
        assertEquals(2000, map.get("Tom").intValue());
    }

    /**
     * 按照key进行排序
     */
    @Test
    public void immutableSortedMapTest() {
        ImmutableSortedMap<String, Integer> map = new ImmutableSortedMap
                .Builder<String, Integer>(Ordering.natural())
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Zom", 2000)
                .build();
        assertEquals("Adam", map.firstKey());
        assertEquals("Zom", map.lastKey());
        assertEquals(2000, map.lastEntry().getValue().intValue());
    }

    /**
     * 单射map
     */
    @Test
    public void bitMapTest() {
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);

        assertEquals(2, words.get("Second").intValue());
        assertEquals("First", words.inverse().get(1));
    }

    /**
     * 单个key关联多个value
     */
    @Test
    public void multiMapTest() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("pet", "cat");
        multimap.put("pet", "dog");

        assertThat(multimap.get("fruit"), containsInAnyOrder("apple", "banana"));

        // 根据字符串长度进行分组
        List<String> names = Lists.newArrayList("John", "Adam", "Tom");
        ImmutableListMultimap<Integer, String> group = Multimaps.index(names, String::length);
        assertThat(group.get(3), containsInAnyOrder("Tom"));
        assertThat(group.get(4), containsInAnyOrder("John", "Adam"));

    }

    /**
     * 使用多个key索引一个value
     */
    @Test
    public void tableTest() {
        Table<String, String, Integer> distance = HashBasedTable.create();
        distance.put("London", "Paris", 340);
        distance.put("New York", "Los Angeles", 3850);

        assertEquals(340, distance.get("London", "Paris").intValue());
    }
}
