import java.util.*;


public class Solution {
  public int[] solution(int k, int[] A) {
    Random gen = new Random();
    for (int i = 0; i < k; ++i) {
      // swap
      int r = gen.nextInt(A.length - i);
      int t = A[i];
      A[i] = A[r];
      A[r] = t;
    }
    return Arrays.copyOfRange(A, 0, k);
  }
  
  
}