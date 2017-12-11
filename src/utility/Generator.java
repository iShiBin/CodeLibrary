package utility;
/**
 * Generate JSON test case.
 */
import java.util.*;

public class Generator {
  /**
   * format: [...]
   */
  static String testCase;
  /**
   * @param cases: each of the case is in format "[a, b]"
   * @return
   */
  public static void print(String[] cases) {
    if (cases == null)
      return ;
    StringBuilder json = new StringBuilder("{");
    for (int i = 0; i < cases.length; i++) {
      json.append("\"" + String.valueOf(i) + "\":[");
      json.append(cases[i]);
      json.append("],");
    }
    json.deleteCharAt(json.length() - 1);
    json.append('}');
    System.out.println(json);
  }
  
  public static void print(List<String> cases) {
    String[] s=cases.toArray(new String[0]);
    print(s);    
  }
  
  public Generator(){}
  public Generator(String str){
    testCase = str;
  }
  
  public static String generateCase(String str){
    return "[" + str + "]";
  }
  
  public static String quote(char[] ch){
    StringBuilder builder=new StringBuilder();
    builder.append("["+quote(ch[0]));
    
    for(int i=1;i<ch.length;i++){
      builder.append(","+quote(ch[i]));
    }
    builder.append("]");
    return builder.toString();
  }
  
  private static String quote(char c){
    return getQuote()+c+getQuote();
  }
  
  public static String quote(String s){
    return getQuote()+s+getQuote();
  }
  
  private static String getQuote(){
    return "\"";
  }
  
  public String getTestCase(){
    return this.testCase;
  }
  

}
