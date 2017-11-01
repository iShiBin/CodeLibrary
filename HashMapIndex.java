import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import tree.TreeNode;

public class HashMapIndex {

  @Test
  public void test() {
    Map<Integer, TreeNode> map=new TreeMap<>();
    map.put(1, new TreeNode(1));
    map.put(1, new TreeNode(2));
    map.put(2, new TreeNode(3));
    
    System.out.println(map);
    System.out.println(map.get(1));
  }

}
