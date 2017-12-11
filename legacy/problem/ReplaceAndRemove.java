package problem;

import java.util.*;

import utility.Generator;

public class ReplaceAndRemove {
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
  // @exclude

  static String randString(int len) {
    Random gen = new Random();
    StringBuilder ret = new StringBuilder();
    while (len-- > 0) {
      ret.append((char) (gen.nextInt(4) + 97));
    }

    return ret.toString();
  }

  static void checkAns(String s, String ans) {
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == 'a') {
        temp.append('d');
        temp.append('d');
      } else if (s.charAt(i) != 'b') {
        temp.append(s.charAt(i));
      }
    }
    assert (ans.equals(temp.toString()));
  }

  public static void main(String[] args) {
    Random gen = new Random();
    List<String> cases = new ArrayList<>();
    for (int times = 0; times < 100; ++times) {
      String s;
      if (args.length == 1) {
        s = args[0];
      } else {
        s = randString(gen.nextInt(100) + 1);
      }
      // System.out.println(s);
      // System.out.println();
      int size = (s.length() << 1) + 1;
      char[] sCopy = new char[size];

      for (int i = 0; i < s.length(); ++i) {
        sCopy[i] = s.charAt(i);
      }

      cases.add(size + "," + Generator.quote(sCopy));

      int finalSize = solution(s.length(), sCopy);

      // StringBuilder ans = new StringBuilder();
      // for (int i = 0; i < finalSize; ++i) {
      // ans.append(sCopy[i]);
      // }
      // checkAns(s, ans.toString());
    }
    Generator.print(cases);
  }
}
