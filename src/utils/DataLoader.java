package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoader {
    private String filepath;
    
    // Cosntructors

    public DataLoader(String filepath)
    {
        try 
        {
            File myFile = new File(filepath);
            Scanner myReader = new Scanner(myFile);

            while( myReader.hasNextLine() )
            {
                String data =  myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("There's no such existing file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        DataLoader data = new DataLoader("/home/carlos-mancillas/Documents/proyectos_personales/Ultimate-Fighter-League/data/ufc-fighters-statistics.csv");
    }
}
