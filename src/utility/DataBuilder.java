package utility;
/**
 * Generate JSON test cases to verify algorithms solutions.
 * Usage:
 * - main(): to generate the required JSON text in the console
 * - get*(): helper function to return proper values
 * - print*(): the actual worker
 * @author bin
 */

import java.util.*;
import java.util.stream.*;


public class DataBuilder {
  
  public static void main(String[] args) {
    DataBuilder.printInts();
  }
  
  
  private static Random random = new Random();
  private static int caseSize=100; //max size of a test case for array
  private static int caseNum=random.nextInt(80) + 20; // 
  
  /**
   * @return
   */
  public static int getInt(){
    return random.nextInt();
  }
  
  public static int getInt(int bound){
    return random.nextInt(bound);
  }
  
  public static int getInt(int origin, int bound){
    return random.ints(origin, bound).findFirst().getAsInt();
  }
  
  public static int getInt(int[] nums){
    return nums[random.nextInt(nums.length)];
  }
  
  public static int[] getIntArray(){
    return random.ints(caseSize).toArray();
  }
  
  /**
   * @return the size could be less than the specified size if distinct
   */
  public static int[] getIntArray(boolean distinct, boolean sorted){
    return getIntArray(caseSize, Integer.MIN_VALUE, Integer.MAX_VALUE, distinct, sorted);
  }
  
  public static int[] getIntArray(int border){
    return getIntArray(0, border);
  }
  
  public static int[] getIntArray(int low, int high){
    return getIntArray(caseSize, low, high, false, false);
  }
  
  public static int[] getIntArray(int size, int low, int high){
    return getIntArray(size, low, high, false, false);
  }
  
  /**
   * Versatile function to produce a integer array from low to high, and with option distinct, sorted.
   * @param size: the size of the test case defaulted to the DataBuilder.size.
   * @param low: low boundary
   * @param high: high boundary
   * @param distinct
   * @param sorted
   * @return
   */
  public static int[] getIntArray(int size, int low, int high, boolean distinct, boolean sorted){
    int[] nums=random.ints(size, low, high).toArray();
    if(distinct) nums=IntStream.of(nums).distinct().toArray();
    if(sorted) nums=IntStream.of(nums).sorted().toArray();
    return nums;
  }
  
  public static int[] getIntArrayRandomSize(int size, int low, int high, boolean distinct, boolean sorted){
    return getIntArray(random.nextInt(size),low, high, distinct, sorted);
  }
  
  public static int[][] getIntArray2(int low, int high, int row, int col){
    int[][] nums=new int[row][col];
    for(int i=0;i<row;i++){
      nums[i] = getIntArray(col, low, high);
    }
    return nums;
  }
  
  /**
   * This is for graph so not very often used.
   * @param vertexNumber
   * @param edgeNumber
   * @return
   */
  public static int[][] generateEdges(int vertexNumber, int edgeNumber){
    int[][] result=new int[edgeNumber][2];
    
    //max edge number
    edgeNumber = Math.min(edgeNumber, (vertexNumber*vertexNumber-1)/2);
    Set<int[]> set=new HashSet<>();
    while(set.size()<edgeNumber){
      int x=random.nextInt(vertexNumber);
      int y=random.nextInt(vertexNumber);
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
  
  public static void printInt(){
    printInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public static void printInt(int bound){
    printInt(0, bound);
  }
  
  public static void printInt(int origin, int bound){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      json.append(DataBuilder.getInt(origin, bound));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  public static void printIntInt(){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      
      json.append(DataBuilder.getInt());
      
      json.append(",");
      json.append(DataBuilder.getInt());
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  
  public static void printIntInt(int bound){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      
      json.append(DataBuilder.getInt(0, bound));
      
      json.append(",");
      json.append(DataBuilder.getInt(0, bound));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  public static void printIntInt(int low, int high){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      
      json.append(DataBuilder.getInt(low, high));
      
      json.append(",");
      json.append(DataBuilder.getInt(low, high));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  public static void printInts(){
    printInts(caseSize, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
  }
  
  public static void printInts(int low, int high){
    printInts(caseSize, low, high, false, false);
  }
  
  public static void printInts(int size, int low, int high){
    printInts(size, low, high, false, false);
  }
  
  //size is the max size. the length output array is [0, random.nextInt(size)). 
  public static void printInts(int size, int low, int high, boolean distinct, boolean sorted){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      //change the following for fixed size array
      json.append(Arrays.toString(DataBuilder.getIntArray(random.nextInt(size), low, high, distinct, sorted)));
//      int[] nums = DataBuilder.getIntArray(random.nextInt(size), low, high, distinct, sorted);
//      json.append(Arrays.toString(nums));
//      int start=random.nextInt(nums.length)+1;
//      int end = random.nextInt(nums.length)+1;
//      json.append(","+ Math.min(start, end) +","+ Math.max(start, end));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  /**
   * This might be the most frequently used function to generate an int and an integer array 
   */
  public static void printIntInts(){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      int size=random.nextInt(caseSize);
      json.append("\""+String.valueOf(i)+"\":[");
      
      json.append(DataBuilder.getInt(0, size));
      
      json.append(",");
      json.append(Arrays.toString(DataBuilder.getIntArray(size)));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
    
  public static void printIntsInt(){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      int size=random.nextInt(caseSize);
      json.append(Arrays.toString(DataBuilder.getIntArray(size)));
      json.append(",");
      json.append(DataBuilder.getInt(0, size));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
    
  }
  public static void printIntsInts(){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[");
      int size=random.nextInt(caseSize);
      json.append(Arrays.toString(DataBuilder.getIntArray(size)));
      json.append(",");
      json.append(Arrays.toString(DataBuilder.getIntArray(size)));
      json.append("],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  public static void printInts2(){
    StringBuilder json=new StringBuilder("{");
    for(int i=0;i<=caseNum;i++){
      json.append("\""+String.valueOf(i)+"\":[[");
      int n=DataBuilder.getInt(50);
      int[][] data=DataBuilder.getIntArray2(1, 100, n, n);
      json.append(Arrays.toString(data[0]));
      
      for(int j=1;j<data.length;j++){
        json.append(","+Arrays.toString(data[j])); 
      }
      json.append("]],");
    }
    json.deleteCharAt(json.length()-1);
    json.append('}');
    System.out.println(json);
  }
  
  
}
