public class Task{
    protected int priority = 0;
    protected int time = 0;
    protected String name = "";
    protected String dueDate  = ""; //date needs to be in format: 2014/08/06 16:06:54
    
    public Task(int a, int b, String c, String d){
        priority = a;
        time = b;
        name = c;
        dueDate = d;
    }
}