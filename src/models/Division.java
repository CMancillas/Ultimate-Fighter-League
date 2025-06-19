package models;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private String name;
    List<Fighter> fighters;
    
    // Constructors
    public Division(String name)
    {
        this.name = name;
        this.fighters = new ArrayList<>();
    }

    public Division(String name, List<Fighter> fighters)
    {
        this.name = name;
        this.fighters = fighters;
    }
    // Getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Fighter> getFighters()
    {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters)
    {
        this.fighters = fighters;
    }

    public void addFighter(Fighter fighter)
    {
        if (fighters.size() < 15)
            fighters.add(fighter);
        else
            System.out.println("Divison " + name + " already has 15 fighters.");
    }

    public void printDivision()
    {
        
        System.out.println("=".repeat(50));
        
        if ( getName().equals("Men's Pound For Pound") || getName().equals("Women's Pound For Pound") )
            System.out.printf(" 🥊 %-40s🥊 \n", name + " Division");
        else
            System.out.printf(" %-40s \n", name + " Division");
        
            System.out.println("=".repeat(50));

        for (int i = 0; i < fighters.size(); i++)
         {
            Fighter fighter = fighters.get(i);
            if (getName().equals("Men's Pound For Pound") || getName().equals("Women's Pound For Pound")) 
                System.out.printf("%2d. %-30s\n", i + 1, fighter.getFullName());
            else
            {
                if (i == 0)
                    System.out.printf("%2s. %-30s 🏆\n", "C", fighter.getFullName());
                else 
                    System.out.printf("%2d. %-30s\n", i, fighter.getFullName());
            } 
        }

        System.out.println("=".repeat(50));
        System.out.println();
    }


    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" Division\n");

        for ( int i = 0; i < fighters.size(); i++)
        {
            stringBuilder.append(i + 1).append(". ").append(fighters.get(i).getFullName()).append("\n");
        }
        return stringBuilder.toString();
    }
}
