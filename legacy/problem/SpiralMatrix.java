package problem;
import java.util.*;

import utility.DataBuilder;

public class SpiralMatrix {
  // @include
  public static int[] matrixInSpiralOrder(int[][] squareMatrix) {

    final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int dir = 0, x = 0, y = 0;
    int[] spiralOrdering = new int[squareMatrix.length * squareMatrix.length];

    for (int i = 0; i < spiralOrdering.length; ++i) {
      spiralOrdering[i] = squareMatrix[x][y];

      squareMatrix[x][y] = 0;
      int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
      if (nextX < 0 || nextX >= squareMatrix.length || nextY < 0 || nextY >= squareMatrix.length
          || squareMatrix[nextX][nextY] == 0) {
        dir = (dir + 1) % 4;
        nextX = x + SHIFT[dir][0];
        nextY = y + SHIFT[dir][1];
      }
      x = nextX;
      y = nextY;
    }
    return spiralOrdering;
  }
  
  //generate the test data
  public static void main(String[] args) {
    int size=4;
    int[][] nums=DataBuilder.getIntArray2(1, 100, 4, 4);
    
    for(int[] n:nums)
    System.out.println(Arrays.toString(n));
    
    System.out.println(Arrays.toString(matrixInSpiralOrder(nums)));
  }
}
