import java.awt.*;
import java.awt.event.*;

class calculator extends WindowAdapter implements ActionListener {
    Frame f = new Frame();
    TextField t = new TextField();
    Button b0 = new Button("0");
    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button ba = new Button("+");
    Button bs = new Button("-");
    Button bm = new Button("*");
    Button bd = new Button("/");
    Button bc = new Button("C");
    Button bce = new Button("CE");
    Button be = new Button("=");
    Button bp = new Button(".");
    Button bE = new Button("Exit");

    double number1, number2, result;
    char operation;

    public calculator() {
        f.add(t);
        f.add(b0);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(ba);
        f.add(bs);
        f.add(bm);
        f.add(bd);
        f.add(bc);
        f.add(bce);
        f.add(be);
        f.add(bp);
        f.add(bE);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        bc.addActionListener(this);
        bce.addActionListener(this);
        be.addActionListener(this);
        bp.addActionListener(this);
        bE.addActionListener(this);
        f.addWindowListener(this);

        t.setBounds(5, 30, 396, 70);
        b7.setBounds(0, 102, 60, 60);
        b8.setBounds(60, 102, 60, 60);
        b9.setBounds(120, 102, 60, 60);
        b4.setBounds(0, 162, 60, 60);
        b5.setBounds(60, 162, 60, 60);
        b6.setBounds(120, 162, 60, 60);
        b1.setBounds(0, 222, 60, 60);
        b2.setBounds(60, 222, 60, 60);
        b3.setBounds(120, 222, 60, 60);
        b0.setBounds(0, 282, 180, 60);
        bp.setBounds(180, 282, 60, 60);
        bs.setBounds(180, 102, 60, 60);
        be.setBounds(240, 282, 60, 60);
        ba.setBounds(180, 162, 60, 60);
        bm.setBounds(180, 222, 60, 60);
        bd.setBounds(240, 102, 60, 60);
        bc.setBounds(240, 162, 60, 60);
        bce.setBounds(240, 222, 60, 60);
        bE.setBounds(290, 470, 100, 20);

        f.setLayout(null);
        f.setSize(400, 500);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bE) {
            System.exit(0);
        }
        if (e.getSource() == b1) {
            t.setText(t.getText() + 1);
        }
        if (e.getSource() == b2) {
            t.setText(t.getText() + 2);
        }
        if (e.getSource() == b3) {
            t.setText(t.getText() + 3);
        }
        if (e.getSource() == b4) {
            t.setText(t.getText() + 4);
        }
        if (e.getSource() == b5) {
            t.setText(t.getText() + 5);
        }
        if (e.getSource() == b6) {
            t.setText(t.getText() + 6);
        }
        if (e.getSource() == b7) {
            t.setText(t.getText() + 7);
        }
        if (e.getSource() == b8) {
            t.setText(t.getText() + 8);
        }
        if (e.getSource() == b9) {
            t.setText(t.getText() + 9);
        }
        if (e.getSource() == b0) {
            t.setText(t.getText() + 0);
        }
        if (e.getSource() == ba) {
            number1 = Double.parseDouble(t.getText());
            t.setText("");
            operation = '+';
        }
        if (e.getSource() == bs) {
            number1 = Double.parseDouble(t.getText());
            t.setText("");
            operation = '-';
        }
        if (e.getSource() == bm) {
            number1 = Double.parseDouble(t.getText());
            t.setText("");
            operation = '*';
        }
        if (e.getSource() == bd) {
            number1 = Double.parseDouble(t.getText());
            t.setText("");
            operation = '/';
        }
        if (e.getSource() == bp) {
            t.setText("");
        }
        if (e.getSource() == be) {
            number2 = Double.parseDouble(t.getText());
            switch (operation) {
                case '+':
                    t.setText(String.valueOf(number1 + number2));
                    break;
                case '-':
                    t.setText(String.valueOf(number1 - number2));
                    break;
                case '*':
                    t.setText(String.valueOf(number1 * number2));
                    break;
                case '/':
                    if (number2 != 0) {
                        t.setText(String.valueOf(number1 / number2));
                    } else {
                        t.setText("Division by zero is not posible");
                    }
                    break;
                default:
                    break;
            }
        }
        if (e.getSource() == bce) {
            String a = t.getText();
            t.setText("");
            for (int i = 0; i < a.length() - 1; i++) {
                t.setText(t.getText() + a.charAt(i));
            }
        }
        if (e.getSource() == bc) {
            number1 = 0;
            number2 = 0;
            t.setText("");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}
