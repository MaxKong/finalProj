import javax.swing.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    //Main Frame
    JFrame frame = new JFrame();
    JButton addTask = new JButton("+");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(addTask);

    ArrayList todoText = new ArrayList();
    ArrayList todoRate = new ArrayList();
    ArrayList todoDue = new ArrayList();
  }
}
