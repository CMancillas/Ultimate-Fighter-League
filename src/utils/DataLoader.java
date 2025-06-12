package utils;
import models.Fighter;
import models.GrapplingStats;
import models.StrikingStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.Pipe.SourceChannel;
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

    public static void main(String[] args)
    {
        DataLoader data = new DataLoader("/home/carlos-mancillas/Documents/proyectos_personales/Ultimate-Fighter-League/data/ufc-fighters-statistics.csv");
        LinkedList<Fighter> fighters = data.loadFighter();
        System.out.println(fighters.get(188));
    }
}
