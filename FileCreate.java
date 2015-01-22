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
            x = new Scanner(new File ("newFile.csv"));
        }
        catch(Exception e){
            System.out.println("error!");
        }
    }
    //reads File
    public void readFile(){
        while(x.hasNext()){
            readString = x.next();
        }
    }
    public void closeFile(){
        f.close();
    }
    
    
    public static void main(String[] args){
        FileCreate f = new FileCreate();
        f.openFile();
        f.readFile();
        f.closeFile();
        System.out.println(readString);
    }
}
