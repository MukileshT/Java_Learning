import java.awt.*;
import java.awt.event.*;

class calculator extends WindowAdapter implements ActionListener {
    Frame f = new Frame();
    TextField displayTextField = new TextField();

    Button buttonArray[] = new Button[18];
    String labelArray[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "C", "CE", ".", "=" };

    /*
     * buttonArray[0] = 0
     * buttonArray[1] = 1
     * buttonArray[2] = 2
     * buttonArray[3] = 3
     * buttonArray[4] = 4
     * buttonArray[5] = 5
     * buttonArray[6] = 6
     * buttonArray[7] = 7
     * buttonArray[8] = 8
     * buttonArray[9] = 9
     * buttonArray[10] = addition
     * buttonArray[11] = subtraction
     * buttonArray[12] = multiplication
     * buttonArray[13] = Division
     * buttonArray[14] = clearScreen
     * buttonArray[15] = backspace
     * buttonArray[16] = decimalPoint
     * buttonArray[17] = equals
     */
    
    public float number1 = 0, number2 = 0, result = 0, tempNumber = 0;
    public String operation, operator = "\0";
    public boolean div_error = false;

    public calculator() {
        for (int i = 0; i < labelArray.length; i++) {
            buttonArray[i] = new Button(labelArray[i]);
            f.add(buttonArray[i]);
            buttonArray[i].addActionListener(this);
        }

        f.add(displayTextField);
        f.addWindowListener(this);

        displayTextField.setBounds(5, 30, 295, 70);
        buttonArray[0].setBounds(0, 282, 180, 60);
        buttonArray[1].setBounds(0, 222, 60, 60);
        buttonArray[2].setBounds(60, 222, 60, 60);
        buttonArray[3].setBounds(120, 222, 60, 60);
        buttonArray[4].setBounds(0, 162, 60, 60);
        buttonArray[5].setBounds(60, 162, 60, 60);
        buttonArray[6].setBounds(120, 162, 60, 60);
        buttonArray[7].setBounds(0, 102, 60, 60);
        buttonArray[8].setBounds(60, 102, 60, 60);
        buttonArray[9].setBounds(120, 102, 60, 60);

        buttonArray[10].setBounds(180, 162, 60, 60);
        buttonArray[11].setBounds(180, 102, 60, 60);
        buttonArray[12].setBounds(180, 222, 60, 60);
        buttonArray[13].setBounds(240, 102, 60, 60);
        buttonArray[14].setBounds(240, 162, 60, 60);
        buttonArray[15].setBounds(240, 222, 60, 60);
        buttonArray[16].setBounds(180, 282, 60, 60);
        buttonArray[17].setBounds(240, 282, 60, 60);

        f.setLayout(null);
        f.setSize(309, 351);
        f.setVisible(true);
        f.setTitle("Calculator");
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        String getString = e.getActionCommand();

        if (getString.matches("\\d") || getString.equals(".")) {
            displayTextField.setText(displayTextField.getText() + getString);
        }

        if (getString.equals("+") || getString.equals("-") || getString.equals("*") || getString.equals("/")) {

            number1 = Float.parseFloat(displayTextField.getText());
            displayTextField.setText("");
            operation = getString;

            if (operator != "\0") {
                switch (operator) {
                    case "+":
                        result = result + tempNumber + number1;
                        break;
                    case "-":
                        result = result - tempNumber - number1;
                        break;
                    case "*":
                        result = ((result == 0) ? 1 : result);
                        tempNumber = ((tempNumber == 0) ? 1 : tempNumber);
                        result = (result * tempNumber) * number1;
                        break;
                    case "/":
                        result = ((result == 0) ? 1 : result);
                        tempNumber = ((tempNumber == 0) ? 1 : tempNumber);
                        result = (result / tempNumber) / number1;
                        break;
                    default:
                        System.out.println("error ");
                        break;
                }
                tempNumber = 0;
            } else {
                tempNumber = number1;
            }
            operator = operation;
        }

        if (e.getSource() == buttonArray[14]) {
            number1 = 0;
            number2 = 0;
            result = 0;
            displayTextField.setText("");
        }
        if (e.getSource() == buttonArray[15]) {
            String a = displayTextField.getText();
            displayTextField.setText("");
            for (int i = 0; i < a.length() - 1; i++) {
                displayTextField.setText(displayTextField.getText() + a.charAt(i));
            }
        }
        if (e.getSource() == buttonArray[17]) {
            number2 = Float.parseFloat(displayTextField.getText());
            switch (operation) {
                case "+":
                    result = ((tempNumber != 0) ? (tempNumber + number2) : (result + number2));
                    break;
                case "-":
                    result = ((tempNumber != 0) ? (tempNumber - number2) : (result + number2));
                    break;
                case "*":
                    result = ((tempNumber != 0) ? (tempNumber * number2) : (result + number2));
                    break;
                case "/":
                    result = ((number2 != 0) ? (tempNumber / number2) : 0);
                    div_error = ((result == 0) ? true : false);
                    break;
                default:
                    break;
            }
            if (!div_error) {
                displayTextField.setText(String.valueOf(result));
            } else {
                displayTextField.setText("Division by zero is not possible");
                div_error = false;
            }
            operation = "\0";
            operator = "\0";
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
