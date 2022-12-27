package com.cracker.interview.basics.algorithm.base;

import com.cracker.interview.basics.algorithm.base.struct.list.ArrayList;
import com.cracker.interview.basics.algorithm.base.struct.list.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListTest {
    
    @Test
    void arrayListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertTrue(list.contains(4));
        assertFalse(list.contains(14));
        int[] ints = {0, 1, 2, 3, 4, 5};
        int[] index = {0};
        list.stream().forEach(each -> assertEquals(ints[index[0]++], each));
        list.add(6);
        assertEquals(list.remove(6), 6);
        index[0] = 0;
        list.stream().forEach(each -> assertEquals(ints[index[0]++], each));
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        int[] ints2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        index[0] = 0;
        list.stream().forEach(each -> assertEquals(ints2[index[0]++], each));
    }
}
