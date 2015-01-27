import java.util.*;
public class Execute {
    public static void main(String[] args){
        boolean isRunning = true;   // keep the code running
        boolean isRemoved = false; //To Check if the a task has been removed 
        String input = "";
        String refresh = "*******************************************************************\n";
        String help = "In order to use this program, type '1' in order to create a new task.\nType '2' in order to remove a task that you have created. Type '3' in order to print a new\ntask. Type '4 in order to see these commands again. Type '5' in order to quit the program.";
        Main m = new Main();
        FileCreate f = new FileCreate();
        f.openFile();
        System.out.println(f.readFile());
        m.createArray(f.readFile());
        f.closeFile();
       
        System.out.print("Welcome to smartPlanner! This program will help you to organize your tasks and carry them ");
        System.out.println("out more efficiently. In order to use this program, type '1' in order to create a new task.");
        System.out.println("Type '2' in order to remove a task that you have created. Type '3' in order to print a new");
        System.out.println("task. Type '4' in order to see these commands again. Type '5' in order to quit the program.");
        
    
    
        //create new tasks here
        Scanner s = new Scanner(System.in);
        
        while(isRunning == true){
            //creating a tasks
            
            System.out.println("Enter a new input");
            input = s.nextLine();
            
            if(input.equals("1")){
                System.out.println("Enter your task name: ");
                String name = s.nextLine();//don't put same name
                System.out.println("Enter your task due date (year/month/day yyyy/mm/dd format): ");
                String date = s.nextLine();
                System.out.println("Enter your task priority: ");
                int priority = s.nextInt();
                System.out.println("Enter your task expected time: ");
                int time = s.nextInt();
                Task t = new Task(priority, time, name, date);
                m.addTask(t);
                System.out.println(refresh);
            }

            //remove a task
            else if(input.equals("2")){
                System.out.println("What is the name of the task that you would like to remove?");
                String toRemove = s.nextLine();
                for(int i = 0; i < m.taskList.size(); i++){
                    if(toRemove.equals(m.taskList.get(i).name)){
                        m.remTask(m.taskList.get(i));
                        System.out.println("You removed the task!");
                        isRemoved = true;
                    }
                }
                if(isRemoved == false){
                    System.out.println("A task of that name was not found!");
                }
                isRemoved = false;
                System.out.println(refresh);
            }
            
            //see your tasks
            else if(input.equals("3")){
                System.out.println(m);
                System.out.println(refresh);
            }
            
            //begin a task
            
            //help
            else if(input.equals("4")){
                System.out.println(help);
            }
            //exit the program
            else if(input.equals("5")){
                isRunning = false;
            }
            
    
            else{
                System.out.println("That doesn't seem like a valid input...");
            }
        }    
        

        //rewrite the file
        f.createFile();
        f.writeTo(m.writeArray());
        f.closeFile();
    }
}
