package api;

import java.util.*;

public class ListLab {
	
//	Arrays.asList(T...a) is immutable, so wrap it by using new ArrayList<>(Arrays.asList()) instead
	public static void asList(){
		List<Integer> list=Arrays.asList(1, 2);
//		list.add(3);// java.lang.UnsupportedOperationException
		
		list=new ArrayList<>(Arrays.asList(1, 2));
		list.add(3); //now, it works fine.
		System.out.println(list);
	}

	public static void main(String[] args) {
		asList();
	}

}
