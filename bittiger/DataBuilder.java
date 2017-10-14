import java.util.*;

public class DataBuilder {

  // return to a random integer array having n values
  public static int[] getIntegers(int n) {
    int[] numbers = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      numbers[i] = random.nextInt();
    }
    return numbers;
  }

  // return a number array of n elements in range [1,n)
  public static int[] getNumbersInRange(int n) {
    int[] numbers = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      numbers[i] = random.nextInt(n) + 1;
    }
    return numbers;
  }

  // return a number array of n elements in range [1, max)
  public static int[] getNumbersInRange(int n, int max) {
    int[] numbers = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      numbers[i] = random.nextInt(max) + 1;
    }
    return numbers;
  }
  
  public static int[][] generateEdges(int vertex, int edge){
    int[][] result=new int[edge][2];
    
    edge = Math.min(edge, (vertex*vertex-1)/2);
    Set<int[]> set=new HashSet<>();
    Random random = new Random();
    while(set.size()<edge){
      int x=random.nextInt(vertex) + 1;
      int y=random.nextInt(vertex) + 1;
      if(x==y) continue;
      int[] ed={Math.min(x, y), Math.max(x, y)};
      set.add(ed);
    }
    
    int index=0;
    for(int[] e:set){
      result[index++]=e;
    }
    
    return result;
  }

  public static void main(String[] args) {
    for(int[] e:generateEdges(100,3000)){
      System.out.print(Arrays.toString(e)+",");
    }
    
  }
}
