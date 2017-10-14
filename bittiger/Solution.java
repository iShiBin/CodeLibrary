import java.util.*;

public class Solution {
  public int[][] solution(int n, int[][] edges) {
    int[][] nums = new int[n][n];
    for (int[] num : edges) {
      int pre = num[0];
      int cur = num[1];

      nums[pre][cur] = 1;
    }
    return nums;
  }
}