package myApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySwingApp extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;

    public MySwingApp() {

        //JTextField setup
        textField = new JTextField();
        textField.setName("textField");
        textField.setPreferredSize(new Dimension(250,40));

        //Button config
        button = new JButton("Submit");
        button.setName("submitButton");
        button.setBounds(100,100,100,100);
        button.addActionListener(this);


        //Frame setup
//        this.setSize(1024,1024);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My AssertJ-Swing App");
        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }



    public static void main(String[] args) {
        new MySwingApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println( "Text entered = " + textField.getText() );

        }

    }
}
