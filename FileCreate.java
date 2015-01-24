import java.util.*;
import java.lang.*;
import java.io.*;
public class FileCreate{
    
    Formatter f;
    Scanner s;
    String readString;
    
    //creates textfile
    public void createFile(){
        try{
            f = new Formatter("newFile.csv");
        }
        catch(Exception e){
            System.out.println("Failed to create file");
        }
    }
    
    //writes to file
    public void writeTo(String s){
        f.format(s);
	f.close();
    }
    //opens file
    public void openFile(){
        try{
            s = new Scanner("newFile.csv");
        }
        catch(Exception e){
            System.out.println("error!");
        }
    }
    //reads File and returns a string of whatever was in the file
    public String readFile() {
    String s = "";
    
     
    try {
        FileReader f = new FileReader("newFile.csv");
        BufferedReader b = new BufferedReader(f);
        s = b.readLine();
    }
    catch (IOException e) {}
    return s;
    }
    //closes file
    public void closeFile(){
        s.close();
    }
    
    
    public static void main(String[] args){
	FileCreate f = new FileCreate();
        f.createFile();
	f.openFile();
	f.writeTo("10,10,Task,12/12/12");
        System.out.println(f.readFile());
        f.closeFile();
        
    }
}
