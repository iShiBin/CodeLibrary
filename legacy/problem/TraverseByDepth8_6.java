package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tree.BinaryTree;
import tree.TreeNode;
import utility.DataBuilder;

class TraverseByDepth8_6 {
  public static int[][] solution(TreeNode root){
    LinkedList<List<Integer>> list=new LinkedList<>();
    getLevelsAll(root,0,list);
    
    int[][] result=new int[list.size()][];
    for(int i=0;i<result.length;i++){
      result[i]=list.get(i).stream().mapToInt(e->e.intValue()).toArray();
    }
    return result;
  }
  
  private static void getLevelsAll(TreeNode root, int level, List<List<Integer>> list){
    
    if(root==null) return;
    
    if(list.size()==level){
      List<Integer> l=new ArrayList<>();
      l.add(root.val);
      list.add(l);
    }else{
      list.get(level).add(root.val);
    }
    
    if(root!=null) getLevelsAll(root.left,level+1,list);
    if(root!=null) getLevelsAll(root.right,level+1,list);
  }
  
  public static void main(String[] args) {
    TreeNode tree = BinaryTree.buildTree(DataBuilder.getIntArray(10, 0, 100));
    BinaryTree.print(tree);
    int[][] list=TraverseByDepth8_6.solution(tree);
    for(int[] l:list){
      System.out.println(Arrays.toString(l));
    }
    
    generateCase();
  }
  
  private static void generateCase(){
    DataBuilder.printInts();
  }

}
