import java.util.*;

import org.junit.Assert;

class CollectionsLab {

    public static void main(String[] args) {
        CollectionsLab test=new CollectionsLab();
        test.setTest();
        test.hashSetTest();
    }
    
    void setTest(){
        Set<Integer> set=new HashSet<>();
        
//        test the return type of add()
        Assert.assertTrue(set.add(1));
        Assert.assertFalse(set.add(1));
        
//        set are equal when they have the same element
        Set<Integer> anotherSet=new HashSet<>();
        set.clear();
        set.addAll(Arrays.asList(1,3,2));
        anotherSet.addAll(Arrays.asList(3,2,1));
        Assert.assertTrue("Two sets are equal when they have the same elements", set.equals(anotherSet));
        
        set.clear();
        set.add(null);
        Assert.assertTrue("Null is also an element", set.size()==1);
    }
    
    void hashSetTest(){
        Set<Object> set=new HashSet<>();
        set.add(1);
        set.add("hi");
        set.add(3.14);
        set.add("eat me");
        System.out.println(set);
    }
}
