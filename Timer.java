import java.util.*;

public class Timer {
    
    protected int minutes;
    protected int seconds;

    public Timer() {
	minutes = 0;
	seconds = 0;
    }

    public Timer(int min, int sec) {
	minutes = min;
	seconds = sec;
    }

    public void secondsToMinutes(int sec) {
	int minutes =  sec/60;
	int seconds = sec%60;
	if (seconds < 10) 
	    System.out.println ( minutes + ":0" + seconds);
	else
	    System.out.println ( minutes + ":" + seconds);
    }

    public void countDown() {
	long start = System.currentTimeMillis();
	int totalTime = minutes*60 + seconds; //in seconds
	int elapsedTime = 0;
	secondsToMinutes(totalTime - elapsedTime);
	while (elapsedTime < totalTime) {
	    if ( System.currentTimeMillis() - start >= 1000 ) {
		start = System.currentTimeMillis();
		elapsedTime++;
		secondsToMinutes(totalTime - elapsedTime);
	    }
	    
	}
    }

    public static void main(String args[]) {
	Timer t = new Timer(1, 10);
	t.countDown();
    }

}
