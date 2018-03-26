import java.util.*;
import javax.swing.*;

public class InfixEval {
  private static ArrayList<Integer> num = new ArrayList<>();
  private static ArrayList<String> op = new ArrayList<>();
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
          int oprnd = operand.pop();
          String oprtr = operator.pop();
          preparePrecedence(oprnd, oprtr);
          if (operand.isEmpty()) {
            result = getResult();
            operand.push(result);
            break;
          }
        }
      } else if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
        operator.push(tokens[i]);
      }
    }
    while (!operator.isEmpty()) {
      int firstOperand = operand.pop();
      String opr = operator.pop();
      preparePrecedence(firstOperand, opr);
    }
    result = getResult();
    operand.push(result);
    System.out.println(operand.pop());
  }

  public static void preparePrecedence(int x, String s){
    if (num.size() == 0) {
        num.add(x);
    } else {
      num.add(0, x);
    }
    if (op.size() == 0) {
      op.add(s);
    } else {
      op.add(0, s);
    }
  }

  public static int getResult() {
    int rslt = 0;
    System.out.println(op.indexOf("+"));
    try {
      while (op.indexOf("*") != -1) {
        int ind = op.indexOf("*");
        int multiply = num.get(ind-1) * num.get(ind);
        num.remove(ind);
        num.set(ind-1, multiply);
        op.remove(ind);
      }
      while (op.indexOf("/") != -1) {
        int ind = op.indexOf("/");
        int division = num.get(ind-1) / num.get(ind);
        num.remove(ind);
        num.set(ind-1, division);
        op.remove(ind);
      }
      while (op.indexOf("+") != -1) {
        int ind = op.indexOf("+");
        int addition = num.get(ind-1) + num.get(ind);
        num.remove(ind);
        num.set(ind-1, addition);
        op.remove(ind);
      }
      while (op.indexOf("-") != -1) {
        int ind = op.indexOf("-");
        int subtract = num.get(ind-1) - num.get(ind);
        num.remove(ind);
        num.set(ind-1, subtract);
        op.remove(ind);
      }
      rslt = num.get(0);
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
