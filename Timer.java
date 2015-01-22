import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Timer extends JFrame {
    
    protected int minutes;
    protected int seconds;
    protected int totalTime;
    protected int elapsedTime; 

    public Timer() {
	minutes = 0;
	seconds = 0;
	totalTime = 0;
    }

    public Timer(int min, int sec) {
	minutes = min;
	seconds = sec;
	totalTime = minutes*60 + seconds; //in seconds
    }

    public String secondsToMinutes(int sec) {
	String s = "";
	int minutes =  sec/60;
	int seconds = sec%60;
	if (seconds < 10){ 
	    //System.out.println ( minutes + ":0" + seconds);
	    s = minutes + ":0" + seconds;
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
		//start = System.currentTimeMillis();
		elapsedTime++;
		isSecond = true;
	    }
	}
	return secondsToMinutes(totalTime - elapsedTime);
    }
    
    public static void main(String args[]) {
	Timer t = new Timer(1, 10);//feed min & sec ofc	
	JFrame j = new JFrame();
	JPanel panel = new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	//JButton b = new JButton("Start Timer");
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setSize(500, 500);
	j.setVisible(true);
	
	JButton l = new JButton("Hih");
	panel.add(l);
	j.getContentPane().add(panel);	
	while (t.elapsedTime < t.totalTime) {	
	    System.out.println("fdfr");
	   
	}
    }
}
