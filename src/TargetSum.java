import java.util.*;

/**
 * Given a positive integer array and target number, return a sub-array which sum can sum to the target number;
 * return null if there is no such list.
 * 
 * Example: [4, 3, 2, 3, 5, 2, 1] 5
 * Output: [1, 4]
 * Note: [5] is also a correct answer, and the output order in a group doesn't matter.
 * @author bin
 *
 */
public class TargetSum {
  
  public List<Integer> getAList(int[] nums, int target){
    if(nums==null || nums.length==0 || target<=0) return null;
    Arrays.sort(nums);
    List<Integer> list=new ArrayList<>();
//    backtrack(nums, list, nums.length-1, target);
    return list;
  }
  
//  private boolean backtrack(int[] nums, List<Integer> list, int start, int remain){
//    if(start>nums.length-1 || remain<nums[0]) {
//      return ;
//    }else{
//      for(int i=start;i<nums.length;i++){
//        list.add(nums[i]);
//        if(backtrack(nums, list, i+1, remain-nums[i])) {
//          return true;
//        }
//        list.remove(list.size()-1);
//      }
//    }
//    
//    for(int i=end-1;i>=0;i--){
//      list.add(nums[i]);
//      backtrack(nums, list, end-1, remain-nums[end]);
//      list.remove(list.size()-1);
//      backtrack(nums, list, end-1, remain);
//    }
//    System.out.println(list);
//    return false;
//  }
  
  public static void main(String[] args) {
    int[] nums={4, 3, 2, 3, 2, 1};
    TargetSum test=new TargetSum();
    System.out.println(test.getAList(nums, 5));
  }

}
