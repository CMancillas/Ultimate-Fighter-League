package models;

public class Match {
    private Fighter fighterA;
    private Fighter fighterB;
    private Fighter winner;

    // Constructors
    public Match(Fighter fighterA, Fighter fighterB)
    {
        this.fighterA = fighterA;
        this.fighterB = fighterB;
    }

    // Getters and Setters
    public Fighter getFighterA()
    {
        return fighterA;
    }

    public void setFighterA(Fighter fighterA)
    {
        this.fighterA = fighterA;
    }

    public Fighter getFighterB()
    {
        return fighterB;
    }

    public void setFighterB(Fighter fighterB)
    {
        this.fighterB = fighterB;
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
        String fighterAName = fighterA.getFullName();
        String fighterBName = fighterB.getFullName();
        String winnerName = (winner != null) ? winner.getFullName() : "TBD";

        return "Match: " + fighterAName + " vs " + fighterBName + " | Winner: " + winnerName;
    }

}
