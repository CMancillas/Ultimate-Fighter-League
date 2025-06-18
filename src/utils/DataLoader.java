package utils;
import models.Fighter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class DataLoader {
    
    private String filepath;
    private FighterParser fighterParser;
    
    // Constructors
    public DataLoader(String filepath)
    {
        this.filepath = filepath;
        this.fighterParser = new FighterParser();
    }

    public LinkedList<Fighter> loadFighter()
    {
        LinkedList<Fighter> ll = new LinkedList<Fighter>();
        boolean firstLine = true; 

        try 
        {
            File myFile = new File(filepath);
            Scanner myReader = new Scanner(myFile);

            while( myReader.hasNextLine() )
            {
                String data =  myReader.nextLine();
                
                if ( firstLine )
                {
                    firstLine = false;
                    continue;
                }

                String[] row = data.split(",");
                ll.add(fighterParser.parseFromCSVRow(row));        
            }

            myReader.close();
        
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("There's no such existing file.");
            e.printStackTrace();
        }

        return ll;
    }
}
