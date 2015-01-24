import java.util.*;
public class Main{
    protected ArrayList<Task> taskList = new ArrayList<Task>();
    
    public String toString(){
        String s = "";
        for(int i = 0; i < taskList.size(); i++){
            s += "name: " + taskList.get(i).name + "\n"; //+ "\npriority: " + taskList.get(i).priority + "\ntime: " + taskList.get(i).time  + "\ndueDate: " +taskList.get(i).dueDate;
        }
        return s;
    }
    
    public void clearArray(){
        
    }
    
    public String writeArray(){
        String s = "";
        for(int i = 0; i < taskList.size(); i++){
            s += taskList.get(i).name + "," + taskList.get(i).priority + "," + taskList.get(i).time  + "," + taskList.get(i).dueDate + ",";
        }
        return s;
    }
    
    public String addTask(Task t){//Adds a task to the arrayList that holds all tasks
	    int i = 0;
  	    while(i < taskList.size() && t.priority < taskList.get(i).priority){
  	        i++;
  	    }
  	    taskList.add(i,t);
        return t.name;
	}
	
	public String remTask(Task t){
	    taskList.remove(t);
	    return t.name;
	}
	
    public void createArray(String s){
        Task temp;
        boolean b;
        //try{
            for (int i = 0; i < s.split(",").length; i +=4){//loops every time a task is created
                b = true;
                for (int x = 0; x < s.split(",")[i].length(); x++) {
                    System.out.println(s.split(",")[i].charAt(x));
                    if (! Character.isDigit(s.split(",")[i].charAt(x)))
                        b = false;
                }
                if (b) {
                    taskList.add(temp = new Task(Integer.parseInt(s.split(",")[i]), Integer.parseInt(s.split(",")[i + 1]), s.split(",")[i + 2], s.split(",")[i + 3] ) );
                    System.out.println("task added!");
                }
            }
        //}
        //catch(Exception e){
         //   System.out.println("make sure the csv has data!");
        //}
            
    }
    

    public static void main(String[] args){
        Main m = new Main();
        Task t = new Task(10, 40, "Task 1", "1/2/3"); 
        Task t1 = new Task(7, 40, "Task 2", "1/2/3"); 
        Task t2 = new Task(30, 40, "Task 3", "1/2/3"); 
        Task t3 = new Task(1, 40, "Task 4", "1/2/3"); 
        
        
        System.out.println(m.writeArray());
        System.out.println("Below");
        
        FileCreate f = new FileCreate();
        f.createFile();
        f.openFile();
        f.writeTo(m.writeArray());
        System.out.println(f.readFile());
        m.createArray(f.readFile());
        f.closeFile();
    
        System.out.println(m);
    }
}
