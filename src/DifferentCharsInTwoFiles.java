
//package vmware;
/**You have two servers. Both of these servers have an identical file with billion characters except for one single character. 
 * These servers are connected over a very slow connection.
 * How do you find the different character? 
 */
import java.util.*;

/**
 * Solution: 
 * (1) P XOR P' will have some bit set, which means P and P' differ on that bit.
 * (2) Divide every element in 2 sets... one with that bit as 0 & another with that bit as 1.
 * (Note that both sets will span across both machines, but we will not merge them)
 * (3) P will be in set 1, P' will be in set2. XOR again within set-1 that will yield P & set-2 will yield P'.
 * 
 * Note: It is similar with swapping two elements using bit manipulation.
 * @author bin
 *
 */
class DifferentCharsInTwoFiles {

  char[] find(char[] file1, char[] file2){
    int xor = getXOR(file1) ^ getXOR(file2);
    int p=Integer.numberOfTrailingZeros(xor);

    int[] xor1=groupBitXOR(file1, p);
    int[] xor2=groupBitXOR(file2, p);
    
    int unset=xor1[0]^xor2[0]^xor;
    int set  =xor1[1]^xor2[1]^xor;
    
    return new char[]{(char)(unset), (char)(set)};
  }
  
  int getXOR(char[] file){
    int xor=0;
    for(char c:file){
      xor^=c;
    }
    return xor;
  }
  
  /**
   * To divide the char[] into two groups by a specific bit position
   * @param ch
   * @param p
   * @return an integer array having two numbers.
   * The first of which is the XOR of numbers in the input array with value '0',
   * and the second is the one with value '1'.
   */
  int[] groupBitXOR(char[] ch, int p){
    int set=0, unset=0;
    for(char c:ch){
      if ((c>>>p & 1) == 0) {//bug: need to &1 to get a right most bit
        System.out.println(Integer.toBinaryString(c));
        unset^=c;
      }
      else set^=c;
    }
    return new int[]{unset, set};
  }
  
  static void displayBits(char[] ch){
    for(char c:ch){
      System.out.printf("%8s\n",Integer.toBinaryString(c));
    }
  }
  
  public static void main(String[] args) {
    Random r=new Random();
    int size=2;
    int[] chars = r.ints(size, 32, 127).toArray();
    char[] file1=new char[size];
    for(int i=0;i<file1.length;i++){
      file1[i]=(char) chars[i];
    }
    
    char[] file2 = Arrays.copyOf(file1, size);
    file2[r.nextInt(size)]=(char) (r.nextInt(127-32) + 32);
    
    System.out.println(Arrays.toString(file1));
    System.out.println(Arrays.toString(file2));
    displayBits(file1);
    displayBits(file2);
    
    DifferentCharsInTwoFiles test=new DifferentCharsInTwoFiles();
    System.out.println(Arrays.toString(test.find(file1, file2)));
  }
}
