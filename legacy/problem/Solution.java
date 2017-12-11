package problem;

import java.util.*;

import list.*;
import utility.DataBuilder;
import utility.Generator;

//Bin
public class Solution {
  // @include
  public static int solution(int size, char[] s) {
    // Forward iteration: remove "b"s and count the number of "a"s.
    int writeIdx = 0, aCount = 0;
    for (int i = 0; i < size; ++i) {
      if (s[i] != 'b') {
        s[writeIdx++] = s[i];
      }
      if (s[i] == 'a') {
        ++aCount;
      }
    }

    // Backward iteration: replace "a"s with "dd"s starting from the end.
    int curIdx = writeIdx - 1;
    writeIdx = writeIdx + aCount - 1;
    final int finalSize = writeIdx + 1;
    while (curIdx >= 0) {
      if (s[curIdx] == 'a') {
        s[writeIdx--] = 'd';
        s[writeIdx--] = 'd';
      } else {
        s[writeIdx--] = s[curIdx];
      }
      --curIdx;
    }
    
    return finalSize;
  }
  
  public static void main(String[] args){
    int size=4;
    char[] s={'a','b','a', 'c', ' '};
    System.out.println(solution(size, s));
    
  }
}