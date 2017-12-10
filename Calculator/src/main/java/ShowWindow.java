import javax.swing.*;
import java.awt.*;

/**
 * Всплывающее окно с описанием ошибки.  Приниает на вход текст сообщения.
 */


public class ShowWindow {

    public static void showWindow(String error) {
        JDialog dialog = new JDialog();

        dialog.setLocationRelativeTo(null);
        dialog.setSize(400, 100);
        dialog.setLayout(new FlowLayout());
        dialog.setResizable(false);

        dialog.setTitle("Error");
        dialog.add(new JLabel(error), Component.CENTER_ALIGNMENT);
        dialog.setVisible(true);
    }
}
