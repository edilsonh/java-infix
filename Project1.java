import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project1 extends JFrame {
  public Project1() {
    setTitle("Infix Expression Evaluator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(3,1));

    JPanel expressionPanel = new JPanel();
    expressionPanel.setLayout(new GridLayout(1,2));
    JLabel expressionLabel = new JLabel("Enter Infix Expression");
    JTextField expressionField = new JTextField("");
    expressionPanel.add(expressionLabel);
    expressionPanel.add(expressionField);
    add(expressionPanel);

    JButton eval = new JButton("Evaluate");;
    add(eval);

    JPanel resultPanel = new JPanel();
    resultPanel.setLayout(new GridLayout(1,2));
    JLabel resultLabel = new JLabel("Result");
    JTextField resultField = new JTextField("");
    resultField.setBackground(Color.LIGHT_GRAY);
    resultField.setEditable(false);
    resultPanel.add(resultLabel);
    resultPanel.add(resultField);
    add(resultPanel);

    eval.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int result = InfixEval.Evaluate(expressionField.getText());
        resultField.setText(String.valueOf(result));
      }
    });

    pack();
    setVisible(true);
    setSize(500,150);
  }

  public static void main(String[] args) {
    new Project1();
  }
}
