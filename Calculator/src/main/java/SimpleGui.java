import Exceptions.EmptyFieldException;
import Exceptions.LeadingZeroExceptions;
import Exceptions.LongNumberException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Графический интерфейс приложения содержит следующие элементы управления:
 * - три текстовых поля: делимое А, делитель В и частное С;
 * - кнопка «=».
 * При нажатии на кнопку «=» выполняется операция деления, результат выводится в поле С.
 * Операция выполняется по всем правилам деления. Ввод в поля немаскированный.
 * При выполнении недопустимых действий пользователю выдается всплывающее окно с описанием ошибки.
 **/


public class SimpleGui extends JFrame {
    private JButton button = new JButton("=");
    private JTextField input1 = new JTextField("", 5);
    private JTextField input2 = new JTextField("", 5);
    private JLabel div = new JLabel("/");
    private JLabel result = new JLabel();
    Calculator calc = new Calculator();


    public SimpleGui() {
        super("Calculator");
        this.setBounds(100, 100, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener action = new CommandAction();
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(input1);
        container.add(div);
        container.add(input2);
        container.add(button);
        container.add(result);
        button.addActionListener(action);
    }

    class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String a = input1.getText();
                String b = input2.getText();

                String res = calc.div(a, b);
                result.setText(res + "");

            } catch (ArithmeticException e) {
                result.setText("");
                ShowWindow.showWindow("Division by zero is impossible.");
            } catch (NumberFormatException e) {
                result.setText("");
                ShowWindow.showWindow("Number is not a number");
            } catch (EmptyFieldException e) {
                result.setText("");
                ShowWindow.showWindow("Number field is empty.");
            } catch (LongNumberException e) {
                result.setText("");
                ShowWindow.showWindow("Number is too long.");
            } catch (LeadingZeroExceptions e) {
                result.setText("");
                ShowWindow.showWindow("The number has leading zero.");
            }

        }
    }
}


