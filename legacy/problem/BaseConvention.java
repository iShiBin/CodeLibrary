package problem;

import java.util.*;

import utility.Generator;

public class BaseConvention {
  public static String solution(String numAsString, int b1, int b2) {
    boolean isNegative = numAsString.startsWith("-");
    int numAsInt = 0;
    for (int i = (isNegative ? 1 : 0); i < numAsString.length(); ++i) {
      numAsInt *= b1;
      numAsInt += Character.isDigit(numAsString.charAt(i))
                      ? numAsString.charAt(i) - '0'
                      : numAsString.charAt(i) - 'A' + 10;
    }
    return (isNegative ? "-" : "")
        + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
  }

  private static String constructFromBase(int numAsInt, int base) {
    return numAsInt == 0
        ? ""
        : constructFromBase(numAsInt / base, base)
              + (char)(numAsInt % base >= 10 ? 'A' + numAsInt % base - 10
                                             : '0' + numAsInt % base);
  }
  // @exclude

  public static String randIntString(int len) {
    Random r = new Random();
    StringBuilder ret = new StringBuilder();
    if (len == 0) {
      return "0";
    }
    if (r.nextBoolean()) {
      ret.append('-');
    }
    ret.append((char)('1' + r.nextInt(9)));
    while (--len != 0) {
      ret.append((char)('0' + r.nextInt(10)));
    }
    return ret.toString();
  }

  private static void unitTest(String input, int b1, int b2) {
    caseList.add("\""+input+"\","+b1+","+b2);
    
//    String yourResult = solution(input, b1, b2);
//    if (!input.equals(solution(yourResult, b2, b1))) {
//      System.err.println("Failed on " + input + " start base = " + b1
//                         + " end base = " + b2);
//      System.err.println("Your result was " + yourResult + " " + b1 + " " + b2);
//      System.exit(-1);
//    }
  }

  private static void directedTests() {
    unitTest("0", 10, 2);
    unitTest("1", 10, 2);
    unitTest("-1", 10, 2);
    unitTest("2147483647", 10, 2);
    unitTest("-2147483647", 10, 2);
    unitTest("10", 10, 16);
    unitTest("A", 16, 16);
    unitTest("B", 16, 16);
    unitTest("F", 16, 16);
    unitTest("A", 16, 10);
    unitTest("B", 16, 10);
    unitTest("F", 16, 10);
    unitTest("F", 16, 2);
    unitTest("10", 2, 4);
    unitTest("-1", 2, 4);
    unitTest("-100", 2, 4);
    unitTest("-100", 2, 4);
    unitTest("-120", 3, 4);
    unitTest("3", 4, 5);
    unitTest("FF", 16, 10);
    // Fails because overflows on changing to positive.
    // unitTest("-2147483648", 10, 2);
  }

  static List<String> caseList=new ArrayList<>();
  
  public static void main(String[] args) {
    if (args.length == 3) {
      String input = args[0];
      int b1 = Integer.parseInt(args[1]);
      int b2 = Integer.parseInt(args[2]);
      System.out.println(solution(input, b1, b2));
      unitTest(input, b1, b2);
    } else {
      directedTests();
      Random r = new Random();
      for (int times = 0; times < 100; ++times) {
        String input = randIntString(r.nextInt(9) + 1);
        int base = r.nextInt(15) + 2;
//        System.out.println("input is " + input + ", base1 = 10, base2 = " + base
//                           + ", result = " + solution(input, 10, base));
        
        unitTest(input, 10, base);
        
      }
      Generator.print(caseList);
    }
  }
}
