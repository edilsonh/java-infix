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
        operand.push(tokens[i]);
      } else {
        operator.push(tokens[i]);
      }
    }
    String ggg = Arrays.toString(operand.toArray());
    System.out.println("Operands: " + ggg);
    String qqq = Arrays.toString(operator.toArray());
    System.out.println("Operators: " + qqq);
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
