import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*CURRENT PROBLEMS
  Timer parameters into ints ==> Solved (most likely)
  Refresh method not displaying Buttons/Panels onto Frames (Either one of those)
  Panel is not visible (that's most likely the problem) on the frame

  TO-DO 
  - Make Buttons Appear on Left
  - Make those Buttons respond by using their individual timer options, etc.
  - Implement Timer Conversion (the mathy stuff) solution to all Timers for each Task (after 
  Left-Hand side buttons are properly made */
public class Main extends JFrame implements ActionListener{
  Font littleFont = new Font ("Heletica", Font.BOLD, 40);
  TaskList t;
  Task selected = new Task("1", "071207", "Task1", "121212"); //Pull from user input
  JPanel leftPanel = new JPanel();
  JFrame frame;
  JPanel panel;
  int timedigit;
  int index = 0;
  ArrayList<JButton> listOfTaskButtons = new ArrayList<JButton>();
  JButton startTimer;
  Timer timer;

  public Main() {
    FileCreate f = new FileCreate();
    f.openFile();

    t = new TaskList();
    t.createArray(f.readFile());

    //Main Frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    frame = new JFrame();
    frame.setTitle("Time Planner");
    // System.out.println("We just made the frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(screenSize.width / 2, screenSize.height / 2);
    frame.setVisible(true);

    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  //Vertical Panel
    // System.out.println("we made the panel");

    //Start Timer
    startTimer = new JButton("Start Current Task");
    /*    int s = timedigit%100;
          int m = ((timedigit-s)/100)%100;
          int h = ((timedigit-s-(m*100))/100)%100;
    */ 
    //    timer = new Timer( ((selected.time)/10000), (((selected.time)%10000)/100), ((selected.time)%100));

    startTimer.addActionListener(timer);
    startTimer.setFont(littleFont);
    // System.out.println("Start Timer");

    //New Task Button
    JButton addTask = new JButton("New Task");
    addTask.addActionListener(new NewTask()); //Listen to click
    addTask.setFont(littleFont);
    //    System.out.println("New Task");

    //Remove Task Button
    //JButton removeTask = new JButton("Remove Task");
    //removeTask.addActionListener(new RemoveTask());
    //removeTask.setFont(littleFont);

    //t.addTask(new Task("1", "111", "Math", "111"));
    //    JButton leftButton = new JButton((t.taskList.get(0).name + t.taskList.get(0).dueDate));

    JPanel leftPanel = new JPanel();
    //JLabel testLabel = new JLabel("Testing!");
    //System.out.println(t.taskList.size());

    panel.add(addTask);
    //    System.out.println("added Task");
    panel.add(startTimer);
    // System.out.println("added Start Timer");
    //panel.add(removeTask);
    frame.getContentPane().add(BorderLayout.EAST, panel);
    //   System.out.println("Get Content Pane thing");
  }

  public void refresh() {

    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));  //Vertical Panel

    panel.setBorder(BorderFactory.createLineBorder(Color.red));
    leftPanel.setBorder(BorderFactory.createLineBorder(Color.blue));    //MAKES SECOND PANEL APPEAR!!

    leftPanel.revalidate();
    leftPanel.repaint();
    frame.getContentPane().add(BorderLayout.WEST, leftPanel);
    
  }
  
  public void actionPerformed(ActionEvent event) {
    //Possibly for Displaying Added Tasks (Max's Text File)
    //Mostly just to avoid inheritance errors
  }

  class RemoveTask implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      t.remTask(selected);
      listOfTaskButtons.remove(selected);
      refresh();
      //      System.out.println(tasks.get(0));      
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
      timedigit = 0;
      for(Integer i = 0; i < 24; i++){
        timerSelectionHours.addItem(i.toString());
        //timedigit=timedigit+(i*10000);
      }
      for(Integer j = 0; j < 61; j++) {
        timerSelectionMinutes.addItem(j.toString());
        // timedigit=timedigit+(j*100);
      }
      for(Integer k = 0; k < 61; k++){
        //        timedigit=timedigit+k;
        timerSelectionSeconds.addItem(k.toString());
      }
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
      
        timerHours = (String)(timerSelectionHours.getSelectedItem());
        timerMinutes = (String)(timerSelectionMinutes.getSelectedItem());
        timerSeconds = (String)(timerSelectionSeconds.getSelectedItem());
      
        if(Integer.parseInt(timerHours) < 10)
          timerHours = "0" + timerHours;
        if(Integer.parseInt(timerMinutes) < 10) 
          timerMinutes = "0" + timerMinutes;
        if(Integer.parseInt(timerSeconds) < 10)
          timerSeconds = "0" + timerSeconds;
      
        selected = new Task(prioritySelection, (timerHours + timerMinutes + timerSeconds), name, (dueYear + dueMonth + dueDay)); //THE TIME IS A NUMBER (INTEGER)
        //End Configure individual Task Time
      
        //Renew the Frame GUI
        t.addTask(selected);
        listOfTaskButtons.add( new JButton(selected.name ));        
        leftPanel.add(listOfTaskButtons.get(index));
        listOfTaskButtons.get(index).addActionListener(new ClickResponse(index));
        index++;
        
        refresh();
        //Close Window
        taskFrame.dispose();
      }
    }
  }

  class ClickResponse implements ActionListener {
    int ind;
    ClickResponse(int indexOfButton) {
      ind = indexOfButton;
    }
    
    public void actionPerformed(ActionEvent event) {
      selected = t.taskList.get(ind);
      timer = new Timer( ((selected.time)/10000), (((selected.time)%10000)/100), ((selected.time)%100));
      //Remove previous Listeners
      for(int i = 0; i < startTimer.getActionListeners().length; i++) {
        startTimer.removeActionListener(startTimer.getActionListeners()[i]);
      }
      startTimer.addActionListener(timer);
    }
  }
  
  public static void main(String[] args) {
    Main GUI = new Main(); //ActionEvent must access an object
  }
}

