import java.util.*;

class Solution {
	public int calculate(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int[] nums = Arrays.stream(s.split("[^0-9]")).mapToInt(e->Integer.parseInt(e)).toArray();
		String[] ops = s.split("[0-9]");//have a empty token in the beginning
//		System.out.println(Arrays.toString(nums));
//		System.out.println(Arrays.toString(operators));
		String priority = "+-*/";
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=1;i<ops.length;i++){
			if(i==ops.length-1){
				int y=stack.pollLast();
				int x=stack.pollLast();
				stack.offer(calculate(x,y,ops[i]));
			}
		}
		
		return 0;
	}


	private int calculate(int x, int y, String op) {
		if (op == "*")
			return x * y;
		else if (op == "/")
			return x / y;
		else if (op == "+")
			return x + y;
		else
			return x - y;
	}
	
	public static void main(String[] args){
		new Solution().calculate("3+6*7");
	}
}