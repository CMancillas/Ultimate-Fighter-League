package models;
    import java.util.List;

public class Tournament {
    private List<Fighter> fighters;
    private Fighter winner;

    // Constructors
    public Tournament()
    {
        this.fighters = null;
        this.winner = null;
    }

    public Tournament(List<Fighter> fighters)
    {
        this.fighters = fighters;
        this.winner = null;
    }

    public Tournament(List<Fighter> fighters, Fighter winner)
    {
        this.fighters = fighters;
        this.winner = winner;
    }
    
    // Getters and Setters
    public List<Fighter> getFighters()
    {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters)
    {
        this.fighters = fighters;
    }

    public Fighter getWinner()
    {
        return winner;
    }

    public void setWinner(Fighter winner)
    {
        this.winner = winner;
    }

    @Override
    public String toString()
    {
        return "Tournament with " + fighters.size() + " fighters | Winner: " +
            (winner != null ? winner.getFullName() : "TBD");
    }
}
