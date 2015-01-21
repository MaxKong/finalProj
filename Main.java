import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{

  public void actionPerformed(ActionEvent event) {
    JFrame taskFrame = new JFrame();
    taskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    taskFrame.setSize(800, 600);
    taskFrame.setVisible(true);

    //Task Details
    JTextField name = new JTextField("Name: ");
    JRadioButton one = new JRadioButton("1");    
    JRadioButton two = new JRadioButton("2");    
    JRadioButton three = new JRadioButton("3");    
    JRadioButton four = new JRadioButton("4");    
    JRadioButton five = new JRadioButton("5");    

    
  }

  public static void main(String[] args) {
    Main buttonOperation = new Main();

    //Main Frame
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setVisible(true);

    //New Task Button
    JButton addTask = new JButton("New Task");
    frame.getContentPane().add(BorderLayout.SOUTH, addTask);    
    addTask.addActionListener(buttonOperation);

    //Start Timer
    JButton startTimer = new JButton("Start Current Task");
    frame.getContentPane().add(BorderLayout.EAST, startTimer);


  }
}
