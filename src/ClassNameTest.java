import java.io.IOException;
import java.util.HashMap;

public class ClassNameTest {

    public static void main(String args[]) throws IOException {
        Object o = "hello";
//        o.length();// do not work because the compiler doesn't know it is a string
        
        System.out.println("class name is: " + o.getClass().getName());
        o = new HashMap();
        System.out.println("class name is: " + o.getClass().getName());
        Boolean b = new Boolean(true);
        o = b;
        System.out.println("class name is: " + o.getClass().getName());
        o = new StringBuffer();
        Class c = o.getClass();
        System.out.println("class name is: " + c.getName());
    }
}

/*
Executing the ClassNameTest class produces the following console output:

class name is: java.lang.String
class name is: java.util.HashMap
class name is: java.lang.Boolean
class name is: java.lang.StringBuffer
*/