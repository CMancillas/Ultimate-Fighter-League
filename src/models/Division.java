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
