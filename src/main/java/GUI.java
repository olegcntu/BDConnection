import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JTextField textField1;
    private JButton createButton;
    private JPanel mainPanel;
    private JTextArea textArea1;

    public GUI(String title) {
        super(title);
        this.setContentPane(mainPanel);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inquiry = textField1.getText();
                String result;
                if (inquiry.toCharArray()[0] == 'S') {
                    result = Query.read(inquiry);

                } else {
                    int intResult = Update.update(inquiry);
                    result=String.valueOf(intResult);
                }
                textArea1.setText(result);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new GUI("Data base connection");
        frame.setVisible(true);

    }
}
