import java.util.*;

public class DropBall {
  
  /*
   * Time Complexity:  O(2^n)
   */
  public String findExit(int[][] matrix, int row, int col){
    Set<Character> result=new HashSet<>();
    findExit(matrix, row, col, result);
    return result.toString();
  }
  
  private void findExit(int[][] m, int row, int col, Set<Character> set) {
//    System.out.println(row+","+col+" "+m[row][col]);
    
    if(row==0 || col==m[row].length-1) {
      set.add('A');
      return ;
    }
    if(col==0 || row==m.length-1) {
      set.add('B');
      return ;
    }
    
    if (set.size() == 2) return ;

    int cur = m[row][col];
    if (row-1>-1 && m[row - 1][col] < cur)
      findExit(m, row - 1, col, set);
    if (row+1<m.length && m[row + 1][col] < cur)
      findExit(m, row + 1, col, set);
    if (col-1>-1 && m[row][col - 1] < cur)
      findExit(m, row, col - 1, set);
    if (col+1<m[row].length && m[row][col + 1] < cur)
      findExit(m, row, col + 1, set);
  }

  public static void main(String[] args) {
    int[][] matrix={
        {1,3,6,9},
        {2,3,4,9},
        {7,6,5,6},
        {9,9,9,9},
        {1,1,2,3}
    };
   
    String exit=new DropBall().findExit(matrix, 3, 1);
    System.out.println(exit);
    
  }
}

/*
       A
2 4 6 9
3 4 6 1
3 3 1 1
9 9 9 9
1 1 2 3
B
*/