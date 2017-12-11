package api;

/**
 * Use Java API to get the max/min in a bunch of numbers
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MaxMin {
  public static void main(String[] args){
//    
//    
    int max, min;
    max=IntStream.of(2,8,3,6,4,7).max().getAsInt();
    System.out.println(max);
    
    int[] nums={2,8,3,6,4,7};
    Arrays.stream(nums).max().getAsInt();
    
    List<Integer> list=Arrays.asList(2,8,3,6,4,7);
    max = Collections.max(list);
    min = Collections.min(list);
    
    list.stream().mapToInt(e->e.intValue()).max().getAsInt();
    list.stream().mapToInt(e->e.intValue()).min().getAsInt();
    
    IntStream stream=IntStream.of(2,8,3,6,4,7);
    max=stream.max().getAsInt();
    
    int size=100;
    long start=0, end=0;
    Random r=new Random();
    
//    get the max/min from an array
    nums=r.ints(size).toArray();
    start=System.currentTimeMillis();
    list=Arrays.stream(nums).boxed().collect(Collectors.toList());
    max=Collections.max(list);
    end=System.currentTimeMillis();
    System.out.println("max:"+max+"\ttime(ms):"+(end-start));
    
    nums=r.ints(size).toArray();
    start=System.currentTimeMillis();
    max=IntStream.of(nums).max().getAsInt();
    end=System.currentTimeMillis();
    System.out.println("max:"+max+"\ttime(ms):"+(end-start));
    
  }
}
