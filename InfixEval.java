import java.util.*;
import javax.swing.*;

public class InfixEval {
  public static void Evaluate(String s){
    int result = 0;
    Stack<Integer> operand = new Stack<>();
    Stack<String> operator = new Stack<>();
    // add space around operators and parentheses to make splitting simpler
    String formattedS = s.replaceAll("\\+", " + ").replaceAll("\\-", " - ").replaceAll("\\*", " * ").replaceAll("\\/", " / ").replaceAll("\\(", " ( ").replaceAll("\\)", " ) ");
    String[] tokens = formattedS.split(" ");
    for (int i = 0;i<tokens.length;i++) {
      if (isInteger(tokens[i])) {
        operand.push(Integer.parseInt(tokens[i]));
      } else if(tokens[i].equals("(")) {
        operator.push(tokens[i]);
      } else if (tokens[i].equals(")")) {
        while (String.valueOf(operator.lastElement()) != "(") {
          int secondOperand = operand.pop();
          int firstOperand = operand.pop();
          String opr = operator.pop();
          result = getResult(firstOperand, secondOperand, opr);
          if (operand.isEmpty()) {
            operand.push(result);
            break;
          }
          operand.push(result);
        }
        operator.pop();
      } else if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
        operator.push(tokens[i]);
      }
    }
    while (!operator.isEmpty()) {
      int secondOperand = operand.pop();
      int firstOperand = operand.pop();
      String opr = operator.pop();
      result = getResult(firstOperand, secondOperand, opr);
      operand.push(result);
    }
    System.out.println(operand.pop());
  }

  public static int getResult(int x, int y, String s) {
    int rslt = 0;
    try {
      switch (s) {
        case "+":
          rslt = x + y;
          break;
        case "-":
          rslt = x - y;
          break;
        case "*":
          rslt = x * y;
          break;
        case "/":
          rslt = x / y;
          break;
      }
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Cannot divide by zero!");
      JFrame f = new JFrame();
      JOptionPane.showMessageDialog(f, "Cannot divide by zero, try again!");
    }
    return rslt;
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
