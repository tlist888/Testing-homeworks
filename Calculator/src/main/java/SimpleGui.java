import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui extends JFrame{
    private JButton button = new JButton("=");
    private JTextField input1 = new JTextField("", 5);
    private JTextField input2 = new JTextField("", 5);
    private JLabel div = new JLabel("/");
    private JLabel result = new JLabel();

    Calculator calc = new Calculator();


    public SimpleGui(){
        super("Calculator");
        this.setBounds(100,100,400,300);
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

    class CommandAction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String a = input1.getText();
            String b = input2.getText();
            String res = calc.checkNumbers(a, b);

            if(res == "Ok") {
                result.setText(calc.div(a, b) + "");
            }
            else{
                showErrorWindow(res);
            }
        }
    }

    public void showErrorWindow(String error){

        JDialog dialog = new JDialog(this, true);
        dialog.setTitle("Error");
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel(error));
        dialog.setResizable(false);
        dialog.setSize(200,100);
        dialog.setVisible(true);


    }
}


