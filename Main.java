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

  public void actionPerformed(ActionEvent event) { //New Task Button
    //Frame
    JFrame taskFrame = new JFrame();
    taskFrame.setSize(800, 600);
    taskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    taskFrame.setVisible(true);

    //Panel
    JPanel taskPanel = new JPanel();
    taskPanel.setBackground(Color.gray);
    taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));  //Vertical Panel
    
    //Task Details
    JLabel name = new JLabel("Name: ");
    JTextField nameText = new JTextField(20); 
    nameText.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameText.getMinimumSize().height)); //1-line box

    JLabel importance = new JLabel("Priority (1: Lowest, 5: highest): ");
    JComboBox<String> priority = new JComboBox<String>(); //Drop Down Menu
    priority.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height)); //small menu
    priority.addItem("1");
    priority.addItem("2");
    priority.addItem("3");
    priority.addItem("4");
    priority.addItem("5");

    JButton submit = new JButton("Submit"); //Submit button, close window, MUST ADD SAVE INFO

    //Add Text Field/Radial Buttons
    taskPanel.add(name);
    taskPanel.add(nameText);
    taskPanel.add(importance);
    taskPanel.add(priority);
    taskPanel.add(submit);

    //Add Panel and Fit Window to Content
    taskFrame.getContentPane().add(taskPanel);
  }

  public static void main(String[] args) {
    Main GUI = new Main();
  }
}
