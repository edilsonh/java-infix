import java.util.*;

public class InfixEval {
  public static void Evaluate(String s){
    Stack operand = new Stack();
    Stack operator = new Stack();
    // add space around operators and parentheses to make splitting simpler
    String formattedS = s.replaceAll("\\+", " + ").replaceAll("\\-", " - ").replaceAll("\\*", " * ").replaceAll("\\/", " / ").replaceAll("\\(", " ( ").replaceAll("\\)", " ) ");
    String[] tokens = formattedS.split(" ");
    System.out.println(formattedS);
    for (int i = 0;i<tokens.length;i++) {
      if (isInteger(tokens[i])) {
        System.out.println("a number");
      } else {
        System.out.println("something else...");
      }
    }
  }

  public static boolean isInteger(String n){
    try {
      int num = Integer.parseInt(n);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
