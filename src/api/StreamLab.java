package api;

import java.util.Arrays;
import java.util.stream.*;

public class StreamLab {
	
	//generate a 1...n sequence using API using IntStream.iterate()
	public static int[] generateSequence(int n){
		return IntStream.iterate(1, i->i+1).limit(n).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateSequence(11)));
	}

}
