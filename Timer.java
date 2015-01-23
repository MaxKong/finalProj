import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer extends JFrame implements ActionListener {
    
  protected int minutes;
  protected int seconds;
  protected int totalTime;
  protected int elapsedTime; 
  protected JLabel label;
  protected boolean pause;
  protected JFrame frame;

  public Timer() {
    minutes = 0;
    seconds = 0;
    totalTime = 0;
    elapsedTime = 0;
  }

  public Timer(int min, int sec) {
    minutes = min;
    seconds = sec;
    totalTime = minutes*60 + seconds; //in seconds
    elapsedTime = 0;
    pause = false;
  }

  public String secondsToMinutes(int sec) {
    String s = "";
    int minutes =  sec/60;
    int seconds = sec%60;
    if (minutes < 10 && seconds < 10) {
      s = "0" + minutes + ":0" + seconds; 
    }
    else if (seconds < 10){ 
	    //System.out.println ( minutes + ":0" + seconds);
	    s = minutes + ":0" + seconds;
    }
    else if (minutes < 10) {
      s = "0" + minutes + ":" + seconds; 
    }
    else{
	    //System.out.println ( minutes + ":" + seconds);
	    s = minutes + ":" + seconds;
    }
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
    JButton button = new JButton( "PAUSE" ); //Pause Button
    button.addActionListener(new Pause());

    JButton close = new JButton( "CLOSE" ); //Close Window Button
    close.addActionListener(new Close());

    panel.add(label);
    panel.add(button);
    panel.add(close);
    frame.getContentPane().add(BorderLayout.CENTER, panel);

    button.setFont(littleFont);
    label.setFont(bigFont);

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
            if(elapsedTime < totalTime) 
              label.setText(countDown());
            else {
              label.setText("TIME'S\n UP!");
            }
          }
          else {
            label.setText("PAUSE");
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
