import java.util.*;
public class TaskList{
    protected ArrayList<Task> taskList = new ArrayList<Task>();
    
    public String toString(){
        String s = "";
        for(int i = 0; i < taskList.size(); i++){
            s += "name: " + taskList.get(i).name + "\n"; //+ "\npriority: " + taskList.get(i).priority + "\ntime: " + taskList.get(i).time  + "\ndueDate: " +taskList.get(i).dueDate;
        }
        return s;
    }
    
    public String writeArray(){
        String s = "";
        for(int i = 0; i < taskList.size(); i++){
            s += taskList.get(i).name + "," + taskList.get(i).priority + "," + taskList.get(i).time  + "," + taskList.get(i).dueDate + "\n";
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
        for (int i = 0; i < s.split(",").length; i += 4){//loops every time a task is created
            taskList.add(Task t = new Task(s.split(",")[i], s.split(",")[i + 1], s.split(",")[i + 2], s.split(",")[i + 3] ) );
        }
    }
    
    

    public static void main(String[] args){
        TaskList m = new TaskList();
        Task t = new Task(10, 40, "Task 1", "1/2/3"); 
        Task t1 = new Task(7, 40, "Task 2", "1/2/3"); 
        Task t2 = new Task(30, 40, "Task 3", "1/2/3"); 
        Task t3 = new Task(1, 40, "Task 4", "1/2/3"); 
        
        m.addTask(t);
        m.addTask(t1);
        m.addTask(t2);
        m.addTask(t3);
        m.remTask(t2);
        
        
        FileCreate f = new FileCreate();
        f.createFile();
        f.writeTo(m.writeArray());
        f.closeFile();
    
        System.out.println(m);
    }
}
