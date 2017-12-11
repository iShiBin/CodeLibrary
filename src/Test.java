
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.plaf.synth.SynthSeparatorUI;

import tree.*;

class Test {

  public static void main(String[] args) {
	List<Integer> list = Arrays.asList(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6);
	Collections.sort(list);
	System.out.println(list);
  }

}