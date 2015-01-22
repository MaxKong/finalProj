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

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  //Vertical Panel

    //New Task Button
    JButton addTask = new JButton("New Task");
    addTask.addActionListener(this); //Listen to click

    //Start Timer
    JButton startTimer = new JButton("Start Current Task");

    panel.add(addTask);
    panel.add(startTimer);
    frame.getContentPane().add(BorderLayout.EAST, panel);
  }


  public void actionPerformed(ActionEvent event) {
    //Frame
    JFrame taskFrame = new JFrame();
    taskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    taskFrame.setSize(300, 300);
    taskFrame.setVisible(true);

    //Panel
    JPanel taskPanel = new JPanel();
    taskPanel.setBackground(Color.darkGray);
    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));  //Vertical Panel
    
    //Task Details
    JTextField name = new JTextField("Name: "); 
    JComboBox<String> priority = new JComboBox<String>(); //Drop Down Menu
    priority.addItem("Important");
    priority.addItem("Not Important");
    JButton submit = new JButton("Submit"); //Submit button, close window, MUST ADD SAVE INFO

    //Add Text Field/Radial Buttons
    taskPanel.add(name);
    taskPanel.add(priority);
    taskPanel.add(submit);

    taskFrame.getContentPane().add(taskPanel);
  }

  public static void main(String[] args) {
    Main GUI = new Main();
  }
}
