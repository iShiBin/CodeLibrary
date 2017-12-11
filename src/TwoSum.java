import java.util.*;
import java.util.Map.*;

class TwoSum {
    private Map<Integer, Integer> num; //<n, frequency>
    
    /** Initialize your data structure here. */
    public TwoSum() {
        num=new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(num.containsKey(number)){
            num.put(number, 2);//2 is enough
        }else{
            num.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer n: num.keySet()){
            if(num.containsKey(value-n) && value!=2*n) return true;
            if(value==2*n && num.get(n)==2) return true;
        }
        return false;
    }
}