package problem;

//https://www.bittiger.io/onlineJudge/problems/edit/2oCMYgbRNivkqBT8S
class XPowerOfY {
  public static int solution(int x, int y) {
    int result = 1;
    int power = y;
    if (y < 0) {
      power = -power;
      x = 1 / x;
    }
    while (power != 0) {
      if ((power & 1) != 0) {
        result *= x;
      }
      x *= x;
      // clang-format off
      power >>>= 1;
      // clang-format on
    }
    return result;
  }

  public static void main(String[] args) {
    int x=2, y=3;
    System.out.println(solution(x,y));
  }

}
