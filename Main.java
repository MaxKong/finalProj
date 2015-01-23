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
    addTask.addActionListener(new NewTask()); //Listen to click

    //Start Timer
    JButton startTimer = new JButton("Start Current Task");
    Timer timer = new Timer(2,0);
    startTimer.addActionListener(timer);

    panel.add(addTask);
    panel.add(startTimer);
    frame.getContentPane().add(BorderLayout.EAST, panel);
  }
  
  public void actionPerformed(ActionEvent event) { //Possibly for Displaying Added Tasks (Max's Text File)
    
  }

  class NewTask implements ActionListener {
    //So Submit can detect amd save/close
    JFrame taskFrame; 
    JTextField taskName; 
    JComboBox<String> priority;

    String name;
    String prioritySelection;
    public void actionPerformed(ActionEvent event) { //New Task Button
      //Frame
      taskFrame = new JFrame();
      taskFrame.setSize(800, 600);
      taskFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      taskFrame.setVisible(true);
      
      //Panel
      JPanel taskPanel = new JPanel();
      taskPanel.setBackground(Color.gray);
      taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));  //Vertical Panel
      
      //Task Details ------------------------------------------

      //TextBox
      JLabel metaName = new JLabel("Name: ");
      taskName = new JTextField(20); 
      //One line Size
      taskName.setMaximumSize(new Dimension(Integer.MAX_VALUE, taskName.getMinimumSize().height));
      
      //Drop Down Menu
      JLabel importance = new JLabel("Priority (1: Lowest, 5: highest): ");
      priority = new JComboBox<String>(); //Drop Down Menu
      //One line Size
      priority.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      priority.addItem("1");
      priority.addItem("2");
      priority.addItem("3");
      priority.addItem("4");
      priority.addItem("5");
      
      JButton submit = new JButton("Submit"); //Submit button, close window, MUST ADD SAVE INFO
      submit.addActionListener(new SubmitListener());

      //Add to Panel
      taskPanel.add(metaName);
      taskPanel.add(taskName);
      taskPanel.add(importance);
      taskPanel.add(priority);
      taskPanel.add(submit);
      
      //Add Panel and Fit Window to Content
      taskFrame.getContentPane().add(taskPanel);
    
    }

    class SubmitListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
        //Get Name
        name = taskName.getText();
        prioritySelection = (String)(priority.getSelectedItem());
          
        //Close Window
        taskFrame.dispose();
      }
    }

  }

  public static void main(String[] args) {
    Main GUI = new Main(); //ActionEvent must access an object

 
  }
}
