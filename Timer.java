import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer extends JFrame implements ActionListener {

  protected int hours;
  protected int minutes;
  protected int seconds;
  protected int totalTime;
  protected int elapsedTime; 
  protected JLabel label;
  protected boolean pause;
  protected JFrame frame;
  protected JButton button;

  public Timer() {
    hours = 0;
    minutes = 0;
    seconds = 0;
    totalTime = 0;
    elapsedTime = 0;
  }

  public Timer(int hour, int min, int sec) {
    hours = hour;
    minutes = min;
    seconds = sec;
    totalTime = hours*3600 + minutes*60 + seconds; //in seconds
    elapsedTime = 0;
    pause = false;
  }

  public String secondsToMinutes(int sec) {
    String s = "";
    int hours = sec/3600;
    int minutes =  (sec - hours*3600)/60;
    int seconds = sec - hours*3600 - minutes*60;
    if(hours < 10) 
      s += "0" + hours;
    else
      s += ":" + hours;

    if(minutes < 10) 
      s += ":0" + minutes;
    else
      s += ":" + minutes;

    if(seconds < 10)
      s += ":0" + seconds;
    else
      s += ":" + seconds;

    return s;
  }

  public String countDown() {
    String s = "";
    long start = System.currentTimeMillis();
    boolean isSecond = false;
    secondsToMinutes(totalTime - elapsedTime);
    while (!isSecond) {//basically a delay factor
	    if (System.currentTimeMillis() - start >= 1000) {
        elapsedTime++;
        isSecond = true;
	    }
    }
    return secondsToMinutes(totalTime - elapsedTime);
  }

  class Pause implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      pause = !pause;
    }
  }

  class Close implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      frame.dispose();
      pause = true;
    }
  }

  public void actionPerformed(ActionEvent event) {

    pause = false;

    Font bigFont = new Font ("Heletica", Font.BOLD, 170);
    Font littleFont = new Font ("Heletica", Font.BOLD, 60);

    frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setBackground(Color.gray);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //Vertical Box Layout

    label = new JLabel( secondsToMinutes(totalTime) );
    button = new JButton( "PAUSE" ); //Pause Button
    button.addActionListener(new Pause());

    JButton close = new JButton( "CLOSE" ); //Close Window Button
    close.addActionListener(new Close());

    panel.add(label);
    panel.add(button);
    panel.add(close);
    frame.getContentPane().add(BorderLayout.CENTER, panel);

    //Set Fonts (and Size)
    button.setFont(littleFont);
    close.setFont(littleFont);
    label.setFont(bigFont);

    //Frame Properties
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setSize(1200,400);
    frame.setVisible(true);

    /*    while (elapsedTime < totalTime) {
          System.out.println(countDown());
          label.setText(countDown());

          }*/

    //To refresh GUI
    javax.swing.Timer timer = new javax.swing.Timer(5, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          if(!pause) {
            button.setText("PAUSE");
            if(elapsedTime < totalTime) 
              label.setText(countDown());
            else {
              label.setText("TIME'S\n UP!");
            }
          }
          else {
            button.setText("START");
            label.setText( secondsToMinutes(totalTime - elapsedTime));
          }
        }
      });

    timer.start();
  }
  /*
    class labelRefresher implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    if(elapsedTime < totalTime) 
    label.setText(countDown());
    }
    }*/
}
