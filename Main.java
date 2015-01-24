import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{
  Font littleFont = new Font ("Heletica", Font.BOLD, 40);
  ArrayList tasks = new ArrayList();
  Task t;
  Task p;
  public Main() {

    //Main Frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame frame = new JFrame();
    frame.setTitle("Time Planner");
    // System.out.println("We just made the frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(screenSize.width / 2, screenSize.height / 2);
    frame.setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  //Vertical Panel
    // System.out.println("we made the panel");

    //Start Timer
    JButton startTimer = new JButton("Start Current Task");
    Timer timer = new Timer(1, 0, 0);
    startTimer.addActionListener(timer);
    startTimer.setFont(littleFont);
    // System.out.println("Start Timer");

    //New Task Button
    JButton addTask = new JButton("New Task");
    addTask.addActionListener(new NewTask()); //Listen to click
    addTask.setFont(littleFont);
    //    System.out.println("New Task");

    //Remove Task Button
    JButton removeTask = new JButton("Remove Task");
    removeTask.addActionListener(new RemoveTask());
    removeTask.setFont(littleFont);

    panel.add(addTask);
    //    System.out.println("added Task");
    panel.add(startTimer);
    // System.out.println("added Start Timer");
    panel.add(removeTask);
    frame.getContentPane().add(BorderLayout.EAST, panel);
    //   System.out.println("Get Content Pane thing");
  }
  
  public void actionPerformed(ActionEvent event) {
    //Possibly for Displaying Added Tasks (Max's Text File)
    //Mostly just to avoid inheritance errors
  }

  class RemoveTask implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      tasks.remove(t);
      System.out.println(tasks.get(0));      
    }
  }

  class NewTask implements ActionListener {
    //So Submit can detect amd save/close
    JFrame taskFrame; 
    JTextField taskName; 
    JComboBox<String> priority;
    //Due Date Selection
    JComboBox<String> dueDateYear;
    JComboBox<String> dueDateMonth;
    JComboBox<String> dueDateDay;

    String dueYear;
    String dueMonth;
    String dueDay;

    //Timer Selection
    JComboBox<String> timerSelectionHours;
    JComboBox<String> timerSelectionMinutes;
    JComboBox<String> timerSelectionSeconds;

    String timerHours;
    String timerMinutes;
    String timerSeconds;

    String name;
    String prioritySelection;

    public void actionPerformed(ActionEvent event) { //New Task Button
      //Frame
      taskFrame = new JFrame();
      taskFrame.setSize(1000, 600);
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
      taskName = new JTextField(20); 
      //One line Size
      taskName.setMaximumSize(new Dimension(Integer.MAX_VALUE, taskName.getMinimumSize().height));
      metaName.setFont(littleFont);
      taskName.setFont(littleFont);

      //Second Line

      //Drop Down Menu
      JPanel secondLine = new JPanel();
      JLabel importance = new JLabel("Priority Level: ");
      importance.setFont(littleFont);
      priority = new JComboBox<String>(); //Drop Down Menu
      //One line Size
      priority.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      priority.setFont(littleFont);
      priority.addItem("1");
      priority.addItem("2");
      priority.addItem("3");
      priority.addItem("4");
      priority.addItem("5");
      
      //Third Line (Due Date)
      JPanel thirdLine = new JPanel();
      JLabel due = new JLabel("Due Date (YY/MM/DD): ");
      due.setFont(littleFont);

      dueDateYear = new JComboBox<String>();
      dueDateMonth = new JComboBox<String>();
      dueDateDay = new JComboBox<String>();
      
      dueDateYear.setFont(littleFont);
      dueDateMonth.setFont(littleFont);
      dueDateDay.setFont(littleFont);

      dueDateYear.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      dueDateMonth.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      dueDateDay.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));

      for(Integer i = 1; i < 100; i++)
        dueDateYear.addItem(i.toString());
      for(Integer j = 1; j < 13; j++) 
        dueDateMonth.addItem(j.toString());
      for(Integer k = 1; k < 32; k++)
        dueDateDay.addItem(k.toString());

      //Fourth Line (Timer Setting)
      JPanel fourthLine = new JPanel();
      JLabel timeSetting = new JLabel("Timer (HH/MM/SS): ");
      timeSetting.setFont(littleFont);

      timerSelectionHours = new JComboBox<String>();
      timerSelectionMinutes = new JComboBox<String>();
      timerSelectionSeconds = new JComboBox<String>();
      
      timerSelectionHours.setFont(littleFont);
      timerSelectionMinutes.setFont(littleFont);
      timerSelectionSeconds.setFont(littleFont);

      timerSelectionHours.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      timerSelectionMinutes.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));
      timerSelectionSeconds.setMaximumSize(new Dimension(Integer.MAX_VALUE, priority.getMinimumSize().height));

      for(Integer i = 0; i < 24; i++)
        timerSelectionHours.addItem(i.toString());
      for(Integer j = 0; j < 61; j++) 
        timerSelectionMinutes.addItem(j.toString());
      for(Integer k = 0; k < 61; k++)
        timerSelectionSeconds.addItem(k.toString());

      //Fifth Line (Submit)
      
      JPanel fifthLine = new JPanel();
      JButton submit = new JButton("Submit"); //Submit button, close window, MUST ADD SAVE INFO
      submit.addActionListener(new SubmitListener());
      submit.setFont(littleFont);

      //Add to Panel
      firstLine.add(metaName);
      firstLine.add(taskName);
      secondLine.add(importance);
      secondLine.add(priority);
      thirdLine.add(due);
      thirdLine.add(dueDateYear);
      thirdLine.add(dueDateMonth);
      thirdLine.add(dueDateDay);
      fourthLine.add(timeSetting);
      fourthLine.add(timerSelectionHours);
      fourthLine.add(timerSelectionMinutes);
      fourthLine.add(timerSelectionSeconds);
      fifthLine.add(submit);
      
      //Add to Overarching Panel
      taskPanel.add(firstLine);
      taskPanel.add(secondLine);
      taskPanel.add(thirdLine);
      taskPanel.add(fourthLine);
      taskPanel.add(fifthLine);

      //Add Panel and Fit Window to Content
      taskFrame.getContentPane().add(taskPanel);
    
    }

    class SubmitListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
        //Get Name
        name = taskName.getText();
        prioritySelection = (String)(priority.getSelectedItem());

        //Get Due Date
        dueYear = (String)(dueDateYear.getSelectedItem());
        dueMonth = (String)(dueDateMonth.getSelectedItem());
        dueDay = (String)(dueDateDay.getSelectedItem());

        //Close Window
        taskFrame.dispose();
      }
    }

  }

  public static void main(String[] args) {
    Main GUI = new Main(); //ActionEvent must access an object

 
  }
}
