import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{
  public Main() {
    //Main Frame
    JFrame frame = new JFrame();
    frame.setTitle("Time Planner");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setVisible(true);

    //New Task Button
    JButton addTask = new JButton("New Task");
    frame.getContentPane().add(BorderLayout.SOUTH, addTask);    
    addTask.addActionListener(this); //Listen to click

    //Start Timer
    JButton startTimer = new JButton("Start Current Task");
    frame.getContentPane().add(BorderLayout.EAST, startTimer);
  }


  public void actionPerformed(ActionEvent event) {
    //Frame
    JFrame taskFrame = new JFrame();
    taskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    taskFrame.setSize(300, 300);
    taskFrame.setVisible(true);

    //Panel
    JPanel panel = new JPanel();
    panel.setBackground(Color.darkGray);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  //Vertical Panel
    
    //Task Details
    JTextField name = new JTextField("Name: ");
    JComboBox<String> priority = new JComboBox<String>();
    priority.addItem("Important");
    priority.addItem("Not Important");

    //Add Text Field/Radial Buttons
    panel.add(name);
    panel.add(priority);

    taskFrame.getContentPane().add(panel);
  }

  public static void main(String[] args) {
    Main GUI = new Main();
  }
}
