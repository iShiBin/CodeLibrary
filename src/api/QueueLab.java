package api;

import java.util.ArrayDeque;
import java.util.Arrays;

public class QueueLab {

	public static void main(String[] args) {
		ArrayDeque<Integer> ad = new ArrayDeque<>(Arrays.asList(1, 3, 5));
		System.out.println(ad.toArray()[2]);
	}

}
