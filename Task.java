public class Task{
  public int priority = 0;
  public int time = 0;
  public String name = "";
  public String dueDate  = ""; //date needs to be in format: 2014/08/06 16:06:54
    
  public Task(String a, String b, String c, String d){
    priority = Integer.parseInt(a);
    time = Integer.parseInt(b);
    name = c;
    dueDate = d;
  }
    
  public String toString(){
    String s = "";
    s = "priority: " + priority + "\ntime: " + time + "\nname: " + name + "\ndueDate: " + dueDate;
    return s;
  }
    
  /*
    public static void main(String[] args){
    Task t = new Task(10, 40, "Math", "1/2/15");
    System.out.println(t);
    System.out.println(t.name);
    System.out.println(t.dueDate);
    }*/
}
