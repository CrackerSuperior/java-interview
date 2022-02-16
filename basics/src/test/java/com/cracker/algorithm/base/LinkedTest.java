package com.cracker.algorithm.base;

import com.cracker.algorithm.base.struct.linked.Linked;
import com.cracker.algorithm.base.struct.linked.SinglyLinked;
import org.junit.Test;

public class LinkedTest {
    
    @Test
    public void linkedTest() {
    
        Linked<Integer> linked = new SinglyLinked<>();
        
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.add(6);
        linked.add(7);
    
        for (int i = 0; i < linked.size(); i++) {
            System.out.println(i + "=" + linked.get(i));
        }
    
        System.out.println(linked.contains(4));
        System.out.println(linked.contains(14));
        
        linked.stream().forEach(System.out::println);
    
        System.out.println("remove = " + linked.remove());
        linked.stream().forEach(System.out::println);
    
        System.out.println("remove3 = " + linked.remove(3));
        linked.stream().forEach(System.out::println);
    
        System.out.println("removeLast = " + linked.removeLast());
        linked.stream().forEach(System.out::println);

        System.out.println(linked.set(linked.size() - 1, 100));
        linked.stream().forEach(System.out::println);
    
    }
}
