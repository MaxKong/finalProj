import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{
  Font littleFont = new Font ("Heletica", Font.BOLD, 60);
  
  public Main() {
    //Main Frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame frame = new JFrame();
    frame.setTitle("Time Planner");
    System.out.println("We just made the frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(screenSize.width / 2, screenSize.height / 2);
    frame.setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  //Vertical Panel
    System.out.println("we made the panel");

    //New Task Button
    JButton addTask = new JButton("New Task");
    addTask.addActionListener(new NewTask()); //Listen to click
    addTask.setFont(littleFont);
    System.out.println("New Task");

    //Start Timer
    JButton startTimer = new JButton("Start Current Task");
    Timer timer = new Timer(2,0);
    startTimer.addActionListener(timer);
    startTimer.setFont(littleFont);
    System.out.println("Start Timer");

    panel.add(addTask);
    System.out.println("added Task");
    panel.add(startTimer);
    System.out.println("added Start Timer");
    frame.getContentPane().add(BorderLayout.EAST, panel);
    System.out.println("Get Content Pane thing");
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
      
      //Overarching Panel
      JPanel taskPanel = new JPanel();
      taskPanel.setBackground(Color.gray);
      taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));  //Vertical Panel
      
      //Task Details ------------------------------------------

      //First Line

      //TextBox
      JPanel firstLine = new JPanel();
      JLabel metaName = new JLabel("Name: ");
      metaName.setFont(littleFont);
      taskName = new JTextField(20); 
      //One line Size
      taskName.setMaximumSize(new Dimension(Integer.MAX_VALUE, taskName.getMinimumSize().height));
      

      //Second Line

      //Drop Down Menu
      JPanel secondLine = new JPanel();
      JLabel importance = new JLabel("Priority Level");
      importance.setFont(littleFont);
      priority = new JComboBox<String>(); //Drop Down Menu
      //One line Size
      priority.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      priority.addItem("1");
      priority.addItem("2");
      priority.addItem("3");
      priority.addItem("4");
      priority.addItem("5");
      

      //Third Line
      
      JPanel thirdLine = new JPanel();
      JButton submit = new JButton("Submit"); //Submit button, close window, MUST ADD SAVE INFO
      submit.addActionListener(new SubmitListener());
      submit.setFont(littleFont);

      //Add to Panel
      firstLine.add(metaName);
      firstLine.add(taskName);
      secondLine.add(importance);
      secondLine.add(priority);
      thirdLine.add(submit);
      
      //Add to Overarching Panel
      taskPanel.add(firstLine);
      taskPanel.add(secondLine);
      taskPanel.add(thirdLine);

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
