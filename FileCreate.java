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
    }
    //opens file
    public void openFile(){
        try{
            s = new Scanner(new File ("newFile.csv"));
        }
        catch(Exception e){
            System.out.println("error!");
        }
    }
    //reads File and returns a string of whatever was in the file
    public String readFile(){
        while(s.hasNext()){
            readString = s.next();
        }
        return readString;
    }
    //closes file
    public void closeFile(){
        s.close();
    }
    
    
    public static void main(String[] args){
        FileCreate f = new FileCreate();
        f.openFile();
        f.readFile();
        f.closeFile();
        
    }
}
