package com.cracker.algorithm.base;

import com.cracker.algorithm.base.struct.linked.LRUCache;
import com.cracker.algorithm.base.struct.linked.Linked;
import com.cracker.algorithm.base.struct.linked.SinglyLinked;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedTest {
    
    @Test
    void linkedTest() {
        Linked<Integer> linked = new SinglyLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.add(6);
        linked.add(7);
        assertTrue(linked.contains(4));
        assertFalse(linked.contains(14));
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        int[] index = {0};
        linked.stream().forEach(each -> assertEquals(ints[index[0]++], each));
        assertEquals(1, linked.remove());
        int[] ints2 = {2, 3, 4, 5, 6, 7};
        index[0] = 0;
        linked.stream().forEach(each -> assertEquals(ints2[index[0]++], each));

        assertEquals(5, linked.remove(3));
        int[] ints3 = {2, 3, 4, 6, 7};
        index[0] = 0;
        linked.stream().forEach(each -> assertEquals(ints3[index[0]++], each));

        assertEquals(7, linked.removeLast());
        int[] ints4 = {2, 3, 4, 6};
        index[0] = 0;
        linked.stream().forEach(each -> assertEquals(ints4[index[0]++], each));
        int[] ints5 = {2, 3, 4, 100};
        index[0] = 0;
        assertEquals(100, linked.set(linked.size() - 1, 100));
        linked.stream().forEach(each -> assertEquals(ints5[index[0]++], each));
    }

    @Test
    void LRUTest() {
        LRUCache<Integer> lruCache = new LRUCache<>(5);
        lruCache.add(1);
        lruCache.add(2);
        lruCache.add(3);
        lruCache.add(4);
        lruCache.add(5);
        int[] ints = {5, 4, 3, 2, 1};
        int[] index = {0};
        lruCache.stream().forEach(each -> assertEquals(ints[index[0]++], each));
        lruCache.add(6);
        int[] ints2 = {6, 5, 4, 3, 2};
        index[0] = 0;
        lruCache.stream().forEach(each -> assertEquals(ints2[index[0]++], each));
    }
}
